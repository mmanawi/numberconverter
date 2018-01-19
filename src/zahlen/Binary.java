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
			
	public static String applyAsDecimal(String binNumber) {

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
	
	public String applyAsDecimal(){
		
		return applyAsDecimal(getBinNumber());
	}
	
	public static String applyAsDuodecimal(String binNumber){
		
		return Decimal.applyAsDuodecimal(Binary.applyAsDecimal(binNumber));	
	}
	
	public String applyAsDuodecimal(){
		
		return applyAsDuodecimal(getBinNumber());
		
	}
	
	public static String applyAsOctal(String binNumber){
		
		return Decimal.applyAsOctal(Binary.applyAsDecimal(binNumber));	
	}
	
	public String applyAsOctal(){
		
		return applyAsOctal(getBinNumber());
		
	}

	public static String applyAsHexadecimal(String binNumber){
		
		return Decimal.applyAsHexadecimal(Binary.applyAsDecimal(binNumber));	
	}
	
	public String applyAsHexadecimal(){
		
		return applyAsHexadecimal(getBinNumber());		
	}
}
