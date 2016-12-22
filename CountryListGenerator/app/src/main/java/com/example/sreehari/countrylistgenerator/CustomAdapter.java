package com.example.sreehari.countrylistgenerator;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sreehari on 22/12/16.
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList<Country> countries=new ArrayList<>();
    Activity context;
    private CustomAdapter(){}
    public CustomAdapter(Activity context,ArrayList<Country> countries){
        this.context=context;
        this.countries=countries;
    }
    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int i) {
        return countries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.listlayout, null, true);
        }
        ((TextView)view.findViewById(R.id.tv_capital)).setText(countries.get(i).getCapital());
        ((TextView)view.findViewById(R.id.tv_country)).setText(countries.get(i).getCountryName());
        return  view;
    }
}
