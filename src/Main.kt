fun main() {
    println("Задача 1")
    //функция которая возвращает элемент $searchld" для search>0
    fun simulateElementSearch(searchId: Int): String? {
        return if (searchId > 0) "searchld $searchId больше 0 " else null
    }

    println("\nЗадача 2")
    //передаем в качестве аргумента 2 и если true исп-я Elvis operator выводим текст функции
    val element1: String? = simulateElementSearch(2) ?: "Элемент не найден"
    println("Результат поиска (элемент есть): '$element1'")
    //если false то выводим текст по умолчанию
    val element2: String? = simulateElementSearch(-5) ?: "Элемент не найден"
    println("Результат поиска (элемента нет): '$element2'")

    println("\nЗадача 3")
    //объявляем массив с двумя элементами
    val serverResponse = arrayOf("error", 404)
    //где проверяем является ли второй элемент массива числом
    if (serverResponse[1] is Int) {
        //если число выводим следуюий ответ
        println("Код ошибки: '${serverResponse[1]}'")
    } else {
        //если не число выводим следующий ответ
        serverResponse[1] as? String
        println("Неизвестный код ошибки")
    }
}

