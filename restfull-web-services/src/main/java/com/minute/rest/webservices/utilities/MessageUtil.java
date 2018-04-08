package com.minute.rest.webservices.utilities;

/*
* This class prints the given message on console.
*/
public class MessageUtil {
   private String message;

   // Constructor
   // @param message to be printed
   public MessageUtil(String message) {
      this.message = message;
   }

   // prints the message
   public String printMessage() {
      System.out.println(message);
      return message;
   }

   // add "https://falconehrproject3.davita.com" to the message
   public String salutationMessage() {
      message = "falconehrproject3.davita.com" + message;
      System.out.println(message);
      return message;
   }

   // add "www." to the message
   public String exitMessage() {
      message = "https://" + message;
      System.out.println(message);
      return message;
   }
}