package presentation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SauvegardeFichier {
	public static void sauvegarder(String nomDuFichier, String contenu) {
		try (FileWriter writer = new FileWriter("app.log");
				 BufferedWriter bw = new BufferedWriter(writer)) {

				bw.write(contenu);

			} catch (IOException e) {
				System.err.format("IOException: %s%n", e);
			}
	}
}
