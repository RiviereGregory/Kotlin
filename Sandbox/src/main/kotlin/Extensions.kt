fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun main(){
    println("Madrigal a quitté le batiment".addEnthusiasm(3))
}