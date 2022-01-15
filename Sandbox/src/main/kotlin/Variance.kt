class Barrel<in T>(item: T)

fun main() {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("Un fédora générique", 15))

    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    fedoraBarrel = lootBarrel
}