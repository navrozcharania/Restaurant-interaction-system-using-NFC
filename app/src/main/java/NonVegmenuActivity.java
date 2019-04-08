package com.example.nfchotel;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class NonvegmenuActivity extends Activity {
	
    ListView msgList;
    ArrayList details;
    AdapterView.AdapterContextMenuInfo info;
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(R.layout.nonveglist);
            
            msgList = (ListView) findViewById(R.id.MessageList);
           
            details = new ArrayList();
                
            MessageDetails Detail;
            Detail = new MessageDetails();
            Detail.setIcon(R.drawable.chickentandoori);
            Detail.setName("Chicken Tandoori");
            Detail.setSub("Rs 200");
            Detail.setDesc("marinated in yogurt, lemon juice, and plenty of spices, then grilled");
            details.add(Detail);
            
            Detail = new MessageDetails();
            Detail.setIcon(R.drawable.crispychickenpng);
            Detail.setName("Chicken Crispy");
            Detail.setSub("Rs 200");
            Detail.setDesc("A whole fryer chicken, marinated and coated in egg, milk and seasoned flour, then fried until extra crispy");
            details.add(Detail);
            
            Detail = new MessageDetails();
            Detail.setIcon(R.drawable.butterchicken);
            Detail.setName("Butter Chicken");
            Detail.setSub("Rs 175");
            Detail.setDesc("Boneless Chicken combined yoghurt, lemon juice, turmeric, garam masala, chilli, cumin, ginger and garlic");
          
            details.add(Detail);        
            Detail = new MessageDetails();
            Detail.setIcon(R.drawable.chickentikkamasala);
            Detail.setName("Chicken Tikka Masala");
            Detail.setSub("Rs 175");
            Detail.setDesc("Boneless Chicken combined yoghurt, lemon juice, turmeric, garam masala, chilli, cumin, ginger and garlic");
          
            details.add(Detail);  
            Detail = new MessageDetails();
            Detail.setIcon(R.drawable.chickenmasala);
            Detail.setName("Chicken Masala");
            Detail.setSub("Rs 150");
            Detail.setDesc("Marinated chicken in coriander pwd, turmeric pwd, ginger garlic paste, 2 slit green chillis and few mint leaves");
          
            details.add(Detail);  
            Detail = new MessageDetails();
            Detail.setIcon(R.drawable.muttonbiryani);
            Detail.setName("Mutton Biryani");
            Detail.setSub("Rs 175");
            Detail.setDesc("Basmati Rice and Meat(goat) cooked with curd, lemon juice, turmeric, garam masala, chilli, cumin, ginger and garlic");
          
            details.add(Detail);  
            Detail = new MessageDetails();
            Detail.setIcon(R.drawable.chickenbiryani);
            Detail.setName("Chicken Biryani");
            Detail.setSub("Rs 175");
            Detail.setDesc("Basmati Rice and boneless Chicken cooked with curd, lemon juice, turmeric, garam masala, chilli, cumin, ginger and garlic");
          
            details.add(Detail);  
            Detail = new MessageDetails();
            Detail.setIcon(R.drawable.fishcurry);
            Detail.setName("          Fish Curry");
            Detail.setSub("Rs 175");
            Detail.setDesc(" fish, sliced coriander leaves, chopped tomatoes, finely chopped cloves garlic");
          
            details.add(Detail);  
            Detail = new MessageDetails();
            Detail.setIcon(R.drawable.fishfry);
            Detail.setName("          Fish Fry");
            Detail.setSub("Rs 175");
            Detail.setDesc("Fish(Promfret) marinated with yoghurt, lemon juice, turmeric, garam masala, chilli, cumin, ginger and garlic");
          
            details.add(Detail);  
            Detail = new MessageDetails();
            Detail.setIcon(R.drawable.prawnsfry);
            Detail.setName("    Prawns Fry");
            Detail.setSub("Rs 175");
            Detail.setDesc("Prawns combined yoghurt, lemon juice, turmeric, chilli, cumin, ginger and garlic");
          details.add(Detail);  
   msgList.setAdapter(new CustomAdapter(details , this));
}}


