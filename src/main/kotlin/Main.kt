const val VISA: String = "VISA"
const val MIR: String = "MIR"
const val MAESTRO: String = "MAESTRO"
const val MASTERCARD: String = "MASTERCARD"
const val VKPAY: String = "VKPAY"

fun main(args: Array<String>) {
    println("Коммиссия за перевод составляет ${commisionCount("MASTERCARD", 9000000, 5000, "asd")} копеек")
}

fun commisionCount(payMethod: String, monthTransfer: Int, currenttranserRub: Int, whereTopay: String): Int {

    val transferKop: Int = currenttranserRub * 100
    val mincommisionVisaMir: Int = 3500
    val visamirComm = when (true) {
        mincommisionVisaMir >= transferKop * 75/10000 -> mincommisionVisaMir
        else -> transferKop * 75 / 10000
    }
    var commisionResult = when (true) {
        whereTopay == VKPAY -> 0
        else ->
            when (true) {
                payMethod == VISA || payMethod == MIR -> visamirComm
                payMethod == MAESTRO || payMethod == MASTERCARD && monthTransfer > 7_500_000 -> transferKop * 60 / 10000 + 2000
                else -> 0
            }
    }
    return commisionResult
}