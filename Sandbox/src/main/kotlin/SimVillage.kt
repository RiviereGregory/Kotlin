fun main() {
    runSimulation()

}

fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Guyal"))
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hopitaux"
    var numBuildings = 5
    return { playerName ->
        val currentYear = 2021
        numBuildings += 1
        println("Ajout de $numBuildings $structureType")
        "Bienvenue à SimVillage, $playerName ! (copyright $currentYear)"
    }
}