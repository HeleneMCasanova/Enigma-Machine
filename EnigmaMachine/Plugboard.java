package EnigmaMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plugboard 
{
	private char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	private char alphabetScrambled[] = new char[26];
	private char characterToEncrypt;
	
	public Plugboard()
	{
		scrambleAlphabet();
	}
	
	public void encrypt()
	{
		System.out.print("Plugboard: ");
		for(int i = 0; i < alphabet.length; i++)
		{
			if(alphabet[i] == characterToEncrypt)
			{
				characterToEncrypt = alphabetScrambled[i];
				i = alphabet.length-1;
				System.out.print(characterToEncrypt + "\n");
			}
		}
	}
	
	public void reflectEncrypt()
	{
		System.out.print("Reflect Plugboard: ");
		for(int i = 0; i < alphabet.length; i++)
		{
			
			if(alphabetScrambled[i] == characterToEncrypt)
			{
				characterToEncrypt = alphabet[i];
				i = alphabet.length-1;
				System.out.print(characterToEncrypt + "\n");
			}
		}
	}
	
	public void scrambleAlphabet()
	{	
		List<Character> list = new ArrayList<>();
		for(int i = 0; i < alphabet.length; i++)
		{
			list.add(alphabet[i]);
		}
		
		Collections.shuffle(list);
		System.out.print("Plug Board: ");
		for(int i = 0; i < alphabetScrambled.length; i++)
		{
			alphabetScrambled[i] = list.get(i);
			System.out.print(alphabetScrambled[i] + ", ");
		}
		
		 setAlphabetScrambled(alphabetScrambled);
	}
	
	
	public void setAlphabetScrambled(char aS[])
	{
		alphabetScrambled = aS;
	}
	
	public char[] getAlphabetScrambled()
	{
		return alphabetScrambled;
	}

	public char getCharacterToEncrypt() {
		return characterToEncrypt;
	}

	public void setCharacterToEncrypt(char characterToEncrypt) {
		this.characterToEncrypt = characterToEncrypt;
	}
}


