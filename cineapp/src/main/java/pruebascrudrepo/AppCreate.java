package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.brndnrg.app.model.Noticia;
import net.brndnrg.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		Noticia noticia = new Noticia();
		noticia.setTitulo("Esperemos que esta cosa funcione");
		noticia.setDetalle("Esto es una prueba de la creación de una noticia con Spring, esperemos en Diosito que si funcione");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		repo.save(noticia);
		context.close();
	}

}
