package pseudoankit.droid.unify.component.textfield

import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors

object UnifyTextFieldDefaults {

    fun placeHolder(
        value: String,
        textType: UnifyTextType = UnifyTextType.BodyLarge
    ) = UnifyTextViewConfig(
        text = value,
        textType = textType,
        color = UnifyColors.Gray800
    )
}
