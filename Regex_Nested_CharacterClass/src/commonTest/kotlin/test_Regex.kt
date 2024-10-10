package test


import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class test_Regex {

    @Test
    fun testRegexNestedCharacterClass_1() {
        val regex = Regex("[^1-9&&[^/]]")
        assertTrue(regex.matches("a"))
    }

    @Test
    fun testRegexNestedCharacterClass_2() {
        val regex = Regex("[^1-9&&[^/]]")
        assertFalse(regex.matches("1"))
    }

    @Test
    fun testRegexNestedCharacterClass_3() {
        val regex = Regex("[^1-9&&[^/]]")
        assertFalse(regex.matches("/"))
    }

}