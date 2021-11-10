import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
var wasDragonSBreath = 5
val pint = 0.125
val valueDragonCoin = 1.43
val playerDragonCoin = 5
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")

fun main() {
    if (patronList.contains("Eli")) {
        println("Le maitre de la taverne dit qu'Eli joue aux cartes.")
    } else {
        println("Le maitre de la taverne dit qu'Eli n'est pas là.")
    }
    if (patronList.containsAll(listOf("Mordoc", "Sophie"))) {
        println("Le maitre de la taverne dit qu'ils sont à côté de la marmite de pot-au-feu.")
    } else {
        println("Le maitre de la taverne dit qu'ils sont partis.")
    }
    //placeOrder("elixir,Shirley's Temple,4.12")
    patronList.forEachIndexed { index, patron ->
        println("Bonjour, $patron - vous êtes le n°${index + 1} dans la file.")
        placeOrder(patron, "shandy,Dragon's Breath,5.91")
    }

    menuList.forEachIndexed { index, data ->
        println("$index : $data")
    }
}

fun performPurchase(price: Double): Boolean {
    displayBalance()
    var totalPurse = playerGold + (playerSilver / 100.0)
    println("Solde de la bourse : $totalPurse")
    println("Achat d'une boisson à $price")

    val remainingBalance = totalPurse - price
    if (remainingBalance < 0) {
        return false
    }
    println("Solde restant : ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
    paidDragonCoin(price)
    return true
}

private fun displayBalance() {
    println("Solde de la bourse du joueur : Or : $playerGold , Argent : $playerSilver")
}

private fun paidDragonCoin(price: Double) {
    var priceDC = price / valueDragonCoin
    val remainingBalanceDC = playerDragonCoin - priceDC
    println("Solde restant en DragonCoin: ${"%.4f".format(remainingBalanceDC)}")
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName parle avec $tavernMaster de sa commande")

    val (type, name, price) = menuData.split(',')

    val message = "$patronName achète un(e) $name ($type) à $price."
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

//    Défi calcul du nombre de pinte restante
    numberPintsRemaining(12)
}

private fun numberPintsRemaining(nbPints: Int) {
    val nbPintsInWas = wasDragonSBreath / pint
    val nbPintsRemaining = nbPintsInWas.toInt() - nbPints
    println("Nombre de pintes restant dans le fût $nbPintsRemaining")

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
