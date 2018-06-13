package com.jrz.bettingsite.database;

import com.jrz.bettingsite.model.Team;

public class TeamDb {

    private Team realMadrid = new Team(
            1,
            "Real Madrid CF"
    );

    private Team barcelona = new Team(
            2,
            "FC Barcelona"
    );

    private Team arsenal = new Team(
            3,
            "Arsenal FC"
    );

    private Team tottenham = new Team(
            4,
            "Tottenham HotSpurs"
    );

    public Team getRealMadrid() {
        return realMadrid;
    }

    public void setRealMadrid(Team realMadrid) {
        this.realMadrid = realMadrid;
    }

    public Team getBarcelona() {
        return barcelona;
    }

    public void setBarcelona(Team barcelona) {
        this.barcelona = barcelona;
    }

    public Team getArsenal() {
        return arsenal;
    }

    public void setArsenal(Team arsenal) {
        this.arsenal = arsenal;
    }

    public Team getTottenham() {
        return tottenham;
    }

    public void setTottenham(Team tottenham) {
        this.tottenham = tottenham;
    }
}
