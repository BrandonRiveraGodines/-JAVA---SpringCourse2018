package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.brndnrg.app.repository.NoticiasRepository;

public class AppExists {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		int idNoticia = 200;
		System.out.println(repo.existsById(idNoticia));
		context.close();
	}

}
