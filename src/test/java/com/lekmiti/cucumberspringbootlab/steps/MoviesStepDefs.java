package com.lekmiti.cucumberspringbootlab.steps;

import com.lekmiti.cucumberspringbootlab.MovieResource;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration
public class MoviesStepDefs {

    @Autowired
    private MovieResource movieResource;

    @LocalServerPort
    private int port;

    private String SERVER_URL = "http://localhost:";


    private ResponseEntity<String> response;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contexLoads() throws Exception {
        assertThat(movieResource).isNotNull();

    }

    @When("^the client calls \"([^\"]*)\"$")
    public void the_client_calls(String givenUrl){
        assertThat(movieResource).isNotNull();
        String url = new StringBuilder(SERVER_URL).append(port).append(givenUrl).toString();
        response  = this.testRestTemplate.getForEntity(url, String.class);
   }

    @Then("^the client get http code (\\d+)$")
    public void the_client_get_http_code(int givenHttpCode){
        assertThat(response.getStatusCodeValue()).isEqualTo(givenHttpCode);
    }

    @And("the client get the following list of movies:$")
    public void the_client_get_the_following_list_of_movies(List<String> givenMovies){
        givenMovies.forEach(movie -> {
            assertThat(response.getBody()).contains(movie);
        });
    }

    @Then("^the client does not get any movie$")
    public void the_client_does_not_get_any_movie(){
        assertThat(response.getBody()).isNull();
    }


}
