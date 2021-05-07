package com.playlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.playlist.domain.Playlist;
import com.playlist.service.PlaylistService;


@Controller
public class AppController {

	@Autowired
	private PlaylistService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Playlist> listPlaylist = service.listAll();
		model.addAttribute("listPlaylist", listPlaylist);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String newPlaylistDetails(Model model) {
		Playlist playlist = new Playlist();
		model.addAttribute("playlist", playlist);
		
		return "create_playlist";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePlaylistDetails(@ModelAttribute("playlist") Playlist playlist) {
		service.save(playlist);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editPlaylistDetails(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_playlist");
		Playlist playlist = service.get(id);
		mav.addObject("playlist", playlist);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePlaylistDetails(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}
