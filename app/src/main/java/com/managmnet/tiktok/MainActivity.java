package com.managmnet.tiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> list;
    Adapter adapter;
    ViewPager2 vpg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);



        getSupportActionBar().hide();
        list = new ArrayList<>();
        this.getTheme().applyStyle(R.style.FullScreen,false);
        list.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.a2,"Nitesh Chauhan",R.drawable.man));
        list.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.b,"Lakhan Rathod",R.drawable.man));
        list.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.c,"Yash Mistry",R.drawable.man));
        list.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.d,"Parth nath",R.drawable.man));


        adapter = new Adapter(MainActivity.this,list);

        vpg = findViewById(R.id.vpg);
        vpg.setAdapter(adapter);
        int size = vpg.getAdapter().getItemCount();
        if(vpg.getCurrentItem()==size)
        {
            vpg.setCurrentItem(1);
        }



    }
}