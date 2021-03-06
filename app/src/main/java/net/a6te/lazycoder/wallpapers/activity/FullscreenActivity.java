package net.a6te.lazycoder.wallpapers.activity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.a6te.lazycoder.wallpapers.R;
import net.a6te.lazycoder.wallpapers.Utility;

import java.io.IOException;


public class FullscreenActivity extends AppCompatActivity {

    private String imageUrl;
    private ImageView wallpaperIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        initializeAll();

        try{
            imageUrl = getIntent().getStringExtra(Utility.IMAGE_URL);
            Picasso.with(this)
                    .load(Integer.valueOf(imageUrl))
                    .resize(1024,1024)
                    .placeholder(R.drawable.banner)
                    .into(wallpaperIv);

        }catch (Exception e){

        }


    }

    private void initializeAll() {
        wallpaperIv = findViewById(R.id.wallpaperIv);
    }

    public void setWallpaperBtn(View view) {
        if (imageUrl != null){
            //set wall paper
            WallpaperManager myWallpaperManager
                    = WallpaperManager.getInstance(getApplicationContext());
            try {
                myWallpaperManager.setResource(Integer.valueOf(imageUrl));
                Toast.makeText(getApplicationContext(),"wallpaper changed",Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {

        }
    }
}
