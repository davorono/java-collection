import java.util.*;
import java.io.*;
public class ContactAppVoronov
{
   //nothing needs to be added here
}
class Person implements Comparable
{
   private String first;
   private String last;
   private String phone;
   public Person(String first, String last, String phone)
   {
      //your code   
      this.first = first;
      this.last = last;
      this.phone = phone;
   }
   public void setPhone(String number)
   {
     phone = number;
   }
   public void setFirst(String newFirst)
   {
     first = newFirst;
   }
   public void setLast(String newLast)
   {
      last = newLast;
   }
   public String getLast()
   {
      return last;
   }
   public String getFirst()
   {
     return first;
   }
   /*implement this method so that we can compare two people*/ 
   public int compareTo(Object o)
   {
      Person person = (Person)o;
      return this.last.compareTo(person.last);
             
   }
   /*Implement this method to display objects. Must use your own formating and cannot use the sample output as your format*/
   public String toString()
   { 
      return (first + " " + last + " - Contact me at: " + phone);
   }
   public String getPhone()
   {
     return phone;
   }
   public boolean equals(Person other)
   {
     return this.last.equalsIgnoreCase(other.last);
   }
 
}
/*this class creates a list of all the contacts , feel free to use any any type of list*/
class Contact
{
   ArrayList<Person> contacts; // Instance var. Declares an ArrayList of Persons'
   public Contact() // Constructor
   {
      contacts = new ArrayList<Person>();
   }
       
   
   public boolean addContact(String first, String last, String phone)
   {
       // Check if last already appears and return false if so
       for (int i = 0; i < contacts.size(); i++) 
       {
         if(last.equals(contacts.get(i).getLast())) 
         {
            return false;
         }
       }
       
       // Create object
       Person s = new Person(first, last, phone);
       
       boolean added = false;
       // Check if empty, if so just add generically
       if (contacts.size() == 0) 
       {
         contacts.add(s);
         added = true;
         return true;
       }
       
       // Place contacts in proper place in ArrayList
       for(int i = 0; i < contacts.size(); i++) 
       {
         if(s.compareTo(contacts.get(i)) < 0) 
         {
            contacts.add(i,s);
            added = true;
            break;
         }
       }
       if(!added) 
       {
         contacts.add(s);
         added = true;
       }
       return added;
   }
   
   public boolean deleteContact(String last)
   {
      for (int i = 0; i < contacts.size(); i++) 
      {
         if(contacts.get(i).getLast().equals(last)) // Search for last name and remove if found
         {
            contacts.remove(i);
            return true;
         }
      }
      return false; // Contact not found
   }
       
   public String searchContact(String last)
   {
       for (int i = 0; i < contacts.size(); i++) 
       {
         if(last.equals(contacts.get(i).getLast())) return (contacts.get(i).getPhone());
       }
       return null;
   }
      
   public ArrayList<Person> getList()
   {
      return contacts;
   }
   public String toString()
   {
      String s = "";
      for (int i = 0; i < contacts.size(); i++) 
      {
         s = s + contacts.get(i).toString() + "\n";  
      }
      return s; 
   }
}
    
class MyDriver
{
   public static void main(String[] args)  
   {
     //see the sample output
     run();                                         
   }
   
   
   public static void run() 
   {
      // Create contact object
      Contact myContact = new Contact();
      
      // Populate with initial 5 contacts
      myContact.addContact("Ana", "Baily", "568-345-9999");
      myContact.addContact("Mary","Busta", "111-222-3333");
      myContact.addContact("Smith", "Richard", "123-123-4567");
      myContact.addContact("Jose", "Hernandez", "444-566-0000");
      myContact.addContact("Sarah", "Schulz", "555-666-7777");
      
      // Print initial 5
      System.out.println("Printing initial contact list:");
      System.out.println(myContact);
      
      // Remove Ana Baily
      myContact.deleteContact("Baily");
      
      // Show new list
      System.out.println("Printing contact list without Ana Baily:");
      System.out.println(myContact);
      
      // Search for Smith Richard and output his phone number
      System.out.println("Search for Smith Richard Phone#:");
      System.out.println(myContact.searchContact("Richard"));
      
      // Add new contact and show
      System.out.println("\nAdd Fled Guza and show:");
      myContact.addContact("Fled", "Guza", "999-100-1244");
      System.out.println(myContact);
      
   }  
  
}