fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "VERTE" else "AUCUNE"
    println(auraColor)

    val healthStatus = if (healthPoints == 100) "est en parfaite condtion !"
    else if (healthPoints in 90..99) "a quelques égratinures."
    else if (healthPoints in 75..89)
        if (isBlessed) "a quelques blessures mineures, mais se rétablit vite !"
        else "a quelques blessures mineures."
    else if (healthPoints in 15..74) "semble mal en point."
    else "est dans une condition épouvantable !"

// Etat de santé du joueur
    println("$name $healthStatus")

}