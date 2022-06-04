package com.bottle.controller;

import com.bottle.domain.Song;
import com.bottle.domain.User;
import com.bottle.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;

    @RequestMapping("/randomSong.do")
    @ResponseBody
    public Song queryUser() {
        Song song = songService.randomSong();
        return song;
    }
}
