package pseudoankit.droid.core.util.validator

import pseudoankit.droid.core.util.TextResource

object Validator {
    const val EMAIL_PATTERN = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$"

    /**
     * email validator returns null if email is valid else will return error message
     */
    fun validateEmail(email: String?): TextResource? {
        if (email.isNullOrBlank()) return TextResource.NormalString("Email cannot be empty")

        val isValid = email.matches(Regex(pattern = EMAIL_PATTERN))
        if (isValid.not()) return TextResource.NormalString("You have entered an invalid email address")

        return null
    }

    /**
     * password validator returns null if email is valid else will return error message
     */
    fun validatePassword(
        password: String?,
        emptyErrorMessage: TextResource = TextResource.NormalString("Password cannot be empty"),
        invalidLengthErrorMessage: TextResource = TextResource.NormalString("Password cannot be less than 6 digits"),
    ): TextResource? {
        if (password.isNullOrBlank()) return emptyErrorMessage
        if (password.contains(' ')) return TextResource.NormalString("Password cannot contain whitespaces")
        if (password.length < 6) return invalidLengthErrorMessage

        return null
    }
}