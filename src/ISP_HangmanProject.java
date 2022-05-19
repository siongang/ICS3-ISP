// The "ISP_HangmanProject" class.
/*
Names: Ethan Xu & Sion Gang
Date: Jan 5, 2022
Teacher: Ms. Basaraba
Description: Description: This 900+ line program contains a functional Hangman game. Created by 2 grade 10 students, it features a animated splashscreen, leaderboards, and difficulties. Challenge your word skills
	     with a game of ISC Hangman.
*/
import java.awt.*;
import hsa.*;
import java.io.*;
public class ISP_HangmanProject
{
    private static Console c;            // The output console
    //Instance Variables
    private static char nextCmd; // variable that holds which scene the program is at
    private static int difficulty; // holds game difficulty
    private int currentScore;
    //ColourVariables
    private BufferedReader file;    // initializes Buffered Reader
    private final static Color lightBlue = new Color (164, 194, 244);
    private final static Color pastelBlue = new Color (137, 171, 228);
    private final static Color grayBlue = new Color (130, 160, 211);
    private final static Color cyan = new Color (84, 110, 153);
    private final static Color white = new Color (255, 255, 255);
    // Font Variables
    private Font title = new Font ("Comic Sans MS", Font.PLAIN, 40);
    private Font heading = new Font ("Comic Sans MS", Font.PLAIN, 26);
    private Font text = new Font ("Comic Sans MS", Font.PLAIN, 18);

    // Stick Man Variables
    private int xPos;
    private int yPos;

    public ISP_HangmanProject ()  // constructor
    {
	c = new Console ();
    }


