package zahlen;
import java.math.BigDecimal;
import java.math.BigInteger;


public class Duodecimal {
	
	private String duoDecNumber;
	final static String MATCH_STRING = "[0-B]";
	
	// Konstruktor:
	
	public Duodecimal(String duoDecNumber){
		
		setDuoDecimalNumber(duoDecNumber);
	}
	
	private void setDuoDecimalNumber(String duoDecNumber){
				
		this.duoDecNumber = Funktionen.numberOK(duoDecNumber, MATCH_STRING);
	}
	
	public String getDuoDecimalNumber(){
		
		return this.duoDecNumber;
	}
			
	public static String toDecimal(String duodecimalNumber) {

		// Zunaechst mal die Nummber auf Richtigkeit pruefen:
		duodecimalNumber = Funktionen.numberOK(duodecimalNumber, MATCH_STRING);
		
		int lengthDuodecimalNumber = duodecimalNumber.length();
		BigInteger sum[] = new BigInteger[lengthDuodecimalNumber]; 
		BigInteger result = new BigInteger("0");
		String str;
		int strToInt;		
		final int BASIS = 12;
		
		// Um sp�ter die letzte rechte Stelle der Duodezimalzahl als erstes zu nehmen
		int x = lengthDuodecimalNumber - 1; 

		for (int i = 0; i < sum.length; i++) {

			// Hier Umwandlung von Char in String, angefangen mit der letzten
			// Stelle rechts  der eingegebenen Binaerzahl

			str = "" + duodecimalNumber.charAt(x);

			// Hier Umwandlung von String in Integer

			switch (str) {

			case "A":
				str = "10";
				break;
			case "B":
				str = "11";
			}

			strToInt = Integer.parseInt(str);

			// Hier Fuellen des Arrays anfgefangen mit letzten Stelle der 
			// Duodezimal-Zahl (von rechts) 

			BigDecimal bdSum = BigDecimal.valueOf( Math.pow(BASIS, i) * strToInt);
			
			sum[i] = bdSum.toBigInteger(); 
			result = result.add(sum[i]);

			x--;
		}

		String strResult = result.toString();		
		return strResult;
	}
	public String toDecimal(){
		
		return toDecimal(getDuoDecimalNumber());
	}
	
	public static String toBinary(String duoDecNumber){
		
		return Decimal.toBinary(Duodecimal.toDecimal(duoDecNumber));	
	}
	
	public String toBinary(){
		
		return toBinary(getDuoDecimalNumber());
		
	}
	
	public static String toOctal(String duoDecNumber){
		
		return Decimal.toOctal(Duodecimal.toDecimal(duoDecNumber));	
	}
	
	public String toOctal(){
		
		return toOctal(getDuoDecimalNumber());
		
	}

	public static String toHexadecimal(String duoDecNumber){
		
		return Decimal.toHexadecimal(Duodecimal.toDecimal(duoDecNumber));	
	}
	
	public String toHexadecimal(){
		
		return toHexadecimal(getDuoDecimalNumber());
		
	}
	
}