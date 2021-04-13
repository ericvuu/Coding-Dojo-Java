package com.ericvuu.lookify.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ericvuu.lookify.models.Song;
import com.ericvuu.lookify.services.SongService;

@Controller
public class SongController {

	private final SongService songService;

	public SongController(SongService songService) {
		this.songService = songService;
	}

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/dashboard")
	public String dashboard(Song song, Model model) {
		List<Song> allSongs = songService.allSongs();
		model.addAttribute("songs", allSongs);
		return "dashboard.jsp";
	}

	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}

	@RequestMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) {
		songService.removeSong(id);
		return "redirect:/dashboard";
	}

	@RequestMapping("/search/topTen")
	public String showTopTen(Model model) {
		List<Song> songs = songService.topTenRating();
		model.addAttribute("songs", songs);
		return "topTen.jsp";
	}
	
	@RequestMapping("/search")
	public String searchArtist(@RequestParam(value="artist", required=false) String artist, Model model, RedirectAttributes redirectAttributes) {
		List<Song> songs = songService.searchByArtist(artist);
		if(songs.size() < 1) {
			redirectAttributes.addFlashAttribute("error", "There are no songs available for this artist.");
			return "redirect:/dashboard";
		} else {
			model.addAttribute("songs", songs);
			return "artist-songs.jsp";
		}
	}

}
