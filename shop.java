
import java.util.Scanner;
public class shop {

	static double discount1 = 0;
	static double discount2 = 0; 
	
	
	public static int Setup(Scanner input, String[] names, double[]prices) {
		System.out.print("Please enter the number of items:"); 
		int items = input.nextInt();
		
		
		
		for (int i = 0; i < items; i++){ 
			
			System.out.print("Enter name of product " + i + ":"); 
			names[i] = input.next(); 
			
			System.out.print("Enter price of product " + i + ":");
			prices[i] = input.nextDouble();	
		}
		
		System.out.print("Please enter the amount to qualify for discount:");
		discount1 = input.nextDouble(); 
		
		System.out.print("Please enter the discount rate (0.1 for 10%):");
		discount2 = input.nextDouble();	 
		
		return items;
		
	} 
	public static void Buy(Scanner input, String[] names, double[] prices, int[] amounts, int items) {
	
		for (int i = 0; i < items; i++){
			System.out.print("Enter the amount of " + names[i] + ":");
			amounts[i] = input.nextInt(); 
			
		}
		
	}
	public static void List(String [] names, double[] prices, int[] amounts, int items) {
		
		for(int i = 0; i < items; i++) {
			if (amounts[i] > 0) {
		
			System.out.println(amounts[i] + " count of " + names[i] + " @  $" + prices[i] + " = $" + (amounts[i]*prices[i]));
			/* 3. For each item purchased (non-zero amount)
			a. Display amount purchase and price per item */
	}
		
			}
	
	}
	public static void Checkout(double[] prices, int[] amounts) {
		
		double total = 0;
		
		for(int i = 0; i < amounts.length; i++) {
		total = prices[i]*amounts[i] + total;
		}
		
		double disc = 0;
		disc = (total*(discount2));
		
		if (total >= discount1){
			System.out.println();
			System.out.println("Thanks for coming!");
			System.out.println("Sub Total:" + total);
			System.out.println("-Discount:" + (disc));
			System.out.println("Total    :" + (total - (disc)));
		}
		else if (total < discount1){
			System.out.println();
			System.out.println("Thanks for coming!");
			System.out.println("Sub Total:" + total);
			System.out.println("-Discount:" + "$0.0");
			System.out.println("Total    :" + total);
			
			/* 3. Display the summary
				a. Sub Total 
				b. Discount 
				c. Total */
				
		}

	}
	
	public static void main(String[] args) {
		final int MAX = 100;
		int set = 0;
		int buy = 0;
		int items = 0;
		
		String[] names = new String[MAX];
		double[] prices = new double[MAX];
		int[] amounts = new int[MAX];
		
		do{
			Scanner input = new Scanner(System.in);
			System.out.println("this program supports 4 functions:");
			System.out.println("1. setup Shop");
			System.out.println("2. buy");
			System.out.println("3. list Items");
			System.out.println("4. checkout");
			System.out.print("Please choose the function you want:");
			int func = input.nextInt();
			
		if ( 1 <= func || func >= 4){
		
	
		if (func == 1){
			if (set == 0){
				items = Setup (input, names, prices);
				
				
			}
			
			set = 1;
			
		}
		
		if (func == 2){
			if (set == 1){
				System.out.println();
				Buy(input, names, prices, amounts, items);
				System.out.println();
				
				
			}
			else{ 
				System.out.println();
				System.out.print("shop is not setup yet!"); 
				System.out.println();
				System.out.println();
				
		}
			buy = 1;
			
		}
			
		if (func == 3){
		
			if (buy == 1){
			System.out.println();
			List(names, prices, amounts, items);
			System.out.println();
		}		
		
			if (set == 1 && buy == 0){
			System.out.println();
			System.out.println("try again: You have not bought anything");
			System.out.println(); 
			
			
		}	
			if (set == 0){
			System.out.println();
			System.out.println("shop is not setup yet!");
			System.out.println();
		}
				
		}
		
		
		if (func == 4){
			if (set == 0){
				System.out.println();
				System.out.println("shop is not setup yet!");
				System.out.println(); 
				continue;
		}
			if (buy == 0){
				System.out.println();
				System.out.println("try again: You have not bought anything");
				System.out.println(); 
				continue;
		}
			if (buy == 1){
				Checkout(prices, amounts);
				break;
				
				
		} 	
				
			}
	
		
		else if (func > 4){
			System.out.println();
			System.out.println("error: Do not know " + func);	
			System.out.println();
		}	
		
			}

		
		}
		while(true);
			}
}



