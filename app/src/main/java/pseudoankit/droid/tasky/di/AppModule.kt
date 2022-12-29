package pseudoankit.droid.tasky.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import pseudoankit.droid.agendamanger.data.local.dao.ReminderDao
import pseudoankit.droid.tasky.database.TaskyDataBase

object AppModule {

    val modules = listOf(
        module {
            single { TaskyDataBase(androidApplication()) }

            factory<ReminderDao> { get<TaskyDataBase>().getNotesDao() }
        }
    )
}