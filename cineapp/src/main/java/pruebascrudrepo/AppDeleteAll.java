package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.brndnrg.app.repository.NoticiasRepository;

public class AppDeleteAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		repo.deleteAll();
		context.close();

	}

}
