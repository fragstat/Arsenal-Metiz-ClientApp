package arsenal.metiz.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class BarcodeCompActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";
    FirebaseFirestore DB = FirebaseFirestore.getInstance();
    TextView id, mark, diameter, plav, part, weight, customer;
    Button butT, butF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_comp);
        bind();
        receiveData();
        setListenerOnButton();

    }

    private void receiveData() {
        String idR = receiveIntent();
        DocumentReference documentReference = DB.collection("certificates").document(idR);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        Map<String, Object> hashMap = document.getData();

                        String markDB = hashMap.get("mark").toString() + "\u00A0";
                        String diameterDB = hashMap.get("diameter").toString() + "\u00A0";
                        String idDB = hashMap.get("id").toString() + "\u00A0";
                        String plavDB = hashMap.get("plav").toString() + "\u00A0";
                        String partDB = hashMap.get("part").toString() + "\u00A0";
                        String weightDB = hashMap.get("weight").toString() + "\u00A0";
                        String customerDB = hashMap.get("customer").toString() + "\u00A0";

                        mark.append(markDB);
                        diameter.append(diameterDB);
                        id.append(idDB);
                        plav.append(plavDB);
                        part.append(partDB);
                        weight.append(weightDB);
                        customer.append(customerDB);

                    } else {
                        Intent intent = new Intent(BarcodeCompActivity.this, NotInTheBaseActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Intent intent = new Intent(BarcodeCompActivity.this, NotInTheBaseActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private String receiveIntent() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("qr");
        return id;
    }

    private void bind() {
        mark = findViewById(R.id.DBmark);
        id = findViewById(R.id.DBid);
        diameter = findViewById(R.id.DBdiameter);
        plav = findViewById(R.id.DBplav);
        part = findViewById(R.id.DBpart);
        butT = findViewById(R.id.butTrue);
        butF = findViewById(R.id.butFalse);
        weight = findViewById(R.id.DBweight);
        customer = findViewById(R.id.DBcustomer);
    }

    private void setListenerOnButton() {
        butT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idR = receiveIntent();
                Intent intent = new Intent(BarcodeCompActivity.this, ConfirmCertificateActivity.class);
                intent.putExtra("id", idR);
                startActivity(intent);
                finish();
            }
        });
        butF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idR = receiveIntent();
                Intent intent = new Intent(BarcodeCompActivity.this, FakeCertificateActivity.class);
                intent.putExtra("id", idR);
                startActivity(intent);
                finish();
            }
        });
    }
}
