import java.util.Scanner;

public class RandomNumberGuesser {
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		String again = "";
		int nextGuess = 0;
		int highGuess = 100;
		int lowGuess = 0;
		int randNum = RNG.rand();
		
		System.out.println("== Example Run 1 (one iteration) ========");
		
		System.out.println("Enter your first guess");
		
		do {
			
			if(again.contentEquals("yes")) {
				
				again = "";
				System.out.println("Please enter a number between 0 and 100");
				randNum = RNG.rand();
				RNG.resetCount();
			}
			
			nextGuess = scan.nextInt();
			
			if (RNG.inputValidation(nextGuess, lowGuess, highGuess) != true) {
				
				continue;
				
			} else {
			
			System.out.println("Number of guesses is " + RNG.getCount());
			
			if(nextGuess != randNum) {
				
				if (nextGuess < randNum) {
					
					System.out.println("Your guess is too low");
					
					lowGuess = nextGuess;
										
				} else if (nextGuess > randNum) {
					
					System.out.println("Your guess is too high");
					
					highGuess = nextGuess;
				}
				
				System.out.println("Enter you next guess between " + lowGuess + " and " + highGuess);
				
			} else {
				
				System.out.println("Congratulations, you guessed correctly \nTry again? (yes or no)");
				again = input.nextLine();
				
			}
			
			}
			
		} while(again.contentEquals("yes") || nextGuess != randNum);		
		
		System.out.println("Thanks for playing...");
		scan.close();
		input.close();

	}
}
/**
 * @author Omeed Mariani
 */
