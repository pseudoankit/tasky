package pseudoankit.droid.core.logger

object TaskyLogger {

    fun log(vararg value: String) {
        println("Tasky debug logs : ${value.joinToString(" ")}")
    }
}