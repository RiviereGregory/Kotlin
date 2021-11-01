const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
}

fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal parle avec $tavernMaster de sa commande")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal achète un(e) $name ($type) à $price."
    println(message)
}