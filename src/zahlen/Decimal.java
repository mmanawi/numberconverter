package zahlen;
public class Decimal {

	private String decNumber;
	final private static String MATCH_STRING = "[0-9]";
	final private static int BASIS2 = 2;
	final private static int BASIS8 = 8;
	final private static int BASIS12 = 12;
	final private static int BASIS16 = 16;

	// Konstruktor:

	public Decimal(String decNumber) {

		setDecNumber(decNumber);
	}

	private void setDecNumber(String decNumber) {

		this.decNumber = Funktionen.numberOK(decNumber, MATCH_STRING);
	}

	public String getDecNumber() {

		return this.decNumber;
	}

	public static String toBinary(String decNr) {

	
		if (decNr == "0") {
			return "0";
		} else if (decNr.startsWith("-")) {		
			return "Negative Number!";
		} else {
						
			decNr = Funktionen.numberOK(decNr, MATCH_STRING);
			int restWert[];
			restWert = Funktionen.restWert(decNr, BASIS2);

			// Hier wird die Dualzahl zusammengebastelt:
			String result = "";

			for (int x = restWert.length - 1; x > -1; x--) {
				result = result + "" + restWert[x];
			}
			
			return Funktionen.nullenWeg(result);
		}
	}
	
	// Und wenn mit einer Instanz aufgerufen wird:

	public String toBinary() {

		return toBinary(getDecNumber());
	}

	public static String toOctal(String decNr) {

		if (decNr == "0") {
			return "0";
		} else if (decNr.startsWith("-")) {		
			return "Negative Number!";
		} else {
			decNr = Funktionen.numberOK(decNr, MATCH_STRING);
			int restWert[];
			restWert = Funktionen.restWert(decNr, BASIS8);

			// Hier wird die Oktalzahl zusammengebastelt:
			String result = "";
			int x = 0;
			for (x = restWert.length - 1; x > -1; x--) {
				result = result + "" + restWert[x];
			}

			return Funktionen.nullenWeg(result);
		}
	}

	// Und wenn mit einer Instanz aufgerufen wird:

	public String toOctal() {

		return toOctal(getDecNumber());
	}
			
	public static String toHexadecimal(String decNr) {

		if (decNr == "0") {
			return "0";
		} else if (decNr.startsWith("-")) {		
			return "Negative Number!";
		} else {

			decNr = Funktionen.numberOK(decNr, MATCH_STRING);
			int restWert[];
			restWert = Funktionen.restWert(decNr, BASIS16);

			// Hier wird die Dualzahl zusammengebastelt:
			String result = "";
			int x;
			for (x = restWert.length - 1; x > -1; x--) {

				switch (restWert[x]) {

				case 10:
					result = result + "" + "A";
					break;
				case 11:
					result = result + "" + "B";
					break;
				case 12:
					result = result + "" + "C";
					break;
				case 13:
					result = result + "" + "D";
					break;
				case 14:
					result = result + "" + "E";
					break;
				case 15:
					result = result + "" + "F";
					break;
				default:
					result = result + "" + restWert[x];
					break;
				}
			}
			return Funktionen.nullenWeg(result);
		}
	}

	// Und wenn mit einer Instanze aufgerufen wird:
	
	public String toHexadecimal() {
		return toHexadecimal(getDecNumber());
	}
	
	public static String toDuodecimal(String decNr) {

		if (decNr == "0") {
			return "0";
		} else if (decNr.startsWith("-")) {		
			return "Negative Number!";
		} else {

			decNr = Funktionen.numberOK(decNr, MATCH_STRING);
			int restWert[];
			restWert = Funktionen.restWert(decNr, BASIS12);

			// Hier wird die Dualzahl zusammengebastelt:
			String result = "";
			int x;

			for (x = restWert.length - 1; x > -1; x--) {

				switch (restWert[x]) {

				case 10:
					result = result + "" + "A";
					break;
				case 11:
					result = result + "" + "B";
					break;
				default:
					result = result + "" + restWert[x];
					break;
				}
			}
			return Funktionen.nullenWeg(result);
		}
	}
	
	// Und wenn mit einer Instanz aufgerufen wird:

	public String toDuodecimal() {

		return toDuodecimal(getDecNumber());
	}
}
