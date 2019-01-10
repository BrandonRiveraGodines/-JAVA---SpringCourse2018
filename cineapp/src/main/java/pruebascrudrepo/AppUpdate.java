package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.brndnrg.app.model.Noticia;
import net.brndnrg.app.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		Optional<Noticia> optional = repo.findById(2);
		if(optional.isPresent()) {
			Noticia noticia = optional.get();
			noticia.setEstatus("Inactiva");
			repo.save(noticia);
		}
		context.close();
	}

}
