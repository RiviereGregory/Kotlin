package fr.riverjach.nyethack

open class Room(val name: String) {
    protected open val dangerLevel = 5
    var monster: Monster? = Goblin()
    fun description() = "Salle : $name\n" +
            "Niveau de danger : $dangerLevel\n" +
            "Créature: ${monster?.description ?: " aucun."}"

    open fun load() = "Pas grand-chose à voir ici..."
}

open class TownSquare : Room("Place publique") {
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "GWONG"

    final override fun load() = "Les villageois sont en liesse à votre arrivée !\n ${rinBell(1)} "

    fun rinBell(nbSonne: Int) = "La cloche annonce votre arrivée. " + "$bellSound ".repeat(nbSonne)
}