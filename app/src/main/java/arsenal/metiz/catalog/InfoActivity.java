package arsenal.metiz.catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class InfoActivity extends AppCompatActivity {

    protected TextView C,mC,Si,mSi,Mn,mMn,Cr,mCr,Ni,mNi,Mo,mMo,Ti,mTi,S,mS,P,mP,O,mO,Pr,mPr,mAm,PrA,mPrA,mAmA,PrB,mPrB,mAmB,PrC,mPrC,mAmC,PrD,mPrD,mAmD,PrE,mPrE,mAmE,PrF,mPrF,mAmF;
    protected String titleText, url;
    private Button link,Elink;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        bind();
        receiveIntent();
        setListenerOnButton();


    }

    private void bind(){
        link = findViewById(R.id.link);
        Elink = findViewById(R.id.Elink);
        C = findViewById(R.id.C);
        mC = findViewById(R.id.mC);
        Si = findViewById(R.id.Si);
        mSi = findViewById(R.id.mSi);
        Mn = findViewById(R.id.Mn);
        mMn = findViewById(R.id.mMn);
        Cr = findViewById(R.id.Cr);
        mCr = findViewById(R.id.mCr);
        Ni = findViewById(R.id.Ni);
        mNi = findViewById(R.id.mNi);
        Mo = findViewById(R.id.Mo);
        mMo = findViewById(R.id.mMo);
        Ti = findViewById(R.id.Ti);
        mTi = findViewById(R.id.mTi);
        S = findViewById(R.id.S);
        mS = findViewById(R.id.mS);
        P = findViewById(R.id.P);
        mP = findViewById(R.id.mP);
        O = findViewById(R.id.Other);
        mO = findViewById(R.id.mOther);

    }


    private void receiveIntent(){
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        if (title.equals("СВ-08Г2С")){
            titleText = title;
            mC.setText("0,05 - 0,11 %");
            mSi.setText("0,70 - 0,95 %");
            mMn.setText("1,80 - 2,10 %");
            mCr.setText("не более 0,20 %");
            mNi.setText("не более 0,25 %");
            mMo.setText("-");
            mTi.setText("-");
            mS.setText("0,025 %");
            mP.setText("0,030 %");
            mO.setText("-");
            url = "http://www.arsenal-metiz.ru/content/sv-08g2s";
        }
        if (title.equals("СВ-08ГСМТ")){
            titleText = title;
            mC.setText("0,06  - 0,11 %");
            mSi.setText("0,40 - 0,70 %");
            mMn.setText("1,00 - 1,30 %");
            mCr.setText("не более 0,30 %");
            mNi.setText("не более 0,30 %");
            mMo.setText("0,20 - 0,40 %");
            mTi.setText("0,05 - 0,12 %");
            mS.setText("0,025 %");
            mP.setText("0,030 %");
            mO.setText("-");
            url = "http://www.arsenal-metiz.ru/content/sv-08gsmt";

        }
        if (title.equals("СВ-10НМА")){
            titleText = title;
            mC.setText("0,07 - 0,12 %");
            mSi.setText("0,12 - 0,35 %");
            mMn.setText("0,40 - 0,70 %");
            mCr.setText("не более 0,20 %");
            mNi.setText("1,00 - 1,50 %");
            mMo.setText("0,40 - 0,55 %");
            mTi.setText("-");
            mS.setText("0,025 %");
            mP.setText("0,020 %");
            mO.setText("-");
            url = "http://www.arsenal-metiz.ru/content/sv-10nma";

        }
        if (title.equals("СВ-18ХМА")){
            titleText = title;
            mC.setText("0,15 - 0,22 %");
            mSi.setText("0,12 - 0,35 %");
            mMn.setText("0,40 - 0,70 %");
            mCr.setText("0,80 - 1,10 %");
            mNi.setText("не более 0,30 %");
            mMo.setText("0,15 - 0,30 %");
            mTi.setText("-");
            mS.setText("0,025 %");
            mP.setText("0,025 %");
            mO.setText("-");
            url = "http://www.arsenal-metiz.ru/content/sv-18hma";

        }
        if (title.equals("СВ-08ХМФА")){
            titleText = title;
            mC.setText("0,06 - 0,10 %");
            mSi.setText("0,12 - 0,30 %");
            mMn.setText("0,35 - 0,60 %");
            mCr.setText("0,90 - 1,20 %");
            mNi.setText("не более 0,30 %");
            mMo.setText("0,50 - 0,70 %");
            mTi.setText("-");
            mS.setText("0,025 %");
            mP.setText("0,025 %");
            mO.setText("V (ванадий) 0,15 - 0,30 %");
            url = "http://www.arsenal-metiz.ru/content/sv-08hmfa";

        }
        if (title.equals("СВ-08ХГСМА")){
            mC.setText("0,06 - 0,10 %");
            titleText = title;
            mSi.setText("0,45 - 0,70 %");
            mMn.setText("1,15 - 1,45 %");
            mCr.setText("0,85 - 1,15 %");
            mNi.setText("не более 0,30 %");
            mMo.setText("0,40 - 0,60 %");
            mTi.setText("-");
            mS.setText("0,025 %");
            mP.setText("0,025 %");
            mO.setText("-");
            url = "http://www.arsenal-metiz.ru/content/sv-08hgsma";
        }
        if (title.equals("СВ-08ХГСМФА")){
            mC.setText("0,06 - 0,10 %");
            mSi.setText("0,45 - 0,70 %");
            mMn.setText("1,20 - 1,50 %");
            mCr.setText("0,95 - 1,25 %");
            mNi.setText("не более 0,30 %");
            mMo.setText("0,50 - 0,70 %");
            mTi.setText("-");
            titleText = title;
            mS.setText("0,025 %");
            mP.setText("0,025 %");
            mO.setText("V (ванадий) 0,20 - 0,35 %");
            url = "http://www.arsenal-metiz.ru/content/sv-08hgsmfa";
        }
        if (title.equals("СВ-08ХН2ГМТА")){
            mC.setText("0,06 - 0,11 %");
            mSi.setText("0,12 - 0,30 %");
            mMn.setText("0,80 - 1,10 %");
            mCr.setText("0,25 - 0,45 %");
            mNi.setText("2,10 - 2,50 %");
            mMo.setText("0,40 - 0,65 %");
            mTi.setText("-");
            titleText = title;
            mS.setText("0,030 %");
            mP.setText("0,030 %");
            mO.setText("Al (алюминий) 0,06 - 0,18 %");
            url = "http://www.arsenal-metiz.ru/content/sv-08hn2gmta";
        }
        if (title.equals("СВ-10Х5М")){
            mC.setText("не более 0,12 %");
            mSi.setText("0,12 - 0,35 %");
            mMn.setText("0,40 - 0,70 %");
            mCr.setText("4,00 - 5,50 %");
            mNi.setText("не более 0,30 %");
            mMo.setText("0,40 - 0,60 %");
            mTi.setText("-");
            titleText = title;
            mS.setText("0,025 %");
            mP.setText("0,030 %");
            mO.setText("-");
            url = "http://www.arsenal-metiz.ru/content/sv-10h5m";
        }
        if (title.equals("СВ-10ГСМТ")){
            mC.setText("0,08  - 0,14 %");
            mSi.setText("0,40 - 0,70 %");
            mMn.setText("1,00 - 1,30 %");
            mCr.setText("не более 0,30 %");
            mNi.setText("не более 0,30 %");
            mMo.setText("0,20 - 0,40 %");
            mTi.setText("0,05 - 0,12 %");
            mS.setText("0,025 %");
            mP.setText("0,030 %");
            mO.setText("-");
            titleText = title;
            url = "http://www.arsenal-metiz.ru/content/sv-10gsmt";
        }
        if (title.equals("СВ-12X13")){
            mC.setText("0,09 - 0,14 %");
            mSi.setText("0,30 - 0,70 %");
            mMn.setText("0,30 - 0,70 %");
            mCr.setText("12,00 - 14,00 %");
            mNi.setText("не более 0,60 %");
            mMo.setText("-");
            mTi.setText("-");
            mS.setText("0,025 %");
            mP.setText("0,030 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-12h13";
        }
        if (title.equals("СВ-01Х19Н")){
            mC.setText("не более 0,03 %");
            mSi.setText("0,50 - 1,00 %");
            mMn.setText("1,00 - 2,00 %");
            mCr.setText("18,00 - 20,00 %");
            mNi.setText("8,00 - 10,00 %");
            mMo.setText("-");
            mTi.setText("-");
            mS.setText("0,015 %");
            mP.setText("0,025 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-01h19n9";
        }
        if (title.equals("СВ-07Х18Н9ТЮ")){
            mC.setText("не более 0,09 %");
            mSi.setText("не более 0,80 %");
            mMn.setText("не более 2,00 %");
            mCr.setText("17,00 - 19,00 %");
            mNi.setText("8,00 - 10,00 %");
            mMo.setText("-");
            mTi.setText("1,00 - 1,40 %");
            mS.setText("0,015 %");
            mP.setText("0,030 %");
            mO.setText("Al(алюминий) 0,60 - 0,95 %");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-07h18n9tyu";
        }
        if (title.equals("СВ-06Х19Н9Т")){
            mC.setText("не более 0,08 %");
            mSi.setText("0,40 - 1,00 %");
            mMn.setText("1,00 - 2,00 %");
            mCr.setText("18,00 - 20,00 %");
            mNi.setText("8,00 - 10,00 %");
            mMo.setText("-");
            mTi.setText("0,50 - 1,00 %");
            mS.setText("0,015 %");
            mP.setText("0,030 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-06h19n9t";
        }
        if (title.equals("СВ-04Х19Н9С2")){
            mC.setText("не более 0,06 %");
            mSi.setText("2,00 - 2,75 %");
            mMn.setText("1,00 - 2,00 %");
            mCr.setText("18,00 - 20,00 %");
            mNi.setText("8,00 - 10,00 %");
            mMo.setText("-");
            mTi.setText("-");
            mS.setText("0,018 %");
            mP.setText("0,025 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-04h19n9s2";
        }
        if (title.equals("СВ-08Х19Н9Ф2С2")){
            mC.setText("не более 0,10 %");
            mSi.setText("1,30 - 1,80 %");
            mMn.setText("1,00 - 2,00 %");
            mCr.setText("18,00 - 20,00 %");
            mNi.setText("8,00 - 10,00 %");
            mMo.setText("-");
            mTi.setText("-");
            mS.setText("0,025 %");
            mP.setText("0,030 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-08h19n9f2s2";
        }
        if (title.equals("СВ-07Х19Н10Б")){
            mC.setText("0,05 - 0,09 %");
            mSi.setText("не более 0,70 %");
            mMn.setText("1,50 - 2,00 %");
            mCr.setText("18,50 - 20,50 %");
            mNi.setText("9,00 - 10,50 %");
            mMo.setText("-");
            mTi.setText("-");
            mS.setText("0,018 %");
            mP.setText("0,025 %");
            mO.setText("Nb (ниобий) 1,20 - 1,50 %");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-07h19n10b";
        }
        if (title.equals("СВ-08Х19Н10Г2Б")){
            mC.setText("0,05 - 0,10 %");
            mSi.setText("0,20 - 0,45 %");
            mMn.setText("1,80 - 2,20 %");
            mCr.setText("18,50 - 20,20 %");
            mNi.setText("9,50 - 10,50 %");
            mMo.setText("-");
            mTi.setText("-");
            mS.setText("0,020 %");
            mP.setText("0,030 %");
            mO.setText("Nb (ниобий) 0,90 - 1,30 %");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-08h19n10g2b";
        }
        if (title.equals("СВ-06Х19Н10М3Т")){
            mC.setText("не более 0,08 %");
            mSi.setText("0,30 - 0,80 %");
            mMn.setText("1,00 - 2,00 %");
            mCr.setText("18,00 - 20,00 %");
            mNi.setText("9,00 - 11,00 %");
            mMo.setText("2,00 - 3,00 %");
            mTi.setText("0,50 - 0,80 %");
            mS.setText("0,018 %");
            mP.setText("0,025 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-06h19n10m3t";
        }
        if (title.equals("СВ-08Х19Н10М3Б")){
            mC.setText("не более 0,10 %");
            mSi.setText("не более 0,60 %");
            mMn.setText("1,00 - 2,00 %");
            mCr.setText("18,00 - 20,00 %");
            mNi.setText("9,00 - 11,00 %");
            mMo.setText("2,00 - 3,00 %");
            mTi.setText("-");
            mS.setText("0,018 %");
            mP.setText("0,025 %");
            mO.setText("Nb (ниобий) 0,90 - 1,30 %");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-08h19n10m3b";
        }
        if (title.equals("СВ-04Х19Н11М3")){
            mC.setText("не более 0,06 %");
            mSi.setText("не более 0,60 %");
            mMn.setText("1,00 - 2,00 %");
            mCr.setText("18,00 - 20,00 %");
            mNi.setText("10,00 - 12,00 %");
            mMo.setText("2,00 - 3,00 %");
            mTi.setText("-");
            mS.setText("0,018 %");
            mP.setText("0,025 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-04h19n11m3";
        }
        if (title.equals("СВ-05Х20Н9ФБС")){
            mC.setText("не более 0,07 %");
            mSi.setText("0,90 - 1,50 %");
            mMn.setText("1,00 - 2,00 %");
            mCr.setText("19,00 - 21,00 %");
            mNi.setText("8,00 - 10,00 %");
            mMo.setText("-");
            mTi.setText("-");
            mS.setText("0,020 %");
            mP.setText("0,030 %");
            mO.setText("Nb (ниобий) 1,00 - 1,40 %" +
                    "V (ванадий) 0,90 - 1,30 %");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-05h20n9fbs";
        }
        if (title.equals("СВ-06Х20Н11М3ТБ")){
            mC.setText("не более 0,08 %");
            mSi.setText("0,50 - 1,00 %");
            mMn.setText("не более 0,80 %");
            mCr.setText("19,00 - 21,00 %");
            mNi.setText("10,00 - 12,00 %");
            mMo.setText("2,50 - 3,00 %");
            mTi.setText("0,60 - 1,10 %");
            mS.setText("0,018 %");
            mP.setText("0,030 %");
            mO.setText("Nb (ниобий) 0,60 - 0,90 %");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-06h20n11m3tb";
        }
        if (title.equals("СВ-07Х25Н12Г2Т")){
            mC.setText("не более 0,09 %");
            mSi.setText("0,30 - 1,00 %");
            mMn.setText("1,50 - 2,50 %");
            mCr.setText("24,00 - 26,50 %");
            mNi.setText("11,00 - 13,00 %");
            mMo.setText("-");
            mTi.setText("0,60 - 1,10 %");
            mS.setText("0,020 %");
            mP.setText("0,035 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-07h25n12g2t";
        }
        if (title.equals("СВ-07Х25Н13")){
            mC.setText("не более 0,09 %");
            mSi.setText("0,50 - 1,00 %");
            mMn.setText("1,00 - 2,00 %");
            mCr.setText("23,00 - 26,00 %");
            mNi.setText("12,00 - 14,00 %");
            mMo.setText("-");
            mTi.setText("-");
            mS.setText("0,018 %");
            mP.setText("0,025 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-07h25n13";
        }
        if (title.equals("СВ-08Х20Н9Г7Т")){
            mC.setText("не более 0,10 %");
            mSi.setText("0,50 - 1,00 %");
            mMn.setText("5,00 - 8,00 %");
            mCr.setText("18,50 - 22,00 %");
            mNi.setText("8,00 - 10,00 %");
            mMo.setText("-");
            mTi.setText("0,60 - 0,90 %");
            mS.setText("0,018 %");
            mP.setText("0,035 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-08h20n9g7t";
        }
        if (title.equals("СВ-08Х21Н10Г6")){
            mC.setText("не более 0,10 %");
            mSi.setText("0,20 - 0,70 %");
            mMn.setText("5,00 - 7,00 %");
            mCr.setText("20,00 - 22,00 %");
            mNi.setText("9,00 - 11,00 %");
            mMo.setText("-");
            mTi.setText("-");
            mS.setText("0,018 %");
            mP.setText("0,035 %");
            mO.setText("-");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-08h21n10g6";
        }
        if (title.equals("СВ-10Х16Н25АМ6")){
            mC.setText("0,08 - 0,12 %");
            mSi.setText("не более 0,60 %");
            mMn.setText("1,00 - 2,00 %");
            mCr.setText("15,00 - 17,00 %");
            mNi.setText("24,00 - 27,00 %");
            mMo.setText("5,50 - 7,00 %");
            mTi.setText("-");
            mS.setText("0,018 %");
            mP.setText("0,025 %");
            mO.setText("N (азот) 0,10 - 0,20 %");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-10h16n25am6";
        }
        if (title.equals("СВ-01Х23Н28М3Д3Т")){
            mC.setText("не более 0,03 %");
            mSi.setText("не более 0,55 %");
            mMn.setText("не более 0,55 %");
            mCr.setText("22,00 - 25,00 %");
            mNi.setText("26,00 - 29,00 %");
            mMo.setText("2,50 - 3,00 %");
            mTi.setText("0,50 - 0,90 %");
            mS.setText("0,018 %");
            mP.setText("0,030 %");
            mO.setText("Cu (медь) 2,50 - 3,50 %");
            titleText = title;
            url = "https://www.arsenal-metiz.ru/content/sv-01h23n28m3d3t";
        }



    }

    public void setListenerOnButton(){
        link.setOnClickListener(v -> {
            Intent intent = new Intent( InfoActivity.this, mWebView.class);
            intent.putExtra("Url", url);
            startActivity(intent);
            finish();
        });
        Elink.setOnClickListener(v -> {
            Intent intent = new Intent(InfoActivity.this, RequestActivity.class);
            intent.putExtra("Title",titleText);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();


    }





}
