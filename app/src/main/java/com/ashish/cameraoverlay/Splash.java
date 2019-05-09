package com.ashish.cameraoverlay;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Splash  extends Activity {
    final int MULTIPLE_PERMISSIONS=22;
    String[] PERMISSIONS = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.CAMERA,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        setContentView(R.layout.splash);

        int permissionCheck = ContextCompat.checkSelfPermission(Splash.this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            if(!checkPermissions()){
            } else {
                runThread();
            }
        } else {
            runThread();
        }
    }
    private  boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (int i=0;i<PERMISSIONS.length;i++) {
            result = ContextCompat.checkSelfPermission(this,PERMISSIONS[i]);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(PERMISSIONS[i]);
            }
        }
        String [] permissionList=new String[listPermissionsNeeded.size()];
        for(int i=0;i<listPermissionsNeeded.size();i++)
        {
            permissionList[i]=listPermissionsNeeded.get(i);
        }
        if (!listPermissionsNeeded.isEmpty()) {

            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),MULTIPLE_PERMISSIONS );
            return false;
        }
        return true;
    }

    public void runThread()
    {
      Intent in=new Intent(Splash.this,MainActivity.class);
      startActivity(in);
      finish();
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    runThread();
                } else {
                    checkPermissions();
                }
                return;
            }

        }
    }
}
