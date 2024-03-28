package com.example.appmold.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmold.R;
import com.example.appmold.databinding.ActivityMainBinding;
import com.example.appmold.ui.home.HomeFragment;
import com.example.appmold.util.ChangeFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        ChangeFragment.loadFragment(this, R.id.container_main, new HomeFragment(), new Bundle());
    }
}