package jellal.mohamed.dam.mp09.uf01.pr2.seguridad.model.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class AESSecurity {


	private static final String ENCRYPT_KEY = "12345678901234567890123456789012";

	public static String encripta(String valorOriginal) {
		String resultado = null;
		try {
			Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(valorOriginal.getBytes("UTF-8"));
			resultado = Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public static String desencripta(String valorEncriptado) {
		String resultado = null;
		try {
			Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(valorEncriptado));
			resultado = new String(decrypted, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
