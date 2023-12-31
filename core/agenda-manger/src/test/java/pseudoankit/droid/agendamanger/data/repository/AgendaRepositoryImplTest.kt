package pseudoankit.droid.agendamanger.data.repository

import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Test
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import kotlin.test.assertEquals


internal class AgendaRepositoryImplTest {

    private val reminderRepository: ReminderRepository = mockk()
    private val repository = AgendaRepositoryImpl(reminderRepository)


    @Test
    fun `getAllSavedItem should return data from reminderRepository`() {
        val expected = listOf(
            AgendaItem.Reminder()
        )
        coEvery { reminderRepository.getReminders() } returns expected

        val actual = repository.getAllSavedItem()

        assertEquals(expected, actual)
    }
}
