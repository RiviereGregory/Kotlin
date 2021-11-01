const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
    // placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("elixir,Shirley's Temple,4.12")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal parle avec $tavernMaster de sa commande")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal achète un(e) $name ($type) à $price."
    println(message)

    val phrase = if (name == "Dragon's Breath") {
        "madrigal s'écrie : ${toDragonSpeak("Ah, quelle merveillece $name")}"
    } else {
        "Madrigal dit merci pour ce $name"
    }
    println(phrase)
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
