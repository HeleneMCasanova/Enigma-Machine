package EnigmaMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reflector 
{
	private char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
		'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
		'W', 'X', 'Y', 'Z'};

private char alphabetScrambledOne[] = new char[26];
private char alphabetScrambledTwo[] = new char[26];
char alphabetScrambledCopy[];
private char characterToEncrypt;
private int rooterPosition;

public Reflector(int position)
{
	scrambleAlphabetOne();
	scrambleAlphabetTwo();
	setRooterPosition(position);
}

public void scrambleAlphabetOne()
{	
	List<Character> list = new ArrayList<>();
	for(int i = 0; i < alphabet.length; i++)
	{
		list.add(alphabet[i]);
	}
	
	Collections.shuffle(list);
	System.out.print("\nReflect Scrambled One: ");
	for(int i = 0; i < alphabetScrambledOne.length; i++)
	{
		alphabetScrambledOne[i] = list.get(i);
		System.out.print(alphabetScrambledOne[i] + ", ");
	}
	
	 setAlphabetScrambledOne(alphabetScrambledOne);
	 //alphabetScrambledCopy = alphabetScrambledOne;
}

public void scrambleAlphabetTwo()
{	
	List<Character> list = new ArrayList<>();
	for(int i = 0; i < alphabet.length; i++)
	{
		list.add(alphabet[i]);
	}
	
	Collections.shuffle(list);
	System.out.print("\nReflect Scrambled Two: ");
	for(int i = 0; i < alphabetScrambledTwo.length; i++)
	{
		alphabetScrambledTwo[i] = list.get(i);
		System.out.print(alphabetScrambledTwo[i] + ", ");
	}
	
	 setAlphabetScrambledTwo(alphabetScrambledTwo);
	 alphabetScrambledCopy = alphabetScrambledTwo;
}


public void encrypt()
{
	int counter = 0;
	System.out.print("Reflect: ");
	for(int i = 0; i < alphabet.length; i++)
	{
		if(characterToEncrypt == alphabetScrambledOne[i])
		{
			characterToEncrypt = alphabetScrambledTwo[i];
			i = alphabet.length-1;
			System.out.print(characterToEncrypt + "\n");
		}
	}
}

public void reflectEncrypt()
{
	int counter = 0;
	System.out.print("Reflect: ");
	for(int i = 0; i < alphabet.length; i++)
	{
		if (characterToEncrypt == alphabetScrambledTwo[i])
		{
			characterToEncrypt = alphabetScrambledOne[i];
			i = alphabet.length-1;
			System.out.print(characterToEncrypt + "\n");
		}
	}
}



public void setAlphabetScrambledOne(char aS[])
{
	alphabetScrambledOne = aS;
}

public char[] getAlphabetScrambledOne()
{
	return alphabetScrambledOne;
}

public void setAlphabetScrambledTwo(char aS[])
{
	alphabetScrambledTwo = aS;
}

public char[] getAlphabetScrambledTwo()
{
	return alphabetScrambledTwo;
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


