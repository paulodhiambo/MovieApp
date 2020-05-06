package com.odhiambopaul.movie;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.odhiambopaul.movie.ui.home.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MovieAppUiTest {
    @Rule
    public ActivityTestRule<HomeActivity> homeActivityActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    /*
    app is loading data asynchronously on different thread, then updates RecyclerView
    on the main thread when it has completely loaded. As a matter of fact, Espresso only
    synchronizes on main thread, so when your app starts to load data in the background,
    it thinks that the main thread of the app has gone idle, and so it proceeds to perform
     the action, which may or may not fail depends on devices performance. T solve this problem
     we delay the test for 3 seconds so that the data is fully loaded
    * */
    @Test
    public void HomeTest() throws InterruptedException {
        Thread.sleep(3000);
        onView(withId(R.id.movieRecyclerView))
                .perform(
                        RecyclerViewActions
                                .actionOnItemAtPosition(0, click())
                );
    }
}
