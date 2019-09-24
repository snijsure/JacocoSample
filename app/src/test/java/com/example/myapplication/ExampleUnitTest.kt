package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    /**
     * Correct Input: test@gmail.com
    Email with subdomain: test@gmail.co.uk
    Without .com: test@gmail
    With extra characters: test@gmail..com
    With no username: @gmail.com
    Empty Input:
    Null value: this can occur if we initialize the string from this field to be null. It doesn’t hurt to have a test case for null check in place.
     */
    @Test
    fun emailValidatorCorrectInput() {
        assertTrue(EmailValidator.isEmail("diki@gits.id"))
    }

    @Test
    fun emailValidatorWithSubDomain() {
        assertTrue(EmailValidator.isEmail("diki@gits.co.id"))
    }

    @Test
    fun emailValidatorWithOutcom() {
        assertFalse(EmailValidator.isEmail("diki@gits"))
    }

    @Test
    fun emailValidatorExtraCharacter() {
        assertFalse(EmailValidator.isEmail("diki@gits..com"))
    }

    @Test
    fun emailValidatorNoUsername() {
        assertFalse(EmailValidator.isEmail("@gits.com"))
    }

    @Test
    fun emailValidatorEmpty() {
        assertFalse(EmailValidator.isEmail(""))
    }

    @Test
    fun emailValidatorNull() {
        assertFalse(EmailValidator.isEmail(null))
    }
}
