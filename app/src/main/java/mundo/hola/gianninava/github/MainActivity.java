package mundo.hola.gianninava.github;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {
    private ProgressBar barra;
    private Button boton;

    CharSequence text = "Mensaje usando un handler";
    int duration = Toast.LENGTH_SHORT;
    Handler miHand;
  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra=(ProgressBar)findViewById(R.id.progressBar);
        boton= (Button) findViewById(R.id.button);
        final Context context = getApplicationContext();

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                barra.setVisibility(View.VISIBLE);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        barra.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                    }
                },3000);



            }
        });


        }



}


