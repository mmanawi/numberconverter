package zahlen;
import java.math.BigDecimal;
import java.math.BigInteger;


public class Binary {
	
	private String binNumber;
	final static String MATCH_STRING = "[0-1]";
	final static private int BASIS = 2;
	
	// Konstruktor:
	
	public Binary(String binNumber){
		
		setBinNumber(binNumber);
	}
	
	private void setBinNumber(String binNumber){
				
		this.binNumber = Funktionen.numberOK(binNumber, MATCH_STRING);
	}
	
	public String getBinNumber(){
		
		return this.binNumber;
	}
			
	public static String toDecimal(String binNumber) {

		// Zunaechst mal die Nummber auf Richtigkeit pruefen:
		binNumber = Funktionen.numberOK(binNumber, MATCH_STRING);
		
		int lengthBinNumber = binNumber.length();
		BigInteger sum[] = new BigInteger[lengthBinNumber]; 
		BigInteger result = new BigInteger("0");
		String str;
		int strToInt;		
		
		// Um spaeter die letzte rechte Stelle der Dualzahl als erstes zu nehmen
		int x = lengthBinNumber - 1; 

		for (int i = 0; i < sum.length; i++) {

			// Hier Umwandlung von Char in String, angefangen mit der letzten
			// Stelle rechts der eingegebenen Binaerzahl

			str = "" + binNumber.charAt(x);

			// Hier Umwandlung von String in Integer

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
		
		return toDecimal(getBinNumber());
	}
	
	public static String toDuodecimal(String binNumber){
		
		return Decimal.toDuodecimal(Binary.toDecimal(binNumber));	
	}
	
	public String toDuodecimal(){
		
		return toDuodecimal(getBinNumber());
		
	}
	
	public static String toOctal(String binNumber){
		
		return Decimal.toOctal(Binary.toDecimal(binNumber));	
	}
	
	public String toOctal(){
		
		return toOctal(getBinNumber());
		
	}

	public static String toHexadecimal(String binNumber){
		
		return Decimal.toHexadecimal(Binary.toDecimal(binNumber));	
	}
	
	public String toHexadecimal(){
		
		return toHexadecimal(getBinNumber());		
	}
}
