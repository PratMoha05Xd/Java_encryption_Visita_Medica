package jellal.mohamed.dam.mp09.uf01.pr2.seguridad.model.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SHA256Security {

	private static final Logger LOGGER = Logger.getLogger(SHA256Security.class.getName());

	public String encripta(String valorOriginal) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(valorOriginal.getBytes());
			byte[] digestBytes = md.digest();

			StringBuilder sb = new StringBuilder();
			for (byte b : digestBytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			LOGGER.log(Level.SEVERE, "Error al calcular SHA-256", e);
			return null;
		}
	}
}
