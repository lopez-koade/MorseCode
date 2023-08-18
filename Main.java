package MorseCodePackage;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args) {
		
		menu();
    }
	
	private static void menu() {
		Scanner scanner = new Scanner(System.in);
		printMenuOptions();
		int welcomeMenuChoice = getIntInputMenu(scanner);
		switch(welcomeMenuChoice) {
			case 1:
				askInputMorseToText(); 
				break;
			case 2:
				askInputTextToMorse();
				break;
			case 3:
				exitProgram();
	        default:
	        	invalidOption();
	        	printMenuOptions();
	        	getIntInputMenu(scanner);
	        	break;
		}
	}
	
	private static int getIntInputMenu(Scanner scanner) {
		while(true) {
			try {
				return scanner.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Please select a valid option:");
				System.out.println("");
				printMenuOptions();
				scanner.next();
			}
		}
	}
	
	private static void printMenuOptions() {
		System.out.println("==========");
		System.out.println("Welcome to the Morse code translator program.");
		System.out.println("");
		System.out.println("1. Press if you want to translate Morse Code into text.");
		System.out.println("2. Press if you want to translate text into Morse code.");
		System.out.println("3. Exit.");
	}
	
	private static void exitProgram() {
		System.out.println("");
       	System.out.println("==========");
        System.out.println("We hope to see you back soon.");
        System.out.println("Good bye!.");
        System.exit(0);
	}
	
	private static void invalidOption() {
		System.out.println("");
    	System.out.println("Invalid option, please try again");
		System.out.println("");
	}
	
	private static void askInputMorseToText() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==========");
		System.out.println("");
		System.out.println("Please provide the Morse code to be translated into text:");
		System.out.println("");
		
		String text = sc.nextLine();
		translation(text, true);
		
		sc.close();
	}
	
	private static void askInputTextToMorse() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==========");
		System.out.println("");
		System.out.println("Please provide the text to be translated into Morse code:");
		System.out.println("");
		
		String text = sc.nextLine();
		translation(text, false); 
		sc.close();
	}
	
	private static int getIntInput (Scanner scanner) {
		while(true){
			try {
				return scanner.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Please select a valid option:");
				backToMenuOrExit();
				scanner.nextLine();
			}
		}
	}
	
	private static void backToMenuOrExit() {
		Scanner scan = new Scanner(System.in);
		boolean loop = false;
		while(!loop) {
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("8. Press to go back to the menu");
	        System.out.println("9. Exit the program.");
	        int choiceBackToMenu = getIntInput(scan);
	        if(choiceBackToMenu == 8) {
	        	menu();
	        	
	        } else if (choiceBackToMenu == 9){
	        	exitProgram();
	        } else {
	        	System.out.println("");
	        	System.out.println("Please select a valid option:");
	        }
		}
	}
	
	private static void translation(String text, boolean isMorseToText) {
		final String[][] morse = {
	            {"A", ".-"},
	            {"B", "-..."},
	            {"C", "-.-."},
	            {"D", "-.."},
	            {"E", "."},
	            {"F", "..-."},
	            {"G", "--."},
	            {"H", "...."},
	            {"I", ".."},
	            {"J", ".---"},
	            {"K", "-.-"},
	            {"L", ".-.."},
	            {"M", "--"},
	            {"N", "-."},
	            {"O", "---"},
	            {"P", ".--."},
	            {"Q", "--.-"},
	            {"R", ".-."},
	            {"S", "..."},
	            {"T", "-"},
	            {"U", "..-"},
	            {"V", "...-"},
	            {"W", ".--"},
	            {"X", "-..-"},
	            {"Y", "-.--"},
	            {"Z", "--.."},
	            {"0", "-----"},
	            {"1", ".----"},
	            {"2", "..---"},
	            {"3", "...--"},
	            {"4", "....-"},
	            {"5", "....."},
	            {"6", "-...."},
	            {"7", "--..."},
	            {"8", "---.."},
	            {"9", "----."},
	            };
		
		System.out.println("");
		boolean isCodeTextValid = false;
		//if the user wants to translate Morse code into text this code will be implemented
		if(isMorseToText) {
			String[] splitWords = text.split("/");
			
			for(int x = 0; x < splitWords.length; x++) {
				String word = splitWords[x].trim();
				if(word.isEmpty()) {
					continue;
					
				}
				String[] splitLetters = word.split(" ");
				
				for(int y = 0; y < splitLetters.length; y++) {
						for(int z = 0; z < morse.length; z++) {
							if(morse[z][1].equals(splitLetters[y])) {
								System.out.print(morse[z][0]);
								isCodeTextValid = true;
							} 
						}
						if(isCodeTextValid == false) {
							System.out.println("");
							System.out.println("You didn't insert a valid input, please try again. ");
							System.out.println("");
							askInputMorseToText();
							}	
				}
				System.out.print(" ");
			}
			
		//if the user wants to translate text into Morse code this code will be implemented
		} else {
			String capitalText = text.toUpperCase();
			String[] splitWords = capitalText.split("\\s+");
			
			for(int x = 0; x < splitWords.length; x++) {
				String word = splitWords[x];
				for(int y = 0; y < word.length(); y++) {
					
					for(int z = 0; z < morse.length; z++) {
						
						if(morse[z][0].equals(Character.toString(word.charAt(y)))) {
							System.out.print(morse[z][1]);
							System.out.print(" ");
							isCodeTextValid = true;
						}
					}	
				}
				System.out.print("/ ");
			}
			if(isCodeTextValid == false) {
				System.out.println("");
				System.out.println("You didn't insert a valid input, please try again. ");
				System.out.println("");
				askInputTextToMorse();
				}
		}
		
		
		backToMenuOrExit();
    }
}

