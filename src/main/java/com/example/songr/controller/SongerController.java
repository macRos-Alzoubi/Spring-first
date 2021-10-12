package com.example.songr.controller;

import com.example.songr.model.Album;
import com.example.songr.repository.AlbumRepository;
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

    @PostMapping("/albums")
    public RedirectView createNewAlbum(@ModelAttribute Album album) {
        albumRepository.save(album);
        return new RedirectView("albums");
    }

    @GetMapping("/albums")
    public String getAlbums(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "albumsPage";
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