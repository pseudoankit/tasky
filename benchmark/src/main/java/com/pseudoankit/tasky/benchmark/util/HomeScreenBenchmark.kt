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

    repeat(10) {
        openReminderScreenToAddItem(it + 1)
    }

    device.wait(Until.hasObject(By.res(HomeTestTag.agendaItemList)), 4_000)
    val agendaItemList = device.findObject(By.res(HomeTestTag.agendaItemList))
    agendaItemList.fling(Direction.DOWN)

    device.waitForIdle()

    agendaItemList.children[agendaItemList.childCount - 1].click()
    device.wait(Until.hasObject(By.text("Remind me about ${agendaItemList.childCount}")), 5_000)
}

private fun MacrobenchmarkScope.openReminderScreenToAddItem(count: Int) {

    device.wait(Until.hasObject(By.res(HomeTestTag.fab)), 3_000)
    val fab = device.findObject(By.res(HomeTestTag.fab))
    fab.click()

    device.wait(Until.hasObject(By.res(AgendaTestTag.reminder)), 3_000)
    val reminder = device.findObject(By.res(AgendaTestTag.reminder))
    reminder.click()

    addReminder(text = "Remind me about $count")
}