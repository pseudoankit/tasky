package pseudoankit.droid.tasky.di

import pseudoankit.droid.agendamanger.di.AgendaManagerModule
import pseudoankit.droid.dbmanager.di.DataBaseModule

internal val AppModule = listOf(
    DataBaseModule(),
    AgendaManagerModule()
)