    public void title ()
    {
	c.setColour (lightBlue);
	c.fillRect (0, 0, 640, 500); //Background

	//Display title text
	c.setColour (white);
	c.setFont (heading);
	c.drawString ("Welcome To", 245, 60);
	c.setFont (title);
	c.drawString ("Hangman", 240, 100);
	c.setFont (text);
	c.drawString ("By: Sion Gang & Ethan Xu", 220, 135);

	//Stick Figure
	xPos = 290; //X position of the stick figure
	yPos = 180; //Y position of the stick figure

	c.setColour (cyan);
	for (int i = 0 ; i < 10 ; i++)
	{ //This loop will increase line thickness to 10 pixels
	    c.drawOval (xPos + i, yPos + i, 70 - i * 2, 70 - i * 2); //Head
	    c.drawLine (xPos + 30 + i, yPos + 70, xPos + 30 + i, yPos + 150); //Body
	    c.drawLine (xPos - 15 - i / 2, yPos + 70 + i, xPos + 30, yPos + 90 + i); //Left Arm
	    c.drawLine (xPos + 85 + i / 2, yPos + 70 + i, xPos + 40, yPos + 90 + i); //Right Arm
	    c.drawLine (xPos + i, yPos + 200 + i / 2, xPos + 30 + i, yPos + 150); //Left Leg
	    c.drawLine (xPos + 70 - i, yPos + 200 + i / 2, xPos + 40 - i, yPos + 150); //Right Leg
	}

	//Decorations
	c.setColour (pastelBlue);
	c.fillRect (0, 0, 150, 100);
	c.fillRect (-20, 80, 80, 110);
	c.fillRect (550, 0, 90, 90);
	c.fillRect (570, 90, 120, 90);

	c.setColour (grayBlue);
	c.fillRect (560, 150, 80, 100);
	c.fillRect (500, 0, 120, 110);
	c.fillRect (0, 0, 100, 120);
	c.fillRect (0, 160, 80, 80);

	c.setColour (cyan);
	c.fillRect (570, -10, 70, 60);
	c.fillRect (590, 210, 100, 95);
	c.fillRect (0, 240, 50, 80);
	c.fillRect (0, 0, 70, 60);

	//Pause program before moving onto next page
	pauseProgram (220, 450);
    }


    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    public void splashScreen ()
    {
	c.setColour (lightBlue);
	c.fillRect (0, 0, 640, 500); //Background

	//Decorations
	c.setColour (pastelBlue);
	c.fillRect (0, 0, 150, 100);
	c.fillRect (-20, 80, 80, 110);
	c.fillRect (550, 0, 90, 90);
	c.fillRect (570, 90, 120, 90);
	c.setColour (grayBlue);
	c.fillRect (560, 150, 80, 100);
	c.fillRect (500, 0, 120, 110);
	c.fillRect (0, 0, 100, 120);
	c.fillRect (0, 160, 80, 80);
	c.setColour (cyan);
	c.fillRect (570, -10, 70, 60);
	c.fillRect (590, 210, 100, 95);
	c.fillRect (0, 240, 50, 80);
	c.fillRect (0, 0, 70, 60);

	//Hangman Stand
	for (int i = 0 ; i < 10 ; i++)
	{
	    c.setColour (grayBlue);
	    c.drawLine (255 + i, 120, 255 + i, 370);
	    c.drawLine (255, 110 + i, 350, 110 + i);
	    c.drawLine (350 + i, 110, 350 + i, 140);
	    c.setColour (cyan);
	    c.drawLine (220, 370 + i, 420, 370 + i); //Base
	}
	//Draw The Stick Figure
	xPos = 320; //X position of the stick figure
	yPos = 140; //Y position of the stick figure

	c.setColour (cyan);
	for (int i = 0 ; i < 10 ; i++)
	{ //This loop will increase line thickness to 10 pixels
	    c.drawOval (xPos + i, yPos + i, 70 - i * 2, 70 - i * 2); //Head
	    c.drawLine (xPos + 30 + i, yPos + 70, xPos + 30 + i, yPos + 150); //Body
	    c.drawLine (xPos - 15 - i / 2, yPos + 70 + i, xPos + 30, yPos + 90 + i); //Left Arm
	    c.drawLine (xPos + 85 + i / 2, yPos + 70 + i, xPos + 40, yPos + 90 + i); //Right Arm
	    c.drawLine (xPos + i, yPos + 200 + i / 2, xPos + 30 + i, yPos + 150); //Left Leg
	    c.drawLine (xPos + 70 - i, yPos + 200 + i / 2, xPos + 40 - i, yPos + 150); //Right Leg
	}

	//Draw out letter decorations around the screen
	int[] xPositions = {50, 100, 120, 170, 250, 280, 360, 390, 460, 490, 530, 590}; //X positions of the letters
	int[] yPositions = {430, 230, 320, 100, 480, 50, 90, 460, 180, 400, 320, 450}; //Y positions of the letters
	c.setColour (white);
	for (int i = 0 ; i < 12 ; i++)
	{
	    //Draw out a random uppercase letter (65 - 90)
	    String randomLetter = (char) (Math.floor (Math.random () * 26) + 65) + "";
	    c.setFont (title); //Set to title size font
	    c.drawString (randomLetter, xPositions [i], yPositions [i]); //Draw a random letter at the designated space

	    try
	    {
		Thread.sleep (160); //Delay between each letter apperance
	    }
	    catch (Exception x)
	    {
	    }
	}
	c.setFont (heading);
	c.drawString ("Welcome To Hangman", 190, 410);

	try
	{
	    Thread.sleep (1000); //Delay one final time before moving on
	}
	catch (Exception x)
	{
	}
    }


    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    public void instructions ()
    {
	c.setColour (lightBlue);
	c.fillRect (0, 0, 640, 500); //Background

	//Decorations
	c.setColour (pastelBlue);
	c.fillRect (0, 0, 150, 100);
	c.fillRect (550, 0, 90, 90);
	c.setColour (grayBlue);
	c.fillRect (500, 0, 120, 110);
	c.fillRect (0, 0, 100, 120);
	c.setColour (cyan);
	c.fillRect (570, -10, 70, 60);
	c.fillRect (0, 0, 70, 60);

	//Instruction Text
	c.setColour (white);
	c.setFont (title);
	c.drawString ("Instructions", 210, 100); //Title
	c.setFont (heading);

	c.drawString ("How To Play", 110, 150); //How to play the game
	c.setFont (text);
	c.drawString ("Hangman is a simple game where", 50, 180);
	c.drawString ("the player must guess letters", 50, 200);
	c.drawString ("in order to guess a word. The", 50, 220);
	c.drawString ("game will ask you to enter a", 50, 240);
	c.drawString ("letter. If the word contains", 50, 260);
	c.drawString ("the letter, all instances of the", 50, 280);
	c.drawString ("letter will be displayed. If the", 50, 300);
	c.drawString ("word does not contain the letter,", 50, 320);
	c.drawString ("a part of the stick figure will", 50, 340);
	c.drawString ("be drawn. Once the stick figure", 50, 360);
	c.drawString ("is completly drawn, the game is", 50, 380);
	c.drawString ("over. There are 3 rounds.", 50, 400);

	c.setFont (heading);
	c.drawString ("Getting Score", 380, 150); //How score is calculated
	c.setFont (text);
	c.drawString ("Score is added when", 340, 180);
	c.drawString ("a player guesses a letter", 340, 200);
	c.drawString ("correctly. However, if you", 340, 220);
	c.drawString ("make a mistake, you will lose score.", 340, 240);
	c.drawString ("If you fail to guess the word", 340, 260);
	c.drawString ("before the hangman is drawn,", 340, 280);
	c.drawString ("you will lose a substantial", 340, 300);
	c.drawString ("amount of points.", 340, 320);
	pauseProgram (220, 450);
    }


    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    public void mainMenu ()
    {
	c.clear ();
	c.setColour (lightBlue);
	c.fillRect (0, 0, 640, 500); //Background

	//Decorations
	c.setColour (pastelBlue);
	c.fillRect (0, 0, 150, 100);
	c.fillRect (-20, 80, 80, 110);
	c.fillRect (550, 0, 90, 90);
	c.fillRect (570, 90, 120, 90);
	c.setColour (grayBlue);
	c.fillRect (560, 150, 80, 100);
	c.fillRect (500, 0, 120, 110);
	c.fillRect (0, 0, 100, 120);
	c.fillRect (0, 160, 80, 80);
	c.setColour (cyan);
	c.fillRect (570, -10, 70, 60);
	c.fillRect (590, 210, 100, 95);
	c.fillRect (0, 240, 50, 80);
	c.fillRect (0, 0, 70, 60);


	c.setColour (grayBlue); //Draw background box
	c.fillRoundRect (195, 140, 260, 40, 5, 5);
	c.fillRoundRect (205, 190, 240, 40, 5, 5);
	c.fillRoundRect (190, 240, 270, 40, 5, 5);
	c.fillRoundRect (185, 290, 280, 40, 5, 5);

	//Display title text
	c.setColour (white);
	c.setFont (title);
	c.drawString ("Main Menu", 225, 100);
	c.setFont (heading);
	c.drawString ("<1> Instructions", 220, 170);
	c.drawString ("<2> High Scores", 225, 220);
	c.drawString ("<3> Level Selection", 210, 270);
	c.drawString ("<4> Leave The Game", 205, 320);
	c.setFont (text);
	c.drawString ("Enter the corresponding number to select an option!", 110, 400);
	while (true) // while loop for error trap
	{
	    nextCmd = c.getChar ();

	    if (nextCmd == '1' || nextCmd == '2' || nextCmd == '3' || nextCmd == '4')
	    { //Check if one of the 4 options
		break;
	    }
	    else
	    {
		new Message ("Please enter an integer between 1 and 4, corresponding to each option."); //Print error message
	    }
	}
    }


    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    public int levelSelection ()
    {
	c.clear ();
	c.setColour (lightBlue);
	c.fillRect (0, 0, 640, 500); //Background
	//Decorations
	c.setColour (pastelBlue);
	c.fillRect (0, 0, 150, 100);
	c.fillRect (-20, 80, 80, 110);
	c.fillRect (550, 0, 90, 90);
	c.fillRect (570, 90, 120, 90);
	c.setColour (grayBlue);
	c.fillRect (560, 150, 80, 100);
	c.fillRect (500, 0, 120, 110);
	c.fillRect (0, 0, 100, 120);
	c.fillRect (0, 160, 80, 80);
	c.setColour (cyan);
	c.fillRect (570, -10, 70, 60);
	c.fillRect (590, 210, 100, 95);
	c.fillRect (0, 240, 50, 80);
	c.fillRect (0, 0, 70, 60);

	c.setColour (grayBlue); //Draw background box
	c.fillRoundRect (195, 140, 260, 40, 5, 5);
	c.fillRoundRect (205, 190, 240, 40, 5, 5);

	//Display title text
	c.setColour (white);
	c.setFont (title);
	c.drawString ("Level Selection", 185, 100);
	c.setFont (heading);
	c.drawString ("<1> Easy Mode", 240, 170);
	c.drawString ("<2> Hard mode", 240, 220);
	c.setFont (text);
	c.drawString ("Enter the corresponding integer to select a level!", 120, 400);
	while (true) // while loop for error trap
	{
	    try
	    {
		difficulty = Integer.parseInt (c.getChar () + ""); // gets user input
		if (difficulty == 1 || difficulty == 2)
		{
		    break;
		}
		else
		{
		    new Message ("Please enter an integer between 1 and 4, corresponding to each option.");
		}
	    }
	    catch (NumberFormatException e)
	    {
		new Message ("Please enter an integer between 1 and 4, corresponding to each option.");
	    }
	}
	return difficulty;
    }


    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public void game ()
    {
	//Get words that the player can guess depending on the difficulty
	String[] roundOne = new String [20]; //Round 1 words
	String[] roundTwo = new String [20]; //Round 2 words
	String[] roundThree = new String [20]; //Round 3 words
	String word; //This is the word that the player will be guessing
	String sortWord;
	int scoreAdd; //Holds the point value that will be added when a correct letter is guessed

	// code to put information in files into arrays for better implementation
	try
	{
	    if (difficulty == 1)
	    { //Difficulty 1 is easy mode
		file = new BufferedReader (new FileReader ("easyWords.txt"));
	    }
	    else
	    { //Difficulty 2 is hard mode
		file = new BufferedReader (new FileReader ("hardWords.txt"));
	    }

	    for (int i = 0 ; i < 20 ; i++)
	    { //Loop through all the round 1 words
		sortWord = file.readLine (); // the current word
		roundOne [i] = sortWord;
	    }
	    for (int i = 0 ; i < 20 ; i++)
	    { //Loop through all the round 2 words
		sortWord = file.readLine (); // the current word
		roundTwo [i] = sortWord;
	    }
	    for (int i = 0 ; i < 20 ; i++)
	    { //Loop through all the round 3 words
		sortWord = file.readLine (); // the current word
		roundThree [i] = sortWord;
	    }

	}
	catch (IOException ex)
	{
	    new Message ("Error, file cannot be found"); // Display a error message
	}

	//Once we have all the words, we want to start the three rounds
	currentScore = 0;
	for (int i = 0 ; i < 3 ; i++)  // for loop for three rounds
	{
	    c.clear ();
	    c.setColour (lightBlue);
	    c.fillRect (0, 0, 640, 500);
	    //Background setup
	    //Decorations
	    c.setColour (pastelBlue);
	    c.fillRect (0, 0, 130, 80);
	    c.fillRect (550, 0, 90, 90);
	    c.setColour (grayBlue);
	    c.fillRect (500, 0, 120, 110);
	    c.fillRect (0, 0, 100, 100);
	    c.setColour (cyan);
	    c.fillRect (570, -10, 70, 60);
	    c.fillRect (0, 0, 70, 60);

	    //Select our random word for the player to guess
	    if (i == 0)
	    { //First round words
		word = roundOne [(int) (Math.random () * roundOne.length)];
		scoreAdd = 75 * difficulty;
	    }
	    else if (i == 1)
	    { //Second round words
		word = roundTwo [(int) (Math.random () * roundTwo.length)];
		scoreAdd = 102 * difficulty;
	    }
	    else
	    { //Third round words
		word = roundThree [(int) (Math.random () * roundThree.length)];
		scoreAdd = 127 * difficulty;
	    }
	    word = word.toUpperCase (); //Set to uppercase


	    //Gameplay code, this includes decoration, point calculation, and playerGuess handling
	    int lives = 6; //Number of lives the player has left (Prevoiously called livess)
	    int letterCounter = 0; // keeps in track if the user guessed all the characters in the given word
	    boolean cheatsUsed = false;
	    char letterGuess = ' ';
	    char[] wordBank = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; //Word bank containing all the words

	    for (int j = 0 ; j < 10 ; j++)
	    { //Hangman Stand
		c.setColour (grayBlue);
		c.drawLine (55 + j, 120, 55 + j, 370);
		c.drawLine (55, 110 + j, 150, 110 + j);
		c.drawLine (150 + j, 110, 150 + j, 140);
		c.setColour (cyan);
		c.drawLine (20, 370 + j, 220, 370 + j); //Base
	    }

	    //Display the _ _ _ that show the player how many letters there are
	    for (int j = 0 ; j < word.length () ; j++)
	    {
		c.setColour (cyan);
		c.fillRect (400 - (word.length () / 2 * 45) + (j * 45), 310, 40, 5);
	    }

	    while (lives >= 0) //This is the code that runs during each round
	    {
		//Draw the hangman figure depending on the number of lives
		//Draw The Stick Figure
		int xPos = 120; //X position of the stick figure
		int yPos = 140; //Y position of the stick figure

		c.setColour (cyan);
		for (int j = 0 ; j < 10 ; j++)
		{ //This loop will increase line thickness to 10 pixels
		    if (lives == 5)
		    {
			c.drawOval (xPos + j, yPos + j, 70 - j * 2, 70 - j * 2); //Head
		    }
		    else if (lives == 4)
		    {
			c.drawLine (xPos + 30 + j, yPos + 70, xPos + 30 + j, yPos + 150); //Body
		    }
		    else if (lives == 3)
		    {
			c.drawLine (xPos - 15 - j / 2, yPos + 70 + j, xPos + 30, yPos + 90 + j); //Left Arm
		    }
		    else if (lives == 2)
		    {
			c.drawLine (xPos + 85 + j / 2, yPos + 70 + j, xPos + 40, yPos + 90 + j); //Right Arm
		    }
		    else if (lives == 1)
		    {
			c.drawLine (xPos + j, yPos + 200 + j / 2, xPos + 30 + j, yPos + 150); //Left Leg
		    }
		    else if (lives == 0)
		    { //If no lives left
			c.drawLine (xPos + 70 - j, yPos + 200 + j / 2, xPos + 40 - j, yPos + 150); //Right Leg
		    }
		}
		if (lives == 0) //Exit the while loop if lives == 0
		{
		    //Since the player lost, they should lose score
		    c.setFont (text);
		    c.setColor (white);
		    c.drawString ("Uh Oh, You Ran Out Of Lives", 310, 340); // fail message
		    break; //End the round and exit the while loop
		}

		//Display player score at the top
		c.setColour (lightBlue);
		c.fillRect (280, 0, 200, 40);
		c.setColour (white);
		c.setFont (text);
		c.drawString ("Score: " + currentScore, 280, 30); //Print out player score
		//Word Bank (Draw it every time)
		c.setColour (pastelBlue);
		c.fillRect (0, 400, 640, 100);
		c.setColour (cyan);
		c.fillRect (0, 395, 640, 10);
		//Display the word bank to the player
		c.setFont (heading);
		c.setColour (white);
		for (int j = 0 ; j < 13 ; j++)  //Upper Row of letters
		{
		    c.drawString (wordBank [j] + "", 30 + 46 * j, 440);
		}
		for (int j = 13 ; j < 26 ; j++) //Lower Row of letters
		{
		    c.drawString (wordBank [j] + "", 30 + 46 * (j - 13), 480);
		}

		//Cheat functions for each difficulty
		c.setFont (text);
		if (difficulty == 1)
		{
		    c.drawString ("Press <9> for hint!", 10, 25);
		}
		else
		{
		    c.drawString ("Press <9> for cheat!", 10, 25);
		}

		//Player Tries Guessing A Letter
		while (true)
		{ //Mak sure it's a letter from A - Z
		    letterGuess = Character.toUpperCase (c.getChar ()); //Get user guess
		    if ((letterGuess >= 65 && letterGuess <= 90) || letterGuess == '9')
			break;                                                                    //Valid letter then break, 9 for hint
		    else
		    {
			new Message ("Please enter a letter from the letter bank!");
		    }
		}

		//Cheat code depends on difficulty
		if (letterGuess == '9') // if user desires a hint
		{
		    cheatsUsed = true;
		    if (difficulty == 1)
		    {
			for (int j = 0 ; j < wordBank.length ; j++)
			{
			    for (int n = 0 ; n < word.length () ; n++)
			    {
				if (wordBank [j] == word.charAt (n)) //Checking to see the word contains the letter from the word bank
				{
				    c.setColour (lightBlue);
				    c.fillRect (240, 40, 200, 40);
				    c.setColour (white);
				    c.drawString ("Guess the letter " + wordBank [j], 250, 60); //Tell the user a letter
				    letterGuess = ' ';
				    if (currentScore - scoreAdd > 0)
				    {
					currentScore -= scoreAdd * 2;
				    }
				    else
				    {
					currentScore = 0;
				    }
				    break;
				}
			    }
			    if (letterGuess != '9') //Break when we have the letter
			    {
				break;

			    }
			}
		    }
		    else
		    {
			c.drawString ("The word is " + word, 240, 60); //Tell the user the word
		    }
		}
		else
		{
		    //We need to check and see if their guess is a dupelicate guess
		    //We can check to see if the index has a ' ' instead of the letter
		    if (wordBank [letterGuess - 65] == ' ')
		    { //Already guessed
			new Message ("You have already guessed this letter!"); //Display a message
		    }
		    else
		    {
			//IndexOf Method was learned in AP_Classroom 2.7 Daily Video 1
			if (word.indexOf (letterGuess) != -1)
			{ //Check if the word contains the guessed letter
			    for (int k = 0 ; k < word.length () ; k++)
			    { // for loop that iterates through all characters of word
				if (letterGuess == word.charAt (k))
				{
				    c.setFont (title);
				    c.drawString (letterGuess + "", 405 - (word.length () / 2 * 45) + k * 45, 305); // draws the letter
				    currentScore += scoreAdd; //Add for every letter guessed right
				    letterCounter++;
				}
			    }
			}
			else
			{ //Doesn't contain the guessed letter
			    lives--; //decrease lives counter by 1.
			    //Take away score for a wrong guess
			    if (currentScore - scoreAdd / 2 > 0)
			    { //Make sure we don't go negative
				currentScore -= scoreAdd / 2; //Subtract the score
			    }
			    else
			    { //If negative, set score to 0
				currentScore = 0;
			    }
			}
			wordBank [letterGuess - 65] = ' '; //Remove letter from the word bank
		    }

		    if (letterCounter == word.length ()) // checks if the user correctly guessed the full word
		    {
			c.setFont (text);
			c.setColor (white);
			c.drawString ("Congraulations You Guessed The Word", 270, 340); // correct message
			currentScore += scoreAdd * 2;
			break;
		    }
		}

	    }
	    if (cheatsUsed && difficulty == 2)
	    {
		currentScore -= currentScore / 3; //Decrease score if cheats used
	    }
	    pauseProgram (320, 370);
	    //Wait before Moving to next round
	}
	//Background setup
	c.clear ();
	c.setColour (lightBlue);
	c.fillRect (0, 0, 640, 500);
	//Decorations
	c.setColour (pastelBlue);
	c.fillRect (0, 0, 130, 80);
	c.fillRect (550, 0, 90, 90);
	c.setColour (grayBlue);
	c.fillRect (500, 0, 120, 110);
	c.fillRect (0, 0, 100, 100);
	c.setColour (cyan);
	c.fillRect (570, -10, 70, 60);
	c.fillRect (0, 0, 70, 60);
	//Word Bank
	c.setColour (pastelBlue);
	c.fillRect (0, 400, 640, 100);
	c.setColour (cyan);
	c.fillRect (0, 395, 640, 10);

	c.drawString ("Game has finished, you gained a score of " + currentScore + ".", 155, 230);
	c.drawString ("Please enter a Username with a length 3 - 9 characters.", 110, 260);


	if (currentScore >= calcScore (currentScore))
	{
	    c.drawString ("Your score is recorded in the leaderboards!", 140, 380);
	}
	else
	{
	    c.drawString ("Unfortunately, your score is not high enough to be on the leaderboards.", 45, 380);
	}
	pauseProgram (220, 450);
    }


    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=


