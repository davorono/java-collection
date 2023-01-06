import java.util.*;
public class BookAppVoronov
{
}
class Book implements Comparable
{
    private String title;
    private String author;
    private String ISBN;
    private double price;
    public Book(String title, String author, String ISBN,double price)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getISBN()
    {
        return ISBN;
    }
    public double getPrice()
    {
        return price;
    }
    public void setTitle(String t)
    {
        title = t;
    }
    public void setPrice(double p)
    {
        price = p;
    }
    public void setIsbn(String sb)
    {
        ISBN = sb;
    }
    public String toString()
    {
        return title+ ", " + author+", "+price+", "+ISBN;
    }
    public boolean equals(Book other)
    {
        return this.ISBN.equals(other.ISBN);
    }

    /* compares the book objects based on the title of the book
    This compareTo method is called in the selection sort*/
    // #1
    public int compareTo(Object o)
    {
        Book b = (Book)o;
        return (this.title).compareTo(b.title); // need to modify the code in here
    }
    /*compares objects of type book based on their author
    This comapreTo method is called in the insertion sort
    the paramter for this method is of type Book and the author of the book b
    needed to be compared with the author of the Book object called this*/
    // #2
    public int compareTo(Book b)
    {
        return this.author.compareTo(b.author); //need to modify the code in here
    }
    /*compares the Book object based on the author, if the author is the same then compares the
    Book  objects based on the price
    this compareTo method is used in the bubbleSort method
    conditional statemnet needs to be used in this method
    if the authors of the book b is the same as the author of the Book object this
         return this.price - b.price
    else
       return   return author.compareTo(b.author)
     */
    // #3
    public double compare(Book b)
    {

        if(this.author.compareTo(b.author) == 0)
        {
            return this.price - b.price;
        }
        else
        {
            return this.author.compareTo(b.author);
        }
    }
}
class BookStore
{
    private ArrayList<Book> books;
    public BookStore()
    {
        books = new ArrayList<Book>();
    }
    public void add(String title, String author, double price, String isbn)
    {
        books.add(new Book(title, author,isbn, price));
    }
    public String toString()
    {
        String s = "";
        for(int i = 0; i < books.size(); i++)
        {
            s= s+ books.get(i).toString()+"\n";
        }
        return s;
    }
    public boolean delete(String isbn)
    {
        for(int i = 0; i < books.size(); i++)
        {
            if (books.get(i).getISBN().equals(isbn))
            {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
    /*sorts the books based on the title of the book
    call the compareTo #1 in this method
    remember the name of the ArrayList is books and it is not list
    refer to the given selectionSort code in the modules*/
    public void selectionSort()
    {
        for (int i = 0; i < books.size(); i++)
        {
            int index = -1;
            Book min = books.get(i);
            boolean swap = false;
            for (int j = i + 1; j < books.size(); j++)
            {
                int a = books.get(j).compareTo(min);
                if (a < 0)
                {
                    index = j;
                    min = books.get(j);
                    swap = true;
                }
            }

            if (swap == true)
            {
                Book temp = books.get(i);
                books.set(i, min);
                books.set(index,temp);
            }
        }

    }
    /*sorts the book objects based on the author of the book
    remember the name of the ArrayList is books and it is not list
    call compare method  #2 in this method
    refer to the provided insertionSort code in the modules*/
    public  void insertionSort( )
    {
        for (int i = 0; i < books.size() - 1; i++)
        {
            int j = 1 + 1;
            Book d = books.get(j);

            while (j > 0 && d.compareTo(books.get(j-1)) < 0)
            {
                books.set(j, books.get(j-1));
                j--;
            }

            books.set(j,d);
        }
    }

    /*sorts the book objcts based on the author,
    if the author is the same then sorts it based on the price2
    call comapre #3 method in this method
    refer to the provided bubbleSort code for in the modules
    */
    public void bubbleSort()
    {
        int n = books.size();
        Book temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(books.get(j-1).compare( books.get(j)) > 0){
                    temp = books.get(j-1);
                    books.set(j-1, books.get(j));
                    books.set(j, temp);
                }
            }
        }
    }
    /*the following search method searches the book based on the title of the book
    therfore the first line of code should be a call to the selection sort to sort the books
    based on the title of the books
    refer to the binarySearch code provided in the modules*/
    public Book binarySearch(String title)
    {
        selectionSort();
        int first = 0;
        int last = books.size();
        int mid = (first + last)/2;
        while( first <= last ){
            if ( books.get(mid).getTitle().compareTo(title) > 0){
                first = mid + 1;
            }else if ( books.get(mid).getTitle() == title )
            {
                return books.get(mid);
            }else {
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if ( first > last ){
            System.out.println("Element is not found!");
        }
        return null;
    }

}

class Driver
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        BookStore myStore = new BookStore();
        myStore.add("Java","Zoie",23.56,"12345678");
        myStore.add("Python","Elina",23.56,"2");
        myStore.add("Advance Java","Stewart",98,"767676576");
        myStore.add("Build Java","Liang",45,"5678656576");
        myStore.add("Zip lining", "Stewart",12,"1234566576");
        myStore.add("C++","Elina",23.56,"2645556");
        myStore.add("Programming Java","Stewart",124,"75465666");
        myStore.add("Humanity","Smith",100.56,"234545657");
        boolean b = true;
        while(b)
        {
            System.out.println("Enter 1 to sort based on the title");
            System.out.println("Enter 2 to sort based on the author");
            System.out.println("Enter 3 to sort based on the author, and the price");
            System.out.print("Enter your choice: ");
            int option = kb.nextInt();
            System.out.println("\n*************");
            if(option == 1)
            {
                System.out.println("Sorted based on the title\n");
                myStore.selectionSort();
            }
            else if (option == 2)
            {
                System.out.println("Sorted based on the author\n");
                myStore.insertionSort();
            }

            else
            {
                System.out.println("Sorted based on the author and price\n");
                myStore.bubbleSort();
            }
            System.out.println(myStore);
            System.out.println("\n     **************     ");
            System.out.println("Enter the title of the book to search for it: ");
            kb.nextLine();
            String t = kb.nextLine();

            Book book = myStore.binarySearch(t);
            if(book != null)
                System.out.println(book);
            else
                System.out.println("Book not found");
            System.out.println("\n");

        }

    }
}
class YourDriver
{
    public static void main(String[] args)
    {
        //your code should be similar to the given driver.
        //create an object of BookStore
        BookStore store = new BookStore();

        //add 6 books of your choice to your BookStore object
        store.add("Greek Philosophy", "Socrates", 49.99, "51235231");
        store.add("Herakleitos and Diogenes", "Diogenes", 10, "4129512");
        store.add("The Odyssey", "Homer", 15, "54913512");
        store.add("The Republic", "Plato", 80, "68431235");
        store.add("Metaphysics", "Aristotle", 30.49, "12595312");
        store.add("The Symposium", "Plato", 52, "63208125");

        //display the menu
        Scanner kb = new Scanner(System.in);

        while (true)
        {
            System.out.println("Enter 1 to sort based on book title");
            System.out.println("Enter 2 to sort based on author");
            System.out.println("Enter 3 to sort based on book title");

            System.out.print("Enter your choice: ");
            int option = kb.nextInt();

            //call the sorting method based on the user's choice
            if (option == 1)
            {
                System.out.println("Sorting based on title\n");
                store.selectionSort();
            }
            else if (option == 2)
            {
                System.out.println("Sorting based on author\n");
                store.insertionSort();
            }
            else if (option == 3)
            {
                System.out.println("Sorting based on author and price\n");
                store.bubbleSort();
            }

            //display the list
            System.out.println(store);

        }



    }
}