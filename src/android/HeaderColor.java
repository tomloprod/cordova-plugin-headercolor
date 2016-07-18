package tomloprod; 

import org.apache.cordova.CallbackContext; 
import org.apache.cordova.CordovaPlugin; 
import org.json.JSONArray; 
import org.json.JSONException; 
import android.app.ActivityManager; 
import android.os.Build; 
import android.graphics.Color; 
import android.content.Context; 

public class HeaderColor extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
	if (action.equals("tint")) {
	    int color = Color.parseColor(data.getString(0));
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
		ActivityManager activityManager = (ActivityManager) cordova.getActivity().getSystemService(Context.ACTIVITY_SERVICE);
	        for(ActivityManager.AppTask appTask : activityManager.getAppTasks()) {
	                if(appTask.getTaskInfo().id == cordova.getActivity().getTaskId()) {
        	            ActivityManager.TaskDescription description = appTask.getTaskInfo().taskDescription;
                	    cordova.getActivity().setTaskDescription(new ActivityManager.TaskDescription(description.getLabel(), description.getIcon(), color));
                	}
            	}
            
	    }
        }
	return false;
    }
}
