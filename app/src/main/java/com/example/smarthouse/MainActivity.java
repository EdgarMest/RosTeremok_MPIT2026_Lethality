package com.example.smarthouse;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.WindowInsetsCompat;
import android.widget.FrameLayout;




public class MainActivity extends AppCompatActivity {

    private LinearLayout btn_1, btn_2, btn_3, btn_4, btn_5;
    private FrameLayout frameLayout;
    private FragmentHomeSkr firstfr = new FragmentHomeSkr();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setContentView(R.layout.activity_main);


        btn_1 = findViewById(R.id.Homebtn1);
        btn_2 = findViewById(R.id.btn2);
        btn_3 = findViewById(R.id.helperaibtn);
        btn_4 = findViewById(R.id.btn4);
        btn_5 = findViewById(R.id.profilebtn);
        frameLayout = findViewById(R.id.fragment_cont);

        setNewFragment(firstfr);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(FragmentHomeSkr);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        private void setNewFragment(Fragment fragment) {

            FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_cont, fragment);
            ft.commit();
        }



    }
}