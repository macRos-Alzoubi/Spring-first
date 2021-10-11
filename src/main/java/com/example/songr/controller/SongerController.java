package com.example.songr.controller;

import com.example.songr.model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SongerController {

    @GetMapping("/albums")
    public String songsAlbums(Model model) {
        List<Album> albumsList = new ArrayList<>();
        albumsList.add(new Album("Secrite", "One Republic",
                "https://s.mxmcdn.net/images-storage/albums/9/9/8/0/2/0/29020899_800_800.jpg",
                5, 360));
        albumsList.add(new Album("Hall of fame", "The Script",
                "https://i.pinimg.com/originals/06/d9/d1/06d9d1a87fe12ce63c18cdeca29078c8.jpg",
                5, 360));
        albumsList.add(new Album("War Zone", "The Wanted",
                "https://images-na.ssl-images-amazon.com/images/I/61Vdrtp2EeL.jpg",
                5, 360));
        model.addAttribute("songsList", albumsList);
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