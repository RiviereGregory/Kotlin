@file:kotlin.jvm.JvmName("Hero") // Permet de changer le nom de la class Herokt en Hero

package fr.riverjach.interop

import java.io.IOException
import java.util.*

fun main() {
    val adversary = Jhava()
    println(adversary.utterGreeting())

    val friendshipLevel = adversary.determineFriendshipLevel()
    println(friendshipLevel?.lowercase(Locale.getDefault()) ?: "C'est compliqué.")

    val adversaryHitPoints: Int = adversary.hitPoints
    println(adversaryHitPoints.dec())
    println(adversaryHitPoints.javaClass)

    adversary.greeting = "Hello, Héros"
    println(adversary.utterGreeting())

    adversary.offerFood()

    try {
        adversary.extendHandInFriendship()
    } catch (e: Exception) {
        println("Adieu, vilain monstre !")
    }

    adversary.apologize()
}

val translator = { utterance: String -> println(utterance.lowercase(Locale.getDefault()).capitalize()) }

fun makeProclamation() = "Salut, Monstre!"

// Permet d'avoir en Java la surcharge des paramètres
@JvmOverloads
fun handOverFood(leftHand: String = "des baies", rightHand: String = "du boeuf") {
    println("Mmmm... Délicieux : $leftHand et $rightHand")
}

@Throws(IOException::class)
fun acceptApology() {
    throw IOException()
}

class Spellbook {
    @JvmField // Permet de n'avoir pas besoin de getter en java
    val spells = listOf("Magic Ms. L.", "Lay on Hans")

    companion object {
        @JvmField
        val MAX_SPELL_COUNT = 10

        @JvmStatic
        fun getSpellbookGreeting() = println("Je suis le grand Grimoire !")
    }
}
