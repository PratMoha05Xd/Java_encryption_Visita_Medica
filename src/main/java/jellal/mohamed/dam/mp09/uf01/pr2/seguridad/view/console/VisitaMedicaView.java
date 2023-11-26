package jellal.mohamed.dam.mp09.uf01.pr2.seguridad.view.console;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import jellal.mohamed.dam.mp09.uf01.pr2.seguridad.model.domain.VisitaMedica;

public class VisitaMedicaView {

	public VisitaMedica getVisitaMedica() {
		VisitaMedica visita = new VisitaMedica();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introdueixi l'ID de la visita: ");
		visita.setIdVisita(scanner.nextInt());

		System.out.print("Introdueixi el nom del pacient: ");
		visita.setNomPaciente(scanner.next());

		System.out.print("Introdueixi el nom del metge: ");
		visita.setNomMetge(scanner.next());

		System.out.print("Introdueixi la data (format yyyy-MM-dd): ");
		String data = scanner.next();
		try {
			LocalDate fecha = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			visita.setFecha(fecha);
		} catch (DateTimeParseException e) {
			System.err.println("Format de data incorrecte");
		}

		System.out.print("Introdueixi el diagnòstic: ");
		scanner.nextLine();
		visita.setDiagnostico(scanner.nextLine());

		return visita;
	}

	public void showMissatge(String missatge, boolean esError) {
		if (esError) {
			System.err.println(missatge);
		} else {
			System.out.println(missatge);
		}
	}
}
