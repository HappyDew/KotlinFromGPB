fun main() {
    println("Задача 1")
    //переменные кодов
    var firstCode = 200
    var secondCode = 201
    //вызов функции и передаем нужные аргументы
    checkStatus(firstCode, secondCode)

    println("\nЗадача 2")
    //создаем переменную в которую кладем вызываемую функцию
    var code = simulateApiRequest()
    //печатаем результат функции
    println("Текущий код: $code")

    println("\nЗадача 3")
    //вызывем simulateApiRequest() и сохраняем результат в переменную actualCode
    var actualCode = simulateApiRequest()
    //вызываем checkStatus(200, actualCode) чтобы сверить ожидаемый код 200 с фактическим
    println("Сверяем коды")
    checkStatus(200, actualCode)
}

//функция Задачи 1, где задаем два параметра и печатаем их
fun checkStatus(expectedCode: Int, actualCode: Int) {
    println("Ожидаемый код: $expectedCode, Фактический код: $actualCode")
}

//функция Задачи 2, которая возвращает одно из трех случайных чисел из списка
fun simulateApiRequest(): Int {
    return listOf(200, 400, 500).random()
}