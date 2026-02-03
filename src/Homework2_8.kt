//объявляем функцию с дженериком, в констукторе объявляем три параметра, третья с неизвестным типом
fun <T> logTestData(description: String?, items: Number?, data: T) {
    //проверяем сравнивая каждую переменную на != null
    if (!description.isNullOrBlank() && items != null && data != null) {
        //если всё ок, то печатем это
        println("$description, $items, $data")
        //иначе ошибка данных при вводе null
    } else {
        println("Ошибка данных")
    }
}

//объявили фунцию которая принимает список
fun <T> countElements(list: List<T>) {
    //печатаем кол-во элементов
    println("Кол-во: ${list.size}")
}

/*class Basket<T>(items: List<T>) {
    private val newItems = mutableListOf<T>()

    fun addItem(newItem: T){

    }

    fun getAllItems() {

    }
}*/

fun main() {
    println("Задача 1")
    //вызов функции
    logTestData("null", 5, "Test")

    println("Задача 2")
    //передаем в функцию агументы листа
    countElements(listOf("a" , 2,  false))
}