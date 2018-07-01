package com.jrz.bettingsite.event;

import com.jrz.bettingsite.player.PlayerService;
import com.jrz.bettingsite.team.Team;
import com.jrz.bettingsite.team.TeamService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest
public class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @MockBean
    private PlayerService playerService;

    @MockBean
    private TeamService teamService;


    @Test
    public void getAllEvents() throws Exception{

        // before GET Request
        List<Event> events = new ArrayList<Event>(Arrays.asList(
                new Event("Fixture 3: Athletico Madrid - Athletic Bilbao", new Team("Athletico Madrid"), 1.89, new Team("Athletic Bilbao"), 2.03, 1),
                new Event("Fixture 4: Manchester United - Arsenal London", new Team("Manchester United"), 1.35, new Team("Arsenal London"), 3.02, 1)));
        Mockito.when(eventService.findAll()).thenReturn(events);

        //during
        mockMvc.perform(MockMvcRequestBuilders.get("/events")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name",Matchers.is("Fixture 3: Athletico Madrid - Athletic Bilbao")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].home.name",Matchers.is("Athletico Madrid")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].homeOdds",Matchers.is(1.89)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].away.name",Matchers.is("Athletic Bilbao")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].awayOdds",Matchers.is(2.03)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].result",Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name",Matchers.is("Fixture 4: Manchester United - Arsenal London")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].home.name",Matchers.is("Manchester United")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].homeOdds",Matchers.is(1.35)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].away.name",Matchers.is("Arsenal London")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].awayOdds",Matchers.is(3.02)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].result",Matchers.is(1)));

        // after
        Mockito.verify(eventService).findAll();
    }

    @Test
    public void getEventById() {
    }

    @Test
    public void saveEvent() {
    }
}