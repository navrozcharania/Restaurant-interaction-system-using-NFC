package com.example.nfchotel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ShoppingCartActivity extends Activity {

	private List<Product> mCartList;
	private ProductAdapter mProductAdapter;
	Button b;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shoppingcart);
		b = (Button) findViewById(R.id.Button02);

		mCartList = ShoppingCartHelper.getCartList();

		// Make sure to clear the selections
		for (int i = 0; i < mCartList.size(); i++) {
			mCartList.get(i).selected = false;
		}

		// Create the list
		final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
		mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(),
				true);
		listViewCatalog.setAdapter(mProductAdapter);

	/*	listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

		@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent productDetailsIntent = new Intent(getBaseContext(),
						ProductDetailsActivity.class);
				productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX,
						position);
				startActivity(productDetailsIntent);
			}
		});    */

	}

	@Override
	protected void onResume() {
		super.onResume();

		// Refresh the data
		if (mProductAdapter != null) {
			mProductAdapter.notifyDataSetChanged();
		}
	}




	private String getText(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	public void checkout(View v){
		final Context context = this;
		int subTotal=0;
		for(Product p : mCartList) {
		 int quantity = ShoppingCartHelper.getProductQuantity(p);
		 subTotal += p.price * quantity;
		}

		
	LayoutInflater li = LayoutInflater.from(context);
	View promptsView = li.inflate(R.layout.alertdialog, null);
	 
	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
			context);

	alertDialogBuilder.setView(promptsView);

	final EditText phone = (EditText) promptsView
			.findViewById(R.id.editTextDialogUserInput1);
	final EditText tablenumber = (EditText) promptsView
			.findViewById(R.id.editTextDialogUserInput2);
	
	// set dialog message
	alertDialogBuilder
		.setCancelable(false)
		.setPositiveButton("Confirm",
		  new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog,int id) {
		    	
		    	ConnectivityManager connMgr = (ConnectivityManager) 
		 		        getSystemService(Context.CONNECTIVITY_SERVICE);
		 		    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		    	String[] item;
		    	String order="";
		    	String Order="";
				int[] quantity;
				double total=0;
		    	try {
					item=new String[mCartList.size()];
					quantity=new int[mCartList.size()];
					for (int i = 0; i < mCartList.size(); i++) {
					    Product obj = mCartList.get(i);
					    item[i]=obj.title;
					    quantity[i]=ShoppingCartHelper.getProductQuantity(obj);
					    total= total+(quantity[i]*obj.price);
					   }
					String bill=Double.toString(total);
					String phno=phone.getText().toString();
					String tablenmber=tablenumber.getText().toString();
					for(int j=0;j< mCartList.size();j++){
						order=item[j]+"    "+quantity[j]+"\n";
						Order=Order+order;
					}
					if((phno.length()==10&&tablenmber.length()==1))
					{
						if (networkInfo != null && networkInfo.isConnected()){
							
						
						 new Task().execute(Order,phno,tablenmber,bill);
					        
					        Toast.makeText(getApplicationContext(),"Order registered successfully",Toast.LENGTH_LONG).show();
					}
						else
							 Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
					}
					else{
						Toast.makeText(getApplicationContext(),"Please enter Valid Phone Number and Table Number",Toast.LENGTH_LONG).show();
					   
					}
					
			        
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
		    }
		  })
		.setNegativeButton("Cancel",
		  new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog,int id) {
			dialog.cancel();
		    }
		  });

	// create alert dialog
	AlertDialog alertDialog = alertDialogBuilder.create();

	// show it
	alertDialog.show();

}
	private class Task extends AsyncTask<String,String,String>{
	     
		@Override
		protected String doInBackground(String... params) {
			String result="false";
	    	try {
				HttpClient hc=new DefaultHttpClient();
				ResponseHandler <String> res=new BasicResponseHandler();
				HttpPost postMethod=new HttpPost("http://www.nfc-hotel.appspot.com/server");
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
				nameValuePairs.add(new BasicNameValuePair("order",params[0]));  
				nameValuePairs.add(new BasicNameValuePair("phone",params[1]));
				nameValuePairs.add(new BasicNameValuePair("tableno",params[2]));
				nameValuePairs.add(new BasicNameValuePair("billamnt",params[3]));
				nameValuePairs.add(new BasicNameValuePair("token","ORDER"));
				postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				String response=hc.execute(postMethod,res);
		        
		        
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	    	return result;
		}
		
	}
}

