
package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class ServerServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
		String token=req.getParameter("token");
		String tableno=req.getParameter("tableno");
		String callforwaiter=req.getParameter("callforwaiter");
		String requestbill=req.getParameter("requestbill");
		String billamnt=req.getParameter("billamnt");
		String phone=req.getParameter("phone");
		String name=req.getParameter("name");
		String order=req.getParameter("order");
		String comment=req.getParameter("comment");
		Date date=new Date();
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SimpleDateFormat f = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		if(token.equalsIgnoreCase("ORDER"))
		{
	Entity cust=new Entity("ORDER",phone);
	cust.setProperty("Date",f.format(date));
	cust.setProperty("tableno",tableno);
	cust.setProperty("order",order);
	cust.setProperty("billamnt",billamnt);
		ds.put(cust);
		}
		if(token.equalsIgnoreCase("CALLFORWAITER"))
		{
	Entity cust1=new Entity("CALL FOR WAITER",phone);
	cust1.setProperty("Date",f.format(date));
	cust1.setProperty("tableno",tableno);
	cust1.setProperty("call for waiter",callforwaiter);
	ds.put(cust1);
		}
		if(token.equalsIgnoreCase("REQUESTFORBILL"))
		{
	Entity cust2=new Entity("REQUEST FOR BILL",phone);
	cust2.setProperty("Date",f.format(date));
	cust2.setProperty("tableno",tableno);
	cust2.setProperty("request for bill",requestbill);
    	ds.put(cust2);
		}
		if(token.equalsIgnoreCase("FEEDBACK"))
		{
	Entity cust3=new Entity("FEEDBACK",phone);
	cust3.setProperty("Date",f.format(date));
    cust3.setProperty("username",name);
	cust3.setProperty("comment",comment);
	ds.put(cust3);
		}
    resp.setContentType("text/plain");
   
        		 }
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
		
	}}