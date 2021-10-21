fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    println(auraVisible)

    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    val auraColor = when (karma) {
        in 16..20 -> "VERT"
        in 11..15 -> "VIOLET"
        in 6..10 -> "ORANGE"
        else -> "ROUGE"
    }

    val healthStatus = when (healthPoints) {
        100 -> "est en parfaite condtion !"
        in 90..99 -> "a quelques égratinures."
        in 75..89 -> if (isBlessed) {
            "a quelques blessures mineures, mais se rétablit vite !"
        } else {
            "a quelques blessures mineures."
        }
        in 15..74 -> "semble mal en point."
        else -> "est dans une condition épouvantable !"
    }

// Etat de santé du joueur
    println("(Aura : $auraColor)" + "(Béni : ${if (isBlessed) "OUI" else "NON"})")
    println("$name $healthStatus")

}