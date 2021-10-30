fun main() {
    var swordJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordJuggling = 2
    }

    proficiencyCheck(swordJuggling)
    swordJuggling = swordJuggling!!.plus(1)
    println("Vous jonglez avec $swordJuggling épées!")
}

fun proficiencyCheck(swordJuggling: Int?) {
    swordJuggling ?: throw UnskilledSwordJugglerException()
}

class UnskilledSwordJugglerException() :
    IllegalStateException("Le joueur ne sait pas jongler avec des épées")