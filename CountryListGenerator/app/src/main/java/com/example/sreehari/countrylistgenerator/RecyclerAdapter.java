package com.example.sreehari.countrylistgenerator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sreehari on 23/12/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Country> countries;
    private int rowLayout;
    private Context context;


    private ClickListner clickListener;

    public RecyclerAdapter(List<Country> countries, int rowLayout, Context context) {
        this.countries = countries;
        this.rowLayout = rowLayout;
        this.context = context;
        Thread t=Thread.currentThread();
        Log.v("Thread","Thread In "+this.toString()+".public RecyclerAdapter(List<Country> countries, int rowLayout, Context context)"+" with name "+t.getName());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        Thread t=Thread.currentThread();
        Log.v("Thread","Thread In "+this.toString()+".public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position)"+" with name "+t.getName());
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Thread t=Thread.currentThread();
        Log.v("Thread","Thread In "+this.toString()+"public void onBindViewHolder(ViewHolder viewHolder, int position)"+" with name "+t.getName());
        viewHolder.capital.setText(countries.get(position).getCapital());
        viewHolder.country.setText(countries.get(position).getName());
        viewHolder.ItemView.setTag(countries.get(position));

    }

    @Override
    public int getItemCount() {
        Thread t=Thread.currentThread();
        Log.v("Thread","Thread In "+this.toString()+"public int getItemCount()"+" with name "+t.getName());
        return countries == null ? 0 : countries.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView capital;
        public TextView country;
        public View ItemView;
        public ViewHolder(View itemView) {
            super(itemView);
            capital = (TextView) itemView.findViewById(R.id.tv_capital_rc);
            country = (TextView) itemView.findViewById(R.id.tv_country_rc);
            ItemView=itemView;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Thread t=Thread.currentThread();
            Log.v("Thread","Thread In "+this.toString()+" with name "+t.getName());
           Country c= (Country) view.getTag();
            AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
            alertDialog.setTitle("CountryDetails");
            alertDialog.setMessage(c.toStringCustomized());
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }
}
