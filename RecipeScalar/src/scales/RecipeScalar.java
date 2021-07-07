/*	Programmer: Russel Love
 * 	Date: 07/07/2021
 * 
 * 	Version: 0.0.2
 * 
 *  Purpose: This is a very simple program.
 *  Its purpose is to resolve the inconvenience of 
 *  getting out a calculator and doing math to make 
 *  a custom sized batch of an already existing recipe.
 *  
 *  Eventually this app will be able to write/read/store 
 *  files on a computer or smartphone. 
 * 
 */

//updated from Dell laptop
package scales;
import java.util.Scanner;
import java.util.ArrayList;

public class RecipeScalar {
	static double recipeMultiplier = 1;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		/* These two lists will storeall the data we need to create a recipe */
		ArrayList<String> ingredients = new ArrayList<String>();
		ArrayList<Integer> weight = new ArrayList<Integer>();

		// ingredient and weight
		String ingredient = "";
		int gram = 0;
		// Scanner object to read input

		// user should be prompted each time they finish adding an ingredient
		// if they say no - addMore will be set to false
		boolean addMore = true;
		while (addMore) {
			// prompt user for ingredient name
			System.out.print("Ingredient name: ");
			ingredient = scan.nextLine();
			ingredients.add(ingredient);

			// prompt user for quantity
			System.out.print("Weight in grams: ");
			gram = scan.nextInt();
			weight.add(gram);

			// prompt user if they want to add more
			System.out.println("Add another ingredient? (y/n)");
			addMore = yesOrNo();
			// scan.nextLine();
		}

		// ask user if they want to scale the recipe
		System.out.println("Would you like to scale this recipe? (y/n)");
		boolean a = yesOrNo();

		// clearing the buffer
		if (a) {
			System.out.println("How many x's would you like to scale the recipes (enter a positive number)");
			recipeMultiplier = scan.nextDouble();
		}

		// print recipe to console
		System.out.println("Generating recipe");
		for (int i = 0; i < weight.size(); i++) {
			String food = ingredients.get(i);
			double q = (weight.get(i) * recipeMultiplier);
			System.out.printf("%-20s %8.1f grams %n", food, q);
		}
		// close scanner
		scan.close();
	}

	public static boolean yesOrNo() {
		String answer = scan.next().toLowerCase();

		// the answer given must equal y or n
		while (!(answer.equals("y") || answer.equals("n"))) {
			System.out.print("Please enter \"y\" or \"n\": ");
			// scan.nextLine();
			answer = scan.next();
		}
		// close scanner and return
		scan.nextLine();
		if (answer.equals("y"))
			return true;
		else
			return false;
	}
	
	public static void writeToFile() {}

}
