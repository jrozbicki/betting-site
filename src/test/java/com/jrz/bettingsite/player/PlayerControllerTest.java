package com.jrz.bettingsite.player;

import com.jrz.bettingsite.team.Team;
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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = PlayerController.class, secure = false)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;


    @Test
    public void getAllPlayers() throws Exception{
        // before GET request
        List<Player> players = new ArrayList<Player>(Arrays.asList(
           new Player("Cristiano Ronaldo"),
           new Player("Leonel Messi"),
           new Player("Paul Pogba")
        ));

        Mockito.when(playerService.findAll()).thenReturn(players);

        // during
        mockMvc.perform(MockMvcRequestBuilders.get("/players")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name",Matchers.is("Cristiano Ronaldo")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name",Matchers.is("Leonel Messi")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].name",Matchers.is("Paul Pogba")));

        // after
        Mockito.verify(playerService).findAll();
    }

    @Test
    public void findById() throws Exception{
        // before GET request
        Player player = new Player("Cristiano Ronaldo");

        Mockito.when(playerService.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(player));

        // during
        mockMvc.perform(MockMvcRequestBuilders.get("/players/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Matchers.is("Cristiano Ronaldo")));

        // after
        Mockito.verify(playerService).findById(Mockito.anyLong());
    }

    @Test
    public void savePlayer() throws Exception{

        // before saveTeam POST
        Player player = new Player("Cristiano Ronaldo");
        String json = "{\n" +
                "  \"name\": \"Cristiano Ronaldo\"\n" +
                "}";
        Mockito.doNothing().when(playerService).savePlayer(Mockito.any(Player.class));

        // during
        mockMvc.perform(MockMvcRequestBuilders.post("/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());

        // after
        Mockito.verify(playerService).savePlayer(Mockito.any(Player.class));
    }
}