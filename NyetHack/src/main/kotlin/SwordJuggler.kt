fun main() {
    var swordJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordJuggling = 2
    }

    try {
        proficiencyCheck(swordJuggling)
        swordJuggling = swordJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }
    println("Vous jonglez avec $swordJuggling épées!")
}

fun proficiencyCheck(swordJuggling: Int?) {
    checkNotNull(swordJuggling, { "Le joueur ne sait pas jongler avec des épées" })
}

class UnskilledSwordJugglerException() :
    IllegalStateException("Le joueur ne sait pas jongler avec des épées")