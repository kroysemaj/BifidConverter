package com.kroysemaj.bifid;

public class BifidConverter
{
	private char [][] polybiusSquare = new char[5][5]; //a 5x5 square in which each element holds a letter of the alphabet
	
	BifidConverter() //fills the polybius square with the alphabet
	{
		char start = 'A';
		
		for(int i = 0; i < 5; ++i)
		{
			for(int j=0; j<5; ++j)
			{
				if(start == 'J')  // 'I' and 'J' are considered analogous
				{
					this.polybiusSquare[i][j] = ++start;
				}
				else 
				{
					this.polybiusSquare[i][j] = start; 
				}
				++start;
			}
		}
	}
	
	public char getCharAt(int i, int j)
	{
		return polybiusSquare[i][j];
	}

	public String returnLocationOfLetter(char c)
	{
		String result = "";
		
		for(int i = 0; i < 5; ++i)
		{
			for(int j=0; j<5; ++j)
			{
				if(this.polybiusSquare[i][j] == c)  
				{
					result = Integer.toString(i+1)+Integer.toString(j+1); // Add 1 to the coordinates to make them more 
				}														  // readable (non-zero-indexed)
			}
		}
		
		return result;
	}

	public String concatenateCoordinates(String ... coords)
	{
		String coordsString ="";
		
		for(int i = 0; i < coords.length; ++i)
		{
			coordsString += coords[i];
		}
		
		return coordsString;
	}

	public String convertStackedCoordsToHalfBifid(String stackedCoords)
	{
		String upperCoords = "";
		String lowerCoords = "";
		String halfBifid = "";
		
		for(int i=0; i<stackedCoords.length(); ++i)
		{
			if(i % 2 == 0)
			{
				upperCoords += stackedCoords.charAt(i);
			}
			else 
			{
				lowerCoords += stackedCoords.charAt(i);
			}
		
		}
		
		halfBifid += upperCoords+lowerCoords;
		
		return halfBifid;
	}

	public String encryptPlaintextToHalfBifid(String plaintext)
	{

		String stackedCoords = "";
		StringBuffer sb = new StringBuffer(plaintext); 
		

		
		plaintext = sb.toString(); 
		plaintext = plaintext.toUpperCase(); 
		
		
		for(int i=0; i<plaintext.length(); ++i)
		{
			stackedCoords += this.returnLocationOfLetter((plaintext.charAt(i)));
		}
		
		return this.convertStackedCoordsToHalfBifid(stackedCoords);
	}

	public String convertHalfBifidToEncyptedText(String halfBifid)
	{
		String newHalfBifid = halfBifid;
		String digitPair = "";
		String encryptedMessage = "";
		int row = 0;
		int col = 0;
		
		
		for(int i = 0; i < halfBifid.length(); i += 2)
		{
			if (newHalfBifid.length() < 2)
			{
				digitPair = newHalfBifid;
				row = Character.getNumericValue(digitPair.charAt(0));
				col = Character.getNumericValue(digitPair.charAt(1));
			}
			else 
			{
				digitPair = newHalfBifid.substring(0, 2);
				row = Character.getNumericValue(digitPair.charAt(0));
				col = Character.getNumericValue(digitPair.charAt(1));
				newHalfBifid = newHalfBifid.substring(2);
			}
			
			encryptedMessage += this.getCharAt(row-1, col-1);
		}
			
		return encryptedMessage;

	}

	public String encryptPlaintextToCipherText(String plaintext)
	{
		
		String encryptedMessage = "";
		
		encryptedMessage = this.encryptPlaintextToHalfBifid(plaintext);
		
		encryptedMessage = this.convertHalfBifidToEncyptedText(encryptedMessage);
		
		
		return encryptedMessage;
	}
	
	
}
