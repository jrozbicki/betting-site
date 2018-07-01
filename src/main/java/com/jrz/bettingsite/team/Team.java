package com.jrz.bettingsite.team;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jrz.bettingsite.event.Event;
import com.jrz.bettingsite.player.Player;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Player> players;
    @ManyToMany
    private List<Event> events;

    public Team(){

    }

    public Team(String name){
        this.name = name;
    }

    public Team(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Team(Long id, String name, List<Player> players, List<Event> events) {
        this.id = id;
        this.name = name;
        this.players = players;
        this.events = events;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // to avoid infinite recursion between Team and Player
    @JsonIgnore
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    // to avoid infinite recursion between Team and Event
    @JsonIgnore
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
