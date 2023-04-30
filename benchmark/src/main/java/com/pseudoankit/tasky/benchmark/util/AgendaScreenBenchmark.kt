package com.pseudoankit.tasky.benchmark.util

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import pseudoankit.droid.core.testtag.AgendaTestTag
import pseudoankit.droid.core.testtag.ReminderTestTag

fun MacrobenchmarkScope.addReminder(
    text: String = "Remind me about ${Math.random()}"
) {
    val edtReminder = device.findObject(By.res(ReminderTestTag.edtRemindMe))
    val btnSave = device.findObject(By.res(AgendaTestTag.save))

    edtReminder.text = text

    btnSave.click()
}