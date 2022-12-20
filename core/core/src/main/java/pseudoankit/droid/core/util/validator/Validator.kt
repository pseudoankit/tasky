package pseudoankit.droid.core.util.validator

import pseudoankit.droid.core.util.TextResource

object Validator {

    fun validateEmail(
        email: String?,
        emptyErrorMessage: TextResource = TextResource.NormalString("Email cannot be empty")
    ): TextResource? {
        if (email.isNullOrBlank()) return emptyErrorMessage

        // todo match pattern

        return null
    }

    fun validatePassword(
        password: String?,
        emptyErrorMessage: TextResource = TextResource.NormalString("Password cannot be empty"),
        invalidLengthErrorMessage: TextResource = TextResource.NormalString("Password cannot be of less than 6 digits"),
    ): TextResource? {
        if (password.isNullOrBlank()) return emptyErrorMessage
        if (password.length < 6) return invalidLengthErrorMessage

        // todo match pattern

        return null
    }
}