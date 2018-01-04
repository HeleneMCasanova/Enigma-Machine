package EnigmaMachine;

import java.util.Scanner;

public class EnigmaMachine 
{	
	private static Plugboard plugBoard;
	private static RightRooter rightRooter;
	private static LeftRooter leftRooter;
	private static MiddleRooter middleRooter;
	private static Reflector reflector;
	private static String message = "";
	
	public static String set(Scanner input)
	{
		System.out.println("\nEnter the void: ");
		String string = input.next();
		return string;
	}
	
	public Plugboard getplugBoard()
	{
		return plugBoard;
	}
	
	public RightRooter getRightRooter()
	{
		return rightRooter;
	}
	
	public LeftRooter getLeftRooter()
	{
		return leftRooter;
	}
	
	public MiddleRooter getMiddleRooter()
	{
		return middleRooter;
	}
	
	public Reflector getReflector()
	{
		return reflector;
	}
	
	
	public static String startEncrypting(String toEncrypt)
	{
		message = "";
		toEncrypt = toEncrypt.toUpperCase();
		char toHold = ' ';
		int counter = 0, counter_right = 0, counter_left = 0, counter_middle = 0;
		
		for(int i = 0; i < toEncrypt.length(); i++)
		{
			
			rightRooter.shift(1);
		
			
			if(counter == 1)
			{
				middleRooter.shift(1);
				counter_middle++;
			}
			

			if(counter == 2)
			{
				leftRooter.shift(1);
				counter = -1;counter_left++;
				
			}
			
			counter++;
			counter_right++;
			
			plugBoard.setCharacterToEncrypt(toEncrypt.charAt(i));
			plugBoard.encrypt();
			toHold = plugBoard.getCharacterToEncrypt();
			
			rightRooter.setCharacterToEncrypt(toHold);
			rightRooter.encrypt();
			toHold = rightRooter.getCharacterToEncrypt();
			
			middleRooter.setCharacterToEncrypt(toHold);
			middleRooter.encrypt();
			toHold = middleRooter.getCharacterToEncrypt();

			leftRooter.setCharacterToEncrypt(toHold);
			leftRooter.encrypt();
			toHold = leftRooter.getCharacterToEncrypt();
			
			
			
			reflector.setCharacterToEncrypt(toHold);
			reflector.reflectEncrypt();
			toHold = reflector.getCharacterToEncrypt();
			
			
			
			leftRooter.setCharacterToEncrypt(toHold);
			leftRooter.reflectEncrypt();
			toHold = leftRooter.getCharacterToEncrypt();
			
			middleRooter.setCharacterToEncrypt(toHold);
			middleRooter.reflectEncrypt();
			toHold = middleRooter.getCharacterToEncrypt();
			
			rightRooter.setCharacterToEncrypt(toHold);
			rightRooter.reflectEncrypt();
			toHold = rightRooter.getCharacterToEncrypt();
			
			
			plugBoard.setCharacterToEncrypt(toHold);
			plugBoard.reflectEncrypt();
			toHold = plugBoard.getCharacterToEncrypt();
			
			
			
			message += toHold;
		}
		
		return message;
		
		
	}
	
	
	
