/*
Design/Psuedo code
   A. Research on Subject Matters
   From Wikipedia:
   Heron's formula is a geometric formula that finds the area of the triangle when all three sides are known.
   The formula states:
   area = sqrt(s*(s - a)*(s - b)*(s - c)) 
   where s = semiperimeter or (a + b + c) / 2
    
   B. Analysis
   This problem uses a lot of mathematics and so expect java MATH to be implemented into your code.
   The main method should be fairly simple and only has to pass the values onto the object triangleArea and then print the result.
   The object will then use those parameters to first calculate the semiperimeter (s) and then use that semiperimeter to calculate the area using Heron's formula.
   The object will return an integer.
   
   C. Psuedo code
   main:
      pass values to triangle area (x, y, z)
      print result
   
   triangle area:
      calculate semiperimeter
      calculate inside part of square root from herons formula
      square the result
      return the result
*/

public class TriangleArea {
public static void main(String[] args) {
      double area = triangleArea(18.8, 25.6, 27.7); // pass values
      System.out.print(area); // print result
   }
   
public static double triangleArea(double a, double b, double c) {
      double s = (a + b + c) / 2; // calculate semiperimeter
      double x = (s * (s - a) * (s - b) * (s - c)); // calculate inner part
      double area = Math.sqrt(x); // take square root
      return area; // return area
   }
}
 