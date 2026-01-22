fun main() {
    println("Задача 1")
    //в переменной объявляем лямбду с типом Int которая проверяет number больше 0
    val isPositive = { number: Int ->
        number > 0
    }
    //объявляем переменную с неким числом
    val positiveNumber = 2
    //тут проверяем условие, если positiveNumber в isPositive = true то один иначе другой
    println("$positiveNumber - ${if(isPositive(positiveNumber)) "положительное" else "отрицательное"}")

    println("\nЗадача 2")
    val isValidPhone = { phoneNumber: String ->
        //Проверка здесь неверная, ты проверяешь что начинается с +7, длина всей строки 12, и что в строке есть хотя бы одна цифра
        phoneNumber.startsWith("+7") && phoneNumber.length <= 12 && phoneNumber.any {it.isDigit()}
    }
    val inputPhoneNumber = "+79249998877"
    println("$inputPhoneNumber - ${if (isValidPhone(inputPhoneNumber)) "Валидный номер" else "Не валидный номер"}")

    println("\nЗадача 3")
    val logTestStart = {
        val currentTime = java.time.LocalTime.now()
        println("Тест 1 запущен в $currentTime")
    }
    logTestStart()
}
