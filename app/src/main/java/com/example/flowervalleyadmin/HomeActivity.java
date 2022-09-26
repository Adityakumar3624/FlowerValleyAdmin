package com.example.flowervalleyadmin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.flowervalleyadmin.fragment.AddFlowerFragment;
import com.example.flowervalleyadmin.fragment.AdminFragment;
import com.example.flowervalleyadmin.fragment.AddBannerFragment;
import com.example.flowervalleyadmin.fragment.OrderFragment;
import com.example.flowervalleyadmin.fragment.ViewAllBannerFragment;
import com.example.flowervalleyadmin.fragment.ViewAllFlowerFragment;

public class HomeActivity extends AppCompatActivity {
String fragmentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        Intent intent=getIntent();
        if(intent !=null){
            fragmentName=intent.getStringExtra("fragment_name");
        }

        switch (fragmentName){
            case "add_flower":{
                replaceFragment(new AddFlowerFragment());
                break;
            }
            case "view_all_flower":{
                replaceFragment(new ViewAllFlowerFragment());
                break;
            }
            case "banner":{
                replaceFragment(new AddBannerFragment());
                break;
            }
            case "view_all_banner":{
                replaceFragment(new ViewAllBannerFragment());
                break;
            }
            case "order":{
                replaceFragment(new OrderFragment());
            break;
            }
            case "admin":{
                replaceFragment(new AdminFragment());
                break;
            }
            default:{
                Log.i(TAG,"onCreate: Fragment Name not found.");
            }

        }


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult: " + requestCode);
        Log.i(TAG, "onActivityResult: " + resultCode);
        Log.i(TAG, "onActivityResult: " + data);

        if (data != null && data.getData() != null) {
            Uri mImageUri = data.getData();
            Log.i(TAG, "onActivityResult: " + mImageUri);
            Bundle bundle = new Bundle();
            bundle.putString("image_uri", mImageUri.toString());

            Toast.makeText(this, mImageUri + "", Toast.LENGTH_SHORT).show();
            AddBannerFragment addBannerFragment = new AddBannerFragment();
            addBannerFragment.setArguments(bundle);
            replaceFragment(addBannerFragment);
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }


    void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }


}