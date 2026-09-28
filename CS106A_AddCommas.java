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
	private static final String SENTINEL = "-0";
	
	
	
	public void run()
	//public static void main(String[] args)
	{
		
		while(true){
			String clientInput = readLine("Enter a number: ");
			if (clientInput.length() == 0 || clientInput.equals(SENTINEL)){ 
				println("goodbye"); 
				break; 
			}
			if (isANumber(clientInput)){
				String clientInputWithCommas = addCommas(clientInput);
				println(clientInputWithCommas);
			} else { 
				println("incorrect format please try again.");
			}
		}
		
		
		//try { println("hey"); } catch (IllegalArgumentException e) {}
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
		/**
		for (int i = strDigits.length()-1; i > 0; i--){
			println(i % 3);
			if (i != strDigits.length()-1 && i % 3 == 0 && i-3 >-1){
				sb.insert(i+1,',');
			}
			
		}
		*/
		int commasPresent = 0;
		for (int i = 0; i < strDigits.length(); i++){
			// &&(Character)strDigits.charAt(i+3)!= null
			sb.insert(i, ',');
			if (i != 0 && i-commasPresent % 3 == 0){
				//println("sb i - 2-commaspresent = " + (i-2-commasPresent));
				sb.insert(i, ',');
				println("insert == " + sb);
				commasPresent++;
			}
		}
	
		return sb.toString();
	}
}