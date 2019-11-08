package com.example.appclass_hw10_invoice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView textPrize;
    TextView textFace;
    Button btnBack;
    Button btnMonth;
    Intent intent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textPrize = findViewById(R.id.TextPrize);
        textFace = findViewById(R.id.TextFace);
        btnBack = findViewById(R.id.BtnBack2);
        btnMonth = findViewById(R.id.BtnMonth);
        textPrize.setText("");
        intent3 = getIntent();
        String[] pNumber = intent3.getStringArrayExtra("P_Number");
        String editNubmer = intent3.getStringExtra("editNumber");
        textPrize.setText("");
        textFace.setText(""+editNubmer);


        if (editNubmer.equals(pNumber[0])) {
            textPrize.setText("獎金為：一千萬！");
        } else if (editNubmer.equals(pNumber[1])) {
            textPrize.setText("獎金為：兩百萬！");
        } else {

            for (int j = 2; j <= 4; j++) {
                for (int i = 0; i <= 5; i++) {
                    if (editNubmer.substring(i, 8).equals(pNumber[j].substring(i, 8)) && textPrize.getText().equals("")) {
                        switch (i) {
                            case 0:
                                textPrize.setText("獎金為：二十萬！");
                                break;
                            case 1:
                                textPrize.setText("獎金為：四萬！");
                                break;
                            case 2:
                                textPrize.setText("獎金為：一萬！");
                                break;
                            case 3:
                                textPrize.setText("獎金為：四千！");
                                break;
                            case 4:
                                textPrize.setText("獎金為：一千！");
                                break;
                            case 5:
                                textPrize.setText("獎金為：兩百！");
                                break;
                            default:
                                break;
                        }
                    }
                }
                if (!textPrize.getText().equals("")) {
                    break;
                }
            }

            if (pNumber.length > 5 && textPrize.getText().equals("")) {
                for (int k = 5; k < pNumber.length; k++) {
                    if (editNubmer.substring(5, 8).equals(pNumber[k].substring(0, 3))) {
                        textPrize.setText("獎金為：兩百！");
                        break;
                    }
                }
            }

            if (textPrize.getText().equals("")) {
                textPrize.setText("很可惜 並沒有中獎");
            }
        }


    }

    public void BtnBack2Onclick(View view) {
        finish();
    }

    public void BtnMonthOnclick(View view) {
        Intent intentTo1 = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intentTo1);
    }

}
