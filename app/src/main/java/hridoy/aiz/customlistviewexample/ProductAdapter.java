package hridoy.aiz.customlistviewexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import hridoy.aiz.customlistviewexample.R;

public class ProductAdapter extends ArrayAdapter<Product> {

    private final Context context;
    private final ArrayList<Product> products;

    public ProductAdapter(@NonNull Context context, ArrayList<Product> products) {
        super(context, R.layout.row_layout, products);
        this.context = context;
        this.products = products;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);

        TextView tvProduct = (TextView) rowView.findViewById(R.id.tvProduct);
        TextView tvPrice = (TextView) rowView.findViewById(R.id.tvPrice);
        TextView tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);

        ImageView ivProduct = (ImageView) rowView.findViewById(R.id.ivProduct);
        ImageView ivSale = (ImageView) rowView.findViewById(R.id.ivSale);

        tvProduct.setText(products.get(position).getTitle());
        tvPrice.setText(String.valueOf(products.get(position).getPrice()));
        tvDescription.setText(products.get(position).getdescription());

        ivSale.setImageResource(R.mipmap.best_price);
        if (products.get(position).isSale()) {
            ivSale.setImageResource(R.mipmap.on_sale);
        }


        if (products.get(position).getType().equals("Laptop")) {
            ivProduct.setImageResource(R.mipmap.laptop);
        } else if (products.get(position).getType().equals("Memory")) {
            ivProduct.setImageResource(R.mipmap.memory);
        } else if (products.get(position).getType().equals("Screen")) {
            ivProduct.setImageResource(R.mipmap.screen);
        } else if (products.get(position).getType().equals("Hard Drive")) {
            ivProduct.setImageResource(R.mipmap.hdd);
        } else {
            ivProduct.setImageResource(R.mipmap.placeholder);
        }

        //return super.getView(position, convertView, parent);
        return rowView;

    }
}
