package arsenal.metiz.catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class NoInternetActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);
        bind();
        setListenerOnButton();
    }

    private void setListenerOnButton() {
        button.setOnClickListener(v -> {
            Intent intent = new Intent(NoInternetActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void bind() {
        button = findViewById(R.id.noInternetToMainButton);
    }


}
