class Player {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    fun castFireball(numFireballs: Int = 2): Int {
        println("Apparition d'un verre de Fireball. (x$numFireballs)")
        return when (numFireballs) {
            0 -> 1
            1 -> 5
            2 -> 10
            3 -> 15
            4 -> 20
            5 -> 25
            6 -> 30
            7 -> 35
            8 -> 40
            9 -> 45
            else -> 50
        }
    }
}