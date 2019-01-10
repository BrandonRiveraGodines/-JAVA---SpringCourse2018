package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.brndnrg.app.model.Noticia;
import net.brndnrg.app.repository.NoticiasRepository;

public class AppDelete {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		int idNoticia = 31;
		Optional<Noticia> optional = repo.findById(idNoticia);
		if(optional.isPresent()) {
			repo.deleteById(idNoticia);
		} else {
			System.out.println("No hay registros con ese ID");
		}
		context.close();
	}

}
