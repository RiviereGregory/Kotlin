fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    if (healthPoints == 100) {
        println("$name est en parfaite condtion !")
    } else if (healthPoints >= 90) {
        println("$name a quelques égratinures.")
    } else if (healthPoints >= 75) {
        println("$name a quelques blessures mineures.!")
    } else if (healthPoints >= 15) {
        println("$name semble mal en point.")
    } else {
        println("$name est dans une condition épouvantable !")
    }

}