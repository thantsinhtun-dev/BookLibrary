package com.stone.booklibrary.search.flow1


import alirezat775.lib.carouselview.CarouselAdapter
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.stone.booklibrary.R
import com.stone.booklibrary.activities.HomeActivity
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.search.flow1.RecyclerViewMatchers.hasItemCount
import com.stone.booklibrary.viewholders.*
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


@RunWith(AndroidJUnit4ClassRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Case1 {

    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)


    @Test
    fun test1_emptyCarouselView() {
        val model: AppModel = AppModelImpl
        model.removeAllBook()
        onView(withId(R.id.rvRecentBook)).check(matches(not(isDisplayed())))


    }

    @Test
    fun test2_childCountInRecyclerView() {
        onView(withId(R.id.rvBookMain)).check(matches((hasItemCount(3))))
        onView(withId(R.id.rvBookMain))
            .perform(scrollToPosition<ViewHolder>(0))
            .check(matches((hasItemCount(3))))
        onView(withId(R.id.rvBookMain))
            .perform(scrollToPosition<ViewHolder>(1))
            .check(matches((hasItemCount(3))))
        onView(withId(R.id.rvBookMain))
            .perform(scrollToPosition<ViewHolder>(2))
            .check(matches((hasItemCount(3))))
    }

    @Test
    fun test3_goBookDetailsAndCheckInCarouselView() {
        onView(withId(R.id.rvBookMain)).perform(
            actionOnItemAtPosition<OverviewBookViewHolder>(2, scrollTo())
        )

        onView(
            allOf(
                withId(R.id.rvEbookGroup),
                withParent(
                    withParentIndex(2)
                )
            )
        ).perform(actionOnItemAtPosition<BookViewHolder>(2, click()))
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.rvRecentBook))
            .perform(scrollToPosition<CarouselAdapter.CarouselViewHolder>(0))
            .check(matches(hasDescendant(withText("DESERT STAR"))))
        onView(
            allOf(
                withId(R.id.rvEbookGroup),
                withParent(
                    withParentIndex(0)
                )
            )
        ).perform(actionOnItemAtPosition<BookViewHolder>(1, click()))

        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.rvRecentBook))
            .perform(scrollToPosition<CarouselAdapter.CarouselViewHolder>(1))
            .check(matches(hasDescendant(withText("THE LOST METAL"))))


        onView(
            allOf(
                withId(R.id.rvEbookGroup),
                withParent(
                    withParentIndex(1)
                )
            )
        ).perform(actionOnItemAtPosition<BookViewHolder>(2, click()))
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.rvRecentBook))
            .perform(scrollToPosition<CarouselAdapter.CarouselViewHolder>(2))
            .check(matches(hasDescendant(withText("VERITY"))))


    }


    //    @Test
    fun testCarouselView() {

        onView(withId(R.id.rvRecentBook)).check(matches(isDisplayed()))

        onView(withId(R.id.rvRecentBook))
            .perform(scrollToPosition<ViewHolder>(0))
            .check(matches(hasDescendant(withText("IT ENDS WITH US"))))
        Thread.sleep(3000L)
        onView(withId(R.id.rvBookMain))
            .perform(scrollToPosition<ViewHolder>(0))
            .check(matches(hasDescendant(withText("Combined Print and E-Book Fiction"))))

    }
    @Test
    fun test4_onClickBottomNavigation(){
        onView(withId(R.id.menu_library)).perform(click())
        onView(withId(R.id.rvBookCategory)).check(matches((hasItemCount(3))))
        onView(withId(R.id.rvBookSmallList))
            .perform(scrollToPosition<BookCategoryViewHolder>(0))
            .check(matches(hasDescendant(withText("DESERT STAR"))))
        onView(withId(R.id.rvBookSmallList))
            .perform(scrollToPosition<BookCategoryViewHolder>(1))
            .check(matches(hasDescendant(withText("THE LOST METAL"))))
        onView(withId(R.id.rvBookSmallList))
            .perform(scrollToPosition<BookCategoryViewHolder>(2))
            .check(matches(hasDescendant(withText("VERITY"))))

        onView(withId(R.id.rvBookCategory)).perform(actionOnItemAtPosition<BookCategoryViewHolder>(0, click()))
        onView(withId(R.id.rvBookSmallList))
            .perform(scrollToPosition<BookCategoryViewHolder>(0))
            .check(matches(hasDescendant(withText("DESERT STAR"))))

        onView(withId(R.id.rvBookCategory)).perform(actionOnItemAtPosition<BookCategoryViewHolder>(1, click()))
        onView(withId(R.id.rvBookSmallList))
            .perform(scrollToPosition<BookCategoryViewHolder>(0))
            .check(matches(hasDescendant(withText("THE LOST METAL"))))

        onView(withId(R.id.rvBookCategory)).perform(actionOnItemAtPosition<BookCategoryViewHolder>(2, click()))
        onView(withId(R.id.rvBookSmallList))
            .perform(scrollToPosition<BookCategoryViewHolder>(0))
            .check(matches(hasDescendant(withText("VERITY"))))

        onView(withId(R.id.ivCancel)).perform(click())
        onView(withId(R.id.rvBookSmallList)).check(matches((hasItemCount(3))))

    }
    @Test
    fun test5_changeListStyle(){
        onView(withId(R.id.menu_library)).perform(click())

        onView(withId(R.id.ivListStyle)).perform(click())
        onView(withId(R.id.rdList)).perform(click())
        onView(withId(R.id.rvBookList)).check(matches( isDisplayed()))

        onView(withId(R.id.ivListStyle)).perform(click())
        onView(withId(R.id.rdSmall)).perform(click())
        onView(withId(R.id.rvBookSmallList)).check(matches( isDisplayed()))


    }
    @Test
    fun test6_sortList(){
        onView(withId(R.id.menu_library)).perform(click())


        onView(withId(R.id.ivSortList)).perform(click())
        onView(withId(R.id.rdTitle)).perform(click())
        onView(withId(R.id.rvBookSmallList))
            .perform(scrollToPosition<BookCategoryViewHolder>(0))
            .check(matches(hasDescendant(withText("DESERT STAR"))))

        onView(withId(R.id.ivSortList)).perform(click())
        onView(withId(R.id.rdAuthor)).perform(click())
        onView(withId(R.id.rvBookSmallList))
            .perform(scrollToPosition<BookCategoryViewHolder>(2))
            .check(matches(hasDescendant(withText("DESERT STAR"))))

        onView(withId(R.id.ivSortList)).perform(click())
        onView(withId(R.id.rdRecent)).perform(click())
        onView(withId(R.id.rvBookSmallList))
            .perform(scrollToPosition<BookCategoryViewHolder>(0))
            .check(matches(hasDescendant(withText("DESERT STAR"))))

    }


    @After
    fun close() {
        activityRule.scenario.close()
    }
}


object RecyclerViewMatchers {
    @JvmStatic
    fun hasItemCount(itemCount: Int): Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(
            RecyclerView::class.java
        ) {

            override fun describeTo(description: Description) {
                description.appendText("has $itemCount items")
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                return view.adapter?.itemCount == itemCount
            }
        }
    }
}