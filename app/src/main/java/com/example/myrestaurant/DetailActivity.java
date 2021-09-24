package com.example.myrestaurant;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.parceler.Parcels;

import java.util.ArrayList;

public class DetailActivity extends Activity {

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

    //xml
    ImageView Food_Display;
    TextView title_textView;
    TextView detailDescription_textView;
    TextView price_textView;
    EditText editQuantity_TextBox;
    Button add_button;

    //t
    String meal = "";
    double price = 0.0;

    ArrayList<FoodItem> cartList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Parcelable parcelable1 = getIntent().getParcelableExtra("DATA_KEY");
        cartList = Parcels.unwrap(parcelable1);

        Food_Display = findViewById(R.id.Food_Display);
        title_textView = findViewById(R.id.title_textView);
        detailDescription_textView = findViewById(R.id.detailDescription_textView);
        price_textView = findViewById(R.id.price_textView);
        add_button = findViewById(R.id.add_button);
        editQuantity_TextBox = findViewById(R.id.editQuantity_TextBox);

        //Shared preference
        sf = getSharedPreferences(file_name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sf.edit();
        final String save = sf.getString(preference1, "A");
        final String item = sf.getString(preference2, "B");


        //test
//        Toast.makeText(DetailActivity.this, title_textView.getText().toString(), Toast.LENGTH_LONG).show();


        if (save.equals("appetizers")) {
            if (item.equals("0")) {
                Food_Display.setImageResource(R.drawable.appetizers_cauliflower);
                title_textView.setText("Roasted Cauliflowers");
                detailDescription_textView.setText("Served with soy sauce, ginger and sriracha.");
                price_textView.setText("7.99");
                meal = "Roasted Cauliflowers";
                price = 7.99;
            }
            if (item.equals("1")) {
                Food_Display.setImageResource(R.drawable.appetizers_focaccia);
                title_textView.setText("Terrine, Focaccia and Marinated Olives");
                detailDescription_textView.setText("Oats, lentils, rosemary, white wine and spices.");
                price_textView.setText("7.99");
                meal = "Terrine, Focaccia and Marinated Olives";
                price = 7.99;
            }
            if (item.equals("2")) {
                Food_Display.setImageResource(R.drawable.appetizers_fries);
                title_textView.setText("Chickpea Fries");
                detailDescription_textView.setText("Served with homemade BBQ sauce.");
                price_textView.setText("7.99");
                meal = "Chickpea Fries";
                price = 7.99;
            }
            if (item.equals("3")) {
                Food_Display.setImageResource(R.drawable.appetizers_poutine);
                title_textView.setText("Poutine");
                detailDescription_textView.setText("Homemade fries with black bean, mushroom and herbs gravy; topped with green onions.");
                price_textView.setText("7.99");
                meal = "Poutine";
                price = 7.99;
            }
            if (item.equals("4")) {
                Food_Display.setImageResource(R.drawable.appetizers_nachos);
                title_textView.setText("Nachos");
                detailDescription_textView.setText("Corn chips, black beans, salsa, bell peppers, tomatoes and green onions.");
                price_textView.setText("9.99");
                meal = "Nachos";
                price = 9.99;
            }
        }
        if (save.equals("burgers")) {
            if (item.equals("0")) {
                Food_Display.setImageResource(R.drawable.burgers_hemp);
                title_textView.setText("Hemp Burger");
                detailDescription_textView.setText("Brown lentil and hemp patty with BBQ sauce, caramelized onions, tomatoes and marinated cucumbers.");
                price_textView.setText("14.99");
                meal = "Hemp Burger";
                price = 14.99;
            }
            if (item.equals("1")) {
                Food_Display.setImageResource(R.drawable.burger_cajun);
                title_textView.setText("Cajun Burger");
                detailDescription_textView.setText("Sweet potato fritter, sauteed onions, bell peppers and garlic, arugula, sweet relish and breaded onion ring.");
                price_textView.setText("14.99");
                meal = "Cajun Burger";
                price = 14.99;
            }
            if (item.equals("2")) {
                Food_Display.setImageResource(R.drawable.burgers_poutine);
                title_textView.setText("Upgrade your fries!");
                detailDescription_textView.setText("Upgrade your fries into a poutine!");
                price_textView.setText("3.99");
                meal = "Upgrade your fries!";
                price = 3.99;
            }
        }
        if (save.equals("salads")) {
            if (item.equals("0")) {
                Food_Display.setImageResource(R.drawable.salade_rosa);
                title_textView.setText("Rosa");
                detailDescription_textView.setText("Lettuce, chickpeas marinated with grilled cumin and lemon confit, tomatoes, carrots, olives, cucumber, banana peppers and maple-balsamic vinaigrette.");
                price_textView.setText("12.99");
                meal = "Rosa";
                price = 12.99;
            }
            if (item.equals("1")) {
                Food_Display.setImageResource(R.drawable.salads_caesar);
                title_textView.setText("Caesar");
                detailDescription_textView.setText("Romaine lettuce, nutty Parmesan, rice bacon, capers, green onions, balsamic reduction, croutons.");
                price_textView.setText("12.99");
                meal = "Ceasar";
                price = 12.99;
            }
        }
        if (save.equals("mains")) {
            if (item.equals("0")) {
                Food_Display.setImageResource(R.drawable.mains_quesadillas);
                title_textView.setText("Roasted Vegetable Quesadilla");
                detailDescription_textView.setText("Roasted vegetables, black beans, spinach; served with guacamole and homemade vegan sour cream. ");
                price_textView.setText("11.99");
                meal = "Roasted Vegetable Quesadilla";
                price = 11.99;
            }
            if (item.equals("1")) {
                Food_Display.setImageResource(R.drawable.mains_burrito);
                title_textView.setText("Black Bean and Sweet Potato Burrito");
                detailDescription_textView.setText("Whole wheat tortilla, corn, grilled bell pepper, tomato salsa, onions and coriander crema; served with basmati rice and a small salad");
                price_textView.setText("14.99");
                meal = "Black Bean and Sweet Potato Burrito";
                price = 14.99;
            }
            if (item.equals("2")) {
                Food_Display.setImageResource(R.drawable.main_stew);
                title_textView.setText("Tunisian Stew, Roasted Almonds and Dill Cucumbers ");
                detailDescription_textView.setText("Cabbage, tomatoes, chickpeas, bell peppers, turmeric and cinnamon; served on basmati rice. ");
                price_textView.setText("12.99");
                meal = "Tunisian Stew, Roasted Almonds and Dill Cucumbers ";
                price = 12.99;
            }
            if (item.equals("3")) {
                Food_Display.setImageResource(R.drawable.mains_tofu);
                title_textView.setText("Braised Tofu and Sauteed Vegetables");
                detailDescription_textView.setText("Tofu braised in a maple and soy sauce, marinated with lime, coriander and ginger; served with basmati rice and sautéed onions, bell peppers and bok choy");
                price_textView.setText("15.99");
                meal = "Braised Tofu and Sauteed Vegetables";
                price = 15.99;
            }
            if (item.equals("4")) {
                Food_Display.setImageResource(R.drawable.mains_curry);
                title_textView.setText("House Curry with Flatbread and Chutney");
                detailDescription_textView.setText("Sweet potato, bell peppers, carrots, beans, tofu, coconut milk and homemade curry paste.");
                price_textView.setText("16.99");
                meal = "House Curry with Flatbread and Chutney";
                price = 16.99;
            }
            if (item.equals("5")) {
                Food_Display.setImageResource(R.drawable.salads_caesar);
                title_textView.setText("Read Bean Chipotle Chili");
                detailDescription_textView.setText("Crumbled seitan, tomatoes, onions and bell peppers; served on basmati rice with corn chips, green onions and garlic sautéed corn.");
                price_textView.setText("13.99");
                meal = "Read Bean Chipotle Chili";
                price = 13.99;
            }
        }
        if (save.equals("desserts")) {
            if (item.equals("0")) {
                Food_Display.setImageResource(R.drawable.desserts_pudding);
                title_textView.setText("Caramel Pudding and Ice Cream");
                detailDescription_textView.setText("One of our most delicious desserts!");
                price_textView.setText("7.99");
                meal = "Caramel Pudding and Ice Cream";
                price = 7.99;
            }
            if (item.equals("1")) {
                Food_Display.setImageResource(R.drawable.desserts_pie);
                title_textView.setText("Chocolate Caramel Pie");
                detailDescription_textView.setText("Salted caramel, chocolate ganache, cognac, pecans and puffed rice. ");
                price_textView.setText("6.99");
                meal = "Chocolate Caramel Pie";
                price = 6.99;
            }
        }

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SaveFoodOrder();

            }
        });
    }

    private void SaveFoodOrder() {
        sf = getSharedPreferences(file_name, MODE_PRIVATE);
        SharedPreferences.Editor edit = sf.edit();

        if (Integer.parseInt(sf.getString(pref_id, "1")) == 1) {
            cartList.remove(0);
        }

        if (!(editQuantity_TextBox.getText().toString().equals(""))) {
            int quantityOrdered = Integer.parseInt(editQuantity_TextBox.getText().toString());
            double total = price * quantityOrdered;


            String q = quantityOrdered + "";
            String p = price + "";
            String t = total + "";
            //deactivated for testing, need to put it back on
//        Toast.makeText(DetailActivity.this, "Added to your cart.", Toast.LENGTH_LONG).show();
            calculateNewTotal(total);
            mergeQuantity(meal, q, p, t);
            goToFoodListActivity();
        }
    }

    private void goToFoodListActivity() {
        //nouvelle version

        Parcelable parcelable2 = Parcels.wrap(cartList);
        Intent intent = new Intent(DetailActivity.this, FoodListActivity.class);
        intent.putExtra("DATA_KEY", parcelable2);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Parcelable parcelable = Parcels.wrap(cartList);
        Intent intent = new Intent(DetailActivity.this, FoodListActivity.class);
        intent.putExtra("DATA_KEY", parcelable);
        startActivity(intent);

    }

    private void calculateNewTotal(double incomingNewOrderTotal) {
        sf = getSharedPreferences(file_name, MODE_PRIVATE);
        SharedPreferences.Editor edit = sf.edit();

        double oldTotal = Double.parseDouble(sf.getString(pref_total, "0"));
        double newTotal = oldTotal + incomingNewOrderTotal;
        edit.putString(pref_total, newTotal + "");
        edit.commit();
    }

    private void mergeQuantity(String meal_s, String quantity_s, String price_s, String total_s) {
        //Shared Preference
        sf = getSharedPreferences(file_name, MODE_PRIVATE);
        SharedPreferences.Editor edit = sf.edit();
        //sharedPref if for tracking the amount of order
        int id = Integer.parseInt(sf.getString(pref_id, "1"));
        boolean repetition = false;

        if (id > 1) {
            for (int i = 0; i < cartList.size(); i++) {
                if (meal_s.equals(cartList.get(i).getName())) {
                    int oldQuantity = Integer.parseInt(cartList.get(i).getQuantity());
                    int newQuantity = Integer.parseInt(quantity_s);

                    double oldTotal = Double.parseDouble(cartList.get(i).getTotal());
                    double newTotal = Double.parseDouble(total_s);

                    cartList.get(i).setQuantity((newQuantity + oldQuantity) + "");
                    cartList.get(i).setTotal((newTotal + oldTotal) + "");
                    repetition = true;
                }
            }
        }
        if (!repetition) {
            FoodItem lastOrder = new FoodItem(meal_s, quantity_s, price_s, total_s);

            cartList.add(lastOrder);
        }

        //sharedPref if for tracking the amount of order (suite)
        int i = id + 1;
        edit.putString(pref_id, i + "");
        edit.commit();
    }
}
