Feature: retrieve all movies
  Scenario: client get all movies
    When the client calls "/movie/all"
    Then the client get http code 200
    And  the client get the following list of movies:
    | Catch me if you can    |
    | Transformers           |
    | Transporter            |