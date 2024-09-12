import gov.nasa.jpf.symbc.Debug;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.lang.*;

public class Spieltisch{

	public Object getHand(){
		return new Object();
	}
	
	public void setNeuGestartet(boolean neuGestartet){
	}
	
	public boolean getNeuGestartet(){
		boolean neuGestartet = Debug.makeSymbolicBoolean("x0");
		return neuGestartet;
	}
	
	public int getBubeAnzahl(){
		int bubeAnzahl = Debug.makeSymbolicInteger("x0");
		return bubeAnzahl;
	}
	
	public void setBubeAnzahl(int bubeAnzahl){
	}
	
	public int getDameAnzahl(){
		int dameAnzahl = Debug.makeSymbolicInteger("x0");
		return dameAnzahl;
		
	}
	
	public void setDameAnzahl(int dameAnzahl){
	}
	
	public int getKoenigAnzahl(){
		int koenigAnzahl = Debug.makeSymbolicInteger("x0");
		return koenigAnzahl;
	}
	
	public void setKoenigAnzahl(int koenigAnzahl){
	}
	
	public void setAnzahlKarten(int handKarten){
	}
	
	public Object getTxtAEingabe(){
		return new Object();
	}
	
	public Object getTxtAChat(){
		return new Object();
	}
	
	


	/***************************************************************************************
	Methode fÃ¼r die Buttons
	****************************************************************************************/
 	public void karteAuspielen(){
	int jokerWert = 1;
	//Ist eine Karte angewaehlt wird sie der ArrayList gespielteKarte hinzugefuegt (JokerKarten)
		for(int i = 0;i<3;i++){
			if(Debug.makeSymbolicBoolean("x0")){
				//Fordert den Spieler auf Falls eine Jokerkarte ausgewaehlt wurde eine Karte und eine Farbe einzugeben
				jokerWert = Debug.makeSymbolicInteger("x1");
							
			}
		}
		//Ist eine Karte angewaehlt wird sie der ArrayList gespielteKarte hinzugefuegt (Hand Karten)
		for(int i = 3;i<17;i++){
			if(Debug.makeSymbolicBoolean("x2")){
	
			}
		}
		
		
		if(jokerWert==0 || Debug.makeSymbolicBoolean("x3")){
			
		}else{
			
			//Wenn bereits Karten ausgespielt wurden, muss Stechlogik ueberprueft werden
			if(Debug.makeSymbolicInteger("x4")>0){
					
				//Wenn eine Einzelkarte gespielt wurde und sie hoecher ist wie die bereits gespielte Karte, stich erfolgreich
				if(Debug.makeSymbolicBoolean("x5")){
					
				}
				
				
				//Wenn die Karten eine Bombe sind können sie alles stechen ausser eine höhere Bombe
				
				//Bombe sticht eine andere Bombe wenn sie höher ist wie die andere Bombe
				else if(Debug.makeSymbolicInteger("x6") > 0 && Debug.makeSymbolicBoolean("x7")){
				}
				
				//Bombe sticht alle anderen Kombinationen ausser hoeher Bomben
				else if(Debug.makeSymbolicInteger("x8") > 0 && Debug.makeSymbolicBoolean("x9")){
				}
				
				//Wenn die Karten ein Paar sind und sie hoecher sind wie das bereits gespielte Paar, Stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x10")){
				}
				
				//Wenn die Karten Drillinge sind und sie hoecher sind wie die bereits gespielten Drillinge, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x11")){
				}
				
				//Wenn die Karten Vierlinge sind und sie hoecher sind wie die bereits gespielten Vierling, Stich erfolgriech
				else if(Debug.makeSymbolicBoolean("x12")){
				}
				
				//Wenn die Karten Fuenflinge sind und sie hoecher sind wie die bereits gespielten Fï¿½nflinge Stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x13")){
				}
				