    private static int calcScore (int score)
    {
	int[] scoreArr = new int [11]; // create array that keeps track of scores in the leaderboard
	String[] usernameArr = new String [11]; // create array that keeps track of users in the leaderboard
	scoreArr [0] = score; // score is from the parameter of the calcScore method
       
	// code for inputing username
	while (true)
	{
	    c.setColor (pastelBlue);
	    c.fillRoundRect (250, 290, 150, 50, 50, 50); // draws rounded rect design

	    usernameArr [0] = ""; // creates the blank for username to be inputed
	    c.setColor (white);
	    for (int i = 0 ; i < 10 ; i++) // for loop iterates 9 times, resulting in a maximum of 9 inputs
	    {


		char userInput = c.getChar (); // get user input
		if ((int) userInput <= 32 && (int) userInput != 8 && (int) userInput != 10)  //if user types any strange characters
		{
		    i--;  // cancels the i++ in for loop.
		}
		else
		{

		    if ((int) userInput == 10) // if user types enter, stop taking in input
		    {
			break;
		    }
		    usernameArr [0] = usernameArr [0] + userInput; // attach each character to the usernameArr[0].
		    c.drawString (userInput + "", 265 + 13 * i, 321); // display the character
		}
	    } // for loop

	    if ((usernameArr [0] + "").length () >= 3 && (usernameArr [0] + "").length () <= 9) // username length requirements
	    {
		break;
	    }
	    else
	    {
		new Message ("Username must have a length between 3-9 characters.");
	    }
	} // while loop
	c.setColour (cyan); // set colour back to original blue text

	try
	{
	    BufferedReader file = new BufferedReader (new FileReader ("highScores.txt"));
	    for (int i = 1 ; i < 11 ; i++)
	    {
	      String  current = file.readLine ();   //  value holder for read line in text file
		if (current != null)
		{
		    usernameArr [i] = current;
		    scoreArr [i] = Integer.parseInt (file.readLine ());

		}
	    }



	    int temp = 0; // temp value holder for array sort\
	    String stringTemp = " ";
	    //Sort the array in ascending order using two for loops
	    for (int i = 0 ; i < scoreArr.length ; i++)
	    {
		for (int j = i + 1 ; j < scoreArr.length ; j++)
		{
		    if (scoreArr [i] < scoreArr [j] && usernameArr [j] != null)
		    { //swap elements if not in order
			temp = scoreArr [i];
			stringTemp = usernameArr [i];
			usernameArr [i] = usernameArr [j];
			usernameArr [j] = stringTemp;
			scoreArr [i] = scoreArr [j];
			scoreArr [j] = temp;
		    }
		}
	    }


	    PrintWriter printWriter = new PrintWriter (new FileWriter ("highScores.txt")); // creates printWriter
	    // writes data into text file
	    for (int i = 0 ; i < 10 ; i++)
	    {
		printWriter.println (usernameArr [i]);
		printWriter.println (scoreArr [i]);

	    }
	    printWriter.close (); // closes print writer
	} // try
	catch (IOException e)
	{
	    new Message ("File not found");
	}

	return scoreArr [9]; // return the lowest score
    }


    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public void highScores ()
    {

	//Background
	c.setColour (lightBlue);
	c.fillRect (0, 0, 640, 500);
	c.setColour (pastelBlue);
	// rounded rectangle design
	c.fillRoundRect (230, 130, 200, 270, 50, 50);
	//Border Decorations
	c.fillRect (0, 0, 150, 100);
	c.fillRect (-20, 80, 80, 110);
	c.fillRect (550, 0, 90, 90); 
	c.fillRect (570, 90, 120, 90);
	c.setColour (grayBlue);
	c.fillRect (560, 150, 80, 100);
	c.fillRect (500, 0, 120, 110);
	c.fillRect (0, 0, 100, 120);
	c.fillRect (0, 160, 80, 80);
	c.setColour (cyan);
	c.fillRect (570, -10, 70, 60);
	c.fillRect (590, 210, 100, 95);
	c.fillRect (0, 240, 50, 80);
	c.fillRect (0, 0, 70, 60);

	// title
	c.setColour (white);
	c.setFont (title);
	c.drawString ("High Scores", 215, 100);
	c.setFont (text); // set font to text
	try
	{
	    file = new BufferedReader (new FileReader ("highScores.txt"));


	    for (int i = 0 ; i < 10 ; i++)
	    {
		String current = file.readLine ();
		if (!current.equals( "null")) // checks if current is not null
		{
		    c.drawString (current, 250, 170 + 22 * i); // print usernames
		    c.drawString (file.readLine (), 370, 170 + 22 * i); // print scores
		}
		else
		{
		    break;
		}
	    }
	}

	catch (IOException e)
	{
	    new Message ("File not found");
	}
	catch (NullPointerException e)
	{
	    new Message ("There are less than 10 scores in the text file"); // error message
	}
	pauseProgram (220, 450);
    }


    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public void goodbye ()
    {
	//Background
	c.setColour (lightBlue);
	c.fillRect (0, 0, 640, 500);

	// Border Decorations
	c.setColour (pastelBlue);
	c.fillRect (0, 0, 150, 100);
	c.fillRect (-20, 80, 80, 110);
	c.fillRect (550, 0, 90, 90);
	c.fillRect (570, 90, 120, 90);

	c.setColour (grayBlue);
	c.fillRect (560, 150, 80, 100);
	c.fillRect (500, 0, 120, 110);
	c.fillRect (0, 0, 100, 120);
	c.fillRect (0, 160, 80, 80);

	c.setColour (cyan);
	c.fillRect (570, -10, 70, 60);
	c.fillRect (590, 210, 100, 95);
	c.fillRect (0, 240, 50, 80);
	c.fillRect (0, 0, 70, 60);


	//Stick Figure
	xPos = 100; //X position of the stick figure
	yPos = 180; //Y position of the stick figure

	c.setColour (cyan);
	// drawing the stick figure
	for (int i = 0 ; i < 10 ; i++) //This loop will increase line thickness to 10 pixels
	{
	    c.drawOval (xPos + i, yPos + i, 70 - i * 2, 70 - i * 2); //Head
	    c.drawLine (xPos + 30 + i, yPos + 70, xPos + 30 + i, yPos + 150); //Body
	    c.drawLine (xPos - 15 - i / 2, yPos + 70 + i, xPos + 30, yPos + 90 + i); //Left Arm
	    c.drawLine (xPos + 85 + i / 2, yPos + 70 + i, xPos + 40, yPos + 90 + i); //Right Arm
	    c.drawLine (xPos + i, yPos + 200 + i / 2, xPos + 30 + i, yPos + 150); //Left Leg
	    c.drawLine (xPos + 70 - i, yPos + 200 + i / 2, xPos + 40 - i, yPos + 150); //Right Leg
	}

	// Goodbye text
	c.setColour (white);
	c.setFont (heading);
	c.drawString ("Thank You For Playing", 235, 250);
	c.drawString ("ISP Hangman", 235, 280);
	c.setFont (text);
	c.drawString ("Made By Sion Gang & Ethan Xu", 235, 325);
	pauseProgram (220, 450);
	c.close (); // close console

    }


    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public void pauseProgram (int x, int y)
    {
	c.setFont (text);
	c.setColor (white);
	if (nextCmd == 0 || nextCmd == 3 || nextCmd == 4) // if program is currently in level selection or game
	{
	    c.drawString ("Press any KEY to continue:", x, y);
	}

	else
	{
	    c.drawString ("Press any KEY to go back to Main Menu:", 170, 450);
	}

	c.getChar (); //Wait for the user to press a key
    }


    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void main (String[] args)
    {
	ISP_HangmanProject h = new ISP_HangmanProject (); // create object of class
	h.title ();
	h.splashScreen ();

	while (nextCmd != '4')
	{ //May not be 4 depending on number of options in the menu
	    h.mainMenu ();
	    if (nextCmd == '1')
	    { //Go to instructions
		h.instructions ();
	    }
	    else if (nextCmd == '2')
	    { //Go to high score leaderboards
		h.highScores ();      // run highscores
	    }
	    else if (nextCmd == '3')
	    { //Go to the level selection
		nextCmd = 3; // sets next command to 3
		difficulty = h.levelSelection (); // set difficulty to the return value of levelSelection()

		h.game (); // run game method
	    }

	}


	nextCmd = 4; // sets next command to four
	h.goodbye (); //pauseProgram will be in here
    }
} // ISP_HangmanProject class


