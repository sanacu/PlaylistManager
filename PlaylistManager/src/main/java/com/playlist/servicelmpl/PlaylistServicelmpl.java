package com.playlist.servicelmpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playlist.domain.Playlist;



public interface PlaylistServicelmpl extends JpaRepository<Playlist, Long> {

}
