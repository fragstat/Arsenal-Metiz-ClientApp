package arsenal.metiz.catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import static arsenal.metiz.catalog.RequestStatusActivity.hasConnection;

public class RequestActivity extends AppCompatActivity {

    TextView Request, Mark, Diameter, Amount, Name, Pack, Price, Inn;
    Button sendButton,statusButton;
    EditText mAmount, mName, mEmail, mInn;
    Spinner mDiameter, mPack;
    RadioGroup RadioGroup;
    RadioButton But1, But2, PickBut;
    AutoCompleteTextView mMark;
    final String sPrefName = "My_Pref";
    final String SAVED_STATE = "request_counter";
    SharedPreferences sharedPreferences;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mSettings = mRootRef.child("settings");
    DatabaseReference mRequestNumber = mSettings.child("requestNumber");
    DatabaseReference mRequests = mRootRef.child("requests");

    private static final String[] Marks = new String[]{"СВ-08Г2С", "СВ-08ГСМТ", "СВ-10НМА",
            "СВ-18ХМА", "СВ-08ХМФА", "СВ-08ХГСМА", "СВ-08ХГСМФА", "СВ-08ХН2ГМТА",
                "СВ-10Х5М", "СВ-10ГСМТ","СВ-12Х13","СВ-01Х19Н9","СВ-07Х18Н9ТЮ","СВ-06Х19Н9Т",
            "СВ-04Х19Н9С2","СВ-08Х19Н9Ф2С2","СВ-07Х19Н10Б","СВ-08Х19Н11М3","СВ-05Х20Н9ФБС",
            "СВ-06Х20Н11М3Б","СВ-07Х25Н12Г2Т","СВ-07Х25Н13","СВ-08Х20Н9Г7Т",
            "СВ-08Х21Н10Г6","СВ-10Х16Н25АМ6","СВ-01Х23Н28М3Д3Т"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        checkInternet();
        bind();
        makeAutoCompleteAdapter();
        makeDiameterAdapter();
        makePacksAdapter();
        getRequestIntent();
        radioButtonActivation();
        markListener();
        setListenerOnButton();
        checkButtonVisibility();
    }



