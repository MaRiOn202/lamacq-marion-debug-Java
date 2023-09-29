package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class AnalyticsCounter {
	public static int headacheCount = 0;
	public static int rashCount = 0;
	public static int pupilCount = 0;

	public static void main(String args[]) throws Exception {

		//1er constat = pas de gestion des exceptions
		//Création d'une MAP (clef-valeur) un symptome = nbre occurence --- fichier result.out à générer
		//


		try {
			// Création d'un fielReader pour lire le fichier .txt
			FileReader fileReader = new FileReader("symptoms.txt");

			//Création d'un bufferedReader qui utilise le fileReader
			BufferedReader reader = new BufferedReader(fileReader);

			String line = reader.readLine();

			int i = 0;	// set i to 0
			int headCount = 0;	// counts headaches
			while (line != null) {
				i++;	// increment i
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headCount++;
					System.out.println("number of headaches: " + headCount);
				}
				else if (line.equals("rush")) {
					rashCount++;
				}
				else if (line.contains("pupils")) {
					pupilCount++;
				}

				line = reader.readLine();
			}

			// next generate output
			FileWriter writer = new FileWriter ("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found Exception");
		}




	}
}
