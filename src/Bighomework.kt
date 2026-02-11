abstract class Vehicle(//ПЕРЕВОД ТРАНСПОРТНОЕ СРЕДСТВО
    open val vin: String,
    open val model: String,
    open val yearManufacture: Int,
    open var mileage: Int = 0,
    open var healthStatus: Boolean = true
)
//Car, Bus, Track будут со своими интерфейсами которы описаны ниже, два пассажирских и грузовой

data class Car(//data class для хранения данных
    override val vin: String,
    override val model: String,
    override val yearManufacture: Int,
    override var mileage: Int,
    override var healthStatus: Boolean,
    override val maxPassengers: Int = 5,//можно в конструктор засунуть
    override val currentPassengers: Int = 3
) : Vehicle(vin, model, yearManufacture, mileage, healthStatus), PassengerTransport

data class Bus(
    override val vin: String,
    override val model: String,
    override val yearManufacture: Int,
    override var mileage: Int,
    override var healthStatus: Boolean,
    override val maxPassengers: Int = 32,
    override val currentPassengers: Int = 15
) : Vehicle(vin, model, yearManufacture, mileage, healthStatus), PassengerTransport

data class Track(
    override val vin: String,
    override val model: String,
    override val yearManufacture: Int,
    override var mileage: Int,
    override var healthStatus: Boolean,
    override val maxLoadCapacity: Double = 10000.00,
    override val currentLoad: Double = 5000.00
) : Vehicle(vin, model, yearManufacture, mileage, healthStatus), CargoTransport

interface PassengerTransport {
    val maxPassengers: Int
    val currentPassengers: Int

    fun board(count: Int): Int {
        if (count > maxPassengers) {
            throw IllegalArgumentException("Превышено максимальное кол-во пассажиров в 'maxPassengers'")
        }
        return currentPassengers
    }

    fun unboard(count: Int): Int {
        if (count > maxPassengers) {
            //тут вместо IllegalArgumentException д.б. вызов объекта класса VehicleException
            throw VehicleException("Попытка высадить больше чем дозволено 'maxPassengers'")
        }
        //currentPassengers -= count
        return currentPassengers
    }
}

interface CargoTransport {
    val maxLoadCapacity: Double
    val currentLoad: Double
    fun load(weight: Double): Double {
        if (weight > maxLoadCapacity) {
            throw VehicleException("Попытка высадить больше чем дозволено 'maxPassengers'")
        }
        return currentLoad.toDouble()
    }

    fun unload(): Double {
        var minus: Double
        return (maxLoadCapacity - currentLoad).also { minus = it }
        //currentLoad = 0.00
    }
}

class VehicleException(message: String) : RuntimeException()
//тут в конструкторе добавить поле message


//класс автопарков
class VehicleFleet<T : Vehicle>(val name: String) {
    //сделать конструктор и добавить нейм и коллекцию ТС (два поля) , создать два или три объекта в main этого класса и наполнить ТС
    private val vehicles = mutableSetOf<T>()

    fun addVehicle(vehicle: T) {
        vehicles.add(vehicle)
        println("Добавлено в '$name': ${vehicle.model} (${vehicle.yearManufacture})")
    }

    fun removeVehicle(vehicle: T) {//реализовать
        vehicles.remove(vehicle)
        println("Убран из '$name': ${vehicle.model} (${vehicle.yearManufacture})")
    }

    fun getVehicles(): List<T> {//реализовать
        return vehicles.toList()
    }

    fun getAllTrucksMaxLoad(): Double {//реализовать
        return vehicles.filterIsInstance<CargoTransport>().sumOf { it.maxLoadCapacity }
    }

    fun getAllPassengerTransport(): List<PassengerTransport> {//реализовать
        return vehicles.filterIsInstance<PassengerTransport>()
    }
}

/*fun <T : Vehicle> VehicleFleet<T>.findNewestVehicle() {

}

fun String.findMaxPassengersVehicle() {

}*/


fun main() {
    val firstVehicleFleet = VehicleFleet<Vehicle>("Первый автопарк")
    firstVehicleFleet.addVehicle(Car("vin123", "porchse", 1980, 100000, true))
    firstVehicleFleet.addVehicle(Car("vin234", "yaz", 1990, 20000, true))
    firstVehicleFleet.addVehicle(Bus("vin345", "paz", 2000, 30000, true))
    firstVehicleFleet.addVehicle(Track("vin123x", "kamaz", 1970, 300000, false))
    firstVehicleFleet.addVehicle(Track("vin234x", "kraz", 1970, 400000, true))
    firstVehicleFleet.addVehicle(Track("vin345x", "ural", 2010, 300000, true))

    val secondVehicleFleet = VehicleFleet<Vehicle>("Второй автопарк")
    secondVehicleFleet.addVehicle(Car("vin1x", "volvo", 1990, 4000000, false))
    secondVehicleFleet.addVehicle(Car("vin2x", "Benz", 2020, 10000, true))
    secondVehicleFleet.addVehicle(Bus("vin3x", "volgaBus", 2010, 300000, true))
    secondVehicleFleet.addVehicle(Track("vin4x", "belaz", 2000, 700000, false))
    secondVehicleFleet.addVehicle(Track("vin5x", "canter", 1990, 900000, true))
    secondVehicleFleet.addVehicle(Track("vin6x", "buhanka", 1980, 600000, true))

    firstVehicleFleet.removeVehicle(Car("vin123", "porchse", 1980, 100000, true))
    secondVehicleFleet.removeVehicle(Car("vin1x", "volvo", 1990, 4000000, false))

    println("Неизменяемый список первого автопарка: ${firstVehicleFleet.getVehicles()}")
    println("Неизменяемый список второго автопарка: ${secondVehicleFleet.getVehicles()}")

    println("Суммарная максимальная грузоподъемность грузовиков в первом автопарке: ${firstVehicleFleet.getAllTrucksMaxLoad()}")
    println("Суммарная максимальная грузоподъемность грузовиков во втором автопарке: ${secondVehicleFleet.getAllTrucksMaxLoad()}")

    println("Список пассажирского транспорта в первом автопарке: ${firstVehicleFleet.getAllPassengerTransport()}")
    println("Список пассажирского транспорта во втором автопарке: ${secondVehicleFleet.getAllPassengerTransport()}")

}