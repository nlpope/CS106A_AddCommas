/**
 * File: CS106A_AddCommas
 * ---------------------------------
 * The CS106A_AddCommas class takes a numeric 
 * input from the client (in string form) and 
 * displays the number with commas inserted at 
 * every third digit.
 * 
 */

import acm.program.*;

public class CS106A_AddCommas extends ConsoleProgram
{
	public void run()
	{
		while(true){
			String clientInput = readLine("Enter a number: ");
			if (clientInput.length() == 0){ println("goodbye"); break; }
			if (isANumber(clientInput)){
				String clientInputWithCommas = addCommas(clientInput);
				println(clientInputWithCommas);
				break;
			} else { 
				println("incorrect format please try again.");
			}
		}
	}
	
	
	private boolean isANumber(String strDigits)
	{		
		for (int i = 0; i < strDigits.length(); i++){
			char c = strDigits.charAt(i);
			
			if (i == 0 && (c == '-')){
				continue;
			} else if (!Character.isDigit(c)){
				return false;
			} 	
		}
		println("was a number");
		return true;
	}
	
	
	private String addCommas(String strDigits)
	{ 
		StringBuffer sb = new StringBuffer(strDigits);
		
		for (int i = strDigits.length()-1; i > 0; i--){
			char c = strDigits.charAt(i);
			strDigitsWithCommas += c;
			if (i != strDigits.length()-1 && i % 3 == 0){
				strDigitsWithCommas += ',';
			}
		}
		StringBuilder.insert(".");
	
		return strDigitsWithCommas;
	}
}