package com.example.sangs.finalprojectkade

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.sangs.finalprojectkade.R.id.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testMatchesNext(){
        Espresso.onView(ViewMatchers.withId(bottom_navigation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(tabs_matches)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("NEXT MATCH")).perform(ViewActions.click())

        onView(withId(spinner_next_match))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(10000)

        Thread.sleep(15000)
        Espresso.onView(ViewMatchers.withId(recycler_next_match))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(recycler_next_match)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(12))
        Thread.sleep(15000)
        Espresso.onView(ViewMatchers.withId(recycler_next_match)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, ViewActions.click()))
        ViewActions.pressBack()
    }

    @Test
    fun testTeams() {
        Espresso.onView(ViewMatchers.withId(bottom_navigation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(bottom_navigation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(navigation_teams)).perform(click())
        Thread.sleep(3000)
        onView(withId(recycler_teams)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))
        Thread.sleep(3000)
        onView(withId(recycler_teams)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click()))
        Espresso.pressBack()
    }

}