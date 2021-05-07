package com.playlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playlist.domain.Playlist;
import com.playlist.servicelmpl.PlaylistServicelmpl;


@Service
@Transactional
public class PlaylistService {

	@Autowired
	private PlaylistServicelmpl playlistServicelmpl;
	
	public List<Playlist> listAll() {
		return playlistServicelmpl.findAll();
	}
	
	public void save(Playlist playlist) {
		playlistServicelmpl.save(playlist);
	}
	
	public Playlist get(long id) {
		return playlistServicelmpl.findById(id).get();
	}
	
	public void delete(long id) {
		playlistServicelmpl.deleteById(id);
	}
}
