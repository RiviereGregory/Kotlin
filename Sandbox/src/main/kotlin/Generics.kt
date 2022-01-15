class LootBox<T>(item: T) {
    var open = false
    private var loot: T = item

    fun fetch(): T? {
        return loot.takeIf { open }
    }

    fun <R> fetch(lootModFunction: (T) -> R): R? {
        return lootModFunction(loot).takeIf { open }
    }
}

class Fedora(val name: String, val value: Int)

class Coin(val value: Int)

fun main() {
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("Un fédora générique", 15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(10))

    lootBoxOne.open = true
    lootBoxOne.fetch()?.run {
        println("Vous récupérez $name de la boite !")
    }

    val coin = lootBoxOne.fetch() {
        Coin(it.value * 3)
    }

    coin?.let { println(it.value) }
}
