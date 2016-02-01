package utils;

import java.util.Locale;

public class FormatMoney {

	public static String FromatMoney(double money){
		return String.format(Locale.ENGLISH,"%.2f", money);
		
	}
}
