public class MovieAppVoronov
{
  //no code goes here
}
class Movie implements Comparable
{
   // instance variables
   private String name;
   private String genre;
   private int rating;
   private int views;
   
   // constructor
   public Movie(String name, String genre, int rating, int views) 
   {
      this.name = name;
      this.genre = genre;
      this.rating = rating;
      this.views = views;
   }
   
   // getter methods 
   public String getName() 
   {
      return name;
   }
   
   public String getGenre() 
   {
      return genre;
   }
   
   public int getRating() 
   {
      return rating;
   }
   
   public int getViews() 
   {
      return views;
   }
   
   // setter methods
   public void setName(String movieName) 
   {
      name = movieName;
   }
   public void setGenre(String movieGenre) 
   {
      genre = movieGenre;
   }
   public void setRating(int movieRating) 
   {
      rating = movieRating;
   }
   public void setViews(int movieViews) 
   {
      views = movieViews;
   }
   
  // compareTo
  public int compareTo(Object o) 
  {
   Movie m = (Movie)o;
   return (this.name).compareTo(m.name); 
  }
  
  // equals method
  public boolean equals (Movie other) 
  {
   return this.name.equals(other.name) && this.genre.equals(other.genre);
  }
  
  // toString
  public String toString() 
  {
      String s = ""; 
      for (int i = 0; i < rating; i++) 
      {
         s = s + "*";
      }
      return name + ", " + genre + ", " + s + ", " + views + "\n";
  }
  
  
   
}

class ListNode
{
   private Movie movie;
   private ListNode next;
   
   public ListNode(Object o) 
   {
      if (o instanceof Movie) 
      {
         Movie m = (Movie)o;
         this.movie = m;
      }
   }
   
   public ListNode() 
   {
   }
   
   public ListNode(Object o, ListNode next) 
   {
      if (o instanceof Movie) 
      {
         Movie m = (Movie)o;
         movie = m;
         this.next = next;
      }
   }
   
   // getters
   public Movie getMovie() 
   {
      return movie;
   }
   
   public ListNode getNext() 
   {
      return next;
   }
   
   // setter
   public void setNext(ListNode n) 
   {
      next = n;
   }
}

interface List
{
   public void add(String name, String genre, int rating, int views); // add movie to end
   public void add(int index, String name, String genre, int rating, int views); // add movie  given index
   public int indexOf(String name); // gives index of movie
   public void remove(String name); // removes movie
   public int size(); // returns size
   public String toString(); // returns to string
   public Movie get(int position); // returns movie at position
}
class MovieList implements List
{
   private ListNode front; // front of the list
   private static int size = 0; // variable to keep track of node amount
   
   // constructors
   public MovieList() 
   {
      front = null;
   }
   public MovieList(Movie m) 
   {
      front = new ListNode(m);
   }
   
   // add the movie to end of list
   public void add(String name, String genre, int rating, int views) 
   {
      Movie m = new Movie(name, genre, rating, views);
      
      ListNode curr = front;
      
      if (curr == null) 
      {
         front = new ListNode(m);
         size++;
         return;
      }
      
      ListNode n = new ListNode (m);
      while (curr.getNext() != null) 
      {
         curr = curr.getNext();
      }
      curr.setNext(n);
      size++;
   }
   
   // adds movie at given index
   public void add(int index, String name, String genre, int rating, int views) 
   {
      Movie m = new Movie(name, genre, rating, views);
      ListNode n = new ListNode(m);
      
      if (index == 0) 
      {
         n.setNext(front);
         front = n;
         size++;
         return;
      }
      
      ListNode curr = front;
      int i = 0;
      while (curr.getNext() != null && i < index -1) 
      {
         curr = curr.getNext();
         i++;
      }
      n.setNext(curr.getNext());
      curr.setNext(n);
      size++;
      
   }
   
   // returns index of movie
   public int indexOf(String name) 
   {
      // if list is empty
      if (front == null) 
      {
         return -1;
      }
 
      if(name.equals(front.getMovie().getName())) 
      {
         return 0;
      }
      
      // somewhere in the list
      ListNode curr = front;
      int index = 1;
      while (curr != null && index <= size) 
      {
         if (curr.getMovie().getName().equals(name)) 
         {
            return index;
         }
         curr = curr.getNext();
         index++;
      }
      return -1;
   }
   
