package com.jrz.bettingsite.event;

import com.jrz.bettingsite.team.Team;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToOne(fetch = FetchType.EAGER)
    private Team home;
    private double homeOdds;
    @OneToOne(fetch = FetchType.EAGER)
    private Team away;
    private double awayOdds;
    @NotFound(action = NotFoundAction.IGNORE)
    private int result;

    public Event(){

    }

    public Event(long id, String name, Team home, double homeOdds, Team away, double awayOdds, int result) {
        this.id = id;
        this.name = name;
        this.home = home;
        this.homeOdds = homeOdds;
        this.away = away;
        this.awayOdds = awayOdds;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", home=" + home +
                ", homeOdds=" + homeOdds +
                ", away=" + away +
                ", awayOdds=" + awayOdds +
                ", result=" + result +
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

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public double getHomeOdds() {
        return homeOdds;
    }

    public void setHomeOdds(double homeOdds) {
        this.homeOdds = homeOdds;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public double getAwayOdds() {
        return awayOdds;
    }

    public void setAwayOdds(double awayOdds) {
        this.awayOdds = awayOdds;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
