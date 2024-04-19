package com.example.appmold.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.appmold.R;
import com.example.appmold.databinding.ActivityMainBinding;
import com.example.appmold.ui.book.BookFragment;
import com.example.appmold.ui.stock.StockFragment;
import com.example.appmold.ui.home.HomeFragment;
import com.example.appmold.util.ChangeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        setContentView(binding.getRoot());

        BottomNavigationView bottomNav = binding.bottomNavigation;
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        ChangeFragment.loadFragment(this, R.id.container_main, new HomeFragment(), new Bundle());

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        Fragment selectFragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.book) {
            selectFragment = new BookFragment();
        } else if (itemId == R.id.home) {
            selectFragment = new HomeFragment();
        } else if (itemId == R.id.stock) {
            selectFragment = new StockFragment();
        }

        // Carrega o fragmento selecionado
        if (selectFragment != null) {
            ChangeFragment.loadFragment(MainActivity.this, R.id.container_main, selectFragment, new Bundle());
        }
        return true;
    };
}