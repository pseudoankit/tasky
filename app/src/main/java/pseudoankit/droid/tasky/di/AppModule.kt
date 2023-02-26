package pseudoankit.droid.tasky.di

import pseudoankit.droid.agendamanger.di.AgendaManagerModule
import pseudoankit.droid.alarm_scheduler.di.AlarmManagerModule
import pseudoankit.droid.core.di.CoreModule
import pseudoankit.droid.dbmanager.di.DataBaseModule
import pseudoankit.droid.navigation.di.NavigationModule
import pseudoankit.droid.notification_manager.di.NotifierModule

internal val AppModule = listOf(
    DataBaseModule(),
    AgendaManagerModule(),
    AlarmManagerModule(),
    NavigationModule(),
    CoreModule(),
    NotifierModule(),
)