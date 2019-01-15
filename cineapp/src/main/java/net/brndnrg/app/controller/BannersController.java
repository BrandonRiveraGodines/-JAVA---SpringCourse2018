package net.brndnrg.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.brndnrg.app.model.Banner;
import net.brndnrg.app.service.IBannersService;
import net.brndnrg.app.util.Utileria;

@Controller
@RequestMapping("/banners/")
public class BannersController {
	
	@Autowired
	private IBannersService serviceBanners;
	
	/*
	 * M�todo para mostrar el listado de Banners
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Banner> banners = serviceBanners.buscarTodos();
		model.addAttribute("banners", banners);
		return "banners/listBanner";
	}
	
	/*
	 * M�todo para mostrar el formulario apra crear un nuevo Banner
	 * @return
	 */
	@GetMapping("/create")
	public String crear(@ModelAttribute Banner banner) {
		return "banners/formBanner";
	}
	
	/*
	 * M�todo para guardar el objeto de modelo de tipo Banner
	 * @param banner
	 * @param result
	 * @param attributes
	 * @param multiPart
	 * @param request
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(@ModelAttribute Banner banner, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			return "banners/formBanner";
		}
		
		if(!multipart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multipart, request);
			banner.setArchivo(nombreImagen);
		}
		serviceBanners.insertar(banner);
		attributes.addFlashAttribute("mensaje", "El registro fue guardado");
		return "redirect:/banners/index";
	}
	
	/*
	 * Metodo para buscar un banner por Id para enviarlo al formulario para edici�n
	 * @param idBanner
	 * @param model
	 * @return
	 */
	@GetMapping(value="/edit/{id}")
	public String editar(@PathVariable("id") int idBanner, Model model) {
		Banner banner = serviceBanners.buscarPorId(idBanner);
		model.addAttribute("banner", banner);
		return "banners/formBanner";
	}
	
	/*
	 * Metodo para eliminar un registro de un banner
	 */
	@GetMapping(value="/delete/{id}")
	public String eliminar(@PathVariable("id") int idBanner, RedirectAttributes attributes) {
		serviceBanners.eliminar(idBanner);
		attributes.addFlashAttribute("msg", "El banner fue eliminado");
		return "redirect:/banners/index";
	}
	
	
	
}
