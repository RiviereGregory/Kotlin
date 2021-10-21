fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "VERTE" else "AUCUNE"
    println(auraColor)

    val healthStatus = if (healthPoints == 100) "est en parfaite condtion !"
    else if (healthPoints >= 90) "a quelques égratinures."
    else if (healthPoints >= 75)
        if (isBlessed) "a quelques blessures mineures, mais se rétablit vite !"
        else "a quelques blessures mineures."
    else if (healthPoints >= 15) "semble mal en point."
    else "est dans une condition épouvantable !"

// Etat de santé du joueur
    println("$name $healthStatus")

}