				//Wenn die Karten Sechslinge sind und sie hoecher sind wie die bereits gespielten Sechslinge, Stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x14")){
				}		
				
				//Wenn die Karten Sieblinge sind und sie hoecher sind wie die bereits gespielten Sieblinge, Stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x15")){
				}
				
				//Wenn die Karten Achtlinge sind und sie hoecher sind wie die bereits gespielten Achtlinge, Stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x16")){
				}
				
				//Wenn die Karten eine dreier Strasse sind und sie hoecher sind wie die bereits gespielte dreier Strasse, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x17")){
				}
				
				//Wenn die Karten eine vierer Strasse sind und sie hoecher sind wie die bereits gespielte vierer Strasse, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x18")){
				}
				
				//Wenn die Karten eine fuenfer Strasse sind und sie hoecher sind wie die bereits gespielte fuenfer Strasse, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x19")){
				}
				
				//Wenn die Karten eine sechser Strasse sind und sie hoecher sind wie die bereits gespielte sechser Strasse, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x20")){
				}
				
				//Wenn die Karten eine siebner Strasse sind und sie hoecher sind wie die bereits gespielte siebner Strasse, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x21")){
				}
				
				//Wenn die Karten eine achter Strasse sind und sie hoecher sind wie die bereits gespielte achter Strasse, stich erfolgriech
				else if(Debug.makeSymbolicBoolean("x22")){
				}
				
				//Wenn die Karten eine neuner Strasse sind und sie hoecher sind wie die bereits gespielte neuner Strasse, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x23")){
				}
				
				//Wenn die Karten eine zehner Strasse sind und sie hoecher sind wie die bereits gespielte zehner Strasse, stich erfolgriech
				else if(Debug.makeSymbolicBoolean("x24")){
				}
				
				//Wenn die Karten eine elfer Strasse sind und sie hoecher sind wie die bereits gespielte elfer Strasse, stich erfolgriech
				else if(Debug.makeSymbolicBoolean("x25")){
				}
				
				//Wenn die Karten eine zwoelfer Strasse sind und sie hoecher sind wie die bereits gespielte zwoelfer Strasse, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x26")){
				}
				
				//Wenn die Karten eine Paar Strasse ist spiele und sie hoecher ist wie die bereits gespielte Paar Strasse, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x27")){
				}
				
				//Wenn die Karten eine Drilling Strasse ist und sie hoecher ist wie die bereits gespielte Drilling Strasse, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x28")){
				}
				
				//Wenn die Karten eine Vierling Strasse ist und sie hoecher ist wie die bereits gespielte Vierling Strasse, stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x29")){
				}
				
				//Wenn die Karten eine Fuenfling Strasse ist und sie hoecher ist wie die bereits gespielte Fuenflng Strasse, Stich erfolgreich
				else if(Debug.makeSymbolicBoolean("x30")){
				}
				
				//Wenn es keine gueltige Kombination ist, wird dem Spieler eine Nachricht gesendet das der Zug ungueltig ist
				else{
				}
					
			
				
			//Falls noch keine FeldKarten ausgespielt wurden muss nur die Ausspiellogik betrachtet werden	
			}else{
				//Alle Kontrollen werden durchgefuehrt ob es gueltig auszuspielende Karten sind
				//Wenn die Karte eine einzelkarte ist dann Spiel sie aus
				if(Debug.makeSymbolicBoolean("x31")){
					
				}
				
				//Wenn die Karten eine Bombe sind
				else if(Debug.makeSymbolicInteger("x32") > 0){
				}
				//Wenn die Karten ein Paar sind dann Spiel sie aus
				else if(Debug.makeSymbolicBoolean("x33")){
				}
				
				//Wenn die Karten Drillinge sind dann Spiele sie aus
				else if(Debug.makeSymbolicBoolean("x34")){
				}
				
				//Wenn die Karten Vierlinge sind dann Spiele sie aus
				else if(Debug.makeSymbolicBoolean("x35")){
				}
				
				//Wenn die Karten Fuenflinge sind dann Spiele sie aus
				else if(Debug.makeSymbolicBoolean("x36")){
				}
				
				//Wenn die Karten Sechslinge sind dann Spiele sie aus
				else if(Debug.makeSymbolicBoolean("x37")){
				}		
				
				//Wenn die Karten Sieblinge sind dann Spiele sie aus
				else if(Debug.makeSymbolicBoolean("x38")){
				}
				
				//Wenn die Karten Achtlinge sind dann Spiele sie aus
				else if(Debug.makeSymbolicBoolean("x39")){
				}
				
				//Wenn die Karten eine dreier Strasse sind spiele sie aus
				else if(Debug.makeSymbolicBoolean("x40")){
				}
				
				//Wenn die Karten eine vierer Strasse sind spiele sie aus
				else if(Debug.makeSymbolicBoolean("x41")){
				}
				
				//Wenn die Karten eine fuenfer Strasse sind spiele sie aus
				else if(Debug.makeSymbolicBoolean("x42")){
				}
				
				//Wenn die Karten eine sechser Strasse sind spiele sie aus
				else if(Debug.makeSymbolicBoolean("x43")){
				}
				
				//Wenn die Karten eine siebner Strasse sind spiele sie aus
				else if(Debug.makeSymbolicBoolean("x44")){
				}
				
				//Wenn die Karten eine achter Strasse sind spiele sie aus
				else if(Debug.makeSymbolicBoolean("x45")){
				}
				
				//Wenn die Karten eine neuner Strasse sind spiele sie aus
				else if(Debug.makeSymbolicBoolean("x46")){
				}
				
				//Wenn die Karten eine zehner Strasse sind spiele sie aus
				else if(Debug.makeSymbolicBoolean("x47")){
				}
				
				//Wenn die Karten eine elfer Strasse sind spiele sie aus
				else if(Debug.makeSymbolicBoolean("x48")){
				}
				
				//Wenn die Karten eine zwoelfer Strasse sind spiele sie aus
				else if(Debug.makeSymbolicBoolean("x49")){
				}
				
				//Wenn die Karten eine Paar Strasse ist spiele sie aus
				else if(Debug.makeSymbolicBoolean("x50")){
				}
				
				//Wenn die Karten eine Drilling Strasse ist spiele sie aus
				else if(Debug.makeSymbolicBoolean("x51")){
				}
				
				//Wenn die Karten eine Vierling Strasse ist spiele sie aus
				else if(Debug.makeSymbolicBoolean("x52")){
				}
				
				//Wenn die Karten eine Fuenfling Strasse ist spiele sie aus
				else if(Debug.makeSymbolicBoolean("x53")){
				}
				
				//Wenn es keine gueltige Kombination ist, wird dem Spieler eine Nachricht gesendet das der Zug ungï¿½ltig ist
				else{
				}
				
				
			}
			
			
		}
	}
	
 	//Methode zum passen eines Spielzuges
	public void passen(){
		
		if(Debug.makeSymbolicBoolean("x0")){
		}
		else if(Debug.makeSymbolicBoolean("x1")){
		}
		
	}
	
	//Methode welche die Nachricht in das ChatFenster schreibt und anschliessend das objekt sendet
	public void schreiben(){
		}
	
	/***************************************************************************************
	Methoden welche zur Hilfe benutzt werden und oft aufgerufen werden
	****************************************************************************************/
	//Macht alle Buttons sichtbar
	public void buttonsSichtbar(){
		for(int i = 0; i<Debug.makeSymbolicInteger("x0");i++){
		}
		for(int i = 0;i<Debug.makeSymbolicInteger("x1");i++){
		} 
	}
	
	//Methode welche alle Karten in der mitte visuel loescht
	public void kartenFeldLoeschen(){
		
		for(int i = 0; i < Debug.makeSymbolicInteger("x0"); i++){
		}
		
	}
	
	//Methode welche alle Borders der buttons zurÃ¼cksetzt
 	public void keinBorder(){
 		//Schlaufe fuer die Jokerkarten
 		for(int i = 0;i<3;i++){
			if(Debug.makeSymbolicBoolean("x0")){
			}
		}
		//Schlaufe fuer die Handkartn
		for(int i = 3;i<17;i++){
			if(Debug.makeSymbolicBoolean("x1")){

			}
		}
 	}
 	
 	//Setzt den Wert und die Punkte der Karten auf 0 wenn ausgespielt, dient zur Kontrolle ob Handkarten leer am Ende
 	private void karteLoeschen(){
 		
 		//Schlaufe für die JokerKarten
 		for(int i = 0;i<3;i++){
 			//Ueberpruefung welche sicherstellt das nur der Wert von ausgewählten Karten auf 0 gesetzt wird
			if(Debug.makeSymbolicBoolean("x0")){
				//Die ausgespielte Karte wird auf null gesetzt, weil wir mit diesem Wert Ã¼berprÃ¼fen ob die Handkarten leer sind
				if(Debug.makeSymbolicBoolean("x1")){
				}else{
				}
			}
		}
		//Schlaufe für die restlichen Handkarten
		for(int i = 3;i<17;i++){
			//Ueberpruefung welche sicherstellt das nur der Wert von ausgewählten Karten auf 0 gesetzt wird
			if(Debug.makeSymbolicBoolean("x2")){
				//Ueberpruefung welcher Spieler am Zug ist
				if(Debug.makeSymbolicBoolean("x3")){
				}else{
				}
			}
		}
 	
 	}
 	
	//Methode welche die die Wetten eingiebt
	public void wetten(){
		int wette = 0;
		boolean gueltig = false;
		int eingabe = Debug.makeSymbolicInteger("x0");
		
		//3 Moeglichkeiten zu Wetten gar nicht (0) klein (15) gross (30)
		if(eingabe == 0){
			wette = 0;
			gueltig = true;
		}
		else if(eingabe == 15){
			wette = 15;
			gueltig = true;
		}
		else if(eingabe == 30){
			wette = 30;
			gueltig = true;
		}
		//Falls eine Falsche Wette getätigt wurde muss der Benutzer Informiert werden
		else{
		}
		
		//Ueberpruefung ob Erflogreich Gewettet wurde
		if(gueltig){
			//Falls erfolgreich gewettet wurde müssen Wetten auf den Spieler übertragen werden
			for (int i = 0; i < Debug.makeSymbolicInteger("x1"); i++){
				//Spieltisch immer gleicher name wie Spieler daher kann anhand des Namens Identifiziert werden welche Wette zu Welchem Spieler
				if(Debug.makeSymbolicBoolean("x2")){
					
				}
			}
		}
	}
		
	//Methode welche den Spieler auffordert einen Wert fuer den Joker einzugeben und diese zurï¿½ck gibt
	public int jokerWert(int i){
		int karteWert = 15;
		
		while(true){
			
			boolean kartenStatus = true;
			try{
				karteWert = Debug.makeSymbolicInteger("x0");
			}catch(NumberFormatException e){
				kartenStatus = false;
			}
			if(kartenStatus){
				break;
			}
		}
		
		
		//ï¿½berprï¿½ft um welche Jokerkarte es sich handelt und gibt falls noetig die anweisung einen Richtigen Wert enzugeben = return 0
		if(i==0){
			if(karteWert > 11 || karteWert <2){
				return 0;
			}
		}
		else if(i==1){
			if(karteWert > 12 || karteWert <2){
				return 0;
			}
		}
		else if(i==2){
			if(karteWert > 13 && karteWert <2){
				return 0;
			}
		}
		return karteWert;
	}
	
	//Methode welche den Spieler auffordert eine Farbe fuer den Joker einzugeben und diese zurueck gibt
	public Object jokerFarbe(){
		while(true){
			//ueberprueft ob die eingegeben farbe keine von den zulaessigen ist und teilt die moeglichkeiten dem Benutzer mit
			if(Debug.makeSymbolicBoolean("x0")){
				break;
			}
		}
		
		return new Object();
	}
		
	
	//Funktion welche den Boolean wert wechslet und so sieht ob die Karte gedruckt ist oder nicht 
	public boolean gedruckt(boolean gedruckt){
		if(gedruckt){
			gedruckt = false;
		}
		else if(!gedruckt){
			gedruckt = true;
		}
		return gedruckt;
	}

	//Methode welche die Spiel Buttons disabled oder Enabled je nach dem wer am Zug ist
	public void amZugButtons(boolean amZug){
		
	}
		
	//Methode welche die Informationen des Gegners in den Spieltisch ladet
	public void setGegnerInfos(int hatBube, int hatDame, int hatKoenig){
		
	}
		
	//Methode zum senden des Spielobjektes
	public void sendeGameObjekt(){
		
		try{
		}catch (IOException e) {
		}
			
	}
			

	//Methode zum senden des Chatobjektes
	public void sendeChatObjekt(){
		try{
			}catch (IOException e) {
			}
	}

	
	public void setWette(boolean wette){
	}
	
	public boolean getWette(){
		boolean wette = Debug.makeSymbolicBoolean("x0");
		return wette;
	}
	
	
	
	/***************************************************************************************
	Methoden welche kontrolliert ob die bei einem neuen Hand auszuspielenden Karten legitim 
	sind oder nicht, gibt einen true wert zurueck	
	****************************************************************************************/
	
	
	
	/***************************************************************************************
	Handler welcher fuer das Anwaehlen von Karten zustaendig ist
	****************************************************************************************/
	public class clickHandler{
	}
	
	/***************************************************************************************
	Handler welcher fuer das klicken der Buttons zustaendig ist
	****************************************************************************************/
	
	public class buttonHandler{
	}
}
		
	

	
	
	



