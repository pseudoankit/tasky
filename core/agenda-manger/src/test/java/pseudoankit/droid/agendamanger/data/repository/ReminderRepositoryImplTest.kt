package pseudoankit.droid.agendamanger.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Test
import pseudoankit.droid.agendamanger.data.local.dao.ReminderDao
import pseudoankit.droid.agendamanger.data.local.entity.ReminderEntity
import pseudoankit.droid.agendamanger.domain.mapper.ReminderMapper.mapToDomain
import pseudoankit.droid.agendamanger.domain.mapper.ReminderMapper.sortByAscDateTime
import pseudoankit.droid.agendamanger.util.reminderEntity
import java.time.LocalDate
import java.time.LocalTime
import kotlin.test.assertEquals

class ReminderRepositoryImplTest {

    private val dao = mockk<ReminderDao>()
    private val repository = ReminderRepositoryImpl(dao)

    @Test
    fun `getReminders should call correct dao when date is not null`() = runTest {
        val date = LocalDate.MAX
        val reminders = flowOf(listOf(mockk<ReminderEntity>()))

        coEvery { dao.getRemindersFlow(date) } returns reminders

        repository.getReminders(date)

        coVerify(exactly = 1) { dao.getRemindersFlow(date) }
        coVerify(exactly = 0) { dao.getRemindersFlow() }
    }

    @Test
    fun `getReminders should call correct dao when date is null`() = runTest {
        val date: LocalDate? = null
        val reminders = flowOf(listOf(mockk<ReminderEntity>()))

        coEvery { dao.getRemindersFlow() } returns reminders

        repository.getReminders(date)

        coVerify(exactly = 1) { dao.getRemindersFlow() }
        coVerify(exactly = 0) { dao.getRemindersFlow(any()) }
    }

    @Test
    fun `getReminders should sort data in asc ordered by dateTime`() = runTest {
        val reminders = flowOf(
            listOf(
                reminderEntity.copy(
                    date = LocalDate.of(1011, 12, 14),
                    time = LocalTime.of(1, 12, 12)
                ),
                reminderEntity.copy(
                    date = LocalDate.of(1011, 12, 2),
                    time = LocalTime.of(1, 12, 19)
                ),
                reminderEntity.copy(
                    date = LocalDate.of(1011, 12, 19),
                    time = LocalTime.of(1, 12, 2)
                )
            )
        )
        coEvery { dao.getRemindersFlow() } returns reminders
        val expected = reminders
            .map { list ->
                list.map {
                    it.mapToDomain
                }.sortByAscDateTime
            }

        val actual = repository.getReminders(null)

        assertEquals(expected.first(), actual.first())
    }
}
