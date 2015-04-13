package cl.usach.lab1.utils;

import java.util.ResourceBundle;

public class Configuraciones {
	/**
	 * Metodo para obtener configuraciones desde archivo .properties
	 * 
	 * @param key nombre de la propiedad a obtener.
	 * @return valor.
	 */
	public static String getConfig(String key) {
		ResourceBundle mainConf = ResourceBundle.getBundle("mainConfig");
		String ambiente = mainConf.getString("ambiente");
		ResourceBundle cfg = ResourceBundle.getBundle(ambiente);
		return cfg.getString(key);
	}
}
