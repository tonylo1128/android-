package com.example.theshire;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theshire.data.ApiDataModel;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Retrieve the data passed as extras
        Intent intent = getIntent();
        ApiDataModel data = (ApiDataModel) intent.getSerializableExtra("data");
        String title = data.getTitle_en();
        String district = data.getDistrict_en();
        

        // Display the data on the page
        TextView titleTextView = findViewById(R.id.detail_title);
        TextView districtTextView = findViewById(R.id.detail_district);


        titleTextView.setText(title);
        districtTextView.setText(district);
//        otherDataTextView.setText(otherData);

        // Add a click listener to the back button to finish the activity
//        Button backButton = findViewById(R.id.back_button);
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }
}
