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

//Задача 3
// 1. Обобщенный (generic) класс Basket с параметром типа T
// T - это любой тип, который будет указан при создании корзины
class Basket<T>(initialItems: List<T> = emptyList()) {
    private val items = mutableListOf<T>().apply {
        addAll(initialItems) // добавляем начальные элементы
    }

    // Добавляем новый элемент
    fun addItem(newItem: T) {
        items.add(newItem)
    }

    // Возвращаем копию списка (чтобы нельзя было изменить оригинал)
    fun getAllItems(): List<T> = items.toList()
}

// 2. Интерфейс для предметов с весом
interface Weighable {
    val weight: Double // только для чтения
}

// 3. Интерфейс для предметов с ценностью
interface Valuable {
    val value: Int // только для чтения
}

// 4. Функция-расширение для вычисления общего веса
// Ограничение where T: Weighable означает, что эта функция будет доступна
// только для Basket, тип элементов которого реализует интерфейс Weighable
fun <T> Basket<T>.totalWeight(): Double where T : Weighable {
    var total = 0.0
    for (item in this.getAllItems()) {
        total += item.weight // можем обращаться к weight, т.к. T: Weighable
    }
    return total
}

// 5. Аналогично для ценности
fun <T> Basket<T>.totalValue(): Int where T : Valuable {
    return this.getAllItems().sumOf { it.value }
}

// 6. Классы предметов
data class Book(
    val title: String,
    val author: String,
    override val value: Int // реализуем Valuable
) : Valuable // Только Valuable, не Weighable

data class Apple(
    val variety: String,
    override val weight: Double, // реализуем Weighable
    override val value: Int     // и Valuable
) : Weighable, Valuable

fun main() {
    println("Задача 1")
    //вызов функции
    logTestData("null", 5, "Test")

    println("Задача 2")
    //передаем в функцию агументы листа
    countElements(listOf("a" , 2,  false))

    println("=== Тестирование ограничений (constraints) ===")

    // Создаем корзину книг
    val booksBasket = Basket<Book>()
    booksBasket.addItem(Book("Книга 1", "Автор 1", 100))
    booksBasket.addItem(Book("Книга 2", "Автор 2", 200))

    // Корзина яблок
    val applesBasket = Basket<Apple>()
    applesBasket.addItem(Apple("Сорт 1", 0.2, 50))
    applesBasket.addItem(Apple("Сорт 2", 0.3, 70))

    // Тестируем доступные функции:

    // Для Basket<Book> доступно:
    println("Для корзины книг:")
    println("- totalValue(): ${booksBasket.totalValue()}") // ✓ Работает
    // booksBasket.totalWeight() // ❌ Ошибка компиляции! Book не реализует Weighable

    // Для Basket<Apple> доступно:
    println("\nДля корзины яблок:")
    println("- totalWeight(): ${applesBasket.totalWeight()}") // ✓ Работает
    println("- totalValue(): ${applesBasket.totalValue()}")   // ✓ Работает

    // Демонстрация, что компилятор предотвращает ошибки:
    println("\n=== Попытка вызвать недоступные методы (закомментированы) ===")

    // Раскомментируйте следующие строки, чтобы увидеть ошибки компиляции:

    // 1. Ошибка: Book не реализует Weighable
    // val bookWeight = booksBasket.totalWeight()

    // 2. Ошибка: Нельзя создать Basket<Int>, т.к. Int не Valuable/Weighable
    // val intBasket = Basket<Int>()
    // intBasket.addItem(42)
    // intBasket.totalValue() // Ошибка

    // 3. Правильное использование - создаем свой класс:
    data class GoldBar(override val weight: Double, override val value: Int) :
        Weighable, Valuable

    val goldBasket = Basket<GoldBar>()
    goldBasket.addItem(GoldBar(1.0, 50000))
    println("\nКорзина золота:")
    println("- Вес: ${goldBasket.totalWeight()} кг")
    println("- Ценность: ${goldBasket.totalValue()} руб.")
}