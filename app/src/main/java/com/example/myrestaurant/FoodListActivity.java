package com.example.myrestaurant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.parceler.Parcels;
import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {


    ListView restaurant_list;

    String[] appetizers_string = {"Crispy Cauliflower", "Terrine, Focaccia and Marinated Olives", "Chickpea Fries", "Poutine", "Nachos"};
    String[] burgers_string = {"Hemp Burger", "Cajun Burger", "Upgrade your fries!"};
    String[] salads_string = {"Rosa", "Caesar"};
    String[] mains_string = {"Roasted Vegetable Quesadilla", "Black Bean and Sweet Potato Burrito", "Tunisian Stew, Roasted Almonds and Dill Cucumbers", "Braised Tofu and Sauteed Vegetables", "House Curry with Flatbread and Pineapple Chutney", "Red Bean Chipotle Chili"};
    String[] sides_string = {"Fries", "Sauteed Vegetables", "Cumin-flavoured Black Beans", "Basmati Rice"};
    String[] desserts_string = {"Caramel Pudding and Homemade Vanilla Ice Cream", "Chocolate Caramel Pie"};

    //shared preferences
    SharedPreferences sf;
    String file_name = "foodPreference";
    String preference1 = "pref1";
    String preference2 = "pref2";
    String item = "";
    String pref_meal = "meal";
    String pref_quantityOrdered = "quantityOrdered";
    String pref_price = "price";
    String pref_total = "total";
    String pref_id = "id";
    String pref_operation_done = "opp";

    Button cart_button;
    Button clear_button;
    TextView Total;

    ArrayList<FoodItem> cartList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);


        //Shared preference
        sf = getSharedPreferences(file_name, MODE_PRIVATE);
        SharedPreferences.Editor edit = sf.edit();

        final String save = sf.getString(preference1, "");


        Parcelable parcelable = getIntent().getParcelableExtra("DATA_KEY");
        cartList = Parcels.unwrap(parcelable);

        Total = (TextView) findViewById(R.id.Total);
        Total.setText("Total : $" + sf.getString(pref_total, "0.00"));

        restaurant_list = (ListView) findViewById(R.id.restaurant_list);

        if (save.equals("appetizers")) {
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.row, appetizers_string);
            restaurant_list.setAdapter(myAdapter);
        }

        if (save.equals("burgers")) {
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.row, burgers_string);
            restaurant_list.setAdapter(myAdapter);
        }

        if (save.equals("salads")) {
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.row, salads_string);
            restaurant_list.setAdapter(myAdapter);
        }

        if (save.equals("mains")) {
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.row, mains_string);
            restaurant_list.setAdapter(myAdapter);
        }
        if (save.equals("sides")) {
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.row, sides_string);
            restaurant_list.setAdapter(myAdapter);
        }
        if (save.equals("desserts")) {
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.row, desserts_string);
            restaurant_list.setAdapter(myAdapter);
        }

        restaurant_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = position + "";
                SaveFoodPreference(item);
                openDetailActivity();

//                Toast.makeText(FoodListActivity.this, item +"",Toast.LENGTH_LONG).show();
            }
        });

//        try {
//            Toast.makeText(FoodListActivity.this, save, Toast.LENGTH_LONG).show();
//        }catch(Exception e){
//            Log.d("SettingActivity", e.getMessage());
//        }

        cart_button = findViewById(R.id.cart_button);
        cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Parcelable parcelable = Parcels.wrap(cartList);
                Intent intent = new Intent(FoodListActivity.this, CartActivity.class);
                intent.putExtra("DATA_KEY", parcelable);
                startActivity(intent);

            }
        });

    }

    private void openDetailActivity() {
        Parcelable parcelable = Parcels.wrap(cartList);
        Intent intent = new Intent(FoodListActivity.this, DetailActivity.class);
        intent.putExtra("DATA_KEY", parcelable);
        startActivity(intent);
    }

    private void SaveFoodPreference(String item) {
        try {
            sf = getSharedPreferences(file_name, MODE_PRIVATE);
            SharedPreferences.Editor edit = sf.edit();
            String data = item + "";
            edit.putString(preference2, data);
            edit.commit();
        } catch (Exception e) {
            Log.e("settingActivity", e.getMessage());
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Parcelable parcelable = Parcels.wrap(cartList);
        Intent intent = new Intent(FoodListActivity.this, MainActivity.class);
        intent.putExtra("DATA_KEY", parcelable);
        startActivity(intent);

    }

}
