package net.brndnrg.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	public static List<String> getNextDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<>();
		while (!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
	}

	public static String guardarImagen(MultipartFile multipart, HttpServletRequest request) {
		// Obtenemos el nombre original del archivo
		String nombreOriginal = multipart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "_");
		String nombreFinal = randomAlphaNumeric(8).concat(nombreOriginal);
		// Obtenemos la ruta ABSOLUTA del directorio images
		// apache-tomcat/webapps/cineapp/resources/images
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro.
			File imageFile = new File(rutaFinal.concat(nombreFinal));
			// Aquí se guarda fisicamente el archivo en el disco duro.
			multipart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error: ".concat(e.getMessage()));
			return null;
		}
	}
	
	// Metodo apra generar una cadena de longitud N de caracteres aleatorios
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while(count-- != 0) {
			int character = (int)(Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}

}
