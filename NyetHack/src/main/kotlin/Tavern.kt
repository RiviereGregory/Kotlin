const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal parle avec $tavernMaster de sa commande")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal achète un(e) $name ($type) à $price."
    println(message)

    val phrase = "Ah, quelle merveillece $name"
    println("madrigal s'écrie : ${toDragonSpeak(phrase)}")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }
