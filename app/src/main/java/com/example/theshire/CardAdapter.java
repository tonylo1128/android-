package com.example.theshire;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.theshire.data.ApiDataModel;

import java.util.List;

public class CardAdapter extends ArrayAdapter<ApiDataModel> {

    private int resourceId;

    public CardAdapter(@NonNull Context context, int resourceId, @NonNull List<ApiDataModel> data){
        super(context, resourceId, data);
        this.resourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        ApiDataModel data = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to detail page and pass data
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("data", data);
                getContext().startActivity(intent);
            }
        });

        TextView title = convertView.findViewById(R.id.card_title);
        TextView district = convertView.findViewById(R.id.card_district);

        title.setText("Title :"+data.getTitle_en());
        district.setText("District :"+data.getDistrict_en());
        return convertView;
    }
}
