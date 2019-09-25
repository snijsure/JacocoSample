package com.example.myapplication

import android.util.Log
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.*

import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    //rule is initialized
    @Rule
    @JvmField
    public val rule = getRule()

    private fun getRule(): ActivityTestRule<MainActivity> {
        Log.e("Initialising rule", "getting Mainacitivy")
        return ActivityTestRule(MainActivity::class.java)
    }

    companion object {

        @BeforeClass
        @JvmStatic
        fun before_class_method() {
            Log.e("@Before class", "Hai this is run before anything")
        }

        @AfterClass
        @JvmStatic
        fun after_class_method() {
            Log.e("@After class", "Hai this is run after anything")
        }
    }

    @Before
    fun before_test_method() {
        Log.e("@After class", "Hai this is run before every test unit")
    }

    @Test
    fun login_success() {
        Espresso.onView(withId(R.id.user_name))
            .perform(ViewActions.typeText("diki"))

        Espresso.onView(withId(R.id.password))
            .perform(ViewActions.typeText("hallo"))

        Espresso.onView(withId(R.id.login_button))
            .perform(ViewActions.click())

        showingSuccess()
    }

    @Test
    fun login_failure() {
        Espresso.onView(withId(R.id.password))
            .perform(ViewActions.typeText("23232323"))

        Espresso.onView(withId(R.id.user_name))
            .perform(ViewActions.typeText("afdfsdfdsf"))

        Espresso.onView(withId(R.id.login_button))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.login_result))
            .check(matches(withText(R.string.login_failed)))
    }

    private fun showingSuccess() {
        Espresso.onView(withId(R.id.login_result))
            .check(matches(withText(R.string.login_success)))
    }

    @After
    fun after_test_method() {
        Log.e("@After","Hi this is run after every test function")
    }
}
