package com.pseudoankit.tasky.benchmark.util

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import pseudoankit.droid.core.testtag.AuthTestTag

fun MacrobenchmarkScope.performLogin() {
    val email = device.findObject(By.res(AuthTestTag.email))
    val password = device.findObject(By.res(AuthTestTag.password))
    val loginBtn = device.findObject(By.res(AuthTestTag.loginBtn))

    email.text = "lostankit7@gmail.com"
    password.text = "qwerty@123"
    loginBtn.click()
}