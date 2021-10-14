const val MAX_EXPERIENCE: Int = 5000

fun main() {
    var hasSteed = false
    val playerName = "Estragon"
    var experiencePoints = 5
    val nomPatron = "Le patron"
    val nomDuPub = "La corne de la licorne"
    var nombrePieces = 0
    val carteBoissons: Set<String> = setOf("Hydromel", "vin", "LaCroix")
    nombrePieces += 50
    experiencePoints += 5
    println(experiencePoints)
    println(playerName)
    println(MAX_EXPERIENCE)
    println("Le joueur à une monture $hasSteed")
    println("Le nom du pub $nomDuPub dont le propriétaire est $nomPatron")
    println("$playerName à $nombrePieces pièces d'or")
    println("Voici la carte des boissons $carteBoissons")
    println(playerName.reversed())
}