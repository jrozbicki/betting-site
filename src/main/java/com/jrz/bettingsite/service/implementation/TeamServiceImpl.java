package com.jrz.bettingsite.service.implementation;

import com.jrz.bettingsite.repository.TeamRepository;
import com.jrz.bettingsite.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;


}
