package com.bottle.service.impl;

import com.bottle.dao.SongDao;
import com.bottle.dao.UserDao;
import com.bottle.domain.Song;
import com.bottle.domain.User;
import com.bottle.service.SongService;
import com.bottle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongDao songDao;

    @Override
    public Song randomSong() {
        return songDao.randomSong();
    }
}
