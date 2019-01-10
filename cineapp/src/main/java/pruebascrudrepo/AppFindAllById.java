package pruebascrudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.brndnrg.app.model.Noticia;
import net.brndnrg.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		List<Integer> ids = new LinkedList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		Iterable<Noticia> it = repo.findAllById(ids);
		for(Noticia n : it) {
			System.out.println(n);
		}
		context.close();
	}

}
