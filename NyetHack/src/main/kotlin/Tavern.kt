const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
    //placeOrder("elixir,Shirley's Temple,4.12")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal parle avec $tavernMaster de sa commande")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal achète un(e) $name ($type) à $price."
    println(message)

    if (name == "Dragon's Breath") {
        println(toDragonSpeak("DRAGON'S BREATH: LA BOISSON DES AVENTURIES !"))
    }
    val phrase = if (name == "Dragon's Breath") {
        "madrigal s'écrie : ${toDragonSpeak("Ah, quelle merveille ce $name")}"
    } else {
        "Madrigal dit merci pour ce $name"
    }
    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a", "A" -> "4"
            "e", "E" -> "3"
            "i", "I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
    }
