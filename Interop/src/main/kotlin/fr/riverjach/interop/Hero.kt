package fr.riverjach.interop

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
}