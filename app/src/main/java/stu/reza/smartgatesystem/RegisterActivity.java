package stu.reza.smartgatesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.opencv.android.JavaCameraView;

public class RegisterActivity extends AppCompatActivity {

    EditText etNama,etEmail,etPassword;
    TextView tvNama, tvImei;
    Button btnKembali;
    Button btnDaftarkan;
    JavaCameraView jcvKameraRegister;
    Account akunUser;
    Boolean formvalid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    private void registerUser() {
        //validasi form
        if (etNama.getText().toString().equals("")) {
            etNama.setError("Inputkan Nama Terlebih Dahulu..");
            etNama.requestFocus();
        } else if (etEmail.getText().toString().equals("")) {
                etEmail.setError("Inputkan Email Terlebih Dahulu");
                etEmail.requestFocus();
            } else if (etPassword.getText().toString().equals("")) {
                    etPassword.setError("Inputkan Password Terlebih Dahulu");
                    etPassword.requestFocus();
                } else {
                    formvalid=true;
                    akunUser = new Account();
                    akunUser.setNama(etNama.getText().toString());
                    akunUser.setEmail(etEmail.getText().toString());
                    akunUser.setPassword(etPassword.getText().toString());
                }

    }
}

