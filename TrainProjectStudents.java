import java.util.*;
public class TrainProjectStudents
{
}
class Person
{
    //your code
    
    // Instance Variables
    private String first;
    private String last;
    private String phone;
    private String email;
    
    // Constructor for Person Class
    public Person(String first, String last, String phone, String email) 
    {
      this.first = first;
      this.last = last;
      this.phone = phone;
      this.email = email;
    }
    
    
    // Getters
    public String getFirst() 
    {
      return first;
    }
    
    public String getLast() 
    {
      return last;
    }
    
    public String getPhone() 
    {
      return phone;
    }
    
    public String getEmail() 
    {
      return email;
    }
    
    // Setters
    public void setFirst(String f) 
    {
      first = f;
    }
    
    public void setLast(String l) 
    {
      last = l;
    }
    
    public void setPhone(String p) 
    {
      phone = p;
    }
    
    public void setEmail(String e) 
    {
      email = e;
    }
    
    // To string
    public String toString() 
    {
      return "\nFirst: " + first + "\nLast: " + last + "\nPhone: " + phone + "\nEmail: " + email;
    }
    
    // Equals
    public boolean equals(Object o) 
    {
      if (o instanceof Person) 
      {
         Person p = (Person)o;
         return this.last.equalsIgnoreCase(p.last);
      }
      return false;
    }
}
class Passenger extends Person  
{
    //your code
    // Instance variables
    private String seatClass;
    private int seatNumber;
    
    // Constructor
    public Passenger(String first, String last, String phone, String email, int seatNumber, String seatClass) 
    {
      super(first, last, phone, email);
      this.seatClass = seatClass;
      this.seatNumber = seatNumber;
    }
    
    // getter
    public String getSeatClass() 
    {
      return seatClass;
    }
    
    // Setters
    public int getSeatNumber() 
    {
      return seatNumber;
    }
    
    public void setClass(String c) 
    {
      seatClass = c;
    }
    
    public void setSeatNumber(int sn) 
    {
      seatNumber = sn;
    }
    
    // toString
    public String toString() 
    {
      return super.toString() + "\nSeat Number: " + seatNumber + "\nClass: " + seatClass;
    }
  
}
interface list
{
   //your code
   public boolean add(Object o);
   public Object search(Object o);
   public boolean delete(Object o);
   public void printLast();
        
}
class Train implements list    
{ 
   //your code
   // Instance variables     
   public static int count = 0;
   private Passenger[] train;
   public int trainNumber;
   
   // Constructor
   public Train() 
   {
      train = new Passenger[10];
   }
   
   // Getters
   public static int getCount() 
   {
      return count;
   }
   
   public int getTrainNumber() 
   {
      return trainNumber;
   }
   
   public Passenger[] getPassengers() 
   {
      return train;
   }
   
   // Interface methods
   public boolean add(Object o) 
   {
      if (o instanceof Passenger) 
      {
         Passenger p = (Passenger)o;
         train[count] = p;
         count++;
         return true;
      }
      return false;
   }
   
   public boolean delete(Object o) 
   {
      if(o instanceof String) 
      {
         String name = (String)o;
         for(int i = 0; i < count; i++) 
         {
            if(train[i].getLast().equalsIgnoreCase(name)) 
            {
               train[i] = null;
               shift(i);
               count--;
               return true;
            }
         }
      }
      return false;
   }
   
   public Object search(Object o) 
   {
      boolean b = o instanceof String;
      if(!b) 
      {
         return null;
      }
      String name = (String)o;
      for (int i = 0; i < train.length; i++) 
      {
         if (train[i] != null && train[i].getLast().equalsIgnoreCase(name)) 
         {
            return train[i];
         }
      
      }
      return null;
   }
   
   public void printLast() 
   {
      for(int i = 0; i < count; i++) 
      {
         if(train[i] != null) 
         {
            System.out.println(train[i].getLast()); 
         }
      }
   }
   
   // ToString
   public String toString() 
   {
      String s ="";
      for (int i = 0; i < count; i++) 
      {
         s = s + "\n" + train[i].toString() + "\n";
      }
      return s;
   }
   
