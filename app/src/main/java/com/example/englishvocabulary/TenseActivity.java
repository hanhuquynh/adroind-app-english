package com.example.englishvocabulary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.englishvocabulary.adapters.TenseAdapter;
import com.example.englishvocabulary.domains.Tense;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class TenseActivity extends AppCompatActivity {
    RecyclerView rcListTense;
    ArrayList<Tense> tenses =new ArrayList<>();
    TenseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tense);
        new TenseActivity.LoadTenseAsyncTask("http://192.168.52.103/android/getTense.php").execute();
        rcListTense = findViewById(R.id.rcTense);

        adapter = new TenseAdapter(TenseActivity.this, tenses);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TenseActivity.this, LinearLayoutManager.VERTICAL,false);
        rcListTense.setLayoutManager(linearLayoutManager);
        rcListTense.setAdapter(adapter);
    }

    public class LoadTenseAsyncTask extends AsyncTask<Void, Long, String> {
        String url;

        public LoadTenseAsyncTask(String url) {
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
                    String tenThi = jsonObject.getString("tenThi");
                    String congThuc = jsonObject.getString("congThuc");
                    String cachSuDung = jsonObject.getString("cachSuDung");
                    String dauHieu = jsonObject.getString("dauHieu");
                    String viDu = jsonObject.getString("viDu");
                    String id = jsonObject.getString("id");
                    Tense tense = new Tense(id, tenThi, congThuc, cachSuDung, dauHieu, viDu);
                    tenses.add(tense);
                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}