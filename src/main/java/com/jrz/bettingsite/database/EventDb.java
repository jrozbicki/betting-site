package com.jrz.bettingsite.database;

import com.jrz.bettingsite.event.Event;

public class EventDb {

    TeamDb teamDb;

    Event match1 = new Event(
            1,
            "Fixture 1 LaLiga",
            teamDb.getRealMadrid(),
            1.44,
            teamDb.getBarcelona(),
            1.66,
            1
    );

    Event match2 = new Event(
            1,
            "Fixture 1 PremierLeague",
            teamDb.getArsenal(),
            1.89,
            teamDb.getTottenham(),
            1.26,
            2
    );

    public Event getMatch1() {
        return match1;
    }

    public void setMatch1(Event match1) {
        this.match1 = match1;
    }

    public Event getMatch2() {
        return match2;
    }

    public void setMatch2(Event match2) {
        this.match2 = match2;
    }
}
