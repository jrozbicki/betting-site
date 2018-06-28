package com.jrz.bettingsite.team;

import org.hamcrest.Matchers;
import org.junit.Before;
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

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = TeamController.class, secure = false)
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;

    @Before
    public void setUp(){

        Team team = new Team((long) 1,"Real Madrid");
        Mockito.when(teamService.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(team));
    }

    @Test
    public void findById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/teams/1")
                    .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Real Madrid")))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.*",Matchers.hasSize(2)));
    }
}