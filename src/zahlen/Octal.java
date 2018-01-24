package zahlen;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Octal {
	
	private String octNumber;
	final static String MATCH_STRING = "[0-8]";
	final static int BASIS = 8;
	
	
	// Konstruktur:
	
	public Octal(String octNumber){
		
		setOctNumber(octNumber);
	}
	
	private void setOctNumber(String octNumber){
		this.octNumber = Funktionen.numberOK(octNumber, MATCH_STRING);
	}
	
	public String getOctNumber(){
		
		return this.octNumber;
	}
	
	public static String toDecimal(String octNumber) {

		// Zunaechst mal die Nummber auf Richtigkeit pruefen:
		octNumber = Funktionen.numberOK(octNumber, MATCH_STRING);
		int lengthOctalNumber = octNumber.length();
		BigInteger sum[] = new BigInteger[lengthOctalNumber]; 
		BigInteger result = new BigInteger("0");
		String str;
		int strToInt;		
		
		// Um spaeter die letzte rechte Stelle der Oktalzimalzahl als erstes zu nehmen
		int x = lengthOctalNumber - 1; 

		for (int i = 0; i < sum.length; i++) {

			// Hier Umwandlung von Char in String, angefangen mit der letzten
			// Stelle rechts eingegebenen Oktalzahl

			str = "" + octNumber.charAt(x);
			strToInt = Integer.parseInt(str);

			// Hier Fuellen des Arrays anfgefangen mit letzten Stelle der 
			// Oktal-Zahl (von rechts) 

			BigDecimal bdSum = BigDecimal.valueOf( Math.pow(BASIS, i) * strToInt);
			
			sum[i] = bdSum.toBigInteger(); 
			result = result.add(sum[i]);

			x--;
		}

		String strResult = result.toString();		
		return strResult;
	}
	
	// Wenn in Verbindung mit einer Instanz:
	
		public String toDecimal(){
			
			return toDecimal(getOctNumber());
		}
		
		// Umrechnung zu Dual
	    // ===================
			
			// Statistisch:
			
			public static String toBinary(String octNumber){
				
				return Decimal.toBinary(toDecimal(octNumber));	
			}
			
			// Als Instanz-Methode:
			
			public String toBinary(){
				
				return toBinary(getOctNumber());
			}
			
		
		// Umrechnung zu Hexal
		// ===================
		
		// Statistisch:
		
		public static String toHexal(String octNumber){
			
			return Decimal.toHexadecimal(toDecimal(octNumber));	
		}
		
		// Als Instanz-Methode:
		
		public String toHexal(){
			
			return toHexal(getOctNumber());
		}
		
		// Umrechnung zu Octal
		// ===================
		// Statistisch:
		
		public static String toOctal(String octNumber){
			
			return Decimal.toOctal(toDecimal(octNumber));	
		}
		
		public String toOctal(){
			
			return toOctal(getOctNumber());
		}
		
		// Umrechnung zu duodezimal
		// ========================
		// Statistisch:
		
		public static String toDuoDecimal(String octNumber){
				
			return Decimal.toDuodecimal(toDecimal(octNumber));	
		}	
		
		public String toDuoDecimal(){
			
			return toDuoDecimal(getOctNumber());
		}
}
