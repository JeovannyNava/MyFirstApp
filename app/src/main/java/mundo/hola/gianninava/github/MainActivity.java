package mundo.hola.gianninava.github;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity  {
    ImageView imagen;
    Button boton;
    static final int REQUEST_IMAGE_CAPTURE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button) findViewById(R.id.boton);
        imagen = (ImageView) findViewById(R.id.imagen);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void OnClick(View v){

                llamarIntent();


            }


        });
    }

    private void llamarIntent(){

        Intent takePictureIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
        }
    }

        @Override
        protected void onActivityResult(int requestCode, int ResultCode, Intent data){
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){

                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                mImageView.setImageBitmap(imageBitmap);
            }
        }
}


