import kotlin.math.pow

fun main() {
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val player = Player()

    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    println(auraVisible)

    val auraColor = auraColor(healthPoints)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // Etat de santé du joueur
    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)

    // Défi : Format de l'Etat configurable Solution trouvé sur le net
    defiFormatEtatConfigurable(player.name, healthStatus, healthPoints, auraColor)

    val drunkLevel = player.castFireball()
    println(drunkLevel(drunkLevel))
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura : $auraColor)" + "(Béni : ${if (isBlessed) "OUI" else "NON"})")
    println("$name $healthStatus")
}

private fun auraColor(healthPoints: Int) = when ((Math.random().pow((110 - healthPoints) / 100.0) * 20).toInt()) {
    in 16..20 -> "VERT"
    in 11..15 -> "VIOLET"
    in 6..10 -> "ORANGE"
    else -> "ROUGE"
}


private fun defiFormatEtatConfigurable(
    name: String,
    healthStatus: String,
    healthPoints: Int,
    auraColor: String
) {
    val statusFormatString = "(HP)(A) -> H"
    val formatSpecifiers = "HP|H|A".toRegex()

    var result = StringBuffer()

    var i = 0
    formatSpecifiers.findAll(statusFormatString).forEach { match ->
        result.append(statusFormatString.substring(i, match.range.first))
        result.append(
            when (match.value) {
                "H" -> "$name $healthStatus"
                "HP" -> "HP : $healthPoints"
                "A" -> "Aura : $auraColor"
                else -> "?"
            }
        )
        i = match.range.last + 1
    }
    result.append(statusFormatString.substring(i))

    println("$result")
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
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

private fun drunkLevel(drunk: Int) = when (drunk) {
    in 1..10 -> "Pompette"
    in 11..20 -> "Pinté"
    in 21..30 -> "Murgé"
    in 31..40 -> "Imbibé"
    else -> "Décalqué"
}
