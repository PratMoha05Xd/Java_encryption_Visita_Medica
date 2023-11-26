package jellal.mohamed.dam.mp09.uf01.pr2.seguridad.controller;

import jellal.mohamed.dam.mp09.uf01.pr2.seguridad.model.domain.VisitaMedica;
import jellal.mohamed.dam.mp09.uf01.pr2.seguridad.model.security.MD5Security;
import jellal.mohamed.dam.mp09.uf01.pr2.seguridad.model.security.AESSecurity;
import jellal.mohamed.dam.mp09.uf01.pr2.seguridad.model.security.SHA256Security;
import jellal.mohamed.dam.mp09.uf01.pr2.seguridad.view.console.VisitaMedicaView;

public class VisitaMedicaController {

	private VisitaMedicaView visitaMedicaView = new VisitaMedicaView();

	public void procesarVisitaMedica() {
		try {
			visitaMedicaView.showMissatge("Introduzca los datos de la visita médica:", false);
			VisitaMedica visita = visitaMedicaView.getVisitaMedica();

			// Aplicar MD5
			MD5Security md5Security = new MD5Security();
			String nomPacienteMD5 = md5Security.encripta(visita.getNomPaciente());
			String diagnosticoMD5 = md5Security.encripta(visita.getDiagnostico());

			// Aplicar SHA256
			SHA256Security sha256Security = new SHA256Security();
			String nomPacienteSHA256 = sha256Security.encripta(visita.getNomPaciente());
			String diagnosticoSHA256 = sha256Security.encripta(visita.getDiagnostico());

			// Aplicar AES
			AESSecurity aesSecurity = new AESSecurity();
			String nomPacienteAESEnc = aesSecurity.encripta(visita.getNomPaciente());
			String diagnosticoAESEnc = aesSecurity.encripta(visita.getDiagnostico());
			String nomPacienteAESDec = aesSecurity.desencripta(nomPacienteAESEnc);
			String diagnosticoAESDec = aesSecurity.desencripta(diagnosticoAESEnc);

			// Mostrar resultados
			visitaMedicaView.showMissatge("Resultados de la encriptación:", false);
			visitaMedicaView.showMissatge("MD5 NomPaciente: " + nomPacienteMD5, false);
			visitaMedicaView.showMissatge("MD5 Diagnostico: " + diagnosticoMD5, false);
			visitaMedicaView.showMissatge("SHA256 NomPaciente: " + nomPacienteSHA256, false);
			visitaMedicaView.showMissatge("SHA256 Diagnostico: " + diagnosticoSHA256, false);
			visitaMedicaView.showMissatge("AES Encriptado NomPaciente: " + nomPacienteAESEnc, false);
			visitaMedicaView.showMissatge("AES Encriptado Diagnostico: " + diagnosticoAESEnc, false);
			visitaMedicaView.showMissatge("AES Desencriptado NomPaciente: " + nomPacienteAESDec, false);
			visitaMedicaView.showMissatge("AES Desencriptado Diagnostico: " + diagnosticoAESDec, false);
		} catch (Exception ex) {
			visitaMedicaView.showMissatge("Error: " + ex.getMessage(), true);
		}
	}
}
