package cahing.reader.api.raseedi.prof.raseedapireader.UI;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cahing.reader.api.raseedi.prof.raseedapireader.Activities.MainActivity;
import cahing.reader.api.raseedi.prof.raseedapireader.Adapter.AdsRecyclerViewAdapter;
import cahing.reader.api.raseedi.prof.raseedapireader.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.number.OrderingComparison.greaterThan;

/**
 * Created by Prof-Mohamed Atef on 30/05/2019.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTester {

    @Rule
    public ActivityTestRule<MainActivity>
        mainActivityTestRule=new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void ensureRecyclerExist()throws Exception{
        MainActivity activity=mainActivityTestRule.getActivity();
        View viewByID=activity.findViewById(R.id.recycler_view);
        assertThat(viewByID,notNullValue());
        assertThat(viewByID,instanceOf(RecyclerView.class));
        RecyclerView recyclerView=(RecyclerView) viewByID;
        RecyclerView.Adapter adapter=recyclerView.getAdapter();
        assertThat(adapter, instanceOf(RecyclerView.Adapter.class));
        assertThat(adapter.getItemCount(), greaterThan(5));
    }

//    @Test
//    public void clickRecyclerViewItem(){
//        onView(withId(R.id.recycler_view))
//                .perform(RecyclerViewActions.actionOnItemAtPosition(2,click()));
//    }



    @After
    public void tearDown() throws Exception {
    }
}