package pseudoankit.droid.dbmanager.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import pseudoankit.droid.dbmanager.TaskyDataBase

object DataBaseModule {

    operator fun invoke() = module {
        single { TaskyDataBase(androidApplication()) }

        factory { get<TaskyDataBase>().reminderDao }
    }
}