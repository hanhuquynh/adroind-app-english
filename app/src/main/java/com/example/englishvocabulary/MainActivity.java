package com.example.englishvocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btnVocab;
    private ImageButton btnGrammar;
    private ImageButton btnTense;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnVocab = (ImageButton) findViewById(R.id.btnVocab);
        btnGrammar = (ImageButton) findViewById(R.id.btnGrammar);
        btnTense = (ImageButton) findViewById(R.id.btnTense);

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