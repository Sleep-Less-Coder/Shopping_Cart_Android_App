package com.android.cmp664.fnl.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView;
import com.android.cmp664.fnl.project.constant.Constant;
import com.android.cmp664.fnl.project.model.Product;
import com.android.cmp664.fnl.model.Cart;
import com.android.cmp664.fnl.util.CartHelper;

public class ProductActivity extends AppCompatActivity {
    private static final String TAG = "ProductActivity";

    TextView tvProductName;
    TextView tvProductDesc;
    ImageView ivProductImage;
    Spinner spQuantity;
    Button bOrder;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product);

        Bundle data = getIntent().getExtras();
        product = (Product) data.getSerializable("product");

        Log.d(TAG, "Product hashCode: " + product.hashCode());

        //Set Shopping Cart link
        setShoppingCartLink();

        //Retrieve views
        retrieveViews();

        //Set product properties
        setProductProperties();

        //Initialize quantity
        initializeQuantity();

        //On ordering of product
        onOrderProduct();
    }

    private void setShoppingCartLink() {
        TextView tvViewShoppingCart = (TextView)findViewById(R.id.tvViewShoppingCart);
        SpannableString content = new SpannableString(getText(R.string.shopping_cart));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tvViewShoppingCart.setText(content);
        tvViewShoppingCart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void retrieveViews() {
        tvProductName = (TextView) findViewById(R.id.tvProductName);
        tvProductDesc = (TextView) findViewById(R.id.tvProductDesc);
        ivProductImage = (ImageView) findViewById(R.id.ivProductImage);
        spQuantity = (Spinner) findViewById(R.id.spQuantity);
        bOrder = (Button) findViewById(R.id.bOrder);
    }

    private void setProductProperties() {
        tvProductName.setText(product.getName());
        tvProductDesc.setText(product.getDescription());
        ivProductImage.setImageResource(this.getResources().getIdentifier(product.getLargeImageName(), "drawable", this.getPackageName()));
    }

    private void initializeQuantity() {
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, Constant.QUANTITY_LIST);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQuantity.setAdapter(dataAdapter);
    }

    private void onOrderProduct() {
        bOrder.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Cart cart = CartHelper.getCart();
                Log.d(TAG, "Adding product: " + product.getName());
                cart.add(product, Integer.valueOf(spQuantity.getSelectedItem().toString()));
                Intent intent = new Intent(ProductActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
    }
}
