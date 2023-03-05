package com.example.theshire;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.theshire.data.ApiDataModel;
import com.example.theshire.data.RetrofitClient;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.theshire.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    ListView apiListView;
    CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        apiListView = findViewById(R.id.apiListView);

        getRouteData(this);
    }

    private void getRouteData(Context context) {

        Call<List<ApiDataModel>> call = RetrofitClient.getInstance().getMyApi().getRouteData();
        call.enqueue(new Callback<List<ApiDataModel>>() {
            @Override
            public void onResponse(Call<List<ApiDataModel>> call, Response<List<ApiDataModel>> response) {

                List<ApiDataModel> routeDataList = response.body();

                adapter = new CardAdapter(context, R.layout.card, routeDataList);

                if (apiListView != null) {
                    apiListView.setAdapter(adapter);
                } else {
                    Log.e("API_ERROR", "ListView is null");
                }
            }

            @Override
            public void onFailure(Call<List<ApiDataModel>> call, Throwable t) {
                Log.i("ERROR", String.valueOf(t));
                Log.i("ERROR", String.valueOf(call));
                Log.e("API_ERROR", "Failed to get data from API: " + t.getMessage());

                Response<List<ApiDataModel>> response = null;
                try {
                    response = call.execute();
                    Log.e("API_RESP", String.valueOf(response));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}