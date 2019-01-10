package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.brndnrg.app.repository.NoticiasRepository;

public class AppCount {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		long num = repo.count();
		System.out.println("Cantidad de registros: " + num + " registros");
		context.close();

	}

}
