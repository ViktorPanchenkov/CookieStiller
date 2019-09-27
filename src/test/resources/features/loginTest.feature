Feature: Login test

  Scenario Outline: Check that an user fails login with incorrect data

    Given User navigate to the site
    And Navigate login form
    When User enters "<name>" to the login field
    And User enters "<password>" to the password field
    And User presses login button
    Then User sees "<status>" login
    Examples:
      | name                    | password                                                                                                                       | status |
      | angeleclipse3@gmail.com | angele_clip_3                                                                                                                  | failed |
      | Angel                   | angele_clip_3                                                                                                                  | failed |
      | Angel                   | testpass                                                                                                                       | failed |
      |                         | testpass                                                                                                                       | failed |
      | angeleclipse3@gmail.com |                                                                                                                                | failed |
      | angeleclipse3@gmail.com | ]’~<!--@/*$%^&#*/()?>,.*/\\                                                                                                    | failed |
      | angeleclipse3@gmail.com | testpassssssssssssssssssssssssSSSSSSSSSSSSSSSSSSSSSSSsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss | failed |
      | angeleclipse3@gmail.com | s                                                                                                                              | failed |
      | angeleclipse3@gmail.com | пароль                                                                                                                         | failed |
      | angeleclipse3@gmail.com | null                                                                                                                           | failed |
      | angeleclipse3@gmail.com | 12312                                                                                                                          | failed |
      | testpass                | angeleclipse3@gmail.com                                                                                                        | failed |
      | DROP TABLE user;        | testpass                                                                                                                       | failed |
      | chiswtest@i.ua          | CHIsw123                                                                                                                       | passed |