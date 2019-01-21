package net.brndnrg.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.brndnrg.app.model.Pelicula;
import net.brndnrg.app.service.IDetallesService;
import net.brndnrg.app.service.IPeliculasService;
import net.brndnrg.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private IDetallesService serviceDetalles;
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@GetMapping("/index")
	public String msotrarIndex(Model model) {
		List<Pelicula> lista = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	@GetMapping(value="/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pelicula> lista = servicePeliculas.buscarTodas(page);
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println("Exisistieron errores " + result.getAllErrors());
			return "peliculas/formPelicula";
		}
		
		if(!multipart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multipart, request);
			pelicula.setImagen(nombreImagen);
		}
		System.out.println("Se guardó la pelicula" + pelicula);
		System.out.println("Elementos en la lsita antes de la isnercion " + servicePeliculas.buscarTodas().size());
		serviceDetalles.insertar(pelicula.getDetalle());
		servicePeliculas.insertar(pelicula);
		System.out.println("Elementos en la lista después de la inserción " + servicePeliculas.buscarTodas().size());
		attributes.addFlashAttribute("mensaje", "El registro fue guardado");
		return "redirect:/peliculas/index";
	}
	
	@GetMapping(value="/edit/{id}")
	private String editar(@PathVariable("id") int idPelicula, Model model) {
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
		model.addAttribute("pelicula", pelicula);
		return "peliculas/formPelicula";
	}
	
	@GetMapping(value="/delete/{id}")
	private String eliminar(@PathVariable("id") int idPelicula, RedirectAttributes attributes) {
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
		servicePeliculas.eliminar(idPelicula);
		serviceDetalles.eliminar(pelicula.getDetalle().getId());
		attributes.addFlashAttribute("mensaje", "La pelicula fue eliminada exitosamente");
		return "redirect:/peliculas/index";
	}
	
	@ModelAttribute("generos")
	public List<String> getGeneros(){
		return servicePeliculas.buscarGeneros();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
}
