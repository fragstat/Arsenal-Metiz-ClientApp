package arsenal.metiz.catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    Button Main,Status;
    TextView text;
    SharedPreferences sharedPreferences;
    final String sPrefName = "My_Pref";
    final String SAVED_STATE = "request_counter";
    final String INITIALISATION = "initialisation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        bind();
        parseIntent();
        setListenerOnButtons();



    }

    public void parseIntent() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("RequestId");

    }

    private void setListenerOnButtons() {
        Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessActivity.this,RequestStatusActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bind() {
        Main = findViewById(R.id.toMain);
        Status = findViewById(R.id.toStatus);
        text = findViewById(R.id.completed);
        sharedPreferences = getSharedPreferences(sPrefName,MODE_PRIVATE);
        int counter = sharedPreferences.getInt(SAVED_STATE,-5);
        String count = String.valueOf(counter);

    }


}


