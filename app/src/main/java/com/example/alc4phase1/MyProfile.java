package com.example.alc4phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyProfile extends AppCompatActivity {

    private TextView mName,mTrack,mCountry,mEmail, mPhone, mUsername;
    private CircleImageView mProfile;
    private Toolbar profile_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        mName = findViewById(R.id.profile_name);
        mTrack = findViewById(R.id.track);
        mCountry = findViewById(R.id.country);
        mEmail = findViewById(R.id.email);
        mPhone = findViewById(R.id.phone);
        mUsername = findViewById(R.id.slack_username);
        mProfile = findViewById(R.id.profile_photo);

        profile_toolbar = findViewById(R.id.toolbar_profile);
        profile_toolbar.setTitle("Profile");
        setSupportActionBar(profile_toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.profile)
                .error(R.drawable.alc);

        Glide.with(getApplicationContext())
                .load(R.drawable.profile)
                .apply(options)
                .into(mProfile);

        //setting profile items
        mName.setText(R.string.name);
        mTrack.setText(R.string.track);
        mCountry.setText(R.string.country);
        mEmail.setText(R.string.email);
        mPhone.setText(R.string.phone);
        mUsername.setText(R.string.username);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
