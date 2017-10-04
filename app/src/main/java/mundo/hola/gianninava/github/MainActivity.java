package mundo.hola.gianninava.github;



import android.graphics.Color;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.WindowManager;
import android.widget.TextView;
;


public class MainActivity extends AppCompatActivity {




    TextView textView;
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

    }



}







