package com.pseudoankit.tasky.benchmark.util

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.testtag.HomeTestTag
import pseudoankit.droid.core.util.extension.parseToString

fun MacrobenchmarkScope.performHomeScreenOperations() {
    openApplication()

    performLogin()

    val todayDateInMMMYYY = TaskyDate.Today.parseToString("MMM yyyy").orEmpty()
    device.wait(Until.hasObject(By.text(todayDateInMMMYYY)), 10_000)

    val dateList = device.findObject(By.res(HomeTestTag.monthDatesHorizontalList))
    dateList.fling(Direction.LEFT)
    device.waitForIdle()
    dateList.fling(Direction.RIGHT)

    val agendaItemList = device.findObject(By.res(HomeTestTag.agendaItemList))
    // TODO add items at top and perform scroll here
}