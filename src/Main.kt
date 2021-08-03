import java.util.*

/*
La diferencia entre Set y array es que set no admite elementos duplicados y el acceso de lectura, escritura es
compatible a través de la interfaz. Los Array son estructuras de datos, admiten eventos duplicados y no hace falta
que pase por alguna interfaz.
*/

/*
Elegimos para este caso Set ya que nos permite que no hayan elementos duplicados (patentes no repetidas)
y se debe cumplir con una interfaz (vehiculos autorizados, fecha de ingreso)
*/

data class Parkable(var vehicle: Vehicle, var type: VehicleType, var checkInTime: Calendar, var discountCard: String = "",
                    val parkerdTime: Long)
get () =(Calendar.getInstance(). timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

data class Parking(val vehicles: MutableSet<Vehicle>)

class Vehicle(val plate: String, val type: VehicleType, val checkInTime: Calendar, var discountCard: String = ""){
    override fun equals(other: Any?): Boolean{
        if(other is Vehicle){
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int{
        return this.plate.hashCode()
    }
}

enum class  VehicleType(val tarifa : Int){
    CAR(20), BUS(30), MINIBUS(25), MOTORCYCLE(15);
}

fun main() {




    //val otro = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance())
    val car = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "asdasdasd")
    val moto = Vehicle("B222BBB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus = Vehicle("CC333CC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus = Vehicle( "DD444DD", VehicleType.BUS, Calendar.getInstance())
    val parking = Parking(mutableSetOf(car, moto, minibus, bus))

    println(parking.vehicles.contains(car))
    println(parking.vehicles.contains(moto))
    println(parking.vehicles.contains(minibus))
    println(parking.vehicles.contains(bus))

    /*var vehicles = Array(Vehicle("asd"), Vehicle("asd"))
    var parking = Parking(vehicles)*/
/*
    var vehiculo1:Vehicle = Vehicle("asd1")
    var vehiculo2:Vehicle = Vehicle("asd2")*/

    /*var userVehicleType = VehicleType.CAR
    println("VehicleType : $userVehicleType")
    println(userVehicleType.tarifa)*/

}