	public static String startDecrypting(String toEncrypt)
	{
		message = "";
		toEncrypt = toEncrypt.toUpperCase();
		char toHold = ' ';
		int counter = 0, counter_right = 0, counter_left = 0, counter_middle = 0, n1 = 0, n2 = 0, n3 = 0;
		
		for(int i = 0; i < toEncrypt.length(); i++)
		{
			rightRooter.shift(n1);
			
			
			if(counter == 1)
			{
				middleRooter.shift(n2);
				counter_middle++;n2++;
			}
			

			if(counter == 2)
			{
				leftRooter.shift(n3);
				counter = -1;counter_left++;n3++;
				
			}
			
			counter++;
			n1++;
			counter_right++;
			
			
			plugBoard.setCharacterToEncrypt(toEncrypt.charAt(i));
			plugBoard.encrypt();
			toHold = plugBoard.getCharacterToEncrypt();
			
			rightRooter.setCharacterToEncrypt(toHold);
			rightRooter.encrypt();
			toHold = rightRooter.getCharacterToEncrypt();
			
			middleRooter.setCharacterToEncrypt(toHold);
			middleRooter.encrypt();
			toHold = middleRooter.getCharacterToEncrypt();

			leftRooter.setCharacterToEncrypt(toHold);
			leftRooter.encrypt();
			toHold = leftRooter.getCharacterToEncrypt();
			
			
			
			reflector.setCharacterToEncrypt(toHold);
			reflector.encrypt();
			toHold = reflector.getCharacterToEncrypt();
			
			
			
			leftRooter.setCharacterToEncrypt(toHold);
			leftRooter.reflectEncrypt();
			toHold = leftRooter.getCharacterToEncrypt();
			
			middleRooter.setCharacterToEncrypt(toHold);
			middleRooter.reflectEncrypt();
			toHold = middleRooter.getCharacterToEncrypt();
			
			rightRooter.setCharacterToEncrypt(toHold);
			rightRooter.reflectEncrypt();
			toHold = rightRooter.getCharacterToEncrypt();
			
			
			plugBoard.setCharacterToEncrypt(toHold);
			plugBoard.reflectEncrypt();
			toHold = plugBoard.getCharacterToEncrypt();
			
		
		
		
		message += (toHold);
	}
		return message;
	}
	
	public static void moveMatrixEncrypt(String a)
	{
		String s = a;
		int num_times = 0;
		for(int i = 0; i < s.length(); i++)
		{
			num_times = 0;
			int eq = (int)s.charAt(i)-65;
			for(int j = 0; j < eq; j++)
			{
				if(i == 0)
				{
					while(rightRooter.getAlphabetScrambledOne()[1] != s.charAt(i))
					{
						rightRooter.shift(1);
						num_times++;
					}
				}
				else if(i == 1)
				{
					while(middleRooter.getAlphabetScrambledOne()[1] != s.charAt(i))
					{
						middleRooter.shift(1);
						num_times++;
					}
				}
				else
				{
					while(leftRooter.getAlphabetScrambledOne()[1] != s.charAt(i))
					{
						leftRooter.shift(1);
						num_times++;
					}
				}
			}
		}
	}
	
	public static void moveMatrixDecrypt(String a)
	{
		int num_times = 0;
		String s = a;
		int n1 = 0, n2 = 0, n3 = 0;
		for(int i = 0; i < s.length(); i++)
		{
			num_times = 0;
			int eq = (int)s.charAt(i)-65;
			
			
			for(int j = 0; j < eq; j++)
			{
				if(i == 0)
				{
					while(rightRooter.getAlphabetScrambledOne()[1] != s.charAt(i))
					{
						rightRooter.shift(n1);
						num_times++;n1++;
					}
				}
				else if(i == 1)
				{
					while(middleRooter.getAlphabetScrambledOne()[1] != s.charAt(i))
					{
						middleRooter.shift(n2);
						num_times++;n2++;
					}
				}
				else
				{
					while(leftRooter.getAlphabetScrambledOne()[1] != s.charAt(i))
					{
						leftRooter.shift(n3);
						num_times++;n3++;
					}
				}
			}
		}
		
	}
	
	public void set()
	{
		plugBoard = new Plugboard();
		rightRooter = new RightRooter(0);
		leftRooter = new LeftRooter(0);
		middleRooter = new MiddleRooter(0);
		reflector = new Reflector(0);
	}
	
	public void reset()
	{
		rightRooter.reset();
		middleRooter.reset();
		leftRooter.reset();
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		plugBoard = new Plugboard();
		rightRooter = new RightRooter(0);
		leftRooter = new LeftRooter(0);
		middleRooter = new MiddleRooter(0);
		reflector = new Reflector(0);
		
		//moveMatrixEncrypt();
		
		System.out.println("--------------------------------------------------------- " );
		
		
		String toEncrypt = set(input);
		startEncrypting(toEncrypt.toUpperCase());
		System.out.println("\nMessage: " + message);
		
		System.out.println("--------------------------------------------------------- " );
		
		rightRooter.reset();
		middleRooter.reset();
		leftRooter.reset();
		
		//moveMatrixDecrypt();
		
		System.out.println("--------------------------------------------------------- " );
		
		String unEncrypt = message.toUpperCase();		
		message = "";
		startDecrypting(unEncrypt);
		System.out.println("\nMessage: " + message);
	}
	
}
