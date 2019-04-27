package com.example.sandhyareddy.quickbilling;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.List;


public class ProductsList extends ArrayAdapter<ScannedDetails> {
    private Activity context;
    private List<ScannedDetails> productsList;
    public ProductsList(Activity context,List<ScannedDetails> productsList){
        super(context,R.layout.list_layout ,productsList);
        this.context=context;
        this.productsList=productsList;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        TextView itemid = (TextView) listViewItem.findViewById(R.id.itemid);
        TextView itemname = (TextView) listViewItem.findViewById(R.id.itemname);
        TextView price = (TextView) listViewItem.findViewById(R.id.price);

        ScannedDetails scannedDetails = productsList.get(position);
        //String s = productsList.get(1).id;
        /*for(int i=0;i<LoginActivity.itemslist.length;i++) {
            //for (int j = 0; j < productsList.size(); j++) {
                if (productsList.contains(LoginActivity.itemslist[i]))
                {*/
                itemid.setText(scannedDetails.getId());
                itemname.setText(scannedDetails.getName());
                price.setText(scannedDetails.getPrice());
            /*}
           // }
        }*/
            return listViewItem;
        }


}
