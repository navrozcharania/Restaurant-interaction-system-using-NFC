package com.example.nfchotel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends Activity {
	 Button b1,b2,b3,b4,b5;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  b1=(Button)findViewById(R.id.button1);
          b2=(Button)findViewById(R.id.button2);
          b3=(Button)findViewById(R.id.button3);
          b4=(Button)findViewById(R.id.button4);
          b5=(Button)findViewById(R.id.button5);
	}
	 public void viewmenu(View v){
     	startActivity(new Intent(this,MainActivity.class));
     }
     public void placeorder(View v){
     	startActivity(new Intent(this,CatalogActivity.class));
     }
     public void callwaiter(View v){
     	startActivity(new Intent(this,CallforwaiterActivity.class));
     }
     public void requestbill(View v){
     	startActivity(new Intent(this,RequestforbillActivity.class));
     }
     public void feedback(View v){
     	startActivity(new Intent(this,CommentActivity.class));
     }
}


