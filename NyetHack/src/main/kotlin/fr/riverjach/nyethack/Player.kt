package fr.riverjach.nyethack

import java.io.File
import kotlin.math.pow
import fr.riverjach.nyethack.extensions.random as randomizer

class Player(
    _name: String,
    override var healthPoints: Int = 100,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) : Fightable {

    override val diceCount = 3
    override val diceSides = 6

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }

    var name = _name
        get() = "${field.capitalize()} de $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown by lazy { selectHometown() }
    var currentPosition = Coordinate(0, 0)

    init {
        require(healthPoints > 0) { "healthPoints doit être supérieur à zéro." }
        require(name.isNotBlank()) { "Le joueur doit avoir un nom." }
    }

    constructor(name: String) : this(
        name,
        isBlessed = true,
        isImmortal = false
    ) {
        if (name.toLowerCase() == "kar") healthPoints = 40
    }

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .randomizer()

    fun castFireball(numFireballs: Int = 2): Int {
        println("Apparition d'un verre de Fireball. (x$numFireballs)")
        return when (numFireballs) {
            0 -> 1
            1 -> 5
            2 -> 10
            3 -> 15
            4 -> 20
            5 -> 25
            6 -> 30
            7 -> 35
            8 -> 40
            9 -> 45
            else -> 50
        }
    }

    fun formatHealthStatus() = when (healthPoints) {
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

    fun auraColor() = when ((Math.random().pow((110 - healthPoints) / 100.0) * 20).toInt()) {
        in 16..20 -> "VERT"
        in 11..15 -> "VIOLET"
        in 6..10 -> "ORANGE"
        else -> "ROUGE"
    }
}