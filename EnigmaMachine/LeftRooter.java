package EnigmaMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeftRooter 
{
	private char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	private char alphabetScrambledOne[] = {'A', 'J', 'D', 'K', 'S' ,'I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
	private static final char copy[] = {'A', 'J', 'D', 'K', 'S' ,'I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
	private final char copy0[] = {'A', 'J', 'D', 'K', 'S' ,'I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
	private char alphabetScrambledCopy[];
	private char characterToEncrypt;
	private int rooterPosition;
	
	public LeftRooter(int position)
	{
		
		setRooterPosition(position);
	}
	
	public void reset()
	{
		alphabetScrambledOne = copy0;
	}
	
	public void encrypt()
	{
		int counter = 0;
		System.out.print("Encrypting Left: ");
		for(int i = 0; i < alphabet.length; i++)
		{
			if(characterToEncrypt == alphabet[i])
			{
				characterToEncrypt = alphabetScrambledOne[i];
				i = alphabet.length-1;
				System.out.print(characterToEncrypt + "\n");
			}
		}
	}
	
	public void reflectEncrypt()
	{
		int counter = 0;
		System.out.print("Reflect Encrypting Left: ");
		for(int i = 0; i < alphabet.length; i++)
		{
			if (characterToEncrypt == alphabetScrambledOne[i])
			{
				characterToEncrypt = alphabet[i];
				i = alphabet.length-1;
				System.out.print(characterToEncrypt + "\n");
			}
		}
	}
	
	
	
	public void shift(int num, int numTimes)
	{	
		int counter = 1;
		
		if(num == 0)
		{
			alphabetScrambledOne = copy0;
			
		}
		
		
		alphabetScrambledCopy = alphabetScrambledOne;
		
		
		System.out.print("Left: ");
		
		for(int i = 0; i < alphabetScrambledOne.length; i++)
		{
			if(counter <= 25)
			{
				alphabetScrambledOne[i] = alphabetScrambledCopy[counter];
				counter++;
			}
			else if((counter > 25) && (i <= 25))
			{
				counter = 0;
				counter+=numTimes;
				while(i <= 25)
				{
					alphabetScrambledOne[i] = copy[counter];
					counter++;
					i++;
				}
				
				if(i == 26)
				{
					i = 25;
				}
			}
			
			System.out.print(alphabetScrambledOne[i] + ",");
			
		}
		System.out.println();
		
		alphabetScrambledCopy = alphabetScrambledOne;
		
	}
	
	public void shift(int num)
	{
		int counter = 1;
		
		if(num == 0)
		{
			alphabetScrambledOne = copy0;
			
		}
		
		
		//alphabetScrambledCopy = alphabetScrambledOne;
		
		
		System.out.print("Right: ");
		
		char a = alphabetScrambledOne[0];
		
		for(int i = 0; i < alphabetScrambledOne.length; i++)
		{
			if(i != 25)
			{
				alphabetScrambledOne[i] = alphabetScrambledOne[counter];
				counter++;
			}
			else
			{
				alphabetScrambledOne[25] = a;
			}
			
			System.out.print(alphabetScrambledOne[i] + ",");
			
		}
		System.out.println();
		
		//alphabetScrambledCopy = alphabetScrambledOne;
		
	}
	
	public void setAlphabetScrambledOne(char aS[])
	{
		alphabetScrambledOne = aS;
		System.out.println("Done.");
	}
	
	public char[] getAlphabetScrambledOne()
	{
		return alphabetScrambledOne;
	}

	public int getRooterPosition() {
		return rooterPosition;
	}

	public void setRooterPosition(int rooterPosition) {
		this.rooterPosition = rooterPosition;
	}

	public char getCharacterToEncrypt() {
		return characterToEncrypt;
	}

	public void setCharacterToEncrypt(char characterToEncrypt) {
		this.characterToEncrypt = characterToEncrypt;
	}
}


