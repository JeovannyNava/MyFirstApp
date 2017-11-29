package mundo.hola.gianninava.github;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {


    private Button button;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions googleSignInOptions;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    TextView textView;
    private static int REQUEST_CODE=100;
    String politicas="By signing up, I agree to Airbnb's Terms of Service, Pryvacy Policy, Guest Refund Policy, and Host Guarantee Terms. ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView)findViewById(R.id.textView);
        textView.setText(politicas);
        SpannableString spannableString=new SpannableString(politicas);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(245,57,54)),34,51,0);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(245,57,54)),52,67,0);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(245,57,54)),68,88,0);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(245,57,54)),93,114,0);
        textView.setText(spannableString);


        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager=CallbackManager.Factory.create();
        loginButton=(LoginButton) findViewById(R.id.login_facebook1);



        googleSignInOptions= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions)
                .build();
        button = (Button) findViewById(R.id.signin_google);






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signInIntent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(signInIntent,REQUEST_CODE);

            }
        });






        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                goSesionScreen();



            }

            @Override
            public void onCancel() {

           Toast.makeText(getApplicationContext(), R.string.com_facebook_loginview_cancel_action, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(FacebookException error) {
             Toast.makeText(getApplicationContext(), "Error al iniciar sesión", Toast.LENGTH_SHORT).show();

            }
        });





    }

    private void goSesionScreen() {
        Intent intent=new Intent(this, Sesion.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK );
        startActivity(intent);

    }



    private void handleSignInResult(GoogleSignInResult result) {

        if(result.isSuccess()){
           goSesionScreen();

        }else{

            Toast.makeText(this, "No se puede iniciar sesion", Toast.LENGTH_SHORT).show();


        }
    }



    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {



    }


    protected void OnActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE){


            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }

    }
}







