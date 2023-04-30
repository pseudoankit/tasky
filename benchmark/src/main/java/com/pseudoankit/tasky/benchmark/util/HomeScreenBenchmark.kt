package com.pseudoankit.tasky.benchmark.util

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.testtag.AgendaTestTag
import pseudoankit.droid.core.testtag.HomeTestTag
import pseudoankit.droid.core.util.extension.parseToString

fun MacrobenchmarkScope.performHomeScreenOperations() {
    openApplication()

    // if horizontal date picker is present that means we are already logged in
    if (device.findObject(By.res(HomeTestTag.monthDatesHorizontalList)) == null) {
        performLogin()
    }

    val todayDateInMMMYYY = TaskyDate.Today.parseToString("MMM yyyy").orEmpty()
    device.wait(Until.hasObject(By.text(todayDateInMMMYYY)), 10_000)

    val dateList = device.findObject(By.res(HomeTestTag.monthDatesHorizontalList))
    dateList.fling(Direction.LEFT)
    dateList.fling(Direction.RIGHT)

    device.waitForIdle()

    val agendaItemList = device.findObject(By.res(HomeTestTag.agendaItemList))
    val itemCount = agendaItemList.children.size
    if (itemCount < 10) {
        repeat(10 - agendaItemList.children.size) {
            openReminderScreenToAddItem(it)
        }
    }

    agendaItemList.fling(Direction.DOWN)
    agendaItemList.fling(Direction.UP)
    agendaItemList.fling(Direction.DOWN)

    device.findObject(By.text("Remind me about 8")).click()

    device.wait(Until.hasObject(By.text("Remind me about 8")), 5000)
}

private fun MacrobenchmarkScope.openReminderScreenToAddItem(count: Int) {
    val fab = device.findObject(By.res(HomeTestTag.fab))
    fab.click()

    val reminder = device.findObject(By.res(AgendaTestTag.reminder))
    reminder.click()

    addReminder(text = "Remind me about $count")
    device.waitForIdle()
}