   // Shift to remove null
   private void shift(int i) 
   {
      for (int index = i; index < count - 1; index++) 
      {
         train[i] = train[i+1];
      }
      train[count] = null;
   }
}
 /*once you implemet the above classes uncommnet the driver and test your program*/       
class Driver
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      Train myTrain = new Train();
      Passenger p1 = new Passenger("Alex", "Mano","123-456-7893","Mano@gmail.com", 12, "First class");
      Passenger p2 = new Passenger("Mary", "Trump","123-456-4894","mary@sierracollege.edu", 23, "Coach class");
      Passenger p3 = new Passenger("Al", "Busta","123-456-7890","AlB@csus.edu", 34, "Business class");
      Passenger p4 = new Passenger("Jose", "Rodrigues","123-222-7890", "Jose*gmail.com",22, "First class");
      Passenger p5 = new Passenger("Joe", "Rodrigues","123-222-7890","joe@yahoo.com", 25, "First class");
      myTrain.add(p1);
      myTrain.add(p2);
      myTrain.add(p3);
      myTrain.add(p4);
      myTrain.add(p5);
      
       
      System.out.println("\nHere is the list of the passengers in this train");
      System.out.println(myTrain);
      
      System.out.println("Testing the printLast method to display the last names");
      myTrain.printLast();
      System.out.println("\nTesting the static method getCount");
      System.out.println("This train has " + myTrain.getCount() + " Passengers\n");
      
      System.out.println("Testing the search method\n");
      System.out.print("Enter the last name of the passenger: ");
      
      String last = kb.nextLine();
      Passenger p = (Passenger)myTrain.search(last);
      if(p == null)
         System.out.println("Passenger not found");
      else
        System.out.println("Here is the info for the passenger: "+p);   
      
      System.out.println("\nTesting the delete method");
      System.out.print("Enter the last name of the passenger: ");
      last = kb.nextLine();
      boolean delete = myTrain.delete(last);
      if(delete)
         System.out.println("Passenger  "+ last+ " has been removed from the list");
      else
        System.out.println("Passenger not found"); 
        
      System.out.println("\nHere is the updated list");
      System.out.println(myTrain); 
      
      System.out.println("This train has " + Train.getCount() + " passengers");
      
      // New train
      Train sierraTrain = new Train();
      System.out.println("\n\nCreated new train: Sierra Train\n");
      
      // Creating 5 objects
      Passenger mom = new Passenger ("Linda", "Johnson", "521-521-1251", "mom@hotmail.com", 23, "First class");
      Passenger dad = new Passenger ("Steve", "Irwin", "918-521-4921", "dad@hotmail.com", 25, "First class");
      Passenger sister = new Passenger ("Amanda", "Einstein", "538-295-5182", "sister@hotmail.com", 12, "First class");
      Passenger brother = new Passenger ("Aiden", "Armstrong", "492-149-2149", "brother@hotmail.com", 14, "First class");
      Passenger uncle = new Passenger ("David", "Swahorski", "214-921-4921", "uncle@hotmail.com", 36, "First class");
      System.out.println("Created passenger objects: Mom, Dad, Sister, Brother, Uncle\n");
      
      // Adding 5 objects
      sierraTrain.add(mom);
      sierraTrain.add(dad);
      sierraTrain.add(sister);
      sierraTrain.add(brother);
      sierraTrain.add(uncle);
      System.out.println("Added passengers to train\n");
      
      // Display last names
      System.out.println("Display passenger last names:\n");
      sierraTrain.printLast();
      
      // Search last names
      System.out.print("Enter the last name of the passenger you'd like to SEARCH: ");
      String lastName = kb.nextLine();
      Passenger pass = (Passenger)sierraTrain.search(lastName);
      if(p == null) 
      {
         System.out.println("Passenger not found\n");
      }
      else
      {
         System.out.println("Here is the passenger information: " + pass);
      }
      
      // Delete a passenger
      System.out.print("Enter the last name of the passenger you'd like to DELETE: ");
      lastName = kb.nextLine();
      delete = sierraTrain.delete(lastName);
      if (delete) 
      {
         System.out.println("Passenger: " + lastName + " has been removed from the train.\n");
      }
      else 
      {
         System.out.println("Passenger not found.\n");
      }
      
      System.out.println("Updated list of passengers: ");
      System.out.println(sierraTrain);
      
      
      
   }
}    
