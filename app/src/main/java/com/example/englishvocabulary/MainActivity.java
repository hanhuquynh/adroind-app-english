package com.example.englishvocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnVocab;
    private Button btnGrammar;
    private Button btnTense;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnVocab = (Button) findViewById(R.id.btnVocab);
        btnGrammar = (Button) findViewById(R.id.btnGrammar);
        btnTense = (Button) findViewById(R.id.btnTense);

        btnVocab.setOnClickListener(this);
        btnGrammar.setOnClickListener(this);
        btnTense.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnVocab:
                Intent intent = new Intent();
                intent.setClass(this, VocabularyActivity.class);
                startActivity(intent);
                break;
            case R.id.btnGrammar:
                Intent intent2 = new Intent();
                intent2.setClass(this, GrammarActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnTense:
                Intent intent3 = new Intent();
                intent3.setClass(this, TenseActivity.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}