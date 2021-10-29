fun main() {
    val greetingFunction: (String, Int) -> String = { playerName, numBuildings ->
        val currentYear = 2021
        println("Ajout de $numBuildings maisons")
        "Bienvenue à SimVillage, $playerName ! (copyright $currentYear)"
    }

    println(greetingFunction("Guyal", 2))
}