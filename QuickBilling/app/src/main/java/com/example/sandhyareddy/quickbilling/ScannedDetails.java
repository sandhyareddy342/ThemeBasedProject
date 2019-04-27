package com.example.sandhyareddy.quickbilling;

import java.io.Serializable;
import java.lang.Long;

public class ScannedDetails implements Serializable {
    public String id;
    public String name;
    public String price;

    public ScannedDetails(){

    }
    public ScannedDetails(String id,String name,String price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public String getId(){
        return  id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
