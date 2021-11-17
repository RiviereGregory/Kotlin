import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

var wasDragonSBreath = 5
val pint = 0.125
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
val patronGold = mutableMapOf<String, Double>()

fun main() {
    displayMenu()
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    displayPatronBalances()

}

fun displayMenu() {
    val message = "** Bienvenu à la taverne Folly **"
    println(message)
    var oldType = ""
    menuList.sorted().forEach { menuData ->
        var menuMessage = ""
        val (type, name, price) = menuData.split(',')
        if (oldType != type) {
            oldType = type
            println("~[$type]~")
        }
        val size = message.length - (name.length + price.length)

        val split = name.split(" ")
        split.forEachIndexed { index, s ->
            menuMessage += s.capitalize()
            if (split.size > index + 1) {
                menuMessage += " "
            }
        }
        menuMessage += ".".repeat(size)
        menuMessage += price
        println(menuMessage)
    }
    println()
    println()
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName parle avec $tavernMaster de sa commande")

    val (type, name, price) = menuData.split(',')

    val message = "$patronName achète un(e) $name ($type) à $price."
    println(message)

    performPurchase(price.toDouble(), patronName)

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

fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, solde : ${"%.2f".format(balance)}")
    }
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
