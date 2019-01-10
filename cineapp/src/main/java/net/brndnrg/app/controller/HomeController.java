package net.brndnrg.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.brndnrg.app.model.Pelicula;
import net.brndnrg.app.service.IBannersService;
import net.brndnrg.app.service.IPeliculasService;
import net.brndnrg.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IBannersService serviceBanners;
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam(name="fecha") String fecha, Model model) {
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		List<String> listaFechas = Utileria.getNextDays(4);
		model.addAttribute("listaFechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", serviceBanners.buscarTodos());
		System.out.println("Buscando todas las peliculas en exhibición para la Fecha: " + fecha);
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		List<String> listaFechas = Utileria.getNextDays(4);
		model.addAttribute("listaFechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);	
		model.addAttribute("banners", serviceBanners.buscarTodos());
		return "home";
	}
	
	@RequestMapping(value="/detail/{id}/{fechaBusqueda}", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable(name="id") int idPelicula, @PathVariable(name="fechaBusqueda") String fecha) {
		System.out.println("idPelicula:" + idPelicula);
		System.out.println("Fecha: " + fecha);
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		return "detalle";
	}
}
