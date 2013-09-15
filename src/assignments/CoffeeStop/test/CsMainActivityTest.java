package assignments.CoffeeStop.test;
import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import assignments.CoffeeStop.CsMainActivity;
import assignments.CoffeeStop.CsMapActivity;
import assignments.CoffeeStop.CsSurveyActivity;

public class CsMainActivityTest extends ActivityInstrumentationTestCase2<CsMainActivity> {

	Activity objActivity;
	
	public CsMainActivityTest()
	{
		super("assignments.CoffeeStop", CsMainActivity.class);	
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		objActivity=getActivity();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGoToMapButtonClick()
	{	
		objActivity=getActivity();
		//Register next activity that need to be monitored.
	    ActivityMonitor activityMonitor = getInstrumentation().addMonitor(CsMapActivity.class.getName(), null, false);
		  
	    //Open current activity.
	    final Button button = (Button)((CsMainActivity)objActivity).findViewById(assignments.CoffeeStop.R.id.mapButton);
	    
	    objActivity.runOnUiThread(new Runnable() {
	    	@Override
		    public void run() {
		    	//Open next activity.
		    	button.performClick();
		    }
	    });
	    
	    Activity act = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 500);
	    
	    //Check if activity is open and functional.
	    assertNotNull(act);
	    act.finish();
	}
	
	public void testGoToSurveyButtonClick()
	{
		objActivity=getActivity();
		//Register next activity that need to be monitored.
	    ActivityMonitor activityMonitor = getInstrumentation().addMonitor(CsSurveyActivity.class.getName(), null, false);
		  
	    //Open current activity.
	    final Button button = (Button)((CsMainActivity)objActivity).findViewById(assignments.CoffeeStop.R.id.surveyButton);
	    
	    objActivity.runOnUiThread(new Runnable() {
	    	@Override
		    public void run() {
		    	//Open next activity.
		    	button.performClick();
		    }
	    });
	    
	    Activity act = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 500);
	    
	    //Check if activity is open and functional.
	    assertNotNull(act);
	    act.finish();
	}
}
