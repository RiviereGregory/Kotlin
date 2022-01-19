fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun Any.easyPrint() = println(this)

fun main(){
    "Madrigal a quitté le batiment".addEnthusiasm(3).easyPrint()
    42.easyPrint()
}