package com.bottle.domain;

public class Song {
    private Integer id;
    private String singer;
    private String title;
    private String lyric;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSinger() {
        return this.singer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getLyric() {
        return this.lyric;
    }
}
