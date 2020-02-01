package arsenal.metiz.catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmCertificateActivity extends AppCompatActivity {

    Button main;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_certificate);
        bind();
        setListenerOnButton();
        getCertificateIntent();
    }

    public void getCertificateIntent() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        message.append(" " + id);
    }

    private void setListenerOnButton() {
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmCertificateActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void bind() {
        main = findViewById(R.id.toMainT);
        message = findViewById(R.id.messageT);
    }



}