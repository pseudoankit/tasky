package pseudoankit.droid.alarm_scheduler.domain

import pseudoankit.droid.alarm_scheduler.domain.model.Alarm

interface AlarmScheduler {
    fun schedule(alarm: Alarm)
    fun cancel(alarm: Alarm)
}