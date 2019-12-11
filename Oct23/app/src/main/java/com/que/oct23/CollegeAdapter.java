package com.que.oct23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CollegeAdapter extends ArrayAdapter<College> {
    Context mContext;
    int mResource;
    public CollegeAdapter(@NonNull Context context, int resource, @NonNull List<College> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int image = getItem(position).getLogo();
        String name = getItem(position).getName();
        String saint = getItem(position).getPatron();
        //College college = new College(image, name);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvSaint = convertView.findViewById(R.id.tvSaint);
        ImageView ivLogo = convertView.findViewById(R.id.ivLogo);
        tvName.setText(name);
        tvSaint.setText(saint);
        ivLogo.setImageResource(image);
        return convertView;
        //return super.getView(position, convertView, parent);
    }
}