   // removes movie
   public void remove(String name) 
   {
      if(front == null) return;
      if (front.getMovie().getName().equals(name)) front = front.getNext();
      ListNode pre = front;
      ListNode curr = front;
      while (curr != null && !(curr.getMovie().getName().equals(name))) 
      {
         pre = curr;
         curr = curr.getNext();
      }
      if (curr != null && curr.getNext() == null && (curr.getMovie().getName().equals(name))) 
      {
         pre.setNext(null);
         size--;
         System.out.println("Last node removed.");
      }
      else if (curr == null) 
      {
         
      }
      else 
      {
         pre.setNext(curr.getNext());
         size--;
         System.out.println("Middle node removed.");
      }
   }
   
   // returns size of list
   public int size() 
   {
      return size+1;
   }
   
   // toString
   public String toString() 
   {
      // check if list empty
      if (front == null) 
      {
         return "";
      }
      ListNode curr = front;
      String s = "";
      
      // run through the entire list
      while (curr != null) 
      {
         s = s + curr.getMovie().toString();
         curr = curr.getNext();   
      }
      return s;
   }
   
   // get method: returns the movie and given position
   public Movie get(int pos) 
   {
      // Error checking
      if (front == null) return null;
      if (pos > size) return null;
      
      ListNode curr = front;
      int index = 0;
      while (curr != null && pos != index) 
      {
         index++;
         curr = curr.getNext();
      }
      if (curr == null) return null;
      return curr.getMovie();
   }
   
   // returns movie with most stars
   public String getMovie(int star) 
   {
      String s = "";
      ListNode curr = front;
      while (curr != null) 
      {
         if (curr.getMovie().getRating() == 5) 
         {
            s = s + curr.getMovie().toString();
         }
         curr = curr.getNext();
      }
      return s;
   }
   
   // returns movie with most people watched
   public Movie mostWatched() 
   {
      ListNode curr = front;
      Movie m = curr.getMovie();
      int mostViews = curr.getMovie().getViews();
      while (curr != null) 
      {	
   	if (mostViews < (curr.getMovie().getViews())) 
      	{
      		mostViews = curr.getMovie().getViews();
      		m = curr.getMovie();
      	}
   	curr = curr.getNext();
      }
      return m;
   }
}
 /*
once you implement all the classes uncommnet the following code to test your program*/
class Driver
{
   public static void main (String [] args)
   {
      MovieList list = new MovieList();
      list.add("Sunny Day", "Action",5, 20000);
      list.add("Airplane", "Comedy", 3, 1200);
      list.add("Doctor Zhivago","comedy", 4,23000);
      list.add("The Deer Hunter", "Family", 3, 2345);
      System.out.println("Here is the list of the movies\n");
      System.out.println(list);
      System.out.println("\nhere is the the movie that was most watched");
      System.out.println(list.mostWatched());
      System.out.println("Here is the list of 5 stars ratings");
      System.out.println(list.getMovie(5));
      System.out.println("removing Reservoir movie");
      list.remove("Reservior Dogs");
      System.out.println(list);
      System.out.println("Displaying the second movie in the list");
      System.out.println(list.get(1));
      System.out.println("adding a movie at position 2");
      list.add(2, "Up", "Carton",3,4500);
      System.out.println(list);
      int i = list.indexOf("Up"); 
      System.out.println("The movie up is in the position " + i);
   }
} 
/*To get the full credit you must create the following driver */
/*the following driver should be similar to the provided driver*/
class myDriver
{
   public static void main(String[] args)
   {
     //create a movie list
     MovieList list = new MovieList();
     
     //add 5 of your favoraite movie to it
     list.add("Interstellar", "Sci-fi", 5, 30000);
     list.add("Paul Blart: Mall Cop", "Comedy", 2, 2000);
     list.add("Dune", "Action", 5, 15600);
     list.add("Inception", "Action", 4, 21000);
     list.add("Tenet", "Thriller", 3, 4200);
     
     //display all the movies
     System.out.println("Here are all the movies:\n" + list);
     
     //display the most watched movie
     System.out.println("The most watched movie is:\n" + list.mostWatched());
     
     //display the movie with the highest rating
     System.out.println("The movies with the top ratings right now:\n" + list.getMovie(5));
     
     //display the index of one of the movies
     System.out.println("The movie Inception is in the position " + list.indexOf("Inception"));
     
     //remove one of the movies from the list
     System.out.println("Removing Interstellar from movie list...");
     list.remove("Interstellar");
     
     //display the list
     System.out.println("Here are all the movies:");
     System.out.println(list);
     
     //display the movie at the index 1
     System.out.println("The movie at index 1 is: " + list.get(1));
   }
}
