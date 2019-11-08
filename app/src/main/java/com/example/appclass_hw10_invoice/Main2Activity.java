package com.example.appclass_hw10_invoice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    TextView textSp;
    TextView textSs;
    TextView textH1;
    TextView textH2;
    TextView textH3;
    TextView textO1;
    TextView textO2;
    TextView textO3;
    Button btnBack1;
    Button btnNext3;
    EditText editNumber;
    Intent intentTo3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textSp = findViewById(R.id.TextSp);
        TextView textSs = findViewById(R.id.TextSs);
        TextView textH1 = findViewById(R.id.TextH1);
        TextView textH2 = findViewById(R.id.TextH2);
        TextView textH3 = findViewById(R.id.TextH3);
        TextView textO1 = findViewById(R.id.TextO1);
        TextView textO2 = findViewById(R.id.TextO2);
        TextView textO3 = findViewById(R.id.TextO3);
        btnBack1 = findViewById(R.id.BtnBack1);
        btnNext3 = findViewById(R.id.BtnNext3);
        editNumber = findViewById(R.id.EditNumber);
        intentTo3 = new Intent(Main2Activity.this, Main3Activity.class);
        Intent intent2 = getIntent();
        int Month = intent2.getIntExtra("Month", 0);
        Resources res = getResources();
        String[] strings = {};
        switch (Month) {
            case 0:
                strings = res.getStringArray(R.array.January);
                break;
            case 1:
                strings = res.getStringArray(R.array.March);
                break;
            case 2:
                strings = res.getStringArray(R.array.May);
                break;
            case 3:
                strings = res.getStringArray(R.array.July);
                break;
            case 4:
                strings = res.getStringArray(R.array.September);
                break;
            case 5:
                strings = res.getStringArray(R.array.November);
                break;
        }
        for (int i = 0; i < strings.length; i++) {
            switch (i) {
                case 0:
                    textSp.setText("特別獎" + strings[0]);
                    break;
                case 1:
                    textSs.setText("特獎" + strings[1]);
                    break;
                case 2:
                    textH1.setText("頭獎" + strings[2]);
                    break;
                case 3:
                    textH2.setText("頭獎" + strings[3]);
                    break;
                case 4:
                    textH3.setText("頭獎" + strings[4]);
                    break;
                case 5:
                    textO1.setText("增開六獎" + strings[5]);
                    break;
                case 6:
                    textO2.setText("增開六獎" + strings[6]);
                    break;
                case 7:
                    textO3.setVisibility(View.VISIBLE);
                    textO3.setText("增開六獎" + strings[7]);
                    break;
                default:
                    break;
            }
        }
        intentTo3.putExtra("P_Number",strings);
    }

    public void BtnBackOnclick(View view) {
        finish();
    }

    public void BtnNextOnclick(View view) {
        String s = editNumber.getText().toString();
        if(s.equals("") || s.length() > 8 || s.length() < 8){
            Toast.makeText(this,"請輸入八位數字,不要空白",Toast.LENGTH_SHORT).show();
        }else {
            intentTo3.putExtra("editNumber",s);
            startActivity(intentTo3);
        }
    }
}
