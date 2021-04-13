package com.ericvuu.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ericvuu.lookify.models.Song;
import com.ericvuu.lookify.repositories.SongRepository;

@Service
public class SongService {
	// adding the song repository
	private final SongRepository songRepository;
	
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	public List<Song> searchByArtist(String artist){
		List<Song> songs = songRepository.findByArtist(artist);
		return songs;
	}
	
	public List<Song> topTenRating(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	public Song createSong(Song song) {
		return songRepository.save(song);
	}
	
	public void removeSong(Long id) {
		songRepository.deleteById(id);
	}
}
