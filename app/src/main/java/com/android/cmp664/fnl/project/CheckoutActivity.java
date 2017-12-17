package com.android.cmp664.fnl.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.android.cmp664.fnl.project.R.id.bShop;
import static com.android.cmp664.fnl.project.R.id.confirmOrderBtn;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Button confirmOrderBtn = (Button) findViewById(R.id.confirmOrderBtn);

        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, OrdersuccessActivity.class);
                startActivity(intent);
            }
        });
    }
}
