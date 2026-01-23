fun main() {
    println("Задача 1")
    //в переменной объявляем лямбду с типом Int которая проверяет number больше 0
    val isPositive = { number: Int ->
        number > 0
    }
    //объявляем переменную с неким числом
    val positiveNumber = 2
    //тут проверяем условие, если positiveNumber в isPositive = true то один иначе другой
    println("$positiveNumber - ${if (isPositive(positiveNumber)) "положительное" else "отрицательное"}")

    println("\nЗадача 2")
    //в переменной объявляем лямбду с типом String
    val isValidPhone = { phoneNumber: String ->
        //тут проверяем что начинается с +7, потом что кол-во цифр = 11, а потом отбрасываем 2 первых символа и в остатке проверяем что они цифры
        phoneNumber.startsWith("+7") && phoneNumber.count { it.isDigit() } == 11 && phoneNumber.drop(2)
            .all { it.isDigit() }

    }
    //объявляем переменную с неким номером
    val inputPhoneNumber = "+79249998877"
    //проверяем условие что если inputPhoneNumber в isValidPhone = true, то одик иначе другой
    println("$inputPhoneNumber - ${if (isValidPhone(inputPhoneNumber)) "Валидный номер" else "Не валидный номер"}")

    println("\nЗадача 3")
    //объявили лямбду без параметров
    val logTestStart = {
        //объявляем переменую для вывода времени
        val currentTime = java.time.LocalTime.now()
        //печатаем результат
        println("Тест 1 запущен в $currentTime")
    }
    //вызываем лямбду без параметров
    logTestStart()
}