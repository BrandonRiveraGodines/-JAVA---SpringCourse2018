package pruebasquery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.brndnrg.app.model.Noticia;
import net.brndnrg.app.repository.NoticiasRepository;

public class AppKeywordOr {

	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//List<Noticia> lista = repo.findByEstatus("Inactiva");
		List<Noticia> lista = repo.findByEstatusOrFecha("Inactiva" ,sdf.parse("2017-09-01"));
		for(Noticia n : lista) {
			System.out.println(n);
		}
		context.close();
	}

}
