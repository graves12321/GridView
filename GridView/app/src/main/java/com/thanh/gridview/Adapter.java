package com.thanh.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    int layout;
    List<Product> ProductList;

    public Adapter(Context context, int layout, List<Product> ProductList) {
        this.context = context;
        this.layout = layout;
        this.ProductList = ProductList;
    }

    @Override
    public int getCount() {
        return ProductList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);

        ImageView imageView=(ImageView)view.findViewById(R.id.image);
        TextView txtName=(TextView) view.findViewById(R.id.name);
        TextView txtPrice=(TextView)view.findViewById(R.id.price);

        Product product = ProductList.get(i);

        imageView.setImageResource(product.getImage());
        txtName.setText(product.getName());
        txtPrice.setText(product.getPrice());
        return view;
    }
}
