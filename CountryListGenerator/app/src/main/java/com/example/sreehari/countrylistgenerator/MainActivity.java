package com.example.sreehari.countrylistgenerator;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pDialog;
    String url="https://restcountries.eu/rest/v1/all";
    Country country;
    ArrayList<Country> countries=new ArrayList<>();
    ArrayList<String> borders=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.bt_generate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetCountries().execute();
            }
        });
    }
    private class GetCountries extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            if (jsonStr != null) {
                try {
                    JSONArray countries = new JSONArray(jsonStr);
                    for (int i = 0; i < countries.length(); i++) {
                        JSONObject c = countries.getJSONObject(i);
                        String countryname = c.getString("name");
                        String capital = c.getString("capital");
                        JSONArray boundries=c.getJSONArray("borders");
                        for(int j=0;j<boundries.length();j++){
                            borders.add(boundries.getString(j));
                        }
                        country=new Country(countryname,capital,borders);
                        MainActivity.this.countries.add(country);
                        borders.clear();
                    }
//                    Gson gson=new Gson();
//                    Log.d("Tag","Json String :- \n"+jsonStr+"\n");
//                    country=gson.fromJson(jsonStr,Country.class);
                } catch (final JSONException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            ((ListView)findViewById(R.id.lv)).setAdapter(new CustomAdapter(MainActivity.this,countries));
        }

    }
}
