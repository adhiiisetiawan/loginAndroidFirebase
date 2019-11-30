package com.oxcart.loginfirebasekuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertActivity extends AppCompatActivity {
    private EditText edtNamaBarang;
    private EditText edtJenisBarang;
    private EditText edtUmurBarang;
    private EditText edtJumlahBarang;
    private EditText edtHargaBarang;

    private String NamaBarang;
    private String JenisBarang;
    private String UmurBarang;

    private String JumlahBarang;
    private String HargaBarang;

    private Button btnInsert;

    // Declaring String variable ( In which we are storing firebase server URL ).
    public static final String Firebase_Server_URL = "https://loginfirebase-4cd48.firebaseio.com/";

    Firebase firebase;
    DatabaseReference databaseReference;

    // Root Database Name for Firebase Database.
    public static final String Database_Path = "Barang_Database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        edtNamaBarang = findViewById(R.id.text_nama_barang);
        edtJenisBarang = findViewById(R.id.text_jenis_barang);
        edtUmurBarang = findViewById(R.id.text_umur_barang);
        edtJumlahBarang = findViewById(R.id.text_jumlah_barang);
        edtHargaBarang = findViewById(R.id.text_harga_barang);

        btnInsert = findViewById(R.id.btn_insert);

        Firebase.setAndroidContext(InsertActivity.this);
        firebase = new Firebase(Firebase_Server_URL);

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Barang barangku = new Barang();
                GetDataFromEditText();

                barangku.setNamaBarang(NamaBarang);
                barangku.setJenisBarang(JenisBarang);
                barangku.setUmurBarang(UmurBarang);
                barangku.setJumlahPerKilo(JumlahBarang);
                barangku.setHargaBarang(HargaBarang);

                // Getting the ID from firebase database.
                String StudentRecordIDFromServer = databaseReference.push().getKey();

                // Adding the both name and number values using student details class object using ID.
                databaseReference.child(StudentRecordIDFromServer).setValue(barangku);

                // Showing Toast message after successfully data submit.
                Intent intent = new Intent(InsertActivity.this, ShowBarangActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(InsertActivity.this,"Data Successfully into Firebase Database", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void GetDataFromEditText(){
        NamaBarang = edtNamaBarang.getText().toString();
        JenisBarang = edtJenisBarang.getText().toString();
        UmurBarang = edtUmurBarang.getText().toString();

        JumlahBarang = edtJumlahBarang.getText().toString();
        HargaBarang = edtHargaBarang.getText().toString();
    }
}
