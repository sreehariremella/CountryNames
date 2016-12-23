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
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pDialog;
    String url="https://restcountries.eu/rest/v1/all";
    List<Country> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ((Button)findViewById(R.id.bt_generate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list==null){
                    new GetCountries().execute();
                }
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
                   /* JSONArray countries = new JSONArray(jsonStr);
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
                    }*/
                    Gson gson = new Gson();
                    Type listOfCountryObject = new TypeToken<List<Country>>(){}.getType();
                    list = gson.fromJson(jsonStr, listOfCountryObject);
                    if(list != null) {
                        Log.d("TAG", "" + list.size());
                    }

                } catch ( Exception e) {
                    Log.d("TAG", "" + e.toString());
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
            ((ListView)findViewById(R.id.lv)).setAdapter(new CustomAdapter(MainActivity.this,list));
        }

    }
}
