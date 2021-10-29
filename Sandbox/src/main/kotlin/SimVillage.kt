fun main() {
    runSimulation("Guyal") { playerName, numBuildings ->
        val currentYear = 2021
        println("Ajout de $numBuildings maisons")
        "Bienvenue à SimVillage, $playerName ! (copyright $currentYear)"
    }

}

// utilisation de inline pour optimiser les lambda dans la JVM
inline fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    println(greetingFunction(playerName, numBuildings))
}