fun main() {
    println("Задача 1")
    //все цены в коллекции
    val prices = listOf(99.99, 25.50, 75.00, 300.00, 49.99)
    //объявляем мин и макс переменные, где спец методы возвращают мин и макс
    val minPrice = prices.min()
    val maxPrice = prices.max()
    //печатаем результат
    println("Минимальная цена: $minPrice; Максимальная цена: $maxPrice")

    //объявляем переменную со ср ценой по спец методу
    val averagePrice = prices.average()
    //печатаем результат с форматирование плавающей запятой после точки обрезая до 2х точек
    println("Средняя цена: ${"%.2f".format(averagePrice)}")

    //переменная где пройдясь по всей коллекции ищем что больше 50.0
    val upPrice = prices.filter { it > 50.0 }
    //печатаем результат
    println("Цены что выше 50.0: $upPrice")

    println("\nЗадача 2")
    //все имена в коллекции
    val users = listOf("alice", "bob", "charlie", "david", "eve")
    //переменная где коллекцию преобразуем в верхний регистр
    //  Можно и так, но вообще такие дейстия можно делать короче, так одна строчка заменяет 4, да их нет хнанения промежуточных данных в памяти
    // users.foreach { println("User: ${it.uppercase()}")}
    val upperCaseUsers = users.map { it.uppercase() }
    //для каждого элемента делаем перебор
    for (upperCaseUser in upperCaseUsers) {
        //если условие true печатаем результат
        println("User $upperCaseUser")
    }

    //переменная где ищем первое имя длиннее 4 символов
    val longName = users.find { it.length > 4 }
    //печатаем результат
    println("Первое имя длиннее 4 символов: $longName")

    //переменная где сортируем имена по длине
    //Там не про сортировку в задании, а про группировку
    val usersSortedByNameLenght = users.groupBy { it.length }
    //печатаем результат
    println("Результат группировки имен по длине: $usersSortedByNameLenght")

    println("\nЗадача 3")
    //ответ от API
    val apiResponse = mapOf(
        "data" to listOf(
            mapOf("id" to 1, "status" to "active"),
            mapOf("id" to 2, "status" to "inactive"),
            mapOf("id" to 3, "status" to "active")
        ),
        "total" to 3
    )
    //принудительное приведение типов из Any в List (небезопасно), где фильтруем уже активные статусы
    //Если тебе несколько раз приходится выполнять оно и тоже дейстие, сохраняй результат в переменную, а не копипастой занимайся
    //Так правильней:
    //val activeUsers = (apiResponse["data"] as List<Map<String,Any>>).filter  {it["status"] == "active"}
    //println("Записи активных пользователей: $activeUsers")
    //println("Количество активных записей: $activeUsers.count()")

    val activeUsers = (apiResponse["data"] as List<Map<String, Any>>).filter { it["status"] == "active" }
    //печатаем результаты
    println("Записи активных пользователей: $activeUsers")
    println("Количество активных записей: ${activeUsers.count()}")
}
