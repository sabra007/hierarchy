import kotlin.math.PI
import kotlin.math.sqrt

fun main() {

    var squareCabin = SquareCabin(5, 50.0)

    with(squareCabin) {
        println("\nSquare Cabin\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room?: ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()

    }


    val roundHut = RoundHut(3, 10.0)
    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")

    }

    val roundTower = RoundTower(4, 15.5,2)
    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")

    }
}


abstract class Dwelling(private var residents: Int) {
    // Properties
    abstract val buildingMaterial: String
    abstract val capacity: Int
    abstract fun floorArea(): Double

    fun hasRoom(): Boolean {
        return residents < capacity
    }
    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You got a room")
        }
        else {
            println("Sorry, at capacity and no rooms left")
        }
    }
}


class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity: Int
        get() = 6

    override fun floorArea(): Double {
        return length * length
    }
}


open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial: String
        get() = "Straw"
    override val capacity: Int
        get() = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

class RoundTower(residents: Int, radius: Double, val floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial: String
        get() = "Stone"
    override val capacity: Int
        get() = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }

}