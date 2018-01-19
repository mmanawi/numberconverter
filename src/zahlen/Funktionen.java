package zahlen;
import java.math.BigInteger;

public class Funktionen {
	
//	Laenge der Dezimalzahl ermitteln:
	
	public static int lengthDecNr(String decNr){
		
		return decNr.length();
	}
	
	public static String nullenWeg(String number) {

		// Damit die ueberfluessige 0 am Anfang der Zahl eliminiert werden:

		int y = 0;
		for (y = 0; y <= Funktionen.lengthDecNr(number); y++) {

			if (number.startsWith("0")) {
				number = number.replaceFirst("0", "");
			}
		}
		
		return number;
	}
	
	public static int wieOftTeilbar(BigInteger x, int y) {
	
		BigInteger z = x;
		int v = 0;

		while (z.signum() > 0) {

			z = x.divide(BigInteger.valueOf(y));
			v++;
			x = z;
		}
		
		return v;
	}

	public static String numberOK(String myNumber, String matches){
			
		String s = "";
		String number;

		myNumber.trim();
		number = myNumber;

		int cntNumber = number.length();
		
		if (!(number == "" || number.isEmpty())) {

			// Die Nummer initialisieren:

			number = "";
			
			int i = 0;
			while (i < cntNumber) {

				s = "" + myNumber.charAt(i);
				s = s.toUpperCase();
				
				if (!(s.matches(matches))) {
					s = "";
				}
				number = number + s;
				i++;
			}
		}
		
		myNumber = number;

		if (myNumber == "" || myNumber.isEmpty()) {
			return "0";
		} else {
			return myNumber;
		}
	}
		
	public static int[] restWert(String number, final int DIVISOR){
		
		BigInteger biDecNr = new BigInteger(number);
		BigInteger quotientWert;
		final int wieOftTeilbar = wieOftTeilbar(biDecNr, DIVISOR);
		int restWert[] = new int[wieOftTeilbar];

		// Diese Variabel ist noetig, um in der Schleife deren Wert dem
		// quotientWert gleich zu setzen, ohne den Wert von dezimalZahl ueberschreiben
		BigInteger biDecNr2 = biDecNr;

		for (int i = 0; i < restWert.length; i++) {
			// Hier wird die Dezimalzahl durch DIVSOR geteilt
			quotientWert = biDecNr2.divide(BigInteger.valueOf(DIVISOR));
			// Da Operationen mit dem Datentyp BigInteger auf komplizierten
			// Wegen moeglich sind, muessen folgende Umwandlungen vorgenommen werden:
			String sDivisor = String.valueOf(DIVISOR);
			BigInteger bi1 = new BigInteger(sDivisor);
			BigInteger bi2 = biDecNr2.mod(bi1);
			// Hier wird das Array restWert gefuellt:
			restWert[i] = bi2.intValue();
			biDecNr2 = quotientWert;
		}
		
		return restWert;
	}
}
