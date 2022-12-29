package pseudoankit.droid.tasky.reminder.domain.mapper

import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.tasky.reminder.domain.model.RepeatsOn

object RepeatsOnMapper {

    val RepeatsOn.homePageLabel
        get() = when (this) {
            RepeatsOn.DoNotRepeat -> TextResource.NormalString("Does not repeat")
            RepeatsOn.Daily -> TextResource.NormalString("Every day")
            RepeatsOn.Weekly -> TextResource.NormalString("Repeats weekly")
            RepeatsOn.Monthly -> TextResource.NormalString("Repeats monthly")
            RepeatsOn.Yearly -> TextResource.NormalString("Repeats yearly")
            RepeatsOn.Custom -> TextResource.NormalString("Custom")
        }
}