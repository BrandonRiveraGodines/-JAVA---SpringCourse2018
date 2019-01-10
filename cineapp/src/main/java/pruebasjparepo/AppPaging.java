package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.brndnrg.app.model.Noticia;
import net.brndnrg.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		Page<Noticia> lista = repo.findAll(PageRequest.of(2, 5, Sort.by("titulo")));
		
		for(Noticia n : lista.getContent()) {
			System.out.println(n);
		}
		context.close();

	}

}