    private void checkInternet() {
        boolean connection = hasConnection(RequestActivity.this);
        if (!connection) {
            Intent intent = new Intent(RequestActivity.this,NoInternetActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public static boolean hasConnection(final Context context) {
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
        return wifiInfo != null && wifiInfo.isConnected();
    }

    private void checkButtonVisibility() {
        sharedPreferences = getSharedPreferences(sPrefName,MODE_PRIVATE);
        int counter = sharedPreferences.getInt(SAVED_STATE,0);
        if (counter == 0){
            statusButton.setVisibility(View.GONE);
        }
    }

    private void priceFetching2(){
        DatabaseReference catalogRef = mRootRef.child("catalog");

        String Mark = mMark.getText().toString().toUpperCase();
        String Diameter = mDiameter.getSelectedItem().toString();
        String Pack = mPack.getSelectedItem().toString();
        String Amount = mAmount.getText().toString();


        if (Pack.equals("Д200/К200") || (Pack.equals("Д300/К300"))){
            String approvedPack = removeCharAt(Pack,4);
            DatabaseReference priceRef = catalogRef.child(Mark).child(Diameter).child(approvedPack);

            priceRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    try {
                        String price = dataSnapshot.getValue().toString();
                        int approvedPrice = Integer.parseInt(price);
                        int approvedAmount = Integer.parseInt(Amount);
                        if (approvedAmount < 150 && approvedAmount > 0){
                            int accurateAmount =2*approvedPrice*approvedAmount;
                            String finishAmount = String.valueOf(accurateAmount);
                            Price.setText(finishAmount +" \u20BD");
                            sendButton.setText("Выставить счёт");
                            Inn.setVisibility(View.VISIBLE);
                            mInn.setVisibility(View.VISIBLE);
                        }if (approvedAmount<500 && approvedAmount>=150){
                            double accurateAmount = 1.5*approvedPrice * approvedAmount;
                            int finishing = (int)accurateAmount;
                            String finishAmount = String.valueOf(finishing);
                            Price.setText(finishAmount +" \u20BD");
                            sendButton.setText("Выставить счёт");
                            Inn.setVisibility(View.VISIBLE);
                            mInn.setVisibility(View.VISIBLE);
                        }if (approvedAmount >= 500) {
                            double accurateAmount = approvedPrice * approvedAmount;
                            int finishing = (int)accurateAmount;
                            String finishAmount = String.valueOf(finishing);
                            Price.setText(finishAmount +" \u20BD");
                            sendButton.setText("Выставить счёт");
                            Inn.setVisibility(View.VISIBLE);
                            mInn.setVisibility(View.VISIBLE);
                        }
                        Price.setVisibility(View.VISIBLE);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Price.setText("Ошибка");
                        Price.setVisibility(View.GONE);
                        Inn.setVisibility(View.GONE);
                        mInn.setVisibility(View.GONE);
                        sendButton.setText("Отправить запрос");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }else {
            String approvedPack = Pack;
            DatabaseReference priceRef = catalogRef.child(Mark).child(Diameter).child(approvedPack);

            priceRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    try {
                        String price = dataSnapshot.getValue().toString();
                        int approvedPrice = Integer.parseInt(price);
                        int approvedAmount = Integer.parseInt(Amount);
                        if (approvedAmount < 150 && approvedAmount > 0){
                            int accurateAmount =2*approvedPrice*approvedAmount;
                            String finishAmount = String.valueOf(accurateAmount);
                            Price.setText(finishAmount +" \u20BD");
                            sendButton.setText("Выставить счёт");
                            Inn.setVisibility(View.VISIBLE);
                            mInn.setVisibility(View.VISIBLE);
                        }if (approvedAmount<500 && approvedAmount>=150){
                            double accurateAmount = 1.5*approvedPrice * approvedAmount;
                            int finishing = (int)accurateAmount;
                            String finishAmount = String.valueOf(finishing);
                            Price.setText(finishAmount +" \u20BD");
                            sendButton.setText("Выставить счёт");
                            Inn.setVisibility(View.VISIBLE);
                            mInn.setVisibility(View.VISIBLE);
                        }if (approvedAmount >= 500) {
                            double accurateAmount = approvedPrice * approvedAmount;
                            int finishing = (int)accurateAmount;
                            String finishAmount = String.valueOf(finishing);
                            Price.setText(finishAmount +" \u20BD");
                            sendButton.setText("Выставить счёт");
                            Inn.setVisibility(View.VISIBLE);
                            mInn.setVisibility(View.VISIBLE);
                        }
                        Price.setVisibility(View.VISIBLE);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Price.setText("Ошибка");
                        Price.setVisibility(View.GONE);
                        Inn.setVisibility(View.GONE);
                        mInn.setVisibility(View.GONE);
                        sendButton.setText("Отправить заявку");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    private void makeAutoCompleteAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Marks);
        mMark.setAdapter(adapter);
    }

    private void markListener() {
        mMark.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                radioButtonActivation();
                priceFetching2();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                radioButtonActivation();
                priceFetching2();
            }

            @Override
            public void afterTextChanged(Editable s) {
                radioButtonActivation();
            }
        });
        mAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                priceFetching2();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                priceFetching2();
            }

            @Override
            public void afterTextChanged(Editable s) {
                radioButtonActivation();
            }
        });
    }

    private void radioButtonActivation() {
        String mark = mMark.getText().toString();
        if ((mark.equalsIgnoreCase("СВ-08Г2С")) || (mark.equalsIgnoreCase
                ("СВ-08ГСМТ")) || (mark.equalsIgnoreCase("СВ-10НМА"))
        || (mark.equalsIgnoreCase("СВ-18ХМА")) || (mark.equalsIgnoreCase
                ("СВ-08ХМФА")) || (mark.equalsIgnoreCase("СВ-08ХГСМА"))
                || (mark.equalsIgnoreCase("СВ-08ХГСМФА"))  || (mark.equalsIgnoreCase
                ("СВ-08ХН2ГМТА")) || (mark.equalsIgnoreCase("СВ-10ГСМТ"))
        ){
            But1.setEnabled(true);
            But2.setEnabled(true);
        } else {
            But1.setEnabled(false);
            But2.setEnabled(false);
        }

    }

    private void makePacksAdapter() {
        ArrayAdapter<CharSequence> packsAdapter = ArrayAdapter.createFromResource(this, R.array.packs, android.R.layout.simple_spinner_item);

        packsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner mPack = findViewById(R.id.mPackage);

        mPack.setAdapter(packsAdapter);

        mPack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                priceFetching2();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void makeDiameterAdapter() {
        ArrayAdapter<CharSequence> diameterAdapter = ArrayAdapter.createFromResource(this, R.array.diameters, android.R.layout.simple_spinner_item);

        diameterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner mDiameter = findViewById(R.id.mDiameter);

        mDiameter.setAdapter(diameterAdapter);

        mDiameter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                priceFetching2();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setListenerOnButton() {
        sendButton.setOnClickListener(v -> {
                    try {
                        boolean status = But1.isEnabled();
                        if (status) {
                            String amount = mAmount.getText().toString().trim();
                            String name = mName.getText().toString().trim();
                            String email = mEmail.getText().toString().trim();
                            String inn = mInn.getText().toString().trim();
                            if (amount.equals("")){
                                mAmount.setError("Введите корректное значение");
                            }
                            if (name.equals("")) {
                                mName.setError("Введите название компании");
                            }
                            if (email.equals("")) {
                                mEmail.setError("Введите Email");
                            }
                            if ((mInn.getVisibility() != View.GONE) && inn.equals("")) {
                                mInn.setError("Введите ИНН");
                            }if (!email.equals("") && !amount.equals("") && !name.equals("") && ( (!inn.equals("") && mInn.getVisibility() != View.GONE) || mInn.getVisibility() == View.GONE )){
                            int selectedId = RadioGroup.getCheckedRadioButtonId();
                            PickBut = findViewById(selectedId);
                            String layer = PickBut.getText().toString();
                            makeOrder2();}
                        }if (!status) {
                            String amount = mAmount.getText().toString().trim();
                            String name = mName.getText().toString().trim();
                            String email = mEmail.getText().toString().trim();
                            String inn = mInn.getText().toString().trim();
                            if (amount.equals("")){
                                mAmount.setError("Введите корректное значение");
                            }
                            if (name.equals("")) {
                                mName.setError("Введите название компании");
                            }
                            if (email.equals("")) {
                                mEmail.setError("Введите Email");
                            }if ((mInn.getVisibility() != View.GONE) && inn.equals("")){
                                mInn.setError("Введите ИНН");
                            }if (!email.equals("") && !amount.equals("") && !name.equals("") && ( (!inn.equals("") && mInn.getVisibility() != View.GONE) || mInn.getVisibility() == View.GONE )) {
                                makeOrder2();
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Выберете поверхность", Toast.LENGTH_LONG);
                        toast.show();
                    }

                }
        );
        statusButton.setOnClickListener(v -> {
            Intent intent = new Intent(RequestActivity.this,RequestStatusActivity.class);
            startActivity(intent);
        });
    }

    private void bind() {
        Mark = findViewById(R.id.Mark);
        mMark = findViewById(R.id.mMark);
        Diameter = findViewById(R.id.Diameter);
        mDiameter = findViewById(R.id.mDiameter);
        Amount = findViewById(R.id.Amount);
        mAmount = findViewById(R.id.mAmount);
        Name = findViewById(R.id.Name);
        mName = findViewById(R.id.mName);
        Pack = findViewById(R.id.Package);
        mPack = findViewById(R.id.mPackage);
        sendButton = findViewById(R.id.send);
        RadioGroup = findViewById(R.id.type);
        But1 = findViewById(R.id.But1);
        But2 = findViewById(R.id.But2);
        Request = findViewById(R.id.request);
        statusButton = findViewById(R.id.checkStatus);
        Price = findViewById(R.id.mPriceR);
        Price.setVisibility(View.GONE);
        mEmail = findViewById(R.id.mEmail);
        mInn = findViewById(R.id.mInn);
        Inn = findViewById(R.id.Inn);
        mInn.setVisibility(View.GONE);
        Inn.setVisibility(View.GONE);
        sendButton.setBackground(getDrawable(R.drawable.cornersoff));
    }

    public void getRequestIntent() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        mRequestNumber.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    long number = dataSnapshot.getValue(long.class);
                    Request.setText("Запрос №" + number);
                    sendButton.setEnabled(true);
                    sendButton.setBackground(getResources().getDrawable(R.drawable
                    .cornersv1));
                } catch (Exception e) {
                    e.printStackTrace();
                    sendButton.setEnabled(false);
                    sendButton.setBackground(getResources().getDrawable(R.drawable.cornersoff));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mMark.setText(title);

    }

    public void makeOrder2() {
        String title = mMark.getText().toString().trim();
        String name = mName.getText().toString().trim();
        String pack = mPack.getSelectedItem().toString().trim();
        String diameter = mDiameter.getSelectedItem().toString().trim();
        String amount = mAmount.getText().toString().trim();
        String id = Request.getText().toString().trim();
        String email = mEmail.getText().toString().trim();

        try {
            int selectedId = RadioGroup.getCheckedRadioButtonId();
            PickBut = findViewById(selectedId);
            String layer = PickBut.getText().toString();
            Map<String, Requests> requests = new HashMap<>();
            requests.put(id,new Requests(title, diameter, pack, layer ,amount,name,
                    email,"Принят в обработку"));
            mRequests.child(id).setValue(requests);
            mRequestNumber.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    try {
                        long number = dataSnapshot.getValue(long.class);
                        number++;
                        mRequestNumber.setValue(number);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            sendEmail();

            SystemClock.sleep(500);
            Intent intent = new Intent(RequestActivity.this, SuccessActivity.class);
            intent.putExtra(id,"RequestId");


            sharedPreferences = getSharedPreferences(sPrefName,MODE_PRIVATE);
            int counter = sharedPreferences.getInt(SAVED_STATE,0);
            int actCounter = counter + 1;
            String save_naming = "request" + actCounter;
            SharedPreferences.Editor ed = sharedPreferences.edit();
            ed.putInt(SAVED_STATE,counter+1);
            ed.putString(save_naming,id);
            ed.apply();

            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Requests> requests = new HashMap<>();
            requests.put(id,new Requests(title, diameter, pack, "-" ,amount,name,
                    email,"Принят в обработку"));
            mRequests.child(id).setValue(requests);
            mRequestNumber.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    long number = dataSnapshot.getValue(long.class);
                    number++;
                    mRequestNumber.setValue(number);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            sendEmail();

            SystemClock.sleep(500);
            Intent intent = new Intent(RequestActivity.this, SuccessActivity.class);
            intent.putExtra(id,"RequestId");


            sharedPreferences = getSharedPreferences(sPrefName,MODE_PRIVATE);
            int counter = sharedPreferences.getInt(SAVED_STATE,0);
            int actCounter = counter + 1;
            String save_naming = "request" + actCounter;
            SharedPreferences.Editor ed = sharedPreferences.edit();
            ed.putInt(SAVED_STATE,counter+1);
            ed.putString(save_naming,id);
            ed.apply();

            startActivity(intent);
        }


    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    private void sendEmail() {
        //Getting content for email
        String email = "sevalavin@edu.hse.ru";
        String subject = mMark.getText().toString().trim();
        String id = Request.getText().toString().trim();
        String company = mName.getText().toString().trim();
        String sendSubject = id + " от компании " + '"' + company + '"';
        String diameter = mDiameter.getSelectedItem().toString().trim();
        String price = Price.getText().toString().trim();
        String amount = mAmount.getText().toString().trim();
        String pack = mPack.getSelectedItem().toString().trim();
        String inn = mInn.toString().trim();
        String layer = null;
        try {
            layer = PickBut.getText().toString().trim().toLowerCase();
            if (!price.equalsIgnoreCase("Ошибка")){
                String message = sendSubject + " на проволоку " + subject + " " + layer + " диаметра "
                        + diameter + " на/в " + pack + " в количестве " + amount + "кг" +
                        " с итоговой ценой " + price + ". Контактный e-mail " + email + " . ИНН для выставления счёта: " + inn;
                SendMail sm = new SendMail(this, email, sendSubject, message);
                sm.execute();
            }else {
                String message = sendSubject + " на проволоку " + subject + " " + layer + " диаметра " + diameter + " на/в " + pack + " в количестве " + amount + " кг";
                SendMail sm = new SendMail(this, email, sendSubject, message);
                sm.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (!price.equalsIgnoreCase("Ошибка")){
                String message = sendSubject + " на проволоку " + subject + " диаметра "
                        + diameter + " на/в " + pack + " в количестве " + amount + "кг" +
                        " с итоговой ценой " + price + ". Контактный e-mail " + email + " . ИНН для выставления счёта: " + inn;
                SendMail sm = new SendMail(this, email, sendSubject, message);
                sm.execute();
            }else {
                String message = sendSubject + " на проволоку " + subject + " диаметра " + diameter + " на/в " + pack + " в количестве " + amount + " кг" +  ". Контактный e-mail " + email + " . ИНН для выставления счёта: " + inn;
                SendMail sm = new SendMail(this, email, sendSubject, message);
                sm.execute();
            }
        }

        //Creating SendMail object

        //Executing sendmail to send email
        finish();
    }

}

