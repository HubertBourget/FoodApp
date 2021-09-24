package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import org.parceler.Parcels;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton appetizers;
    ImageButton burgers;
    ImageButton salads;
    ImageButton mains;
    ImageButton desserts;

    //shared preferences
    SharedPreferences sf;
    String file_name = "foodPreference";
    String preference1 = "pref1";
    String item = "";
    String pref_id = "id";

    ArrayList<FoodItem> cartList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Shared preference
        sf = getSharedPreferences(file_name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sf.edit();

        int id = Integer.parseInt(sf.getString(pref_id, "1"));
        if (id == 1) {
            String meal_s = " ";
            String quantity_s = " ";
            String price_s = " ";
            String total_s = " ";
            FoodItem noNullPointer = new FoodItem(meal_s, quantity_s, price_s, total_s);
            cartList.add(noNullPointer);
        } else {
            Parcelable parcelable = getIntent().getParcelableExtra("DATA_KEY");
            cartList = Parcels.unwrap(parcelable);
        }

        appetizers = findViewById(R.id.appetizers_menu);
        appetizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item = "appetizers";
                SaveFoodPreference(item);
                openFoodListActivity();

            }

        });
        burgers = findViewById(R.id.burgers_menu);
        burgers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item = "burgers";
                SaveFoodPreference(item);
                openFoodListActivity();

            }
        });
        salads = findViewById(R.id.salads_menu);
        salads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item = "salads";
                SaveFoodPreference(item);
                openFoodListActivity();

            }
        });
        mains = findViewById(R.id.mains_menu);
        mains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item = "mains";
                SaveFoodPreference(item);
                openFoodListActivity();

            }
        });
        desserts = findViewById(R.id.desserts_menu);
        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item = "desserts";
                SaveFoodPreference(item);
                openFoodListActivity();

            }
        });

    }

    private void openFoodListActivity() {

        Parcelable parcelable = Parcels.wrap(cartList);
        Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
        intent.putExtra("DATA_KEY", parcelable);
        startActivity(intent);
    }

    private void SaveFoodPreference(String item) {
        try {
            SharedPreferences sf = getSharedPreferences(file_name, MODE_PRIVATE);
            SharedPreferences.Editor edit = sf.edit();
            String data = item + "";
            edit.putString(preference1, data);
            edit.commit();
        } catch (Exception e) {
            Log.e("settingActivity", e.getMessage());
        }
    }
}

