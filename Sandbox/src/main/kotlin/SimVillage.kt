fun main() {
    val greetingFunction = { playerName: String, numBuildings: Int ->
        val currentYear = 2021
        println("Ajout de $numBuildings maisons")
        "Bienvenue à SimVillage, $playerName ! (copyright $currentYear)"
    }

    runSimulation("Guyal", greetingFunction)
}

fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    println(greetingFunction(playerName, numBuildings))
}