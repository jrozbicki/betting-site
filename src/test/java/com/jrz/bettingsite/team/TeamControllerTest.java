package com.jrz.bettingsite.team;

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
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = TeamController.class, secure = false)
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;

    @Test
    public void findById() throws Exception {

        // before findById GET
        Team team = new Team((long) 1,"Real Madrid");
        Mockito.when(teamService.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(team));

        // during
        mockMvc.perform(MockMvcRequestBuilders.get("/teams/1")
                    .contentType(MediaType.APPLICATION_JSON)
        )
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Real Madrid")))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.*",Matchers.hasSize(2)));

        //after
        Mockito.verify(teamService).findById(Mockito.anyLong());
    }

    @Test
    public void findAll() throws Exception {

        // before findAll GET
        List<Team> teams = new ArrayList<Team>(Arrays.asList(
                new Team((long) 1,"Real Madrid"),
                new Team((long) 2,"Barcelona"),
                new Team((long) 3,"Athletico Madrid")));
        Mockito.when(teamService.findAll()).thenReturn(teams);

        // during
        mockMvc.perform(MockMvcRequestBuilders.get("/teams")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("Real Madrid")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].*",Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("Barcelona")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].*",Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id", Matchers.is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].name", Matchers.is("Athletico Madrid")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].*",Matchers.hasSize(2)));

        // after
        Mockito.verify(teamService).findAll();
    }

    @Test
    public void saveTeam() throws Exception {

        // before saveTeam POST
        Team team = new Team((long) 1,"Real Madrid");
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"Real Madrid\"\n" +
                "}";
        Mockito.doNothing().when(teamService).saveTeam(Mockito.any(Team.class));

        // during
        mockMvc.perform(MockMvcRequestBuilders.post("/teams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());

        // after
        Mockito.verify(teamService).saveTeam(Mockito.any(Team.class));
    }
}