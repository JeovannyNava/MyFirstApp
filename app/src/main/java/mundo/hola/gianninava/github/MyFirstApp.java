package mundo.hola.gianninava.github;

import android.app.Application;

import com.facebook.FacebookActivity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by jeova on 26/10/2017.
 */

public class MyFirstApp extends Application {
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}
