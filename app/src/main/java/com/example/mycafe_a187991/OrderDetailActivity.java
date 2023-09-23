package com.example.mycafe_a187991;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton imgBtnCall, imgBtnMail, imgBtnWeb, imgBtnMap;
    TextView tvName, tvQuantity;
    String name;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        imgBtnCall = findViewById((R.id.img_btn_call_order_act));
        imgBtnMail = findViewById((R.id.img_btn_mail_order_act));
        imgBtnWeb = findViewById((R.id.img_btn_web_order_act));
        imgBtnMap = findViewById((R.id.img_btn_map_order_act));

        tvName = findViewById(R.id.tv_name_order_act);
        tvQuantity = findViewById(R.id.tv_quantity_order_act);

        Intent intent = getIntent();
        quantity = intent.getIntExtra("quantity", 0);
        name = intent.getStringExtra("name");

        tvName.setText(name);
        tvQuantity.setText("" + quantity);

        imgBtnCall.setOnClickListener(this);
        imgBtnMail.setOnClickListener(this);
        imgBtnWeb.setOnClickListener(this);
        imgBtnMap.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.img_btn_call_order_act:
               //Toast.makeText(OrderDetailActivity.this, "Image Button Call", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: 0123456789"));

           if (callIntent.resolveActivity(getPackageManager())!=null){ //verify that app exist to receive the intent
                startActivity(callIntent);
           }
           else {
               Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data.", Toast.LENGTH_SHORT).show();
            }
                break;

            case R.id.img_btn_mail_order_act:

                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.setType("text/plain");
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "ORDER INFORMATION");
                mailIntent.putExtra(Intent.EXTRA_TEXT, "Dear customer, this is your order information.");
                mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"a187991cafeapp@company.com"});

                if(mailIntent.resolveActivity(getPackageManager()) !=null){
                    startActivity(mailIntent);
                }
                else {
                    Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data.", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.img_btn_web_order_act:
                //Toast.makeText(OrderDetailActivity.this, "Image Button Web", Toast.LENGTH_SHORT).show();
               Uri webpage = Uri.parse("http://www.google.com");
               Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);

               if(webIntent.resolveActivity(getPackageManager()) !=null){
                   startActivity(webIntent);
               }

               else {
                   Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data.", Toast.LENGTH_SHORT).show();
               }

                break;

            case R.id.img_btn_map_order_act:
                //Toast.makeText(OrderDetailActivity.this, "Image Button Web", Toast.LENGTH_SHORT).show();
                Uri gmmIntentUri = Uri.parse("geo:2.9261824,101.6692736");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                if(mapIntent.setPackage("com.google.android.apps.maps") !=null){
                    startActivity(mapIntent);
                }

                else {
                    Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data.", Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }
}