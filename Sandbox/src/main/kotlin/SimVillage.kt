fun main() {
    val greetingFunction: () -> String = {
        val currentYear = 2021
        "Bienvenue à SimVillage, Monsieur le Maire ! (copyright $currentYear)"
    }

    println(greetingFunction())
}