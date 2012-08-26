package com.kroysemaj.bifid;

import static org.junit.Assert.*;

import org.junit.Test;

public class BifidConverterTest
{
	
	BifidConverter bc = new BifidConverter();
	
		
	@Test
	public void declarePolybiusSquare()
	{
		char[][] polybiusSquare = new char[5][5];
	}

	@Test
	public void firstCharInPolySquareShouldBeA()
	{
		assertEquals('A', bc.getCharAt(0, 0));
	}
	
	@Test
	public void lastCharInPolySquareShouldBeZ()
	{
		assertEquals('Z', bc.getCharAt(4, 4));
	}
	
	@Test
	public void confirmNCharInPolySquareShouldBeAt22()
	{
		assertEquals('N', bc.getCharAt(2, 2));
	}
	
	@Test
	public void returnLocationOfLetterA()
	{
		assertEquals("11", bc.returnLocationOfLetter('A'));
	}
	
	@Test
	public void returnLocationOfLetterZ()
	{
		assertEquals("55", bc.returnLocationOfLetter('Z'));
	}
	
	@Test
	public void returnLocationOfLetterN()
	{
		assertEquals("33", bc.returnLocationOfLetter('N'));
	}
	
	@Test
	public void returnLocationOfLetterK()
	{
		assertEquals("25", bc.returnLocationOfLetter('K'));
	}
	
	@Test
	public void concatenateCoordinatesForAB()
	{
		assertEquals("1112", bc.concatenateCoordinates("11", "12"));
	}
	
	@Test
	public void concatenateCoordinatesForABZ()
	{
		assertEquals("111255", bc.concatenateCoordinates("11", "12", "55"));
	}
		
	@Test
	public void convertStringOfStackedCoordinatesToHalfBifidForAF()
	{
		assertEquals("1211", bc.convertStackedCoordsToHalfBifid("1121"));
	}

	@Test
	public void convertStringOfStackedCoordinatesToHalfBifidForAZ()
	{
		assertEquals("1515", bc.convertStackedCoordsToHalfBifid("1155"));
	}
	
	@Test
	public void convertStringOfStackedCoordinatesToHalfBifidForANZ()
	{
		assertEquals("135135", bc.convertStackedCoordsToHalfBifid("113355"));
	}
	
	@Test
	public void convertStringOfStackedCoordinatesToHalfBifidForTEST()
	{
		assertEquals("42444534", bc.convertStackedCoordsToHalfBifid("44254344"));
	}
	
	@Test
	public void convertPlainTextToHalfBifidForTEST()
	{
		assertEquals("41444534", bc.encryptPlaintextToHalfBifid("Test"));
	}
	
	@Test
	public void convertPlainTextToHalfBifidForMessagesWithSpaces()
	{
		assertEquals("4144414445344534", bc.encryptPlaintextToHalfBifid("Test Test"));
	}
	
	@Test
	public void convertPlainTextToHalfBifidForBowerSleeps()
	{
		assertEquals("1351443113424252315553", bc.encryptPlaintextToHalfBifid("Bower Sleeps"));
	}
	
	@Test
	public void convertHalfBifidToEncryptedTextWithNoSpaces()
	{
		assertEquals("CVTLCRRWLZX", bc.convertHalfBifidToEncyptedText("1351443113424252315553"));
	}

	@Test
	public void convertPlaintextToEncryptedTextWithSpacesforBowerSleeps()
	{
		assertEquals("CVTLC RRWLZX", bc.encryptPlaintextToCipherText("Bower Sleeps"));
	}
	
	@Test
	public void convertPlaintextToEncryptedTextWithSpacesForJamesYork()
	{
		assertEquals("FLUOI BXTK", bc.encryptPlaintextToCipherText("James York"));
	}
	
	@Test
	public void convertPlaintextToEncryptedTextWithSpacesWithMultipleSpaces()
	{
		assertEquals("SQQQQ BSX BWY", bc.encryptPlaintextToCipherText("Roses are red"));
	}
		
	/*
	@Test
	public void constructCustomPolybiusSquare()
	{
		char[][] polybiusSquare = new char[5][5];
	}	
	*/
	
}
