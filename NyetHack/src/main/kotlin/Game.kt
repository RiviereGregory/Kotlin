fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    if (isBlessed && healthPoints > 50 || isImmortal) {
        println("VERTE")
    } else {
        println("AUCUNE")
    }

    if (healthPoints == 100) {
        println("$name est en parfaite condtion !")
    } else if (healthPoints >= 90) {
        println("$name a quelques égratinures.")
    } else if (healthPoints >= 75) {
        if (isBlessed) {
            println("$name a quelques blessures mineures, mais se rétablit vite !")
        } else {
            println("$name a quelques blessures mineures.")
        }
    } else if (healthPoints >= 15) {
        println("$name semble mal en point.")
    } else {
        println("$name est dans une condition épouvantable !")
    }

}