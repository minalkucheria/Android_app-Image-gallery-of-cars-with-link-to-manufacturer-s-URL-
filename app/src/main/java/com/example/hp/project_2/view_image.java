package com.example.hp.project_2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
//Display image activity
public class view_image extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        Intent i = getIntent();//Receive intent

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(i.getIntExtra(MainActivity.identifier1,0));      //get resource position of image
        setContentView(imageView); //display the image
        final String url=i.getStringExtra(MainActivity.identifier2); //url passed from calling activity

        //Activity when a user clicks on image i.e call browser activity to open official website
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }
}
