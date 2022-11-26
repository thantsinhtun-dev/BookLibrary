package com.stone.booklibrary.search.flow2

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.stone.booklibrary.R
import com.stone.booklibrary.activities.HomeActivity
import com.stone.booklibrary.data.models.AppModel
import com.stone.booklibrary.data.models.AppModelImpl
import com.stone.booklibrary.search.flow1.RecyclerViewMatchers
import com.stone.booklibrary.viewholders.BookCategoryViewHolder
import kotlinx.android.synthetic.main.item_book_style_list.view.*
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


@RunWith(AndroidJUnit4ClassRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Case2 {
    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)


    fun navigateToShelves() {
        onView(withId(R.id.menu_library)).perform(click())
        onView(withText(R.string.lbl_your_shelves)).perform(click())
    }


    @Test
    fun test1_emptyShelves() {
        navigateToShelves()
        val model: AppModel = AppModelImpl
        model.removeAllShelves()

        onView(withId(R.id.rvShelves)).check(
            matches(
                (RecyclerViewMatchers.hasItemCount(
                    0
                ))
            )
        )
    }

    @Test
    fun test2_createNewShelves() {
        navigateToShelves()
        onView(withId(R.id.btnCreateNewShelf)).perform(click())
        onView(withId(R.id.editCreateShelf)).perform(
            typeText("This is new Shelf"),
            ViewActions.pressImeActionButton()
        )
        onView(withId(R.id.rvShelves))
            .perform(scrollToPosition<ViewHolder>(0))
            .check(matches(hasDescendant(withText("This is new Shelf"))))

    }


    @Test
    fun test3_addBookToShelf() {

        onView(withId(R.id.menu_library)).perform(click())

        onView(withId(R.id.rvBookSmallList))
            .perform(
                actionOnItemAtPosition<ViewHolder>(
                    0,
                    object : ViewAction {
                        override fun getConstraints(): Matcher<View>? {
                            return null
                        }
                        override fun getDescription(): String {
                            return "Click on specific button"
                        }
                        override fun perform(uiController: UiController, view: View) {
                            val button = view.findViewById<View>(R.id.imgMore)
                            button.performClick()
                        }
                    })
            )
        Thread.sleep(1000L)
        onView(withText(R.string.lbl_delete)).check(matches(isDisplayed()))
        onView(withText(R.string.lbl_download)).check(matches(isDisplayed()))
        onView(withText(R.string.lbl_add_to_shelves)).check(matches(isDisplayed()))
        onView(withText(R.string.lbl_make_as_read)).check(matches(isDisplayed()))

        onView(withId(R.id.rlShelves)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShelves)).perform(forceClick())

        Thread.sleep(1000L)
        onView(withId(R.id.rvShelves)).check(matches( hasChildCount(1)))
        onView(withId(R.id.cbShelves)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.rvBookSmallList))
            .perform(
                actionOnItemAtPosition<ViewHolder>(
                    1,
                    object : ViewAction {
                        override fun getConstraints(): Matcher<View>? {
                            return null
                        }
                        override fun getDescription(): String {
                            return "Click on specific button"
                        }
                        override fun perform(uiController: UiController, view: View) {
                            val button = view.findViewById<View>(R.id.imgMore)
                            button.performClick()
                        }
                    })
            )
        Thread.sleep(1000L)
        onView(withText(R.string.lbl_add_to_shelves)).check(matches(isDisplayed()))
        onView(withId(R.id.rlShelves)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShelves)).perform(forceClick())
        onView(withId(R.id.cbShelves)).perform(click())
        onView(isRoot()).perform(pressBack())


     onView(withId(R.id.rvBookSmallList))
            .perform(
                actionOnItemAtPosition<ViewHolder>(
                    2,
                    object : ViewAction {
                        override fun getConstraints(): Matcher<View>? {
                            return null
                        }
                        override fun getDescription(): String {
                            return "Click on specific button"
                        }
                        override fun perform(uiController: UiController, view: View) {
                            val button = view.findViewById<View>(R.id.imgMore)
                            button.performClick()
                        }
                    })
            )
        Thread.sleep(1000L)
        onView(withText(R.string.lbl_add_to_shelves)).check(matches(isDisplayed()))
        onView(withId(R.id.rlShelves)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShelves)).perform(forceClick())
        onView(withId(R.id.cbShelves)).perform(click())
        onView(isRoot()).perform(pressBack())

        onView(withText(R.string.lbl_your_shelves)).perform(click())

        onView(withId(R.id.rvShelves))
            .perform(scrollToPosition<ViewHolder>(0))
            .check(matches(hasDescendant(withText("3books"))))

        onView(withId(R.id.rvShelves))
            .perform(actionOnItemAtPosition<ViewHolder>(0, click()))




    }
    @Test
    fun test4_clickCategory(){
        onView(withId(R.id.menu_library)).perform(click())
        onView(withText(R.string.lbl_your_shelves)).perform(click())
        onView(withId(R.id.rvShelves))
            .perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        onView(withId(R.id.rvBookCategory)).check(matches((RecyclerViewMatchers.hasItemCount(3))))
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
        onView(withId(R.id.rvBookSmallList)).check(matches((RecyclerViewMatchers.hasItemCount(3))))

    }
    @Test
    fun test5_changeListStyle(){
        onView(withId(R.id.menu_library)).perform(click())
        onView(withText(R.string.lbl_your_shelves)).perform(click())
        onView(withId(R.id.rvShelves))
            .perform(actionOnItemAtPosition<ViewHolder>(0, click()))

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
        onView(withText(R.string.lbl_your_shelves)).perform(click())
        onView(withId(R.id.rvShelves))
            .perform(actionOnItemAtPosition<ViewHolder>(0, click()))


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
    private fun forceClick(): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return allOf(isClickable(), isEnabled())
            }

            override fun getDescription(): String {
                return "force click"
            }

            override fun perform(uiController: UiController, view: View) {
                view.performClick()
                uiController.loopMainThreadUntilIdle()
            }
        }
    }

}