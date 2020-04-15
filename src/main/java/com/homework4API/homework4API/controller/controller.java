package com.homework4API.homework4API.controller;

import com.homework4API.homework4API.Models.ChuckJokesRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

//This class is assigned as the controller for the application:
@Controller
public class controller{

    @Autowired
    ChuckJokesRepo chuckJokesRepo;

    //Functions to connect to and view the desired data of the API Call:
    @RequestMapping("/")
    public ModelAndView Home() {

        ModelAndView model = new ModelAndView("index");
        String jokeString = "";
        String jokeNumber = "";
        String completeJoke = "";
        String apikey = "3a3a558e3cmsha8488d7d8a67788p1f89b2jsn3640a3ddfbb6";

        //Try/Catch statement to test the API Call connection:
        try {
            URL url = new URL("https://matchilling-chuck-norris-jokes-v1.p.rapidapi.com/jokes/random");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-rapidapi-host", "matchilling-chuck-norris-jokes-v1.p.rapidapi.com");
            connection.setRequestProperty("x-rapidapi-key", apikey);
            connection.setRequestProperty("accept", "application/json");
            connection.connect();
            BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null){
                json.append(line);
            }
            //Adds desired JSON objects from the API Call to each variable and then concatenates them to display to the user:
            JSONObject obj = new JSONObject(json.toString());
            jokeString = obj.getString("value");
            jokeNumber = obj.getString("id");
            completeJoke = "Joke ID: "+ jokeNumber + " " +
                    "\n" + "\n" + "Joke: " + jokeString;
            }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        model.addObject("jokeslist", chuckJokesRepo.findAll());
        model.addObject("joke", completeJoke);
        return model;
    }


}