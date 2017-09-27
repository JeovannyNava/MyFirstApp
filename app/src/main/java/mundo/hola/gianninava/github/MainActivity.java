package mundo.hola.gianninava.github;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

    String c="";
    String p="" ;
    String test_email="email@gmail.com";
    String test_password="Contra123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);





    }

    public void Dialog(View v) {

        correo = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        c=correo.getText().toString();
        p=password.getText().toString();


        if(c.isEmpty() || p.isEmpty()){

            Toast.makeText(MainActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();

        }

        else {



          if (valid()) {


                if(c.equals(test_email) && p.equals(test_password)) {


                    AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                    ventana.setMessage("Los datos son correctos");
                    ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            correo.setText("");
                            password.setText("");
                        }
                    });
                    ventana.show();
                }

                else if(c.equals(test_email) && !p.equals(test_email)){


                    AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                    ventana.setMessage("Password incorrecto");
                    ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            correo.setText("");
                            password.setText("");
                        }
                    });
                    ventana.show();
                }

                else if(!c.equals(test_email) && !p.equals(test_password)){


                    AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                    ventana.setMessage("Email y password incorrectos");
                    ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            correo.setText("");
                            password.setText("");
                        }
                    });
                    ventana.show();
                }

            }
        }




    }

    public boolean valid() {


        Pattern p_c = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        Matcher m_c = p_c.matcher(c);
        boolean b_c = m_c.find();

        Pattern p_p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,15}$");
        Matcher m_p = p_p.matcher(p);
        boolean b_p = m_p.find();

        if (b_c  && b_p ) {

            Toast.makeText(MainActivity.this, "Datos validos", Toast.LENGTH_SHORT).show();


        } else if(!b_c && b_p) {


            Toast.makeText(MainActivity.this, "Correo no Valido", Toast.LENGTH_SHORT).show();
        }

        else if(b_c && !b_p){

            Toast.makeText(MainActivity.this, "Password invalido", Toast.LENGTH_SHORT).show();
       }

       else if(!b_c && !b_p){

            Toast.makeText(MainActivity.this,"Ambos formatos son invalidos", Toast.LENGTH_SHORT).show();

        }


        return b_c & b_p;
    }




}







