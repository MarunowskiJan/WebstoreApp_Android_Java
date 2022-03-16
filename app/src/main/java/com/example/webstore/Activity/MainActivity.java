package com.example.webstore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.webstore.Adapter.CategoryAdapter;
import com.example.webstore.Adapter.RecommendedAdapter;
import com.example.webstore.Domain.CategoryDomain;
import com.example.webstore.Domain.ProductDomain;
import com.example.webstore.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent =  getIntent();
        String message = intent.getStringExtra(IntroActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.userName);
        textView.setText(message);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {

        LinearLayout homeBtn= findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductDomain> foodList = new ArrayList<>();
        foodList.add(new ProductDomain("Xiaomi Gaming Laptop", "xiaomi_gaming_laptop_image", "Xiaomi Mi Gaming Laptop 15.6” Quad-Core i7-8750H GTX1060 16GB 256GB SSD / 1T HDD. Gwarancja 24 miesiące.",4499.0,"zł","Chiny", 4.7, 14));
        foodList.add(new ProductDomain("Iphone 11", "iphone_image", "Producent: Apple, Model: iPhone 11, Procesor: Apple A11 64-bit, Ekran: Super Retina HD 5,8”, OLED, Kamera: iSight 2x 12 Mpix (Szerokokątny + Tele),3 GB pamięci RAM, 64GB pamięci wbudowanej.",1999.0,"zł","Polska", 4.4, 2));
        foodList.add(new ProductDomain("Fotel Diablo", "red_gaming_chair_image", "Specyfikacja: certyfikaty: CE, SGS,kolor: czarno-czerwony, maksymalne obciążenie: 150kg, materiał: metal + pianka EPE + ekoskóra, kółka: silikon, wymiary całkowite (dł/szer/wys): 124/63/63cm, waga: 19,5kg.",899.0,"zł","Niemcy", 3.9, 7));
        foodList.add(new ProductDomain("Etui Iphone 7/8", "etui_iphone_image", "Transparentne etui do Iphone 7/8. Wykonane z tworzywa sztucznego wysokiej jakości. ",25.0,"zł","Czechy", 4.5, 7));
        adapter2 = new RecommendedAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Smartfony", "smartphone_image"));
        categoryList.add(new CategoryDomain("Laptopy", "laptop_image"));
        categoryList.add(new CategoryDomain("Komputery", "pc_image"));
        categoryList.add(new CategoryDomain("Telewizory", "tv_image"));
        categoryList.add(new CategoryDomain("Fotele", "gaming_chair_image"));
        categoryList.add(new CategoryDomain("Akcesoria", "accesories_image"));

        adapter=  new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}