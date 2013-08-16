import javax.swing.JOptionPane;

public class HotelBilling {

	final static float SALES_TAX =0.13F;
	
	public static void main(String[] args) {
		//Declare variables
		double roomRate = 69;
		double coupon = 0.1;
		int quantity = 2;
		double totalBill = calculateBill(roomRate, coupon, quantity);
		
		//Call each instance for calculateBill
		totalBill = calculateBill(roomRate);
		JOptionPane.showMessageDialog (null, "Your total with tax is $ " + totalBill);
		totalBill = calculateBill(roomRate, quantity);
		JOptionPane.showMessageDialog (null, "Your total with tax for" + quantity + " rooms is $ " + totalBill);
		totalBill = calculateBill(roomRate, coupon, quantity);
		JOptionPane.showMessageDialog (null, "Your total with tax for " + quantity + " rooms is $"  + totalBill
				+ ".\n This includes a coupon discount of " + coupon * 100 + " percent");
	}
		//calculate for one room
		public static double calculateBill(double rate)	{
		double tax = rate * SALES_TAX;
		double finalRate = rate + tax;
		finalRate = twoDecimalRounding(finalRate);
		return finalRate;
		}
		
		//calculate for two rooms
		public static double calculateBill(double rate, int quantity )	{
		double tax = rate * SALES_TAX;
		double finalRate = rate + tax;
		finalRate = finalRate * quantity;
		finalRate = twoDecimalRounding(finalRate);
		return finalRate;
	}
	//calculate with tax
	public static double calculateBill(double rate, double coupon, int quantity)	{
		double tax = rate * SALES_TAX;
		double finalRate = rate + tax;
		finalRate = finalRate * (1-coupon) * quantity;
		finalRate = twoDecimalRounding(finalRate);
		return finalRate;
	}
	
	//rounding to two decimal places
	public static double twoDecimalRounding(double decimal)	{
		decimal = decimal*100;
		decimal = decimal + 0.5;
		decimal = (int) decimal;
		decimal = decimal/100;
		return decimal;
	}
}