package com.kobe.cinephiles

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.contrib.RecyclerViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kobe.cinephiles.repository.room.DATABASE_NAME
import com.kobe.cinephiles.view.MainActivity
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CineUITest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        activityRule.activity.deleteDatabase(DATABASE_NAME)
    }

    @Test
    fun test_add_favorite() {
        val tagRecyclerWeb = "web"
        val tagRecyclerFav = "fav"
        val movieTitleToBeClicked = "Dolittle"

        onView(withTagValue(`is`(tagRecyclerWeb as Any))).perform(scrollTo<RecyclerView.ViewHolder>(
            hasDescendant(withText(movieTitleToBeClicked))
        ))

        onView(withTagValue(`is`(tagRecyclerWeb as Any))).perform(actionOnItem<RecyclerView.ViewHolder>(
            hasDescendant(withText(movieTitleToBeClicked)),
            click()
        ))

        onView(withId(R.id.txtTitleMovieDetails)).check(matches(withText(movieTitleToBeClicked)))

        onView(withId(R.id.fabFavorite)).perform(click())

        pressBack()

        onView(withId(R.id.viewPager)).perform(swipeLeft())

        onView(withTagValue(`is`(tagRecyclerFav as Any))).check(matches(hasDescendant(withText(movieTitleToBeClicked))))
    }
}