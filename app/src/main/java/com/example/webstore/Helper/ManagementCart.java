package com.example.webstore.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.webstore.Domain.ProductDomain;
import com.example.webstore.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(ProductDomain item){
        ArrayList<ProductDomain> productList=getListCart();
        boolean existAlready = false;
        int n=0;
        for (int i = 0; i<productList.size();i++){
            if (productList.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }
        if (existAlready){
            productList.get(n).setNumberInCart(item.getNumberInCart());
        }
        else{
            productList.add(item);
        }
        tinyDB.putListObject("CardList",productList);
        Toast.makeText(context, "Produkt został dodany do koszyka.", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ProductDomain> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberFood(ArrayList<ProductDomain> productList, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if(productList.get(position).getNumberInCart()==1){
            productList.remove(position);
        }
        else{
            productList.get(position).setNumberInCart(productList.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CardList",productList);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<ProductDomain> productList, int position, ChangeNumberItemsListener changeNumberItemsListener){
        productList.get(position).setNumberInCart(productList.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CardList",productList);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<ProductDomain> productList2=getListCart();
        double fee = 0;
        for(int i = 0;i<productList2.size(); i++){
            fee=fee+(productList2.get(i).getFee()*productList2.get(i).getNumberInCart());
        }
        return fee;
    }
}
