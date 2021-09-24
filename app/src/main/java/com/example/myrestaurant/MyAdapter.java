package com.example.myrestaurant;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<FoodItem> data;
    Context m_context;

    public MyAdapter(ArrayList<FoodItem> data, Context context) {
        this.data = data;
        m_context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.indexOf(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(m_context, R.layout.adapter_view_layout, null);

        TextView tvMealName = v.findViewById(R.id.textView1);
        TextView tvQuantity = v.findViewById(R.id.textView2);
        TextView tvPrice = v.findViewById(R.id.textView3);
        TextView tvTotal = v.findViewById(R.id.textView4);

        tvMealName.setText(data.get(position).getName());
        tvQuantity.setText(data.get(position).getQuantity());
        tvPrice.setText(data.get(position).getPrice());
        tvTotal.setText(data.get(position).getTotal());
        return v;
    }
}
