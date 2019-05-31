package com.developer.rifky.mabooks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.developer.rifky.mabooks.modeling.ModelUser;

/**
 * Created by Rifky on 28-Dec-17.
 */

public class AdapterUser extends ArrayAdapter<ModelUser> {

    private Context context;
    private int resource;

    public AdapterUser(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Holder holder;
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(resource, null);
            holder = new Holder();
            holder.viewJudul = (TextView) view.findViewById(R.id.vJudul);
            holder.viewPeminjam = (TextView) view.findViewById(R.id.vPeminjam);
            holder.viewNohp = (TextView) view.findViewById(R.id.vNohp);
            holder.viewDipinjam = (TextView) view.findViewById(R.id.vDipinjam);

            view.setTag(holder);
        }
        else {
            holder = (Holder) view.getTag();
        }

        holder.viewJudul.setText(getItem(position).getJudul());
        holder.viewPeminjam.setText(getItem(position).getPeminjam());
        holder.viewNohp.setText(getItem(position).getNohp());
        holder.viewDipinjam.setText(getItem(position).getDipinjam());

        return view;
    }

    class Holder {
        TextView viewJudul, viewPeminjam, viewNohp, viewDipinjam;
    }
}