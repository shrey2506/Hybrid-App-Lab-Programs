package com.example.program1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.warkiz.widget.IndicatorSeekBar;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ImageView imageView;
    Button button;
    Uri imageUri;
    RatingBar ratingBar;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        imageView=findViewById(R.id.image_view);
        button=findViewById(R.id.button);
        ratingBar=findViewById(R.id.rating_bar);
        seekBar=findViewById(R.id.seek_bar);

        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), "rating: "+ s+" stars",Toast.LENGTH_LONG).show();
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "FAB Clicked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast toast = Toast.makeText(getApplicationContext(), "On Start", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast toast = Toast.makeText(getApplicationContext(), "On Resume", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(getApplicationContext(), "On Stop", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast toast = Toast.makeText(getApplicationContext(), "On Pause", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast toast = Toast.makeText(getApplicationContext(), "On Destroy", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast toast = Toast.makeText(getApplicationContext(), "On Restart", Toast.LENGTH_LONG);
        toast.show();
    }

}
