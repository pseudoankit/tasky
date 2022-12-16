package pseudoankit.droid.core.util.validator

object Validator {

    fun validate(email: String?, password: String?): Boolean {
        return isValidEmail(email) && isValidPassword(password)
    }

    fun isValidEmail(email: String?): Boolean {
        if (email.isNullOrBlank()) return false

        // todo match pattern

        return true
    }

    fun isValidPassword(password: String?): Boolean {
        if (password.isNullOrBlank()) return false
        if (password.length < 6) return false

        // todo match pattern

        return true
    }
}