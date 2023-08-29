package com.vs.uc10

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ValidatorUnitTests {

    private val validStrings = listOf(
        "k~Ize15aUJMew[g}",
        "tY`vL|q<+sp9Dz",
        "{j(SpZZZZ;Buj51.J",
    )

    private fun isStringValid(str: String, maxLength: Int = 30): Boolean {
        val pattern = getPattern(maxLength)

        return pattern.matches(str)
    }
    @Test
    fun validStrings_isMatchPattern() {
        validStrings.forEach {
            assertTrue(isStringValid(it))
        }
    }

    @Test
    fun outOfAcceptableRangeString_isNotMatchPattern() {
        val str = "&D{%Fg!mdbtK\$*J:X<\$aWPqe-jG;0Ed" //length == 31
        assertFalse(isStringValid(str))
    }

    @Test
    fun notIncludeDigitString_isNotMatchPattern() {
        val str = "V?P&:'w#^P"
        assertFalse(isStringValid(str))
    }

    @Test
    fun notIncludeLowercaseString_isNotMatchPattern() {
        val str = "A3LE2LR&S)"
        assertFalse(isStringValid(str))
    }

    @Test
    fun notIncludeUppercaseString_isNotMatchPattern() {
        val str = "2lmb1m)o]i"
        assertFalse(isStringValid(str))
    }

    @Test
    fun notIncludeSymbolsString_isNotMatchPattern() {
        val str = "QYFmRxd5Dx"
        assertFalse(isStringValid(str))
    }

    @Test
    fun emptyString_isNotMatchPattern() {
        val str = ""
        assertFalse(isStringValid(str))
    }

    @Test
    fun whitespaceAtTheStartOfString_isNotMatchPattern() {
        val str = " " + validStrings.first()
        assertFalse(isStringValid(str))
    }

    @Test
    fun whitespaceAtTheEndOfString_isNotMatchPattern() {
        val str = validStrings.first() + " "
        assertFalse(isStringValid(str))
    }

    @Test
    fun newLineInString_isNotMatchPattern() {
        val str = "\n" + validStrings.first()
        assertFalse(isStringValid(str))
    }

    @Test
    fun negativeMaxLengthNotCrashApp() {
        assertFalse(isStringValid("", -1))
    }
}