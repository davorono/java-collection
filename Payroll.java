public class Payroll
{
   // instance variables
   private String name;
   private String id;
   private double HourlyRate;
   private double HoursWorked;
   
   // constructor
   public Payroll(String n, String ID, double hoursWorked, double hourlyRate) 
   {
      name = n;
      id = ID;
      HoursWorked = hoursWorked;
      HourlyRate = hourlyRate; 
   }
   
   // getter methods
   public String getName() 
   {
      return name;
   }
   
   public String getId() 
   {
      return id;
   }
   
   public double getHourlyRate() 
   {
      return HourlyRate;
   }
   
   public double getHoursWorked() 
   {
      return HoursWorked;
   }
   
   //setter methods
   public void setName(String Name) 
   {
      name = Name;
   }
   
   public void setHourlyRate(double rate) 
   {
      HourlyRate = rate;
   }
   
   public void setHoursWorked(double hours) 
   {
      HoursWorked = hours;
   }
   
   public double getPay() 
   {
      return (HourlyRate * HoursWorked);
   }
   
   //toString method
   public String toString() 
   {
      String s = "Name: " + getName();
      s = s + "\nID: " + getId();
      s = s + "\nHours worked: " + getHoursWorked();
      s = s + "\nHourly rate: " + getHourlyRate();
      return s;
   }
   
   
   
   
   
}
//once you implement the Payroll class, uncommnet the code in the main method and run your program. 
class PayrollDriver
{
  public static void main(String[] args)
  {
   
   //uncommnet  the provided code below
    System.out.println("Cretaing payroll objects");
    Payroll p1 = new Payroll("Alex Martinez" ,"123456", 25, 20);
    Payroll p2 = new Payroll("Ali Santos" ,"986747", 125, 45);
    Payroll p3 = new Payroll(" Jose Busta" ,"45678", 55, 30);
    System.out.println("testing the toString method");
    
    System.out.println(p1);
    System.out.println("Salary is : " + p1.getPay());  //calling the getPay method
    System.out.println("\n*******************");
    System.out.println(p2);
    System.out.println("Salary is : "+ p2.getPay());
    System.out.println("\n*******************");
    System.out.println(p3);
    System.out.println("Salary is : "+ p3.getPay());
    System.out.println("\n*******************");
    System.out.println("\nTesting the setter methods");
    System.out.println("The hourly pay of " + p1.getName()  + " is being changed");
    p1.setHoursWorked(80);  // changing the hours worked for the object p1
    System.out.println(p1);   
     
    //1. create two objects of the payroll class 
    Payroll p4 = new Payroll("Steve Jobs", "298143", 40, 60);
    Payroll p5 = new Payroll("Fled Guza", "391841", 20, 15);
    
    //2. display the objects on the screen by calling the toString method
    System.out.println(p4.toString());
    System.out.println("\n" + p5.toString());

    
    //2. display the salary of each person by calling the getPay method
    System.out.println(p4.getPay());
    System.out.println("\n" + p5.getPay());
    
    //change the hourlyRate of the objects you created
    p4.setHourlyRate(30);
    p5.setHourlyRate(10);
    
    
    //display the objects again to see the changes you made by calling the toString method
    System.out.println("\n" + p4.toString());
    System.out.println("\n" + p5.toString());
    
    //change the hoursworked for the objects you created by calling the setter methods
    p4.setHoursWorked(50);
    p5.setHoursWorked(5);
    
    //display your objects again to see the changes you made
    System.out.println("\n" + p4.toString());
    System.out.println("\n" + p5.toString());
    
    
  }
}