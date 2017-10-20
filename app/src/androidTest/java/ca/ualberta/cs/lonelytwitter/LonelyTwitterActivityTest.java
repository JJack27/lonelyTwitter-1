package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>{

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }


    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity()); //gets the information from the device we running on//
        Log.d("SETUP", "setUp()");
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testTweet(){
        solo.assertCurrentActivity("wrong activity", LonelyTwitterActivity.class); //check to see if we in loenely twitter if not get the error message//
        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body),"Test Tweet!");
        solo.clickOnButton("Save"); //the text that is on the button//
        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("Test Tweet!"));
        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet!", 1,1000));


    }
    public void testClickTweetList(){
        LonelyTwitterActivity activity= (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("wrong activity", LonelyTwitterActivity.class); //check to see if we in loenely twitter if not get the error message//
        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body),"Test Tweet!");

        solo.clickOnButton("Save"); //the text that is on the button//

        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("Test Tweet!"));
        final ListView oldTweetList = activity.getOldTweetList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());


        solo.clickInList(0);//click on the first tweet in the tweetlist//
        solo.assertCurrentActivity("wrong activiy",EditTweetActivity.class);

        assertTrue(solo.waitForText("Tweet Test!",1, 1000));
        solo.goBack();//very useful if you want to add back button//
        solo.assertCurrentActivity("wrong Activity", LonelyTwitterActivity.class);

    }


    @Override //not necessary but good to use//
    public void tearDown() throws Exception{
        solo.finishOpenedActivities(); //clear activities after our test case is done//

    }

}