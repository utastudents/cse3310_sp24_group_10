package uta.cse3310;

import java.util.ArrayList;
import java.util.List;

public class Chat{
  ArrayList<String> messages = new ArrayList<>();

  public void addMessage(String message){
    messages.add(message);
  }
  // public List<String>getMessages(){
  //   return messages;
  // }
}
