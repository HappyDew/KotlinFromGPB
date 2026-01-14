fun main() {
    println("===Задача 1===")
    //Создаем массив invalidEmails, содержащий 3-4 заведомо невалидных email-адреса
    val invalidEmails: List<String> = listOf("безсобаки", "@без-логина", "с-точкой-в-начале.@mail.ru")
    println(invalidEmails)

    println("\n===Задача 2===")
    //Напишем код, который берет первый email из этого списка и "отправляет" его в систему.
    val sendEmailsInSystem = invalidEmails[0]
    println("Пользователь вводит email: '$sendEmailsInSystem'")

    //симуляция ответа системы, объявляем переменную errorMessage и присваиваем ей значение "Неверный формат email"
    val errorMessage = "Неверный формат email"
    println("Ответ системы: $errorMessage")

    println("\n===Задача 3===")
    //Используя строковые шаблоны и методы, выводим на экран:
    //какой email был введен
    println("Был введен email: '$sendEmailsInSystem'")

    //какую ошибку вернула система
    println("Система вернула ошибку: '$errorMessage'")

    //длина введенного email
    println("Длина введенного email была: ${sendEmailsInSystem.length} символов")

    //проверяем содержит ли текст ошибки слово "формат" с выводом true/false
    println("Содержит ли текст ошибки слово 'формат'? ${errorMessage.contains("формат")}")

}