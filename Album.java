package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String name;
    private String artist;
    ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }
    public boolean addToPlayList(int tracker, LinkedList<Song> playlist) {
        int index =tracker-1;
        if((index >= 0) && index <=songs.size()) {
            playlist.add(songs.get(index));
            return true;
        }
        return false;
    }
    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if(song != null) {
            playlist.add(song);
            return true;
        }
        return false;
    }
    private Song findSong(String title) {
       for(int i = 0; i < songs.size(); i++) {
           Song findSong = songs.get(i);
           if(findSong.getTitle().equals(title)){
               return findSong;
           }
       }
        return null;
    }
}
