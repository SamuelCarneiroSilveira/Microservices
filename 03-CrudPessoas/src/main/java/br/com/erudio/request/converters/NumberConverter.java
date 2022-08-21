package br.com.erudio.request.converters;

public class NumberConverter {

	public static Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D; // 0 Double 
		String number = strNumber.replace(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D; // 0 Double
	}

	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
