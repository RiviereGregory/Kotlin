class Barrel<out T>(val item: T)

fun main() {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("Un fédora générique", 15))

    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    lootBarrel = fedoraBarrel
    val myFedora: Fedora = lootBarrel.item
}