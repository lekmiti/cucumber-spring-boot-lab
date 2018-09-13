Feature: movie endpoints feature using scenario outline

  Scenario: client get all movies
    When the client calls "/movie/all"
    Then the client get http code 200
    And  the client get the following list of movies:
      | Catch me if you can    |
      | Transformers           |
      | Transporter            |

  Scenario Outline:: client get movie by index
    When the client calls "<resourcePath>"
    Then the client get http code <httpCode>
    And  the client get movie "<movie>"

    Examples:
      | resourcePath   | httpCode| movie                |
      | /movie/0       | 200     | Catch me if you can  |
      | /movie/1       | 200     | Transformers         |
      | /movie/2       | 200     | Transporter          |
      | /movie/3       | 204     | null                 |
