package zahlen;

import java.math.BigInteger;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ZahlenKonverterController implements Initializable {

	@FXML
	Button leereEingabefelder, end, ergebnisButton;

	@FXML
	TextField binTextfeld, decTextfeld, hexTextfeld, octTextfeld, duodecTextfeld, eingabe1, eingabe2, ergebnis;

	@FXML
	Label decLbl, binLbl, hexLbl, octLbl, duodecLbl, arithmetikLbl, basisLbl, gleichLbl, operatorLbl;

	@FXML
	RadioButton decimal, dual, hexadecimal, duodecimal, octal, plus, minus, mal, durch, modulo;

	ToggleGroup tGroup;
	ToggleGroup tGroup2;

	String strEingabe1 = "";
	String strEingabe2 = "";

	final private static String MATCH_STRING2 = "[0-1]";
	final private static String MATCH_STRING10 = "[0-9]";
	final private static String MATCH_STRING8 = "[0-7]";
	final private static String MATCH_STRING12 = "[0-B]";
	final private static String MATCH_STRING16 = "[0-F]";
	final private static int BASIS2 = 2;
	final private static int BASIS8 = 8;
	final private static int BASIS10 = 10;
	final private static int BASIS12 = 12;
	final private static int BASIS16 = 16;

	int basis;
	String operator;
	boolean ergebnisKonvertieren;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		setOperator("+");
		setBasis(10);
		initComponents();
	}

	// GETTERs UND SETTERs

	private void setOperator(String operator) {

		this.operator = operator;
		operatorLbl.setText("+");
	}

	public String getOperator() {

		return this.operator;
	}

	private void setBasis(int basis) {

		this.basis = basis;
		basisLbl.setText("[" + basis + "]");

	}

	public int getBasis() {

		return this.basis;
	}

	private void initComponents() {

		String konv2 = null;
		String konv3 = null;
		String konv4 = null;
		String konv5 = null;
		String konv6 = null;
		String konv7 = null;

		konv2 = "Konvertiert eine Dezimalzahl in andere Formate";
		konv3 = "Konvertiert eine Dualzahl in andere Formate";
		konv4 = "Konvertiert eine Hexadezimalzahl in andere Formate";
		konv5 = "Konvertiert eine Oktalzahl in andere Formate";
		konv6 = "Konvertiert eine Duodezimalzahl in andere Formate";
		konv7 = "Liefert das Ergebnis der arithmetischen Operation!";

		// Die Radio-Buttons einer Gruppe zuordnen:
		tGroup = new ToggleGroup();
		tGroup2 = new ToggleGroup();

		dual.setToggleGroup(tGroup);
		octal.setToggleGroup(tGroup);
		decimal.setToggleGroup(tGroup);
		duodecimal.setToggleGroup(tGroup);
		hexadecimal.setToggleGroup(tGroup);

		plus.setToggleGroup(tGroup2);
		minus.setToggleGroup(tGroup2);
		mal.setToggleGroup(tGroup2);
		durch.setToggleGroup(tGroup2);
		modulo.setToggleGroup(tGroup2);

	}

	/**
	 * Zur Durchfuehrung von Operationen mit verschiedenen Zahlen Systemen,
	 * gesteuert von Radiobuttons
	 * 
	 * @param ergebnisKonvertieren
	 */

	private void ergebnisBerechnen(boolean ergebnisKonvertieren) {

		String myErgebnis = "";

		if (eingabe1.getText().length() > 0 && eingabe2.getText().length() > 0) {

			BigInteger bi1 = new BigInteger("0");
			BigInteger bi2 = new BigInteger("0");

			switch (getBasis()) {

			case 2:

				if (isNumber(eingabe1.getText(), MATCH_STRING2) && isNumber(eingabe2.getText(), MATCH_STRING2)) {

					bi1 = new BigInteger(Binary.toDecimal(eingabe1.getText()));
					bi2 = new BigInteger(Binary.toDecimal(eingabe2.getText()));

					switch (getOperator()) {
					case "+":
						myErgebnis = (Decimal.toBinary((bi1.add(bi2).toString())));
						break;
					case "-":
						myErgebnis = (Decimal.toBinary((bi1.subtract(bi2).toString())));
						break;
					case "*":
						myErgebnis = (Decimal.toBinary((bi1.multiply(bi2).toString())));
						break;
					case "/":
						if (bi2.signum() > 0) {
							myErgebnis = (Decimal.toBinary((bi1.divide(bi2).toString())));
						}
						break;
					case "%":
						// Hier sicherstellen, dass nicht durch 0 dividiert wird:
						myErgebnis = (Decimal.toBinary((bi1.mod(bi2).toString())));
						break;
					}

					if (ergebnisKonvertieren == true) {
						binTextfeld.setText(ergebnis.getText());
						konvertDual(ergebnis.getText());
					}
				}

				ergebnis.setText(myErgebnis);
				break;

			case 8:

				if (isNumber(eingabe1.getText(), MATCH_STRING8) && isNumber(eingabe2.getText(), MATCH_STRING8)) {

					bi1 = new BigInteger(Octal.toDecimal(eingabe1.getText()));
					bi2 = new BigInteger(Octal.toDecimal(eingabe2.getText()));

					switch (getOperator()) {

					case "+":

						myErgebnis = (Decimal.toOctal((bi1.add(bi2).toString())));
						break;
					case "-":
						myErgebnis = (Decimal.toOctal((bi1.subtract(bi2).toString())));
						break;
					case "*":
						myErgebnis = (Decimal.toOctal((bi1.multiply(bi2).toString())));
						break;
					case "/":
						// Hier sicherstellen, dass nicht durch 0 dividiert wird:
						if (bi2.signum() > 0) {
							myErgebnis = (Decimal.toOctal((bi1.divide(bi2).toString())));
						}
						break;
					case "%":
						myErgebnis = (Decimal.toOctal((bi1.mod(bi2).toString())));
						break;
					}

					if (ergebnisKonvertieren == true) {
						octTextfeld.setText(ergebnis.getText());
						konvertOktal(ergebnis.getText());
					}
				}
				ergebnis.setText(myErgebnis);
				break;

			case 10:

				if (isNumber(eingabe1.getText(), MATCH_STRING10) && isNumber(eingabe2.getText(), MATCH_STRING10)) {

					bi1 = new BigInteger(eingabe1.getText());
					bi2 = new BigInteger(eingabe2.getText());

					switch (getOperator()) {

					case "+":
						myErgebnis = (bi1.add(bi2).toString());
						break;
					case "-":
						myErgebnis = (bi1.subtract(bi2).toString());
						break;
					case "*":
						myErgebnis = (bi1.multiply(bi2).toString());
						break;
					case "/":
						// Hier sicherstellen, dass nicht durch 0 dividiert wird:
						if (bi2.signum() > 0) {
							myErgebnis = (bi1.divide(bi2).toString());
						}
						break;
					case "%":
						myErgebnis = (bi1.mod(bi2).toString());
						break;
					}

					if (ergebnisKonvertieren == true) {
						decTextfeld.setText(ergebnis.getText());
						konvertDezimal(ergebnis.getText());
					}
				}

				ergebnis.setText(myErgebnis);
				break;

			case 12:

				if (isNumber(eingabe1.getText(), MATCH_STRING12) && isNumber(eingabe2.getText(), MATCH_STRING12)) {

					bi1 = new BigInteger(Duodecimal.toDecimal(eingabe1.getText()));
					bi2 = new BigInteger(Duodecimal.toDecimal(eingabe2.getText()));

					switch (getOperator()) {
					case "+":
						myErgebnis = (Decimal.toDuodecimal((bi1.add(bi2).toString())));
						break;
					case "-":
						myErgebnis = (Decimal.toDuodecimal((bi1.subtract(bi2).toString())));
						break;
					case "*":
						myErgebnis = (Decimal.toDuodecimal((bi1.multiply(bi2).toString())));
						break;
					case "/":
						// Hier sicherstellen, dass nicht durch 0 dividiert wird:
						if (bi2.signum() > 0) {
							myErgebnis = (Decimal.toDuodecimal((bi1.divide(bi2).toString())));
						}
						break;
					case "%":
						myErgebnis = (Decimal.toDuodecimal((bi1.mod(bi2).toString())));
						break;
					}

					if (ergebnisKonvertieren == true) {
						duodecTextfeld.setText(ergebnis.getText());
						konvertDuodezimal(ergebnis.getText());
					}
				}

				ergebnis.setText(myErgebnis);
				break;

			case 16:

				if (isNumber(eingabe1.getText(), MATCH_STRING16) && isNumber(eingabe2.getText(), MATCH_STRING16)) {

					bi1 = new BigInteger(Hexadecimal.toDecimal(eingabe1.getText()));
					bi2 = new BigInteger(Hexadecimal.toDecimal(eingabe2.getText()));

					switch (getOperator()) {

					case "+":
						myErgebnis = (Decimal.toHexadecimal((bi1.add(bi2).toString())));
						break;
					case "-":
						myErgebnis = (Decimal.toHexadecimal((bi1.subtract(bi2).toString())));
						break;
					case "*":
						myErgebnis = (Decimal.toHexadecimal((bi1.multiply(bi2).toString())));
						break;
					case "/":
						// Hier sicherstellen, dass nicht durch 0 dividiert wird:
						if (bi2.signum() > 0) {
							myErgebnis = (Decimal.toHexadecimal((bi1.divide(bi2).toString())));
						}
						break;
					case "%":
						myErgebnis = (Decimal.toHexadecimal((bi1.mod(bi2).toString())));
						break;
					}

					if (ergebnisKonvertieren == true) {
						hexTextfeld.setText(ergebnis.getText());
						konvertHexadezimal(ergebnis.getText());
					}

					ergebnis.setText(myErgebnis);
				}
			}

		} else {

			ergebnis.clear();
		}
	}

	private void allesKlaeren() {

		binTextfeld.clear();
		decTextfeld.clear();
		hexTextfeld.clear();
		octTextfeld.clear();
		duodecTextfeld.clear();
		eingabe1.clear();
		eingabe2.clear();
		ergebnis.clear();
	}

	// RadioListener:
	@FXML
	public void myRadioButtonListener(Event e) {

		// Auswahl des Zahlensystems:
		if (e.getSource() == decimal) {
			setBasis(BASIS10);
		} else if (e.getSource() == dual) {
			setBasis(BASIS2);
		} else if (e.getSource() == octal) {
			setBasis(BASIS8);
		} else if (e.getSource() == duodecimal) {
			setBasis(BASIS12);
		} else if (e.getSource() == hexadecimal) {
			setBasis(BASIS16);
		}

		// Auswahl der arithmetischen Operation:
		if (e.getSource() == plus) {
			setOperator("+");
		} else if (e.getSource() == minus) {
			setOperator("-");
		} else if (e.getSource() == mal) {
			setOperator("*");
		} else if (e.getSource() == durch) {
			setOperator("/");
		} else if (e.getSource() == modulo) {
			setOperator("%");
		}

		operatorLbl.setText(getOperator());
		ergebnisBerechnen(false);
	}

	// Action-Listener:

	@FXML
	public void myButtonListener(Event eve) {

		if (eve.getSource() == ergebnisButton)
			ergebnisBerechnen(true);

		if (eve.getSource() == leereEingabefelder)
			allesKlaeren();

		if (eve.getSource() == end) {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Frage");
			alert.setHeaderText(null);
			alert.setContentText("Wollen Sie wirklich abbrechen?");

			Optional<ButtonType> result = alert.showAndWait();

			if (result.get() == ButtonType.OK)
				System.exit(0);
		}
	}

	@FXML
	public void myKeyListener(KeyEvent event) {

		if (event.getCode().getName() != "Enter") {

			String number = "";

			if (event.getSource() == decTextfeld) {
				number = decTextfeld.getText();

				if (isNumber(number, MATCH_STRING10)) {
					konvertDezimal(number);
				} else {
					binTextfeld.clear();
					octTextfeld.clear();
					duodecTextfeld.clear();
					hexTextfeld.clear();
				}

			} else if (event.getSource() == binTextfeld) {

				number = binTextfeld.getText();

				if (isNumber(number, MATCH_STRING2)) {
					konvertDual(number);
				} else {
					octTextfeld.clear();
					decTextfeld.clear();
					duodecTextfeld.clear();
					hexTextfeld.clear();
				}

			} else if (event.getSource() == octTextfeld) {

				number = octTextfeld.getText();
				if (isNumber(number, MATCH_STRING8)) {
					konvertOktal(number);
				} else {
					binTextfeld.clear();
					decTextfeld.clear();
					duodecTextfeld.clear();
					hexTextfeld.clear();
				}

			} else if (event.getSource() == duodecTextfeld) {

				number = duodecTextfeld.getText();
				if (isNumber(number, MATCH_STRING12)) {
					konvertDuodezimal(number);
				} else {
					binTextfeld.clear();
					octTextfeld.clear();
					decTextfeld.clear();
					hexTextfeld.clear();
				}

			} else if (event.getSource() == hexTextfeld) {

				number = hexTextfeld.getText();

				if (isNumber(number, MATCH_STRING16)) {
					konvertHexadezimal(number);
				} else {
					binTextfeld.clear();
					octTextfeld.clear();
					decTextfeld.clear();
					duodecTextfeld.clear();
				}

			} else {
				// fuer die Textfelder eingabe1 und eingabe2
				ergebnisBerechnen(false);
			}

		}
	}

	/**
	 * Prueft die Richtigkeit der angegeben Zahl
	 * 
	 * @param s
	 * @param stringMatch
	 * @return
	 */

	public boolean isNumber(String s, String stringMatch) {

		boolean b = true;

		try {

			for (int i = 0; i < s.length(); i++) {
				String c = "" + s.charAt(i);

				if (!(c.toUpperCase().matches(stringMatch))) {

					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Eingabepr�fung");
					alert.setHeaderText("Zul�ssige Eingabe: " + stringMatch.subSequence(1, stringMatch.length() - 1));
					alert.setContentText("Ihre Eingabe -> (" + c + ") ist nicht richtig!");
					alert.showAndWait();

					b = false;
				}
			}
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	// Dual:
	private void konvertDual(String number) {

		decTextfeld.setText(Binary.toDecimal(number));
		hexTextfeld.setText(Binary.toHexadecimal(number));
		octTextfeld.setText(Binary.toOctal(number));
		duodecTextfeld.setText(Binary.toDuodecimal(number));
	}

	// Dezimal:
	private void konvertDezimal(String number) {

		binTextfeld.setText(Decimal.toBinary(number));
		hexTextfeld.setText(Decimal.toHexadecimal(number));
		octTextfeld.setText(Decimal.toOctal(number));
		duodecTextfeld.setText(Decimal.toDuodecimal(number));
	}

	// Oktal:
	private void konvertOktal(String number) {

		decTextfeld.setText(Octal.toDecimal(number));
		binTextfeld.setText(Octal.toBinary(number));
		hexTextfeld.setText(Octal.toHexal(number));
		duodecTextfeld.setText(Octal.toDuoDecimal(number));
	}

	// Duodezimal:
	private void konvertDuodezimal(String number) {

		decTextfeld.setText(Duodecimal.toDecimal(number));
		binTextfeld.setText(Duodecimal.toBinary(number));
		octTextfeld.setText(Duodecimal.toOctal(number));
		hexTextfeld.setText(Duodecimal.toHexadecimal(number));
	}

	// Hexal:
	private void konvertHexadezimal(String number) {

		decTextfeld.setText(Hexadecimal.toDecimal(number));
		binTextfeld.setText(Hexadecimal.toBinary(number));
		octTextfeld.setText(Hexadecimal.toOctal(number));
		duodecTextfeld.setText(Hexadecimal.toDuodecimal(number));
	}
}