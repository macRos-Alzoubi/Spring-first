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

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        System.out.println("in endpoint");
        model.addAttribute("helloWold", "HelloWold");
        return "helloworld";
    }

    @GetMapping("/capitalize/{capital}")
    public String capitalize(@PathVariable String capital, Model model) {
        capital = capital.toUpperCase();
        model.addAttribute("capital", capital);
        return "capitalized";
    }

    @GetMapping("/albums ")
    public String getAlbum(Model model) {
        Album[] albums ={new Album("Secrite", "One Republic",
                "https://static.wikia.nocookie.net/onerepublic8290/images/e/e1/WakingUpIntl.jpg/revision/latest/scale-to-width-down/1000?cb=20160808062819",
                5, 360),
                new Album("Hall of fame", "The Script",
                        "https://www.google.jo/url?sa=i&url=https%3A%2F%2Fwww.pinterest.jp%2Fpin%2F751467887803708946%2F&psig=AOvVaw2UUSUBtpVXiLF6kjC-uXu0&ust=1633972840385000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCJD7sqqtwPMCFQAAAAAdAAAAABAP",
                        5, 360),
                new Album("War Zone", "The Wanted",
                        "https://www.google.jo/url?sa=i&url=https%3A%2F%2Fwww.europosters.eu%2Fposters%2Fthe-wanted-band-v14881&psig=AOvVaw0egm6K1u7xTwR7sgKJCAaB&ust=1633973001813000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCPCasfetwPMCFQAAAAAdAAAAABAD",
                        5, 360)
        };
//        List<Album> albumList = new ArrayList<>();
//        albumList.add();
//        albumList.add();
//        albumList.add();
        model.addAttribute("albums", albums);
        return "albums";
    }
}
