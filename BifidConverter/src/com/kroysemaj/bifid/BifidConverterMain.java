package com.kroysemaj.bifid;

import java.util.Scanner;

public class BifidConverterMain
{
	public static void main(String[] args)
	{
		String input = "";
		Scanner consoleIn = new Scanner(System.in);
		BifidConverter bc = new BifidConverter();
		BifidConverter cc = new BifidConverter();
		//String answer = "";
		
			System.out.print("Enter the plain text you want encrypted: ");
			input = consoleIn.nextLine();
			
			System.out.println();
			System.out.println("Half Bifid: " +bc.encryptPlaintextToHalfBifid(input));
			System.out.println("Ciphertext: " +cc.encryptPlaintextToCipherText(input));
		
			/*
			System.out.println();
			System.out.print("Encrypt another line? (Y/N)");
			answer = consoleIn.next();
			*/		
	}
}
