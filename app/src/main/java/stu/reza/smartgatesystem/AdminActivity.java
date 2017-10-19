package stu.reza.smartgatesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {
    TextView tvAdmin,tvRiwayat;
    Button btnRegister,btnLogout;
    Intent intentDariAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        tvAdmin = (TextView) findViewById(R.id.tvAdmin);
        tvRiwayat = (TextView) findViewById(R.id.tvRiwayat);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentDariAdmin = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intentDariAdmin);
            }
        });
    }
}