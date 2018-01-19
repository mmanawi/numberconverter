package zahlen;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Hexadecimal {
	
	private String hexalNumber;
	final private static String MATCH_STRING = "[0-F]";
	final static int BASIS = 16;
	
	// Konstruktor:
	
	public Hexadecimal(String hexalNumber){
		
		setHexalNumber(hexalNumber);
	}
	
	private void setHexalNumber(String hexalNumber){
				
		this.hexalNumber = Funktionen.numberOK(hexalNumber, MATCH_STRING) ;
	}
	
	public String getHexalNumber(){
		
		return this.hexalNumber;
	}
	
	public static String applyAsDecimal(String hexalNumber) {

		// Zunaechst mal die Nummber auf Richtigkeit pruefen:
		hexalNumber = Funktionen.numberOK(hexalNumber, MATCH_STRING);
		
		int lengthHexalNumber = hexalNumber.length();
		BigInteger sum[] = new BigInteger[lengthHexalNumber]; 
		BigInteger result = new BigInteger("0");
		String str;
		int strToInt;		
		
		// Um spaeter die letzte rechte Stelle der Hexadezimalzahl als erstes zu nehmen
		int x = lengthHexalNumber - 1; 

		for (int i = 0; i < sum.length; i++) {

			// Hier Umwandlung von Char in String, angefangen mit der letzten
			// Stelle rechts
			// der eingegebenen Bin�rzahl

			str = "" + hexalNumber.charAt(x);

			// Hier Umwandlung von String in BigInteger

			switch (str) {

			case "A":
				str = "10";
				break;
			case "B":
				str = "11";
				break;
			case "C":
				str = "12";
				break;
			case "D":
				str = "13";
				break;
			case "E":
				str = "14";
				break;
			case "F":
				str = "15";
				break;
			}

			strToInt = Integer.parseInt(str);

			// Hier F�llen des Arrays anfgefangen mit letzten Stelle der 
			// Hexadezimal-Zahl (von rechts) 

			BigDecimal bdSum = BigDecimal.valueOf( Math.pow(BASIS, i) * strToInt);
			
			sum[i] = bdSum.toBigInteger(); 
			result = result.add(sum[i]);

			x--;
		}

		String strResult = result.toString();		
		return strResult;
	}
	
	public String applyAsDecimal(){
		
		return applyAsDecimal(getHexalNumber());
	}
	
	public static String applyAsBinary(String hexalNumber){
		
		return Decimal.applyAsBinary(applyAsDecimal(hexalNumber));	
	}
	
	public String applyAsBinary(){
		
		return applyAsBinary(getHexalNumber());
		
	}
	
	public static String applyAsOctal(String hexalNumber){
		
		return Decimal.applyAsOctal(applyAsDecimal(hexalNumber));	
	}
	
	public String applyAsOctal(){
		
		return applyAsOctal(getHexalNumber());
		
	}

	public static String applyAsDuodecimal(String hexalNumber){
		
		return Decimal.applyAsDuodecimal(applyAsDecimal(hexalNumber));	
	}
	
	public String applyAsDuodecimal(){
		
		return applyAsDuodecimal(getHexalNumber());
		
	}
}
