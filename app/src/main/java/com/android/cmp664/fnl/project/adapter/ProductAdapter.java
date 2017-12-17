package com.android.cmp664.fnl.project.adapter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cmp664.fnl.project.R;
import com.android.cmp664.fnl.project.constant.Constant;
import com.android.cmp664.fnl.project.model.Product;

public class ProductAdapter extends BaseAdapter {
    private static final String TAG = "ProductAdapter";

    private List<Product> products = new ArrayList<Product>();

    private final Context context;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    public void updateProducts(List<Product> products) {
        this.products.addAll(products);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Product getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tvName;
        TextView tvPrice;
        ImageView ivImage;
        TextView tvDescription;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.adapter_product, parent, false);
            tvName = (TextView) convertView.findViewById(R.id.tvProductName);
            tvPrice = (TextView) convertView.findViewById(R.id.tvProductPrice);
            ivImage = (ImageView) convertView.findViewById(R.id.ivProductImage);
            tvDescription = (TextView) convertView.findViewById(R.id.tvProductDesc);
            convertView.setTag(new ViewHolder(tvName, tvPrice, ivImage, tvDescription));
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            tvName = viewHolder.tvProductName;
            tvPrice = viewHolder.tvProductPrice;
            ivImage = viewHolder.ivProductImage;
            tvDescription = viewHolder.tvProductDesc;
        }

        final Product product = getItem(position);
        tvName.setText(product.getName());
        tvPrice.setText(Constant.CURRENCY+String.valueOf(product.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP)));

        //display trimmed excerpt for description
        int descriptionLength = product.getDescription().length();
        if(descriptionLength >= 100){
            String descriptionTrim = product.getDescription().substring(0, 100) + "...";
            tvDescription.setText(descriptionTrim);
        }else{
            tvDescription.setText(product.getDescription());
        }

        Log.d(TAG, "Context package name: " + context.getPackageName());
        ivImage.setImageResource(context.getResources().getIdentifier(
                product.getImageName(), "drawable", context.getPackageName()));
                return convertView;
    }

    private static class ViewHolder {
        public final TextView tvProductName;
        public final TextView tvProductPrice;
        public final ImageView ivProductImage;
        public final TextView tvProductDesc;
        public ViewHolder(TextView tvProductName, TextView tvProductPrice, ImageView ivProductImage, TextView tvProductDesc) {
            this.tvProductName = tvProductName;
            this.tvProductPrice = tvProductPrice;
            this.ivProductImage = ivProductImage;
            this.tvProductDesc = tvProductDesc;
        }
    }
}
