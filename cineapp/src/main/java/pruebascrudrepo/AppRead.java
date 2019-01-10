package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.brndnrg.app.model.Noticia;
import net.brndnrg.app.repository.NoticiasRepository;

public class AppRead {

	public static void main(String[] args) {
		Noticia noticia = new Noticia();
		noticia.setId(2);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		Optional<?> optional = repo.findById(noticia.getId());
		if(optional.isPresent()) {
			System.out.println(optional.get().toString());
		}
		context.close();

	}

}
