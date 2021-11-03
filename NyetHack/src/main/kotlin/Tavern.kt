const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
    //placeOrder("elixir,Shirley's Temple,4.12")
}

fun performPurchase(price: Double) {
    displayBalance()
    var totalPurse = playerGold + (playerSilver / 100.0)
    println("Solde de la bourse : $totalPurse")
    println("Achat d'une boisson à $price")

    val remainingBalance = totalPurse - price
    println("Solde restant : ${"%.2f".format(remainingBalance)}")
}

private fun displayBalance() {
    println("Solde de la bourse du joueur : Or : $playerGold , Argent : $playerSilver")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal parle avec $tavernMaster de sa commande")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal achète un(e) $name ($type) à $price."
    println(message)
    performPurchase(price.toDouble())

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
