package com.hazyaz.ctup.cache;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class ctup extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        //for caching user profile name and status
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);



        // for caching user profile images
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this,Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);

    }
}
