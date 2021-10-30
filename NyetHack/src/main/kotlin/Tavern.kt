fun main() {
    var beverage = readLine()

    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("Je ne peux pas faire cela sans planter - beverage = null !!!")
    }

    val beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)
}