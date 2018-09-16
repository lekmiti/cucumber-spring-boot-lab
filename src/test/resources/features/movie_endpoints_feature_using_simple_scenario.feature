Feature: movie endpoints feature using simple scenario

  Background: the system must be up
    Given the client calls "/actuator/health"
    Then the client get http code 200
    And  the client get status "UP"

  Scenario: client get all movies
    When the client calls "/movie/all"
    Then the client get http code 200
    And  the client get the following list of movies:
      | Catch me if you can    |
      | Transformers           |
      | Transporter            |

  Scenario: client get movie by index
    When the client calls "/movie/0"
    Then the client get http code 200
    And  the client get the following list of movies:
      | Catch me if you can    |

  Scenario: client get movie by index
    When the client calls "/movie/1"
    Then the client get http code 200
    And  the client get the following list of movies:
      | Transformers    |

  Scenario: client get movie by index
    When the client calls "/movie/2"
    Then the client get http code 200
    And  the client get the following list of movies:
      | Transporter    |

  Scenario: client get movie by index
    When the client calls "/movie/3"
    Then the client get http code 204
    And  the client does not get any movie
