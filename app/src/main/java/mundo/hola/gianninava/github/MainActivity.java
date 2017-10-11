package mundo.hola.gianninava.github;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends AppCompatActivity {



    private LoginButton loginButton;
    private CallbackManager callbackManager;
    TextView textView;
    String politicas="By signing up, I agree to Airbnb's Terms of Service, Pryvacy Policy, Guest Refund Policy, and Host Guarantee Terms. ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_main);


        textView = (TextView)findViewById(R.id.textView);
        textView.setText(politicas);
        SpannableString spannableString=new SpannableString(politicas);

        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(245,57,54)),34,51,0);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(245,57,54)),52,67,0);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(245,57,54)),68,88,0);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(245,57,54)),93,114,0);
        textView.setText(spannableString);




        callbackManager=CallbackManager.Factory.create();
        loginButton=(LoginButton)findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });





    }


    protected void OnActivityResult(int requesCode, int resultCode, Intent data){
        super.onActivityResult(requesCode, resultCode, data);
        callbackManager.onActivityResult(requesCode, resultCode, data);

    }



}







