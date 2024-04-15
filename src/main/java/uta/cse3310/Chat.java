package uta.cse3310;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Chat
{
  List<String> messages = new ArrayList<>();

  public void addMessage(String message)
  {
  }
  public List<String>getMessages()
  {
    return messages;
  }



  private BlockingQueue<String> chatMessages;

  public void TextChat() 
  {
      this.chatMessages = new ArrayBlockingQueue<>(100); // Queue to store chat messages
  }

  // Method to start the chat thread
  public void startChat() 
  {
    Thread chatThread = new Thread(() -> 
    {
      Scanner scanner = new Scanner(System.in);
      try 
      {
        while (true) 
        {
          String message = "<" + player.name + ">" + scanner.nextLine(); // Read user input
          if (message.equalsIgnoreCase("exit")) 
          {
            break; // Exit chat thread if "exit" is entered
          }
          chatMessages.put(message); // Add message to chat queue
        }
      } 
      catch (InterruptedException e) 
      {
        e.printStackTrace();
      } 
      finally 
      {
        scanner.close();
      }
    });
    chatThread.start(); // Start chat thread
  }

  // Method to send a message to the chat
  public void sendMessage(String message) 
  {
    try 
    {
      chatMessages.put(message); // Add message to chat queue
    } 
    catch (InterruptedException e) 
    {
      e.printStackTrace();
    }
  }

  // Method to receive a message from the chat
  public String receiveMessage() 
  {
    try 
    {
      return chatMessages.take(); // Retrieve message from chat queue
    } 
    catch (InterruptedException e) 
    {
      e.printStackTrace();
      return null;
    }
  }

  public static void messagingloop(String[] args) 
  {
    TextChat textChat = new TextChat();
    textChat.startChat(); // Start chat thread

    // Continuous messaging loop
    while (true) 
    {
      // Check if message is available to send
      if (!textChat.chatMessages.isEmpty()) 
      {
        // Send message
        String inputMessage = textChat.chatMessages.poll();
        textChat.sendMessage(inputMessage);

        // Receive message
        String receivedMessage = textChat.receiveMessage();
        System.out.println(receivedMessage);
      }
    }
  }
}

