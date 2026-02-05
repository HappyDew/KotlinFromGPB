//объявили функцию с тремя параметрами который возвращает Double
fun calculate(a: Double, b: Double, operator: String): Double {
    //первый блок
    return try {
        //цикл принимает знак
        when (operator) {
            //если плюс делаем сложение
            "+" -> a + b
            //если минус вычитание
            "-" -> a - b
            //если звезда то умножение
            "*" -> a * b
            //если дробь то
            "/" -> {
                //проверяем будет ли второе число номем и если да то ловим ошибку 1
                if (b == 0.0) throw ArithmeticException()
                //если нет то делим
                a / b
            }
            //если ни один знак не подходит то ловим ошибку 2
            else -> throw IllegalArgumentException()
        }
        //второй блок где если словили ошибку 1 то печатаем это
    } catch (e: ArithmeticException) {
        println("Ошибка деления на ноль")
        0.0
        //третий блок кода если словили ошибку 2 то печатаем это
    } catch (e: IllegalArgumentException) {
        println("Ошибка оператора")
        Double.NaN
        //просто сообщаем что закончили
    } finally {
        println("закончили")
    }
}

fun main() {
    //печатаем результаты
    println("Результат 1: ${calculate(10.0, 0.0, "/")}")
    println("Результат 2: ${calculate(10.0, 5.0, "&")}")
    println("Результат 3: ${calculate(10.0, 2.0, "+")}")
}