package com.stone.booklibrary.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.stone.booklibrary.R
import com.stone.booklibrary.activities.HomeActivity
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SearchUITest {
    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun checkLoginButtonIsDisplayed() {
        onView(withId(R.id.txtSearch)).perform(click())

        onView(withId(R.id.edSearch)).perform(
            ViewActions.typeText("android"),
           pressImeActionButton()
        )
        Thread.sleep(5000L)
        onView(withId(R.id.rvSearch))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .check(matches(hasDescendant(withText("Android For Dummies"))))
        onView(withId(R.id.rvSearch))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
            .check(matches(hasDescendant(withText("Android Security Internals"))))
        onView(withId(R.id.rvSearch))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
            .check(matches(hasDescendant(withText("Android Best Practices"))))
        onView(withId(R.id.rvSearch))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))
            .check(matches(hasDescendant(withText("Professional Android"))))
        onView(withId(R.id.rvSearch))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(4))
            .check(matches(hasDescendant(withText("Android Phones For Dummies"))))
        onView(withId(R.id.rvSearch))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
            .check(matches(hasDescendant(withText("Android Epistemology"))))
        onView(withId(R.id.rvSearch))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(6))
            .check(matches(hasDescendant(withText("Expert Android"))))

        onView(withId( R.id.rvSearch)).perform(RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(2,
            click()
        ))

    }


    @After
    fun close(){
        activityRule.scenario.close()
    }
}