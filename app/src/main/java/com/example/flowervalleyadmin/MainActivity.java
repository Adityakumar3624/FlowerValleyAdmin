package com.example.flowervalleyadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView add_flower,view_all_flower,banner,view_all_banner,order,admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_flower=(CardView) findViewById(R.id.add_flower);
        view_all_flower=(CardView) findViewById(R.id.view_all_flower);
        banner=(CardView) findViewById(R.id.banner);
        view_all_banner=(CardView) findViewById(R.id.view_all_banner);
        order=(CardView) findViewById(R.id.order);
        admin=(CardView) findViewById(R.id.admin);

        add_flower.setOnClickListener(this);
        view_all_flower.setOnClickListener(this);
        banner.setOnClickListener(this);
        view_all_banner.setOnClickListener(this);
        order.setOnClickListener(this);
        admin.setOnClickListener(this);





    }




    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){

            case R.id.add_flower:
                i = new Intent(this, AddFlowerFragment.class);startActivity(i); break;

            case R.id.view_all_flower:
                i = new Intent(this, ViewAllFlowerFragment.class); startActivity(i);  break;

            case R.id.banner:
                i = new Intent(this, BannerFragment.class); startActivity(i);  break;

            case R.id.view_all_banner:
                i = new Intent(this, ViewAllBannerFragment.class); startActivity(i);  break;

            case R.id.order:
                i = new Intent(this,OrderFragment.class); startActivity(i);  break;

            case R.id.admin:
              


            default:break;

        }




    }
    void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }

}