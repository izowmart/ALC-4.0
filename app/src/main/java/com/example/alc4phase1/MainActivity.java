package com.example.alc4phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button alcBtn,profileBtn;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alcBtn = findViewById(R.id.about_alc);
        profileBtn = findViewById(R.id.about_me);
        mToolbar = findViewById(R.id.toolbar_main);

        mToolbar.setTitle("ALC 4.0");
        setSupportActionBar(mToolbar);

        alcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(MainActivity.this,AboutALC.class);
                startActivity(aboutIntent);
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(MainActivity.this,MyProfile.class);
                startActivity(profileIntent);
            }
        });
    }
}
