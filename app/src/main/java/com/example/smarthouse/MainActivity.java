package com.example.smarthouse;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private LinearLayout btn_1, btn_2, btn_3, btn_4, btn_5, btn_6;
    private FrameLayout frameLayout;
    private FragmentHomeSkr firstfr = new FragmentHomeSkr();
    private ChatFragment chatFragment = new ChatFragment();

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

        btn_1 = findViewById(R.id.Homebtn1);
        btn_2 = findViewById(R.id.btn2);
        btn_3 = findViewById(R.id.helperaibtn);
        btn_4 = findViewById(R.id.btn4);
        btn_5 = findViewById(R.id.profilebtn);
        btn_6 = findViewById(R.id.btn5);
        frameLayout = findViewById(R.id.fragment_cont);

        setNewFragment(firstfr);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(firstfr);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 secondfrag = new Fragment2();
                setNewFragment(secondfrag);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatFragment thirdfrag = new ChatFragment();
                setNewFragment(thirdfrag);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment4 ffrag = new Fragment4();
                setNewFragment(ffrag);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment5 fiffrag = new Fragment5();
                setNewFragment(fiffrag);
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment6 sixfrag = new Fragment6();
                setNewFragment(sixfrag);
            }
        });
    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_cont, fragment);
        ft.commit();
    }
}