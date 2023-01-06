/*
Design/Psuedo code
   A. Research on Subject Matters
      Standard deviation is a formula commonly used in statistics that measures the amount of variation or dispersion
      of a set of values. 
      
   B. Analysis
      Since the formula is quite long and complicated, I will have to split up the formula into seperate mathematical 
      tasks that calculates each part individually. Since I am also working with arrays, I will need to use several
      for loops. The only variables I need to declare for this problem is an average (avg) and a number (num) I believe.
      
   C. Psuedo code
      In main:
         Pass array to standard deviation function
      
      In standard deviation function:
         Declare double average
         Declare double number
         for index < length of the array,
            sum every value in the array to the average
         
         calculate the average
         
         for index < array length,
            number = (array value - average) * (array value - average)
         
         return the square root of the number divided by (array length - 1)
*/ 
public class Stdev {
   public static void main(String[] args) {
      int array[] = {1, -2, -4, 9, -6, 16, -8, 25, -10};
      System.out.print(stdev(array));
   }
   
   public static double stdev(int[] a) {
    double avg = 0;
    double num = 0;
    
    for(int i = 0; i < a.length; i++) {
        avg += a[i];
    }
    avg /= a.length;
    
    for(int i = 0; i < a.length; i++) {
        num += (a[i] - avg) * (a[i] - avg);
    }
    return Math.sqrt(num / (a.length - 1));
}
   
}