package stu.reza.smartgatesystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    Button btnLogout, btnBukaGerbang, btnTutupGerbang, btnMenuAdmin;
    ImageView ivFotoUser;
    Intent intentDariUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ivFotoUser = (ImageView) findViewById(R.id.ivFotoAkun);
        btnBukaGerbang = (Button) findViewById(R.id.btnBukaGerbang);
        btnTutupGerbang = (Button) findViewById(R.id.btnTutupGerbang);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnMenuAdmin = (Button) findViewById(R.id.btnMenuAdmin);

        btnBukaGerbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Buka Gerbang!",Toast.LENGTH_SHORT).show();
            }
        });

        btnTutupGerbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Tutup Gerbang!",Toast.LENGTH_SHORT).show();
            }
        });

        btnMenuAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentDariUser = new Intent(getApplicationContext(),AdminActivity.class);
                startActivity(intentDariUser);
            }
        });
    }
}
