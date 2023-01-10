package pseudoankit.droid.alarm_scheduler.di

import org.koin.dsl.module
import pseudoankit.droid.alarm_scheduler.data.AndroidAlarmScheduler
import pseudoankit.droid.alarm_scheduler.domain.AlarmScheduler

object AlarmManagerModule {

    operator fun invoke() = module {
        single<AlarmScheduler> { AndroidAlarmScheduler(get()) }
    }
}