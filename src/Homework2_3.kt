fun main() {
    println("Задача 1")
    //создали переменную serverStatus = String
    var serverStatus = "processing"
    //создали переменную countServerStatus равную нулю
    var countServerStatus: Int = 0

    //когда в цикле countServerStatus дойдет до 3 то остановится,
    //а до этого печатает текст serverStatus
    //По задание установка статуса в processing должна быть в цикле, и условие выхода из цикла должно быть значение success в переменной serverStatus
    while (serverStatus != "success") {
        println("Статус: $serverStatus")
        //инкремент чтобы цикл не стал вечным
        countServerStatus++
        if (countServerStatus == 3) {
            serverStatus = "success"
        }
    }
    //по завершению цикла печать последнего статуса
    println("Статус: $serverStatus")

    println("\nЗадача 2")
    //цикл повторяется пять раз
    for (i in 1..5) {
        //не нужно создавать лишних переменных которые непонятно что хранят,
        //в данном случае необходимо в цикле сделать один when в котором и будет вывод необходимой строки
        when (i) {
            1 -> println("Тест $i: В процессе")
            2 -> println("Тест $i: В процессе")
            3 -> println("Тест $i: В процессе")
            4 -> println("Тест $i: Провален")
            else -> println("Тест $i: Успех")
        }
        //Это дерево if'ов вообще не нужно
    }

    println("\nЗадача 3")
    //функция которая определяет сложно теста на основе длительности и сложности
    fun testBrains(duration: Int, complexity: Int){
        when {
            //когда тест до 10 минут то такой ответ
            duration < 10 -> println("Быстрый тест")
            //когда тест от 10 до 30 минут и сложность от 1 до 3 то такой ответ
            duration in 10..30 && complexity in 1..3 -> println("Стандартный тест")
            //когда тест от 10 до 30 минут и сложность от 4 до 5 то такой ответ
            duration in 10..30 && complexity in 4..5 -> println("Сложный тест")
            //когда тест более 30 минут такой ответ
            duration > 30 -> println("Длительный тест")
            //в дз не было про это, но добавил на всякий
            else -> println("Тест провален")
        }
    }
}