package arsenal.metiz.catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Byte3;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class BarcodeCustomersActivity extends AppCompatActivity {

    TextView id,B1V,B2V,B3V,B4V;
    Button butT,butF;

    FirebaseFirestore DB = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_customers);
        bind();
        receiveData();
        setListenerOnButton();
    }

    private String receiveIdFromIntent() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        return id;
    }

    private void bind() {
        B1V = findViewById(R.id.B1);
        id = findViewById(R.id.Bid);
        B2V = findViewById(R.id.B2);
        B2V.setVisibility(View.GONE);
        B3V = findViewById(R.id.B3);
        B3V.setVisibility(View.GONE);
        B4V =findViewById(R.id.B4);
        B4V.setVisibility(View.GONE);
        butT = findViewById(R.id.butTrueB);
        butF = findViewById(R.id.butFalseB);
    }

    private void receiveData() {
        String idR = receiveIdFromIntent();
        DocumentReference documentReference = DB.collection("customers").document(idR);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Map<String, Object> hashMap = (Map<String, Object>) document.getData();
                        try {
                            String B1 = hashMap.get("customer1").toString() + "\u00A0";
                            B1V.append(B1);
                        } catch (Exception e) {
                            e.printStackTrace();
                            B1V.setText("В базе данных нет данных о покупателях");
                        }
                        try {
                            String B2 = hashMap.get("customer2").toString() + "\u00A0";
                            B2V.append(B2);
                            B2V.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            String B3 = hashMap.get("customer3").toString() + "\u00A0";
                            B3V.append(B3);
                            B3V.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            String B4 = hashMap.get("customer4").toString() + "\u00A0";
                            B4V.append(B4);
                            B4V.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String idC = hashMap.get("id").toString() + "\u00A0";
                        id.append(idC);

                    } else {

                    }
                } else {
                }
            }
        });

    }

    private void setListenerOnButton(){
        butT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idR = receiveIdFromIntent();
                Intent intent = new Intent(BarcodeCustomersActivity.this,ConfirmCertificateActivity.class);
                intent.putExtra("id",idR);
                startActivity(intent);
                finish();
            }
        });
        butF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idR = receiveIdFromIntent();
                Intent intent = new Intent(BarcodeCustomersActivity.this, FakeCertificateActivity.class);
                intent.putExtra("id",idR);
                startActivity(intent);
                finish();
            }
        });
    }

}
