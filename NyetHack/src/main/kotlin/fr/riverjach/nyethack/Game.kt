package fr.riverjach.nyethack

import kotlin.system.exitProcess

fun main() {
    Game.play()
}

object Game {
    private var isFinish = false
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()
    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )


    init {
        println("Bienvenue, aventurier.")
        currentRoom.configurePitGoblin { goblin ->
            goblin.healthPoints = dangerLevel * 3
            goblin
        }
    }

    fun play() {
        while (!isFinish) {
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
            println(GameInput(readLine()).processCommand())
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

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction en dehors des limites")
            }
            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, déplacement de $direction dans ${newRoom.name}.\n ${newRoom.load()}"
        } catch (e: Exception) {
            "Direction invalide : $directionInput"
        }

    private fun fight() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0) {
            slay(it)
            Thread.sleep(1000)
        }
        "Combat terminé."
    } ?: "Il n'y a rien a combattre ici."

    private fun slay(monster: Monster) {
        println("${monster.name} a causé ${monster.attack(player)} dommages !")
        println("${player.name} a causé ${player.attack(monster)} dommages !")

        if (player.healthPoints <= 0) {
            println(">>>> Vous avez été vaincu ! Merci d'avoir joué. <<<<")
            exitProcess(0)
        }

        if (monster.healthPoints <= 0) {
            println(">>>> ${monster.name} été vaincu ! <<<<")
            currentRoom.monster = null
        }
    }

    private fun map(): String {
        var map = ""
        worldMap.forEachIndexed { y, list ->
            list.forEachIndexed { x, _ ->
                map += if (player.currentPosition == Coordinate(x, y)) {
                    " X"
                } else {
                    " O"
                }
            }
            map += "\n"
        }
        return map
    }


    private fun ring(argument: String): String {
        var ringText = "Vous ne pouvez faire sonner les cloches que sur la Place Publique"
        if (currentRoom is TownSquare) {
            ringText = (currentRoom as TownSquare).rinBell(argument.toIntOrNull() ?: 1)
        }
        return ringText
    }


    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        fun processCommand() = when (command.toLowerCase()) {
            "exit", "quit" -> {
                isFinish = true
                "Merci d'avoir participé ${fr.riverjach.nyethack.Game.player.name}"
            }
            "fight" -> fight()
            "move" -> move(argument)
            "map" -> map()
            "ring" -> ring(argument)
            else -> commandNotFound()
        }

        private fun commandNotFound() = "Je ne comprends pas ce que vous voulez faire!"
    }
}
