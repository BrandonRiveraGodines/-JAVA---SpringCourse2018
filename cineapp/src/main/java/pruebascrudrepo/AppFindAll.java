package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.brndnrg.app.model.Noticia;
import net.brndnrg.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		Iterable<Noticia> iterable = repo.findAll();
		for(Noticia n : iterable) {
			System.out.println(n);
		}
		context.close();
	}

}
