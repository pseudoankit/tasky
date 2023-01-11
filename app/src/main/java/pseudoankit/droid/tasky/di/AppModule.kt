package pseudoankit.droid.tasky.di

import pseudoankit.droid.agendamanger.di.AgendaManagerModule
import pseudoankit.droid.alarm_scheduler.di.AlarmManagerModule
import pseudoankit.droid.dbmanager.di.DataBaseModule
import pseudoankit.droid.navigation.di.NavigationModule

internal val AppModule = listOf(
    DataBaseModule(),
    AgendaManagerModule(),
    AlarmManagerModule(),
    NavigationModule()
)