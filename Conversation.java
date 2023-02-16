import java.util.Scanner;
import java.util.Random;

public class Conversation {
   /**
    * This chat bot will generate statements in response to the user's input
    * @param args command line argument
    * @return chatbot returns a response based upon the user's input
 **/

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in); // This creates a Scanner object to read the user's input
      Random rand = new Random(); // This creates a Random object to generate random numbers which will randomly select a canned response


      String userInput; // This variable will store the user's input
      String mirrored; //This variable will store the mirrored responses
      
      String[] cannedResponses = { // This array stores the canned responses
         "Interesting, tell me more.",
         "That's great!",
         "Wow, I never thought about it that way.",
         "Can you elaborate on that?",
         "I see. What else?",
         "Super cool!",
         "Oh wow!",
         "Fascinating!"
      };

      System.out.println("\nWelcome!\n"); // This prints out a Welcome message
      System.out.print("How many rounds of conversation would you like to have?\n"); // This prints a message which asks the user how many rounds of conversation they want to have

      int rounds = input.nextInt(); // This scans the user's input for the number of rounds
      input.nextLine(); // This makes sure that the scanner is at the beginning of the next line so that it will actually scan the user's first input for the first round of conversation

      String[] transcript = new String[rounds * 2 + 1]; // This array will store the conversation transcript (the size of the array has to be twice the number of rounds in order to take in the user's input and the chat bot's response, plus one for the initial greeting)
      transcript[0] = "Hi there! What's on your mind?"; // This initializes the first element of the transcript with a greeting 
      System.out.println(transcript[0]); // This prints out the greeting

      int index = 0; // This keeps track of the index (the position) in the transcript array and the index(position) starts at 0

      for (int i = 0; i < rounds; i++) { // This begins the conversation loop . i, the loop control variable, is set to 0, which is the starting point of the loop. The loop will continue as long as 'i' is less than the amount of rounds. i++ increments the value of i by 1 each time the loop completes a full iteration.
         userInput = input.nextLine(); // This reads the user's input for the current round

         StringBuilder result = new StringBuilder(); // This creates a StringBuilder object (allows you to manipulate strings) to store the mirrored response
         String[] words = userInput.split(" "); // This splits the user's input into individual words
         boolean first = true; // This checks if a word is the first word the user inputed. This is important since we insert a space character between each word in the mirrored string except for the first word
         for (String word : words) { //This loops over every word in the input
            if (first) {
               first = false;
            } else {
               result.append(' '); // This states if the word is not the first word, append a space to the mirrored response
            }
            switch (word.replaceAll("[^a-zA-Z0-9]+$", "").toLowerCase()) { // Here the switch statement allows us to mirror specific words. It also replaces any non-alphanumeric characters at the end of the word with an empty string. It also converts the words in the switch case statements to lowercase before comparison
               case "i": // If a word matches a "case" then it is set to the "word"
                  word = "you";
                  break; // This exits the switch statement once the match is found
               case "i'm":
                  word = "you're";
                  break;
               case "me":
                  word = "you";
                  break;
               case "am":
                  word = "are";
                  break;
               case "you":
                  word = "I";
                  break;
               case "my":
                  word = "your";
                  break;
               case "your":
                  word = "my";
                  break;
               case "you're":
                  word = "I'm";
                  break;
               case "are":
                  word = "am";
                  break;
            }
            result.append(word); // This appends the mirrored words to the StringBuilder object
         }

         mirrored = result.toString(); // This converts the StringBuilder to a String
         if (mirrored.equals(userInput)) {
            mirrored = cannedResponses[rand.nextInt(cannedResponses.length)];
         } // This states if the transformed mirrored response is the same as the user's input, choose a random canned response instead. This is because we don't want the chatbot to simply echo back the user's original input.

         System.out.println(mirrored); // This prints the mirrored output back to the user
         transcript[++index] = userInput;; // This adds the user's input to the transcript array. The ++index ensures that each new pair of strings is stored in the next available position in the array.
         transcript[++index] = mirrored; // This adds the mirrored output transcript array
      }

      System.out.println("Goodbye!"); // This prints the final goodbye message
      System.out.println(" ");
      System.out.println("--TRANSCRIPT--"); // This prints a string which states "TRANSCRIPT"
      for (int i = 0; i <= index; i++) { // This begins the transcript loop . i, the loop control variable, is set to 0, which is the starting point of the loop. The loop will continue as long as 'i' is less than or equal to the index. i++ increments the value of i by 1 each time the loop completes a full iteration
         System.out.println(transcript[i]); // This loops through the transcript array and prints out each element
      }

      System.out.println("Goodbye!"); // This prints one last goodbye message before exiting the program
   }
}

