val String.numVowels
    get() = count { "aeiouy".contains(it) }

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun <T> T.easyPrint(): T {
    println(this)
    return this
}

fun main() {
    "Madrigal a quitté le batiment".easyPrint().addEnthusiasm(3).easyPrint()
    42.easyPrint()
    "Combien de voyelles ?".numVowels.easyPrint()
}