fun main() {
    println("Задача 1")
    //класс для пользователя с параметрами
    data class OriginalUser(
        var name: String, var email: String, var password: Int,
        var dateRegistration: String
    )
    //объявляем объект класса куда передаем след аргументы
    val testUser = OriginalUser("Вася", "test@gmail.com", 123, "18 апреля")
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
    data class testOrder(var status: String, var comments: String, var price: Double)
    //объявляем объект класса с аргументами
    val newOrder = testOrder("Actual", "very good", 123.45)
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
    data class responceApi(var code: Int, var status: String?)
    //объявляем объект класса с аргументами
    val newResponce = responceApi(200, null)
    //в функции проверяем что status != null, и если не null то печатаем результат
    val result = newResponce.status?.let{
        it != null
        println("Получены данные: $newResponce")
    }
    //иначе печатаем другой результат
    if (result == null) println("Данные не получены")

    println("\nЗадача 4")
    //логируем все объекты классов которые были созданы и печатаем их
    testUser.also { testUser -> println("Логируем создание пользователя $testUser") }
    newOrder.also { newOrder -> println("Логируем отправку запроса $newOrder") }
    newResponce.also { newResponce -> println("Логируем отправку запроса $newResponce") }
}