package com.example.songr.controller;

import com.example.songr.model.Album;
import com.example.songr.model.Song;
import com.example.songr.model.songDTO.SongDTO;
import com.example.songr.repository.AlbumRepository;
import com.example.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SongerController {

    @Autowired
    private AlbumRepository albumRepository;

    private final SongRepository songRepository;

    public SongerController(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @PostMapping("/albums")
    public RedirectView createNewAlbum(@ModelAttribute Album album) {
        albumRepository.save(album);
        return new RedirectView("songs/addSong");
    }

    @GetMapping("/albums")
    public String getAlbums(Model model) {
//        model.addAttribute("albums", albumRepository.findAll());
        return "albumsPage";
    }

    @GetMapping("/songs")
    public String getSongs(Model model){
        List<Song> songs = songRepository.findAll();
        model.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("/songs/addSong")
    public String addSong(){
        return "addSong";
    }

    @GetMapping("/songs/album/{album}")
    public String getSongsByAlbum(@PathVariable String album, Model model){
        List<Song> songs = songRepository.findAllByAlbum_Title(album).orElseThrow();
        model.addAttribute("songs", songs);
        return "songs";
    }

    @PostMapping("/songs")
    public RedirectView createNewSong(@ModelAttribute SongDTO songDTO){
        Album album = albumRepository.findAuthorByTitle(songDTO.getAlbum()).orElseThrow();
        Song newSong = new Song(songDTO.getTitle(), songDTO.getLength(), songDTO.getTrackNumber(), album);
        songRepository.save(newSong);
        return new RedirectView("songs");
    }

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("helloWold", "HelloWold");
        return "helloworld";
    }

    @GetMapping("/capitalize/{capital}")
    public String capitalize(@PathVariable String capital, Model model) {
        capital = capital.toUpperCase();
        model.addAttribute("capital", capital);
        return "capitalized";
    }

}