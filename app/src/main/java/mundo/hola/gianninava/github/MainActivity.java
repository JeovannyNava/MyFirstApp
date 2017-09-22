package mundo.hola.gianninava.github;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {


    private EditText correo;
    private EditText password;
    Button b;

    String c = "";
    String p = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        correo = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                c = correo.getText().toString();
                p = password.getText().toString();

                if (((c == null) || (c.isEmpty())) || ((p == null) || (p.isEmpty()))) {

                    Toast.makeText(MainActivity.this, "No has introducido tus datos", Toast.LENGTH_SHORT).show();
                } else {

                    validar();

                }


            }
        });


    }

    public void validar() {


        Pattern p_c = Pattern.compile(
                "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n" +
                        "            + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$");
        Matcher m_c = p_c.matcher(c);
        boolean b_c = m_c.find();

        Pattern p_p = Pattern.compile(
                "abc");
        Matcher m_p = p_p.matcher(p);
        boolean b_p = m_p.find();

        if (b_c == true && b_p == true) {

            Toast.makeText(MainActivity.this, "bien", Toast.LENGTH_SHORT).show();
        } else {


            Toast.makeText(MainActivity.this, "mal", Toast.LENGTH_SHORT).show();
        }


    }


}







