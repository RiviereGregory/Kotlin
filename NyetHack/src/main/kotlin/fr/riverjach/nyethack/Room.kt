package fr.riverjach.nyethack

open class Room(val name: String) {
    protected open val dangerLevel = 5
    fun description() = "Salle : $name\n" +
            "Niveau de danger : $dangerLevel"

    open fun load() = "Pas grand-chose à voir ici..."
}

open class TownSquare : Room("Place publique") {
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "GWONG"

    final override fun load() = "Les villageois sont en liesse à votre arrivée !\n ${rinBell()} "

    private fun rinBell() = "La cloche annonce votre arrivée. $bellSound"
}