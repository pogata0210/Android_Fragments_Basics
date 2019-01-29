package com.example.android_fragments_basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            MtgCardFragment fragment = new MtgCardFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }

    }