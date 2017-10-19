package stu.reza.smartgatesystem;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.opencv.android.OpenCVLoader;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    Intent intent;
    Button btnLogin;
    EditText etEmail,etPassword;

    private static final String TAG = "MainActivity";
    public static final int MULTIPLE_PERMISSIONS = 10; //sembarang kode

    static {
        if(!OpenCVLoader.initDebug()) {
            Log.d(TAG, "OpenCV not loaded");
        } else {
            Log.d(TAG, "OpenCV loaded");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),UserActivity.class);
                startActivity(intent);
            }
        });
    }

    //PERMISSIONS
    //list array permission, sesuaikan dengan yang di manifest
    String[] permissions = new String[] {
            Manifest.permission_group.STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.INTERNET
    };

    //cek permission di awal activity
    @Override
    protected void onStart() {
        if(checkPermission()) {
            Toast.makeText(getApplicationContext(),"Permission granted!", Toast.LENGTH_LONG).show();
        } else {
            //Toast.makeText(getApplicationContext(),"Permission denied! Please check permissions settings",Toast.LENGTH_LONG).show();
        }
        super.onStart();
    }

    private boolean checkPermission() {
        int result;
        List<String> listPermissionNeeded = new ArrayList<>();
        for (String p:permissions) {
            result = ContextCompat.checkSelfPermission(getApplicationContext(),p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionNeeded.add(p);
            }
        }
        if (!listPermissionNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionNeeded.toArray(new String[listPermissionNeeded.size()]),
                    MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
            }
        }
    }
    //end permissions
}
