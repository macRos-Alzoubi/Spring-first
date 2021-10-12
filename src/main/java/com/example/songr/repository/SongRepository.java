package com.example.songr.repository;

import com.example.songr.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<List<Song>> findAllByAlbum_Title(String title);
}
