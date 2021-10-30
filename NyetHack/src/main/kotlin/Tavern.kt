fun main() {
    var beverage = readLine()
//    beverage = null
    beverage?.let {
        beverage = it.capitalize()
    } ?: println("Je ne peux pas faire cela sans planter - beverage = null !!!")

    val beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)
}