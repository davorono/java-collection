import java.util.*;
public class TicTacToe {
 static ArrayList<String> coordinates = new ArrayList<String>(); // List of positions
 
       public static void main(String[] args) {
       // Populate List
       coordinates.add("A1"); coordinates.add("A2"); coordinates.add("A3");
       coordinates.add("B1"); coordinates.add("B2"); coordinates.add("B3"); 
       coordinates.add("C1"); coordinates.add("C2"); coordinates.add("C3");  

      // Get player names
      String userX = "Player 1 (X)"; // placeholder
      String userO = "Player 2 (O)"; // placeholder
      userX = getNames(userX); // get player 1 name
      userO = getNames(userO); // get player 2 name
      // print player names and corresponding X and O
      System.out.print("X:" + userX + " | "); 
      System.out.print("O:" + userO);
      System.out.println();
      // Playing grid
      char [][] grid = {
      //  0    1    2    3    4    5    6    7    8    9    0    1    2    3    4    5    6  
   /*0*/{' ', ' ', ' ', '1', ' ', ' ', ' ', ' ', '2', ' ', ' ', ' ', ' ', ' ', '3', ' ', ' '},
   /*1*/{' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '}, // (Row, Column)
   /*2*/{'A', ' ', ' ', '-', ' ', '|', ' ', ' ', '-', ' ', ' ', '|', ' ', ' ', '-', ' ', ' '}, // A1: (2,3) A2: (2,8) A3: (2,14)
   /*3*/{' ', '_', '_', '_', '_', '|', '_', '_', '_', '_', '_', '|', '_', '_', '_', '_', '_'},
   /*4*/{' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
   /*5*/{'B', ' ', ' ', '-', ' ', '|', ' ', ' ', '-', ' ', ' ', '|', ' ', ' ', '-', ' ', ' '}, // B1: (5,3) B2: (5,8) B3: (5,14)
   /*6*/{' ', '_', '_', '_', '_', '|', '_', '_', '_', '_', '_', '|', '_', '_', '_', '_', '_'},
   /*7*/{' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
   /*8*/{'C', ' ', ' ', '-', ' ', '|', ' ', ' ', '-', ' ', ' ', '|', ' ', ' ', '-', ' ', ' '}, // C1: (8,3) C2: (8,8) C3: (8,14)
   /*9*/{' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '}};
      // Print the initial grid
      for(char[] row : grid) {
         for (char c : row) {
            System.out.print(c);
         }
         System.out.println();
      }
      
      // Game mechanics
      boolean turn = false; // Keep track of turns
      int turnCount = 0;
      while (turnCount < 8) {
         if (turn == false) {
            turnCount++;
            placeSymbol(grid, userX, 'X', userX, userO);
            turn = true;
            // check win for X
            if (win(grid, 'X') == true) {
               System.out.println(userX + " wins!");
               break;
            } 
         }
         if (turn == true) {
            turnCount++;
            placeSymbol(grid, userO, 'O', userX, userO);
            turn = false;   
            // check win for O
            if (win(grid, 'O') == true) {
               System.out.println(userO + " wins!");
               break;
            } 
         }
         if (turnCount > 7) {
            System.out.println("It's a tie!");
         }
     }
   }
      
   
   // Function to check if a string contains illegal characters, credit to Rohit Jain on stack overflow
   public static boolean containsIllegals(String toExamine) {
      String[] arr = toExamine.split("[~#@*+%{}<>\\[\\]|\"\\_^]", 2);
      return arr.length > 1;
   }
    
   // Get player input for both names and store them in some variable with error checking (player 1 is X, player 2 is O)
   public static String getNames(String player) {
      boolean errorCheck1 = false;
      boolean errorCheck2 = false;
      String username = "";
      Scanner console = new Scanner(System.in); // create scanner for input
      System.out.println("Enter " + player + " username: "); // prompt user input for player 1

      do {
      username = console.nextLine(); // read user input for player 1
      
      // Error checking
         if (containsIllegals(username) == true) {
            errorCheck1 = true;
            System.out.println("Error: Invalid characters");
         } else {
            errorCheck1 = false;
         }
         if (username.length() > 9 || username.length() < 1) {
            errorCheck2 = true;
            System.out.println("Error: Maximum user length is 9, minimum user length is 1");
         } else {
            errorCheck2 = false;
         }
      
      } while (errorCheck1 == true || errorCheck2 == true);
      return username;
   }
   
   public static void placeSymbol(char[][] grid, String user, char symbol, String userX, String userO) {
     boolean errorCheck = false; // Track errors    
     do {
     Scanner scan = new Scanner(System.in);
     System.out.print(user + ", Enter your placement using the given coordinates (Format: LETTERNumber. Ex: A1): "); // Prompt player
     String pos = scan.nextLine();
     // Switch/Case for possible inputs
     switch(pos) {
         case "A1":
            if (coordinates.get(0) == "A1") { // Check if coordinate is taken
               grid[2][3] = symbol;
               coordinates.set(0, " "); // Remove coordinate from possible choices
               errorCheck = false;
            } else {
               System.out.println("This coordinate is taken");
               errorCheck = true;
            }
            break;
         case "A2":
            if (coordinates.get(1) == "A2") {
               grid[2][8] = symbol;
               coordinates.set(1, " ");
               errorCheck = false;
            } else {
               System.out.println("This coordinate is taken");
               errorCheck = true;
            }
            break;
         case "A3":
            if (coordinates.get(2) == "A3") {
               grid[2][14] = symbol;
               coordinates.set(2, " "); 
               errorCheck = false;
            } else {
               System.out.println("This coordinate is taken");
               errorCheck = true;
            }
            break;
         case "B1":
            if (coordinates.get(3) == "B1") {
               grid[5][3] = symbol;
               coordinates.set(3, " "); 
               errorCheck = false;
            } else {
               System.out.println("This coordinate is taken");
               errorCheck = true;
            }
            break;
         case "B2":
            if (coordinates.get(4) == "B2") {
               grid[5][8] = symbol;
               coordinates.set(4, " "); 
               errorCheck = false;
            } else {
               System.out.println("This coordinate is taken");
               errorCheck = true;
            }
            break;
         case "B3":
            if (coordinates.get(5) == "B3") {
               grid[5][14] = symbol;
               coordinates.set(5, " "); 
               errorCheck = false;
            } else {
               System.out.println("This coordinate is taken");
               errorCheck = true;
            }
            break;
         case "C1":
            if (coordinates.get(6) == "C1") {
               grid[8][3] = symbol;
               coordinates.set(6, " "); 
               errorCheck = false;
            } else {
               System.out.println("This coordinate is taken");
               errorCheck = true;
            }
            break;
         case "C2":
            if (coordinates.get(7) == "C2") {
               grid[8][8] = symbol;
               coordinates.set(7, " "); 
               errorCheck = false;
            } else {
               System.out.println("This coordinate is taken");
               errorCheck = true;
            }
            break;
         case "C3":
            if (coordinates.get(8) == "C3") {
               grid[8][14] = symbol;
               coordinates.set(8, " "); 
               errorCheck = false;
            } else {
               System.out.println("This coordinate is taken");
               errorCheck = true;
            }
            break;
                  default:
            System.out.println("Invalid Coordinate");
            errorCheck = true;
     }
     } while (errorCheck == true); // Will continue to run as long as errors are present
     // print player names and corresponding X and O
      System.out.print("X:" + userX + " | "); 
      System.out.print("O:" + userO);
      System.out.println();
     // Print new grid
     for(char[] row : grid) {
         for (char c : row) {
            System.out.print(c);
         }
         System.out.println();
      }
     
   }
   
   public static boolean win(char[][] grid, char symbol) {
         // Top Row Win
         if (grid[2][3] == symbol && grid[2][8] == symbol && grid[2][14] == symbol) {
            return true;
         }
         // Mid Row Win
         if (grid[5][3] == symbol && grid[5][8] == symbol && grid[5][14] == symbol) {
            return true;
         }
         // Bot Row Win
         if (grid[8][3] == symbol && grid[8][8] == symbol && grid[8][14] == symbol) {
            return true;
         }
         // First Col Win
         if (grid[2][3] == symbol && grid[5][3] == symbol && grid[8][3] == symbol) {
            return true;
         }
         // Second Col Win
         if (grid[2][8] == symbol && grid[5][8] == symbol && grid[8][8] == symbol) {
            return true;
         } 
         // Third Col Win
         if (grid[2][14] == symbol && grid[5][14] == symbol && grid[8][14] == symbol) {
            return true;
         }
         // Top-Bot Diagonal Win
         if (grid[2][3] == symbol && grid[5][8] == symbol && grid[8][14] == symbol) {
            return true;
         }
         // Bot-Top Diagonal Win
         if (grid[8][3] == symbol && grid[5][8] == symbol && grid[2][14] == symbol) {
            return true;
         }
         return false;
   }
   
}