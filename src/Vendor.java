/**
 * This class implements a vendor that sells one kind
 * of items. A vendor carries out sales transactions.
 */

/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own.  Signed:  Aman Haileyesus
 * @author haileyesusa
 * Date of Completion:  11/4/2022
 * Assignment:  Case Study Ch10:  SnackBar and Vendor.java
 * 
 * Attribution:  Tommy Latham
 * 
 * General Description:   Implements a vendor that sells one kind
 *						  of items. A vendor carries out sales transactions.
 * 
 * 
 * Advanced:  
 * 				
 * Errata: 
 *
 */
public class Vendor
{
	//CLASS VARIABLES AND METHODS (STATIC)
	private static double totalSales = 0.0; //total sales of all vendors in dollars

	public static double getTotalSales()
	{
		double temp = totalSales;
		totalSales = 0;
		return temp;
	}



	// Instance Variables or Fields:
	private int price; //price for a single item in the machine
	private int stock; //total stock left in machine
	private int deposit; //money put in for one transaction
	private int change; //money to return after transaction

	/**
	 * Constructs a Vendor
	 * @param price the price of a single item in cents (int)
	 * @param stock number of items to place in stock (int)
	 */
	public Vendor (int price, int stock) 
	{
		this.price = price;
		this.stock = stock;
		deposit = 0;
		change = 0;
	}

	/**
	 * Sets the quantity of items in stock.
	 * @param qty number of items to place in stock (int)
	 */
	public void setStock(int qty)
	{
		stock = qty;
	}

	/**
	 * Returns the number of items currently in stock.
	 * @return number of items currently in stock (int)
	 */
	public int getStock() 
	{
		return stock;
	}

	/**
	 * Adds a specified amount (in cents) to the
	 * deposited amount.
	 * @param number of cents to add to the deposit (int)
	 */
	public void addMoney (int cents)
	{
		deposit+=cents;
	}

	/**
	 * Returns the currently deposited amount (in cents).
	 * @return number of cents in the current deposit (int)
	 */
	public int getDeposit()
	{
		return deposit;
	}

	/**
	 * Implements a sale.  If there are items in stock and
	 * the deposited amount is greater than or equal to
	 * the single item price, then adjusts the stock and
	 * calculates and sets change, sets deposit to 0 and
	 * returns true; otherwise refunds the whole deposit
	 * (moves it into change) and returns false.
	 * @return true for a successful sale, false otherwise (boolean)
	 */
	public boolean makeSale()
	{


		if (stock > 0 && deposit >= price) { //if there are items in stock and deposit is enough for 1
			stock--;
			change = deposit - price;
			totalSales+=price/100.0;
			deposit = 0;
			return true;
		}
		else {
			change = deposit; //otherwise refund deposit
			deposit = 0;
			return false;
		}
	}

	/**
	 * Returns and zeroes out the amount of change (from
	 * the last sale or refund).
	 * @return number of cents in the current change (int)
	 */
	public int getChange() 
	{
		int tempChange = change; //temp variable to return
		change = 0;
		return tempChange;

	}
}
