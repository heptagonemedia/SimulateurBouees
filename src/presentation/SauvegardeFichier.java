package presentation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import donnee.PointDonnee;

public class SauvegardeFichier {
	public static void sauvegarder(String nomDuFichier, ArrayList<PointDonnee> contenu) {
		
		String graphiqueSel, graphiqueTemp, graphiqueDebit;
		
		graphiqueSel = graphiqueDebit = graphiqueTemp = "<?xml version=\"1.0\"?><graph><plot>";
		int x = 0;
		
		for(PointDonnee p : contenu) {
			graphiqueSel += "<point x='" + x + "' y='" + p.getSalinite() + "'/>";
			graphiqueTemp += "<point x='" + x + "' y='" + p.getTemperature() + "'/>";
			graphiqueDebit += "<point x='" + x + "' y='" + p.getDebit() + "'/>";
			x++;
		}
		
		graphiqueSel += "</plot></graph>";
		graphiqueTemp += "</plot></graph>";
		graphiqueDebit += "</plot></graph>";
		
		try (FileWriter writer = new FileWriter(nomDuFichier + ".sel.xml");
				BufferedWriter bw = new BufferedWriter(writer)) {

			bw.write(graphiqueSel);
		}
		catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		try (FileWriter writer = new FileWriter(nomDuFichier + ".temp.xml");
				BufferedWriter bw = new BufferedWriter(writer)) {

			bw.write(graphiqueTemp);
		}
		catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		try (FileWriter writer = new FileWriter(nomDuFichier + ".debit.xml");
				BufferedWriter bw = new BufferedWriter(writer)) {

			bw.write(graphiqueDebit);
		}
		catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}
}
