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
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")

fun main() {
    displayMenu()
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }
}

fun displayMenu() {
    val message = "** Bienvenu à la taverne Folly **"
    println(message)
    menuList.forEach { menuData ->
        val (_, name, price) = menuData.split(',')
        val size = message.length - (name.length + price.length)

        val split = name.split(" ")
        split.forEachIndexed { index, s ->
            print(s.capitalize())
            if (split.size > index + 1) {
                print(" ")
            }
        }
        print(".".repeat(size))
        println(price)
    }
    println()
    println()
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
        "$patronName s'écrie : ${toDragonSpeak("Ah, quelle merveille ce $name")}"
    } else {
        "$patronName dit merci pour ce $name"
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
