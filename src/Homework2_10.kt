import NameEmployee.printName
//Задача 1
//объявлем объект ввода нового сотрудника
object NameEmployee {
    //объявляем аннотацию на замену старой функции на новую с текстом подсказкой
    @Deprecated(
        "Используйте printEmployeeName() c вводом ещё и возраста",
        replaceWith = ReplaceWith("printEmployeeName(name, age)"),
        level = DeprecationLevel.WARNING
    )
    //объявляем старую функцию с вводом имени
    fun printName(name: String) : String {
        return name
    }
    //объявляем новую функцию с вводом имени + возраста
    fun printEmployeeName(name: String, age: Int) : String {
        return "$name, $age"
    }
}

fun main() {
    //вызываем старую функцию
    NameEmployee.printName("Вася")
}