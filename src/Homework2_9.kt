fun main() {
    println("Задача 1")
    //класс для пользователя с параметрами
    data class OriginalUser(
        var name: String, var email: String, var password: Int,
        var dateRegistration: String
    )
    //объявляем объект класса куда передаем след аргументы
    val testUser = OriginalUser("Вася", "test@gmail.com", 123, "18 апреля")
    testUser.also { println("Логируем создание пользователя $testUser") }
    //переопределяем свойства объекта
    testUser.apply {
        this.name = "Толя"
        this.email = "qwe@mail.ru"
        this.password = 456
        this.dateRegistration = "1 мая"
    }
    //печать результата
    println("Данные пользователя: $testUser")

    println("\nЗадача 2")
    //объявляем новый класс с параметрами
    //Именование классов должно быть в CamelCase и начинаться с заглавной буквы
    data class TestOrder(var status: String, var comments: String, var price: Double)
    //объявляем объект класса с аргументами
    val newOrder = TestOrder("Actual", "very good", 123.45)
    newOrder.also { println("Логируем отправку запроса $newOrder") }
    //показываем текущее состояние
    println("Текущий заказ: $newOrder")
    //новая переменная где переназначаем свойства и возвращаем последнее значение
    val actualOrder = with(newOrder) {
        status = "обработан"
        comments = "тестовый заказ"
        price = 156.87
        "Новый заказ: ${this.status}, ${this.comments}, ${this.price}"
    }
    //печатаем результат
    println(actualOrder)

    println("\nЗадача 3")
    //объявляем новый класс с параметрами
    //Именование классов должно быть в CamelCase и начинаться с заглавной буквы
    data class ResponceApi(var code: Int, var status: String?)
    //объявляем объект класса с аргументами
    val newResponce = ResponceApi(200, null)
    newResponce.also { println("Логируем отправку запроса $newResponce") }
    //в функции проверяем что status != null, и если не null то печатаем результат
    newResponce.status?.let {
        println("Получены данные: $newResponce")
    } ?: println("Данные не получены")
}