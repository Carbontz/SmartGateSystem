package stu.reza.smartgatesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.opencv.android.JavaCameraView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText etNama,etEmail,etPassword;
        TextView tvNama, tvImei;
        Button btnKembali;
        Button btnDaftarkan;
        JavaCameraView jcvKameraRegister;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNama = (EditText) findViewById(R.id.etNama);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnKembali = (Button) findViewById(R.id.btnKembali);
        btnDaftarkan = (Button) findViewById(R.id.btnDaftarkan);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnDaftarkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Registrasi Sukses!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

