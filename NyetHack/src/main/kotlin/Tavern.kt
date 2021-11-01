const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
    placeOrder()
}

fun placeOrder() {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal parle avec $tavernMaster de sa commande")
}