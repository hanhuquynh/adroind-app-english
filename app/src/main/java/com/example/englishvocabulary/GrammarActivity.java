package com.example.englishvocabulary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;


import com.example.englishvocabulary.adapters.GrammarAdapter;
import com.example.englishvocabulary.domains.Grammar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class GrammarActivity extends AppCompatActivity {
    RecyclerView rcListGrammar;
    ArrayList<Grammar> grammars =new ArrayList<>();
    GrammarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);
        new GrammarActivity.LoadGrammarAsyncTask("http://192.168.52.104/android/getGrammar.php").execute();
        rcListGrammar = findViewById(R.id.rcGrammar);

        adapter = new GrammarAdapter(GrammarActivity.this, grammars);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GrammarActivity.this, LinearLayoutManager.VERTICAL,false);
        rcListGrammar.setLayoutManager(linearLayoutManager);
        rcListGrammar.setAdapter(adapter);
    }

    public class LoadGrammarAsyncTask extends AsyncTask<Void, Long, String> {
        String url;

        public LoadGrammarAsyncTask(String url) {
            this.url = url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(this.url);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                String line = null;
                StringBuilder builder = new StringBuilder();
                BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(inputStream));
                while ( (line = inputStreamReader.readLine()) != null) {
                    builder.append(line + "\n");
                }
                return builder.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String structure = jsonObject.getString("structure");
                    String example = jsonObject.getString("example");
                    String id = jsonObject.getString("id");
                    Grammar grammar = new Grammar(id, structure, example);
                    grammars.add(grammar);
                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}