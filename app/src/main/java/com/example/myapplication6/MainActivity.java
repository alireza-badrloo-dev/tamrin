package com.example.myapplication6;

import static com.example.myapplication6.FragmentB.KEY_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_NAME,"some Text From Activity Main");
                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(bundle);

                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.fragmentContainerView, fragmentB);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
            }
        });

    }
}