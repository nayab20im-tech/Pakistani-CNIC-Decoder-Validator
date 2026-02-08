//Nayab 231980059//

import java.util.Scanner;

public class CNICInfo{

	public static boolean isValidCNIC(String cnic)
	{
		Scanner input = new Scanner(System.in);

		int length = cnic.length();

		for(int i=0; i<length ; i++)
		{
			char c = cnic.charAt(i);

			if((!Character.isDigit(c)) || (length!= 13))
			{
				System.out.println("Invalid input enter again");

                cnic = input.nextLine();
			}

		}
		return true;
	}
	public static String determineProvince(int provinceCode)
	{
		if(provinceCode == 1)
		{
			return "Khyber Pakhtunkhwa";
		}
		else if(provinceCode == 2)
		{
			return "FATA (Federally Administered Tribal Area)";
		}
		else if(provinceCode == 3)
		{
			return "Punjab";
		}
		else if(provinceCode == 4)
		{
			return "Sindh";
		}
		else if(provinceCode == 5)
		{
			return "Balochistan";
		}
		else if(provinceCode == 6)
		{
			return "Islamabad Territory";
		}
		else if(provinceCode == 7)
		{
			return "Gilgit-Baltistan";
		}
		else 
		{
			return "Unknown";
		}
		
	}
	public static String determineDivision(int divisionCode)
	{
		if(divisionCode == 4)
		{
			return "Gujranwala";
		}
		else 
	    {
	    	return "Not belongs to Gujranwala";
	    }
	} 
	public static String determineGender(int genderCode)
	{
		if(genderCode % 2 ==0)
		{
			return "Female";
		}
		else 
		{
			return "Male";
		}
	}
	public static int calculateExpiryYear(int issueYear)
	{
		int expiryYear = issueYear+10;

		return expiryYear;
	} 
	public static void main(String[]args)
	{
     Scanner input = new Scanner(System.in);

     System.out.println("Enter your CNIC number (without dashes)");

     String cnic = input.nextLine();

     boolean valid = isValidCNIC(cnic);

     System.out.println("Enter the the year of card issue (e.g.2022)");

     int issueYear = input.nextInt();

     System.out.println("********* CARD_HOLDER_DETAILS *********");

     int provinceCode = Character.getNumericValue(cnic.charAt(0));


     int divisionCode = Character.getNumericValue(cnic.charAt(1));


     int genderCode = Character.getNumericValue(cnic.charAt(12));


     String province = determineProvince(provinceCode);

     System.out.println(" Province : "+province);

     String division = determineDivision(divisionCode);

     System.out.println(" Division : "+division);

     String gender = determineGender(genderCode);

     System.out.println(" Gender : "+gender);

     int expiryYear = calculateExpiryYear(issueYear);
     
     System.out.println(" Expiry Year : "+expiryYear);
	}
}