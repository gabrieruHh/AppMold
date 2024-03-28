package com.example.appmold.util;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ChangeFragment {

    public static void loadFragment(AppCompatActivity activity, int frame, Fragment fragment, Bundle bundle){
        fragment.setArguments(bundle);
        activity.getSupportFragmentManager().beginTransaction().replace(
            frame, fragment
        ).commit();
    }
}
