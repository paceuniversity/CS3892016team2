  package com.vinacovre.myapplication;

  /**
   * Created by Ryan Faranda on 4/10/2016.
   */
  public class Player {
      int playerId;
      String playerName;
      int playerAge;
      String playerAdress;
      String playerSkill;
      //Create a basic profile for the player, I am refering to the user as a player, for demo purposes this
      //Info will be filled out before hand, this will just allow us to add a join group and event functionality
      //and will also allow me to just have some people to add for my adding to database create championship
      //class ie; one attribute in the firebase for championships is player names, and I have a object for the
      // Championship, so I want to be able to create an array of type players, so that I can have player objects
      //To display in the player list, this is low prioity but I want to at least have the constructor set up
      //Correctly so that way I dont have to re think this thought process of creating the data types for the project
      //Unless I have to do gorups then whatever

      public void Player(String n, String a, String s)
      {

          playerName = n;
          playerAdress = a;
          playerSkill = s;
      }

      public int getPlayerId()
      {
          return playerId;
      }

      public String getPlayerName()
      {
          return(playerName);
      }




      public String getPlayerAdress()
      {
          return playerAdress;
      }

      public String getPlayerSkill()
      {
          return playerSkill;
      }




      public void setPlayerAdress(String a){playerAdress = a;}

      public void setPlayerName(String n)
      {
          playerName = n;

      }


      public void setPlayerSkill(String s)
      {
          playerSkill = s;
      }
  }

