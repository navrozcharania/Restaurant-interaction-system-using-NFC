package com.example.nfchotel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class CommentActivity extends Activity {

	EditText comment,name,phone;
	Button b;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comment);
		comment=(EditText)findViewById(R.id.editText1);
		name=(EditText)findViewById(R.id.editText3);
		phone=(EditText)findViewById(R.id.editText2);
		b=(Button)findViewById(R.id.button1);
		
	}
    public void post(View v)
    {
    	String comm=comment.getText().toString();
    	String user=name.getText().toString();
    	String phno=phone.getText().toString();
    	
    	ConnectivityManager connMgr = (ConnectivityManager) 
 		        getSystemService(Context.CONNECTIVITY_SERVICE);
 		    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
 		    if (networkInfo != null && networkInfo.isConnected()){
        new Task().execute(comm,user,phno);
 
        Toast.makeText(getApplicationContext(),"comment registered successfully",Toast.LENGTH_LONG).show();
        comment.setText("");
        name.setText("");
        phone.setText("");
 		    }
 		    else
 		    	 Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
    	
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
			nameValuePairs.add(new BasicNameValuePair("comment",params[0]));  
			nameValuePairs.add(new BasicNameValuePair("name",params[1]));
			nameValuePairs.add(new BasicNameValuePair("phone",params[2]));
			nameValuePairs.add(new BasicNameValuePair("token","FEEDBACK"));
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




