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
	
	public static String applyAsDecimal(String octNumber) {

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
	
		public String applyAsDecimal(){
			
			return applyAsDecimal(getOctNumber());
		}
		
		// Umrechnung zu Dual
	    // ===================
			
			// Statistisch:
			
			public static String applyAsBinary(String octNumber){
				
				return Decimal.applyAsBinary(applyAsDecimal(octNumber));	
			}
			
			// Als Instanz-Methode:
			
			public String applyAsBinary(){
				
				return applyAsBinary(getOctNumber());
			}
			
		
		// Umrechnung zu Hexal
		// ===================
		
		// Statistisch:
		
		public static String applyAsHexal(String octNumber){
			
			return Decimal.applyAsHexadecimal(applyAsDecimal(octNumber));	
		}
		
		// Als Instanz-Methode:
		
		public String applyAsHexal(){
			
			return applyAsHexal(getOctNumber());
		}
		
		// Umrechnung zu Octal
		// ===================
		// Statistisch:
		
		public static String applyAsOctal(String octNumber){
			
			return Decimal.applyAsOctal(applyAsDecimal(octNumber));	
		}
		
		public String applyAsOctal(){
			
			return applyAsOctal(getOctNumber());
		}
		
		// Umrechnung zu duodezimal
		// ========================
		// Statistisch:
		
		public static String applyAsDuoDecimal(String octNumber){
				
			return Decimal.applyAsDuodecimal(applyAsDecimal(octNumber));	
		}	
		
		public String applyAsDuoDecimal(){
			
			return applyAsDuoDecimal(getOctNumber());
		}
}
