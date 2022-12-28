package pseudoankit.droid.unify.components.textfield

import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyColors

object UnifyTextFieldDefaults {

    fun placeHolder(
        value: String,
        textType: UnifyTextType = UnifyTextType.BodyLarge
    ) = UnifyTextView.Config(
        text = value,
        textType = textType,
        color = UnifyColors.Gray800
    )
}