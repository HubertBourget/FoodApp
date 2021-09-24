package com.example.myrestaurant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.parceler.Parcels;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ListView restaurant_list;
    Button clear_button;
    TextView Total;

    SharedPreferences sf;
    String file_name = "foodPreference";
    String pref_total = "total";

    ArrayList<FoodItem> cartList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);

        restaurant_list = findViewById(R.id.restaurant_list);
        Total = findViewById(R.id.Total);

        //Shared preference
        sf = getSharedPreferences(file_name, MODE_PRIVATE);
        SharedPreferences.Editor edit = sf.edit();

        Total.setText("Total : $" + (sf.getString(pref_total, "0.00")));

        Parcelable parcelable = getIntent().getParcelableExtra("DATA_KEY");
        cartList = Parcels.unwrap(parcelable);

        MyAdapter myAdapter = new MyAdapter(cartList, CartActivity.this);
        restaurant_list.setAdapter(myAdapter);


        clear_button = findViewById(R.id.clear_button);
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Shared preference
                sf = getSharedPreferences(file_name, MODE_PRIVATE);
                SharedPreferences.Editor edit = sf.edit();
                sf.edit().clear().commit();

                openMainActivity();
            }
        });
    }

    private void openMainActivity() {
        Intent intent = new Intent(CartActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Parcelable parcelable = Parcels.wrap(cartList);
        Intent intent = new Intent(CartActivity.this, FoodListActivity.class);
        intent.putExtra("DATA_KEY", parcelable);
        startActivity(intent);
    }
}