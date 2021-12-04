fun main(args: Array<String>) {
    val payMethod : String = "MIR"
    val monthTransfer : Int = 8000000
    val currentTransfer : Int = 10000
    println("Коммиссия за перевод составляет ${commissionCount(payMethod, monthTransfer, currentTransfer)} копеек")
}

fun commissionCount(payMethod: String = "VKPay", monthTransfer: Int = 0, currentTransfer: Int): Int {

    val rubbleToKop: Int = currentTransfer * 100
    val mincommissionVisaMir: Int = 3500
    val visamirComm = when {
        mincommissionVisaMir >= rubbleToKop * 75/10000 -> mincommissionVisaMir
        else -> rubbleToKop * 75 / 10000
    }
    var commisionResult = when {
        payMethod == "VKPay" -> 0
        else ->
            when {
                payMethod == "VISA" || payMethod == "MIR" -> visamirComm
                payMethod == "MAESTRO" || payMethod == "MASTERCARD" && monthTransfer > 7_500_000 -> rubbleToKop * 60 / 10000 + 2000
                else -> 0
            }
    }
    return commisionResult
}