package tomloprod;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.ActivityManager;
import android.os.Build;
import android.graphics.Color;
import android.content.Context;

public class HeaderColor extends CordovaPlugin {
	@Override
	public void initialize(final CordovaInterface cordova, CordovaWebView webView){
		super.initialize(cordova, webView);
		setColor(preferences.getString("HeaderColor", "#000000"));
	}

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
		if (action.equals("tint")) {
			setColor(data.getString(0));
		}
		return false;
    }

	private void setColor(String data) {
		int color = Color.parseColor(data);
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
}
