import gov.nasa.jpf.symbc.Debug;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

//Diese Klasse enthaelt die Logik eines Deckes
public class Deck {
	
	
	//Konstruktor welche ein Deck mit allen 54 Karten vom Typ Card erstellt
	public Deck(){
		
		int kartenHoehe = Debug.makeSymbolicInteger("x3");
		int kartenBreite = Debug.makeSymbolicInteger("x2");
		double width = Debug.makeSymbolicReal("x0");
		 double height = Debug.makeSymbolicReal("x1");
		
		if(height > 1000 && width > 1300){
			 kartenBreite = 100;
			 kartenHoehe = 150;
		}
		
	}
	
	//Methode welche die Karten nach den Regeln auf zwei Spieler aufteilt
	public void aufteilen(int anzahl){
		
		
		
		
		
		boolean spieler1 = Debug.makeSymbolicBoolean("x9");
		//Zwei Spieler aufteilung
		if(anzahl==2){
			
			int j = 0;
			while(j < Debug.makeSymbolicInteger("x0")){
				
				if(Debug.makeSymbolicBoolean("x1")){
					if(Debug.makeSymbolicBoolean("x2")){
					}
				}
				else{
					j++;
				}
			}
			
			//Schleife welche einen Buben entfernt
			for(int i =0;i<Debug.makeSymbolicInteger("x3");i++){
				if(Debug.makeSymbolicBoolean("x4")){
					break;
				}
			}
			//schleife welche eine Dame entfernt
			for(int i =0;i<Debug.makeSymbolicInteger("x5");i++){
				if(Debug.makeSymbolicBoolean("x6")){
					break;
				}
			}
			//Schleife welche einen Koenig entfernt
			for(int i =0;i<Debug.makeSymbolicInteger("x7");i++){
				if(Debug.makeSymbolicBoolean("x8")){
					break;
				}
			}
			


			//While Schleife welche beiden Spielern einen Buben gibt
			int k = 0;
			while(true){
				if(spieler1){
					if(Debug.makeSymbolicBoolean("x10")){
						spieler1 = false;
						k--;
					}
				}
				else if(!spieler1){
					if(Debug.makeSymbolicBoolean("x11")){
						spieler1 = true;
						break;
					}
				}
				k++;
			}

			//While Schleife welche beiden Spielern eine Dame gibt
			k = 0;
			while(true){
				if(spieler1){
					if(Debug.makeSymbolicBoolean("x12")){
						spieler1 = false;
						k--;
					}
				}
				else if(!spieler1){
					if(Debug.makeSymbolicBoolean("x13")){
						spieler1 = true;
						break;
					}
				}
				k++;
			}
			
			//While Schleife welche beiden Spielern einen Koenig gibt
			k = 0;
			while(true){
				if(spieler1){
					if(Debug.makeSymbolicBoolean("x14")){
						spieler1 = false;
						k--;
					}
				}
				else if(!spieler1){
					if(Debug.makeSymbolicBoolean("x15")){
						spieler1 = true;
						break;
					}
				}
				k++;
			}
			
			
			//Schleife in der 14 mal eine Zufallszahl gemacht wird zwischen

			
			for(int i = 0; i<28;i++){
				//Variable welche dafuer sorgt das die Karten abwechselnd verteilt werden
				
				
				int decZufallZahl = Debug.makeSymbolicInteger("x17");
				int zufallsZahl = Debug.makeSymbolicInteger("x18") - 1;
				if(spieler1){
					spieler1 = false;
				}
				else if(!spieler1){
					spieler1=true;
				}
				
			}
			for (int i = 0; i < 3; i++){
			}
			
			for (int i = 0; i < 3; i++){
			}

		}
		
		
		//Drei Spieler aufteilung
		else if(anzahl==3){
			
		}
	}
	
	//Getters und Setters
	public Object getHandKarten1(){
		return new Object();
	}
	
	public Object getHandKarten2(){
		return new Object();
	}
	
	public Object getHand(int i){
		return new Object();
	}
	
	public Object getHaeggis(){
		return new Object();
	}
	
}
