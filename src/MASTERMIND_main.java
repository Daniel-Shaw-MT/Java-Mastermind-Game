import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cs1.Keyboard;

public class MASTERMIND_main {
	
	static Scoreboard board = new Scoreboard();
	static GameStateController GSC = new GameStateController();

	private static int tries = 12;
	public int SavedScore;
	
	
	// Colors (For Ref)
	// Red
	// Blue
	// Green
	// Purple
	// Colors (For Ref)
	
	/*
	 * This is my version of Mastermind the board game. I tried to use rules found on wikipedia. This took me 3 hours to
	 * create using java. 
	 * 
	 * Here are the prerequisites:
	 * CS1.java
	 * Programmed by Daniel Shaw @2020
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
	int round = 0;	
	boolean gamerunning = true;
	while(gamerunning==true) {
		round++;
		System.out.println("$$\\      $$\\  $$$$$$\\   $$$$$$\\ $$$$$$$$\\ $$$$$$$$\\ $$$$$$$\\  $$\\      $$\\ $$$$$$\\ $$\\   $$\\ $$$$$$$\\  \r\n" + 
				"$$$\\    $$$ |$$  __$$\\ $$  __$$\\\\__$$  __|$$  _____|$$  __$$\\ $$$\\    $$$ |\\_$$  _|$$$\\  $$ |$$  __$$\\ \r\n" + 
				"$$$$\\  $$$$ |$$ /  $$ |$$ /  \\__|  $$ |   $$ |      $$ |  $$ |$$$$\\  $$$$ |  $$ |  $$$$\\ $$ |$$ |  $$ |\r\n" + 
				"$$\\$$\\$$ $$ |$$$$$$$$ |\\$$$$$$\\    $$ |   $$$$$\\    $$$$$$$  |$$\\$$\\$$ $$ |  $$ |  $$ $$\\$$ |$$ |  $$ |\r\n" + 
				"$$ \\$$$  $$ |$$  __$$ | \\____$$\\   $$ |   $$  __|   $$  __$$< $$ \\$$$  $$ |  $$ |  $$ \\$$$$ |$$ |  $$ |\r\n" + 
				"$$ |\\$  /$$ |$$ |  $$ |$$\\   $$ |  $$ |   $$ |      $$ |  $$ |$$ |\\$  /$$ |  $$ |  $$ |\\$$$ |$$ |  $$ |\r\n" + 
				"$$ | \\_/ $$ |$$ |  $$ |\\$$$$$$  |  $$ |   $$$$$$$$\\ $$ |  $$ |$$ | \\_/ $$ |$$$$$$\\ $$ | \\$$ |$$$$$$$  |\r\n" + 
				"\\__|     \\__|\\__|  \\__| \\______/   \\__|   \\________|\\__|  \\__|\\__|     \\__|\\______|\\__|  \\__|\\_______/ \r\n" + 
				"                                                                                                       \r\n" + 
				"                                                                                                       \r\n" + 
				"                                                                                                       ");
		System.out.println("                                                  MAIN MENU:\n"
				+ "                                                  Start(Y)\n"
				+ "                                                  Quit(X)");
		System.out.print("Choice: ");
		char choice = Keyboard.readChar();
		
		switch(choice) {
		
		case 'Y':
		case 'y':
		
		// Display instructions.
		System.out.print("Hello and welcome to ::MASTERMIND:: You have 20 Seconds to read these instructions:\n"
				+ "1) Player 1 who is the Codemaster will be prompted to input 4 colors. format: XXXX\n"
				+ "2) There are 4 colors, Red(R), Blue(B), Green(G), Purple(P)\n"
				+ "3) Here is an example set of colors [R][B][G][P] You do not need to put any brackets\n"
				+ "4) Player 2 who is the Codebreaker will then have to guess what order and what colors player 1 has inputted.\n"
				+ "5) The Codebreaker will have 12 chances to input their guesses.\n");
		
		
		// extend for end version.
		TimeUnit.SECONDS.sleep(1);
		GSC.clear();
		System.out.println("Loading...");
		TimeUnit.SECONDS.sleep(2);
		GSC.clear();
		
		board.display(round);
		System.out.print("Player 1 please input your set of colors.\n"
				+ "Colors(R,G,B,P): ");
		String inputcolors = Keyboard.readString();
		
		if(inputcolors.length() == 4) {	
			
			char[] colorarray = new char[4];
			colorarray = inputcolors.toCharArray();
			
			// Displays the contents of the array to the end user.
			
			System.out.println("Please remember what you inputted:");
			for(char ch : colorarray) {
				System.out.print(ch);		
			}
			
			TimeUnit.SECONDS.sleep(3);
			GSC.clear();
			
			// Allows for switching of controls.
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Please give the controls to player 2");
			TimeUnit.SECONDS.sleep(5);
			GSC.clear();
			
			// Start of Codebreaker.
			board.display(round);
			System.out.println("Hello Player 2. You will now attempt to break the code that Player 1 has set.\n"
					+ "You will now be able to input your own guesses");
			boolean gamestate = true;
			int counter = 0;
			
			while(gamestate==true) {
				counter++;
				System.out.print("Input colors(R,G,B,P): ");
				String codebreakcolors = Keyboard.readString();
				char[] codebreakcolorsarray = new char[4];
				
				
				
				// Ends game if out of tries.
				if(counter>=tries) {
					gamestate=false;
					GSC.gameover();
					board.update(1, 0);
					board.display(round);
					System.out.print("Thank you for playing MASTERMIND would you like to:\n"
							+ "			Replay? (R)\n"
							+ "			Quit? (X)\n"
							+ "Choice: ");
					char restartcheck = Keyboard.readChar();
					
					switch(restartcheck) {
					
					// If user decided to keep on playing.
					case 'R':
						gamestate = false;
						GSC.clear();
						break;
					// If user decided to stop playing.
					case'X':
						System.exit(0);
						break;
					
					}	
				}
				
				if(codebreakcolors.length() == 4) {	
					codebreakcolorsarray = codebreakcolors.toCharArray();
					
					// Deeply checks the arrays for certain similarities.
					for(int y=0; y < 4; y++) {
						if(codebreakcolorsarray[y] == colorarray[y]) {
							
							// Gives the user a number besides 0. 
							int printpos = y+1;
							System.out.println(colorarray[y]+" at position "+printpos+" is correct");
						}

					}
					// Checks for exact chars.
					boolean same = Arrays.equals(colorarray, codebreakcolorsarray);
					
					
					
					// If player guesses the code game ends.
					if(same == true) {
						GSC.winstate();
						board.update(0, 1);
						board.display(round);
						System.out.print("Thank you for playing MASTERMIND would you like to:\n"
								+ "			Replay? (R)\n"
								+ "			Quit? (X)\n"
								+ "Choice: ");
						char restartcheck = Keyboard.readChar();
						
						switch(restartcheck) {
						
						// If user decided to keep on playing.
						case 'R':
						case 'r':
							gamestate = false;
							GSC.clear();
							break;
						// If user decided to stop playing.
						case 'X':
						case 'x':
							System.exit(0);
							break;
						
						}	
					}
					// Error checking.
				}else {
					counter--;
					System.out.println("Please input ONLY four colors.");
				}
				// Returns to looping.
			}
			
		}else {
			System.out.print("Game and input a set of ONLY four colors.");
			
			
		}break;
		case 'X':
		case 'x':
			System.exit(0);
			break;
		}
		
	}	
}
	
}

	

