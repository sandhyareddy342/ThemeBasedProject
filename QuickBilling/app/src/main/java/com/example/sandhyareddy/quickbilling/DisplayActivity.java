package com.example.sandhyareddy.quickbilling;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    DatabaseReference databaseProducts;
    ListView Products;
    List<ScannedDetails> productsList,sortedList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        databaseProducts = FirebaseDatabase.getInstance().getReference("ProductDetails");
        Products = (ListView) findViewById(R.id.Products);
        productsList = new ArrayList<>();
        sortedList = new ArrayList<>();


        databaseProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                productsList.clear();
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    ScannedDetails scannedDetails = itemSnapshot.getValue(ScannedDetails.class);
                    String s = scannedDetails.getId();
                    for (int i = 0; i < LoginActivity.itemslist.length; i++) {
                        if (LoginActivity.itemslist[0].equals(s)) {
                            productsList.add(scannedDetails);
                           // sortedList.add(scannedDetails);
                        }
                    }
                }
                Toast.makeText(DisplayActivity.this,"cost is 40",Toast.LENGTH_LONG).show();
               /*  for(int i=0;i<LoginActivity.itemslist.length;i++){
                    for(int j=0;j<productsList.size();j++){
                        if(LoginActivity.itemslist[i].equals(productsList.get(j).id)){

                            sortedList.add(productsList.get(j));
                        }

                    }
                 }*/
              // ScannedDetails scannedDetails1 = new ScannedDetails("8901030698545","Vim","20");
               //productsList.add(scannedDetails1);
             //  sortedList.remove(scannedDetails1);
                ProductsList adapter = new ProductsList(DisplayActivity.this, productsList);
                Products.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}

   /* protected void onStart(){
        super.onStart();
        }*/


