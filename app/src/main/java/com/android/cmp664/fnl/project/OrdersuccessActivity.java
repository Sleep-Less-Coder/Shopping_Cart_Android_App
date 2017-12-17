package com.android.cmp664.fnl.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.android.cmp664.fnl.project.R.id.confirmOrderBtn;
import static com.android.cmp664.fnl.project.R.id.goHomeBtn;

public class OrdersuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordersuccess);

        Button goHomeBtn = (Button) findViewById(R.id.goHomeBtn);

        goHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrdersuccessActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
