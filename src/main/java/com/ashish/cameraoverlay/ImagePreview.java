package com.ashish.cameraoverlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImagePreview extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        String path=getIntent().getStringExtra("path");
        if(path.contains("file:///"))
        {
           path= path.substring(7,path.length());
           try {
               Bitmap bitmap = BitmapFactory.decodeFile(path);
               imageView.setImageBitmap(bitmap);
           }catch (Exception ex)
           {
               ex.fillInStackTrace();
           }
        }else{
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            imageView.setImageBitmap(bitmap);
            imageView.setRotation(90);
        }






    }
}

