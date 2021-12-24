package fr.riverjach.nyethack

fun main() {
    Game.play()
}

object Game {
    private val player = Player("Madrigal")
    private var currentRoom = TownSquare()


    init {
        println("Bienvenue, aventurier.")
        player.castFireball()
    }

    fun play() {
        while (true) {
            // Test Salle
            println(currentRoom.description())
            println(currentRoom.load())

            // Etat de santé du joueur
            printPlayerStatus(player)

            // Défi : Format de l'Etat configurable Solution trouvé sur le net
            defiFormatEtatConfigurable(player)

            val drunkLevel = player.castFireball()
            println(drunkLevel(drunkLevel))

            print("> Saisissez votre commande :")
            println("Dernière commande : ${readLine()}")
        }
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura : ${player.auraColor()})" + "(Béni : ${if (player.isBlessed) "OUI" else "NON"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private fun defiFormatEtatConfigurable(player: Player) {
        val statusFormatString = "(HP)(A) -> H"
        val formatSpecifiers = "HP|H|A".toRegex()

        var result = StringBuffer()

        var i = 0
        formatSpecifiers.findAll(statusFormatString).forEach { match ->
            result.append(statusFormatString.substring(i, match.range.first))
            result.append(
                when (match.value) {
                    "H" -> "${player.name} ${player.formatHealthStatus()}"
                    "HP" -> "HP : ${player.healthPoints}"
                    "A" -> "Aura : ${player.auraColor()}"
                    else -> "?"
                }
            )
            i = match.range.last + 1
        }
        result.append(statusFormatString.substring(i))

        println("$result")
    }

    private fun drunkLevel(drunk: Int) = when (drunk) {
        in 1..10 -> "Pompette"
        in 11..20 -> "Pinté"
        in 21..30 -> "Murgé"
        in 31..40 -> "Imbibé"
        else -> "Décalqué"
    }
}