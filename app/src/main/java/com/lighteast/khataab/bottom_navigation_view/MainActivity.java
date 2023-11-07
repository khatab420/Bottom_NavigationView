package com.lighteast.khataab.bottom_navigation_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction;

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        fragmentManager=getSupportFragmentManager();
        Fragment fragmenthome=new Fragment_Home();
         fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,fragmenthome);
        fragmentTransaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId=item.getItemId();

                if(itemId== R.id.navigation_dashboard){
                    Fragment fragmentdashboard=new FragmentDashboard();
                     FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.fragment_container,fragmentdashboard);
                    fragmentTransaction.commit();
                    return true;

                }


                return false;
            }
        });
    }
}