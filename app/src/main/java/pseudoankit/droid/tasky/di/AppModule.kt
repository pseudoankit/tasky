package pseudoankit.droid.tasky.di

import pseudoankit.droid.agendamanger.di.AgendaManagerModule
import pseudoankit.droid.alarm_scheduler.di.AlarmManagerModule
import pseudoankit.droid.dbmanager.di.DataBaseModule

internal val AppModule = listOf(
    DataBaseModule(),
    AgendaManagerModule(),
    AlarmManagerModule()
)