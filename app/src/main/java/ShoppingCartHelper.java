package com.example.nfchotel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {
	
	public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
	
	private static List<Product> catalog;
	private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();
	
	public static List<Product> getCatalog(Resources res){
		if(catalog == null) {
			catalog = new Vector<Product>();
			catalog.add(new Product("Chicken Tandoori", res
					.getDrawable(R.drawable.chickentandoori),
					"", 200));
			catalog.add(new Product("Chicken Crispy", res
					.getDrawable(R.drawable.crispychickenpng),
					"", 200));
			catalog.add(new Product("Butter Chicken", res
					.getDrawable(R.drawable.butterchicken),
					"", 175));
			catalog.add(new Product("Chicken Tikka Masala",res
					.getDrawable(R.drawable.chickentikkamasala),
					"", 175));
			catalog.add(new Product("Chicken Masala", res
					.getDrawable(R.drawable.chickenmasala),
					"", 150));
			catalog.add(new Product("Mutton Biryani", res
					.getDrawable(R.drawable.muttonbiryani),
					"", 175));
			catalog.add(new Product("Chicken Biryani", res
					.getDrawable(R.drawable.chickenbiryani),
					"", 175));
			catalog.add(new Product("Fish Curry", res
					.getDrawable(R.drawable.fishcurry),
					"", 175));
			catalog.add(new Product("Fish Fry", res
					.getDrawable(R.drawable.fishfry),
					"", 175));
			catalog.add(new Product("Prawns Fry", res
					.getDrawable(R.drawable.prawnsfry),
					"", 175));
			catalog.add(new Product("Malai Kofta", res
					.getDrawable(R.drawable.malaikofta),
					"",150));
			catalog.add(new Product("Vegetarian Manchurian", res
					.getDrawable(R.drawable.vegmanchurian),
					"", 150));
			catalog.add(new Product("Palak paneer", res
					.getDrawable(R.drawable.palakpaneer),
					"", 125));
			catalog.add(new Product("Rajma", res
					.getDrawable(R.drawable.rajma),
					"", 125));
			catalog.add(new Product("Mutter Paneer", res
					.getDrawable(R.drawable.mutterpaneer),
					"", 100));
			catalog.add(new Product("Kaali Daal", res
					.getDrawable(R.drawable.kaalidaal),
					"", 125));
			catalog.add(new Product("Chole", res
					.getDrawable(R.drawable.chole),
					"", 100));
			catalog.add(new Product("Bhindi Ki Sabzi", res
					.getDrawable(R.drawable.bhindikisabzi),
					"", 75));
			catalog.add(new Product("kabab", res
					.getDrawable(R.drawable.kabab),
					"", 150));
			catalog.add(new Product("Lehsuni Daal", res
					.getDrawable(R.drawable.lehsunidaal),
					"", 175));
			catalog.add(new Product("Machurian Soup", res
					.getDrawable(R.drawable.manchuriansoup),
					"", 125));
			catalog.add(new Product("SweetCorn Soup", res
					.getDrawable(R.drawable.sweetcorn),
					"", 100));
			catalog.add(new Product("Fried Rice", res
					.getDrawable(R.drawable.friedrice),
					"", 125));
			catalog.add(new Product("Schezwan Fried Rice", res
					.getDrawable(R.drawable.schezwanfriedrice),
					"", 150));
			catalog.add(new Product("Triple Schezwan Rice", res
					.getDrawable(R.drawable.triplefriedrice),
					"", 150));
			catalog.add(new Product("Hakka Noodles", res
					.getDrawable(R.drawable.hakkanoodle),
					"", 125));
			catalog.add(new Product("Chapathi", res
					.getDrawable(R.drawable.chapati),
					"", 8));
			catalog.add(new Product("Tandoori Roti", res
					.getDrawable(R.drawable.tandooriroti),
					"", 12));
			catalog.add(new Product("Butter Naan", res
					.getDrawable(R.drawable.butternaan),
					"", 15));
			catalog.add(new Product("Aloo Paratha", res
					.getDrawable(R.drawable.alooparatha),
					"", 20));
			catalog.add(new Product("Paneer Paratha", res
					.getDrawable(R.drawable.paneerparatha),
					"", 20));
			catalog.add(new Product("Poori", res
					.getDrawable(R.drawable.poori),
					"", 5));
			catalog.add(new Product("Bread Pudding", res
					.getDrawable(R.drawable.pudding),
					"", 50));
			catalog.add(new Product("Brownie", res
					.getDrawable(R.drawable.brownie),
					"", 50));
			catalog.add(new Product("Pumpkin Pie", res
					.getDrawable(R.drawable.pumpkinpie),
					"", 75));
			catalog.add(new Product("Tea", res
					.getDrawable(R.drawable.tea),
					"", 20));
			catalog.add(new Product("Coffee", res
					.getDrawable(R.drawable.coffee),
					"",20));
			catalog.add(new Product("Soft Drinks", res
					.getDrawable(R.drawable.softdrinks),
					"",20));
		}
		
		return catalog;
	}
	
	public static void setQuantity(Product product, int quantity) {
		// Get the current cart entry
		ShoppingCartEntry curEntry = cartMap.get(product);
		
		// If the quantity is zero or less, remove the products
		if(quantity <= 0) {
			if(curEntry != null)
				removeProduct(product);
			return;
		}
		
		// If a current cart entry doesn't exist, create one
		if(curEntry == null) {
			curEntry = new ShoppingCartEntry(product, quantity);
			cartMap.put(product, curEntry);
			return;
		}
		
		// Update the quantity
		curEntry.setQuantity(quantity);
	}
	
	public static int getProductQuantity(Product product) {
		// Get the current cart entry
		ShoppingCartEntry curEntry = cartMap.get(product);
		
		if(curEntry != null)
			return curEntry.getQuantity();
		
		return 0;
	}
	
	
	public static void removeProduct(Product product) {
		cartMap.remove(product);
	}
	
	public static List<Product> getCartList() {
		List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
		for(Product p : cartMap.keySet()) {
			cartList.add(p);
		}
		
		return cartList;
	}
	}
