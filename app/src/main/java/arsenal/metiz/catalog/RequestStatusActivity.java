package arsenal.metiz.catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RequestStatusActivity extends AppCompatActivity {

    final String sPrefName = "My_Pref";
    final String SAVED_STATE = "request_counter";

    SharedPreferences sharedPreferences;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRequests = mRootRef.child("requests");

    private StatusAdapter statusAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_status);
        checkInternet();
        final RecyclerView rv = findViewById(R.id.recyclerS);
        statusAdapter = new StatusAdapter();
        rv.setAdapter(statusAdapter);
        fillAdapter();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);


    }

    private void checkInternet() {
        boolean connection = hasConnection(RequestStatusActivity.this);
        if (!connection) {
            Intent intent = new Intent(RequestStatusActivity.this,NoInternetActivity.class);
            startActivity(intent);
        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RequestStatusActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public static boolean hasConnection(final Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        return false;
    }

    public void fillAdapter() {
        ArrayList<RequestsStatus> statuses = new ArrayList<>();
        sharedPreferences = getSharedPreferences(sPrefName, MODE_PRIVATE);
        int counter = sharedPreferences.getInt(SAVED_STATE, 0);
        for (int i = 1; i <= counter; i++) {
            String destination = sharedPreferences.getString("request" + i, "");
            DatabaseReference statusRef = mRequests.child(destination);
            DatabaseReference mStatusRef = statusRef.child(destination);
            mStatusRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    try {
                        Map<String, Object> hashMap = (Map<String, Object>) dataSnapshot.getValue();
                        String mark = hashMap.get("mark").toString() + "\u00A0";
                        String diameter = hashMap.get("diameter").toString() + "\u00A0";
                        String layer = hashMap.get("layer").toString() + "\u00A0";
                        String pack = hashMap.get("pack").toString() + "\u00A0";
                        String status = hashMap.get("status").toString() + "\u00A0";
                        RequestsStatus requestsStatus = new RequestsStatus(destination, mark, diameter, layer, pack, status);
                        statuses.add(requestsStatus);
                        statusAdapter.replaceStatuses(statuses);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    }

}
