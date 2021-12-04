import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commisionCountTestMAESTRO() {
        val expected : Int = 8000
        val result = commissionCount("MAESTRO", 8000000, 10000)
        assertEquals(expected, result)
    }
    @Test
    fun commisionCountTestMASTERCARD() {
        val expected : Int = 100
        val result = commissionCount("MASTERCARD", 0, 10000)
        assertEquals(expected, result)
    }
    @Test
    fun commisionCountTestVISA() {
        val expected : Int = 7500
        val result = commissionCount("VISA", 0, 10000)
        assertEquals(expected, result)
    }
    @Test
    fun commisionCountTestVKPAY() {
        val expected : Int = 0
        val result = commissionCount("VKPay", 0, 10000)
        assertEquals(expected, result)
    }
    @Test
    fun commisionCountTestMirMin() {
        val expected : Int = 3500
        val result = commissionCount("MIR", 0, 1000)
        assertEquals(expected, result)
    }
}