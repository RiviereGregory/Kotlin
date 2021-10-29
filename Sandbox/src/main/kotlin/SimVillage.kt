fun main() {
    runSimulation("Guyal", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2021
        println("Ajout de $numBuildings maisons")
        "Bienvenue à SimVillage, $playerName ! (copyright $currentYear)"
    }

}

// utilisation de inline pour optimiser les lambda dans la JVM
inline fun runSimulation(
    playerName: String,
    costPrinter: (Int) -> Unit,
    greetingFunction: (String, Int) -> String
) {
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("Coût de la construction : ${cost * numBuildings}")
}