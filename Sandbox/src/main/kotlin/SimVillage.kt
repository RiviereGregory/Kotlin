fun main() {
    val greetingFunction: (String) -> String = { playerName ->
        val currentYear = 2021
        "Bienvenue à SimVillage, $playerName ! (copyright $currentYear)"
    }

    println(greetingFunction("Guyal"))
}