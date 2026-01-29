import kotlin.math.log

//Задание 1
//создали enum с разными кодами
enum class HttpStatus(val code: Int, val description: String) {
    OK(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_ERROR(500, "Internal Server Error");

    //метод для проверки кода в диапазоне
    fun isSuccess(): Boolean = code in 200..299
}

//Задание 2
//расширение toSlug для строки, которое возвращает маленький регистр
fun String.toSlug(): String {
    return this.lowercase()
}

//Задание 3
object DbConfig {
    const val loginDb = "Admin"
    const val passwordDb = "12345"

    fun connectStatusSuccess(status: String): String {
        return "СТАТУС: подключение успешно"
    }
    fun connectStatusEnd(status: String): String {
        return "СТАТУС: подключение завершено"
    }
}

fun main() {
    //вызов Задания 1
    //получаем готовый экземпляр enum
    println("Задание 1")
    val status = HttpStatus.OK
    println("Code: ${status.code}, Status: ${status.description}")

    //вызов Задания 2
    println("\nЗадание 2")
    println("Test String".toSlug())

    //вызов Задания 3
    println("\nЗадание 3")
    println("Вводим логин: ${DbConfig.loginDb} и пароль: ${DbConfig.passwordDb}")
    println(DbConfig.connectStatusSuccess("start"))
    println(DbConfig.connectStatusEnd("finish"))
}

