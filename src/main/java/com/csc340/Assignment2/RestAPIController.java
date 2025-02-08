package com.csc340.Assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class RestAPIController {


    /**
     * Get info about a YuGiOh card from the YGOProDeck API.
     *
     * @param cardName
     * @return a card object
     */
    @GetMapping("/card")
    public Object getCard(@RequestParam(value = "name", defaultValue = "Dark Magician") String cardName) {
        try {
            String url ="https://db.ygoprodeck.com/api/v7/cardinfo.php?name=" + cardName;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse =restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            Card card = new Card(root.get("data").get(0).get("name").asText(), root.get("data").get(0).get("type").asText(),
                    root.get("data").get(0).get("atk").asInt(), root.get("data").get(0).get("def").asInt(), root.get("data").get(0).get("level").asInt());
            return card;

        }   catch (JsonProcessingException ex){
            Logger.getLogger(RestAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return "error in /card";
        }
    }
}
