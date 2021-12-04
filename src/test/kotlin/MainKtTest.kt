import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commisionCountTestMAESTRO() {
        val expected : Int = 8000
        val result = commisionCount(MAESTRO, 8000000, 10000, MIR)
        assertEquals(expected, result)
    }
    @Test
    fun commisionCountTestMASTERCARD() {
        val expected : Int = 0
        val result = commisionCount(MASTERCARD, 0, 10000, MIR)
        assertEquals(expected, result)
    }
    @Test
    fun commisionCountTestVISA() {
        val expected : Int = 7500
        val result = commisionCount(VISA, 0, 10000, MASTERCARD)
        assertEquals(expected, result)
    }
    @Test
    fun commisionCountTestVKPAY() {
        val expected : Int = 100
        val result = commisionCount(VISA, 0, 10000, VKPAY)
        assertEquals(expected, result)
    }
    @Test
    fun commisionCountTestMirMin() {
        val expected : Int = 3500
        val result = commisionCount(MIR, 0, 1000, MASTERCARD)
        assertEquals(expected, result)
    }
}