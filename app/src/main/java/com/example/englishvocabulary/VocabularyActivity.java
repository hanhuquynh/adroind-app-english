package com.example.englishvocabulary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.englishvocabulary.adapters.VocabularyAdapter;
import com.example.englishvocabulary.domains.Vocabulary;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class VocabularyActivity extends AppCompatActivity {
    RecyclerView rcListVocabulary;
    ArrayList<Vocabulary> vocabularies =new ArrayList<>();
    VocabularyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
        new LoadVocabularyAsyncTask("http://192.168.52.104/android/getVocab.php").execute();
        rcListVocabulary = findViewById(R.id.rcVocabulary);

        adapter = new VocabularyAdapter(VocabularyActivity.this, vocabularies);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(VocabularyActivity.this, LinearLayoutManager.VERTICAL,false);
        rcListVocabulary.setLayoutManager(linearLayoutManager);
        rcListVocabulary.setAdapter(adapter);
    }

    public class LoadVocabularyAsyncTask extends AsyncTask<Void, Long, String> {
        String url;

        public LoadVocabularyAsyncTask(String url) {
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
                    String word = jsonObject.getString("word");
                    String type = jsonObject.getString("type");
                    String pronounce = jsonObject.getString("pronounce");
                    String meaning = jsonObject.getString("meaning");
                    String id = jsonObject.getString("id");
                    Vocabulary vocabulary = new Vocabulary(id, word, type, pronounce, meaning);
                    vocabularies.add(vocabulary);
                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}