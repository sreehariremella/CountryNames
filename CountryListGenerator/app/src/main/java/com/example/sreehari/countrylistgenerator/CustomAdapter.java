package com.example.sreehari.countrylistgenerator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sreehari on 22/12/16.
 */

public class CustomAdapter extends BaseAdapter {
    List<Country> countries;
    Activity context;

    private CustomAdapter() {
    }

    public CustomAdapter(Activity context, List<Country> countries) {
        this.context = context;
        this.countries = countries;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("CountryDetails");
                alertDialog.setMessage(countries.get(i).toStringCustomized());
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        };
        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.listlayout, null, true);
        }
        ((TextView) view.findViewById(R.id.tv_capital)).setText(countries.get(i).getCapital());
        ((TextView) view.findViewById(R.id.tv_country)).setText(countries.get(i).getName());
        view.setOnClickListener(listener);
        return view;
    }
}
