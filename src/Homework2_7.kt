import java.util.*

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
    //объявляем два переменных конст
    const val loginDb = "Admin"
    const val passwordDb = "12345"
    //методы возвращают начало и конец подключения
    fun connectStatusSuccess(status: String): String {
        return "СТАТУС: подключение успешно"
    }
    fun connectStatusEnd(status: String): String {
        return "СТАТУС: подключение завершено"
    }
}
//Задание 4
// 1. Интерфейс ApiClient
interface ApiClient {//это как бы действия, пример животное бегает
    val baseEndpoint: String // поле (свойство)

    fun get(id: UUID) {
        println("GET запрос отправлен на $baseEndpoint/$id")//реализация метода
    }

    fun post(body: Any) {
        println("POST запрос отправлен на $baseEndpoint")
        println("Тело запроса: $body")
    }
}

// 2. Абстрактный класс, имплементирующий интерфейс
abstract class AbstractApiClient : ApiClient {//это как бы объект, пример животное без конкретики!
    // Поле baseEndpoint НЕ заполняем - оставляем абстрактным
    // Методы get и post уже имеют реализацию по умолчанию из интерфейса
    //override val baseEndpoint = "test"

}

// 3. Первый класс, наследующий абстрактный класс
class UserApiClient : AbstractApiClient() {//а это уже конкретное животное типо Кошка, которая идет от животного и берет интерфейс бегать
    override val baseEndpoint: String = "https://api.example.com/users"//override говорит что переоделеяет тут

    // Можно добавить свои методы
    fun getAllUsers() {
        println("GET запрос отправлен на $baseEndpoint")
    }
}

// 4. Второй класс, наследующий абстрактный класс с переопределением метода post
class ProductApiClient : AbstractApiClient() {
    override val baseEndpoint: String = "https://api.example.com/products"

    // Переопределяем метод post
    override fun post(body: Any) {
        println("=== ОТПРАВКА ПРОДУКТА ===")
        println("Отправка POST на $baseEndpoint")
        println("Данные продукта: $body")
        println("Заголовки: Content-Type: application/json")
        println("=== КОНЕЦ ЗАПРОСА ===")
    }

    // Дополнительный метод
    fun getWithDiscount(id: UUID, discount: Int) {
        println("GET запрос на $baseEndpoint/$id?discount=$discount")
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
    //просто печатаем что вводим из объекта
    println("Вводим логин: ${DbConfig.loginDb} и пароль: ${DbConfig.passwordDb}")
    //вызываем методы объекта
    println(DbConfig.connectStatusSuccess("start"))
    println(DbConfig.connectStatusEnd("finish"))

    //вызов Задания 4
    // 5. Использование
    fun main() {
        println("=== Демонстрация ApiClient ===")

        // Создаем экземпляры
        val userClient = UserApiClient()
        val productClient = ProductApiClient()

        println("\n1. Работа с UserApiClient:")
        userClient.get(UUID.randomUUID())
        userClient.post(mapOf("name" to "Иван", "age" to 25))
        userClient.getAllUsers()

        println("\n2. Работа с ProductApiClient:")
        productClient.get(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
        productClient.post(mapOf(
            "name" to "Ноутбук",
            "price" to 999.99,
            "inStock" to true
        ))
        productClient.getWithDiscount(UUID.randomUUID(), 15)

        println("\n3. Использование через интерфейс:")
        val clients: List<ApiClient> = listOf(userClient, productClient)
        clients.forEach { client ->
            println("\nРабота с ${client.javaClass.simpleName}:")
            client.get(UUID.randomUUID())
            client.post("Тестовые данные")
        }
    }
}