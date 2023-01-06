import java.util.*;
import java.util.Stack;

public class QueueVoronov {
	
	ArrayList<Integer> list;
	public QueueVoronov()
	{
		list=new ArrayList<>();
	}
   
   // Adds a number to queue
	public void enqueue(Integer num)
	{
		list.add(num);
	}
   
   // Removes a number from queue
	public Integer dequeue() {
		return list.remove(0);
	}
   
   // Converts toString
	public String toString()
	{
		String s="";
		Queue copy=new Queue();
		boolean b=false;
		while(!b)
		{
			try {
				int num =this.dequeue();
				copy.enqueue(num);
				s=s+" "+num;
			}
			catch(Exception e)
			{
				b=true;
			}
		}
		restore(copy);
		return s;
	}
   
   // Gets maximum element in queue and returns it
	public int getMax()
	{
		Queue copy=new Queue();
		boolean b=false;
		int max=0;
		while(!b)
		{
			try {
				int num=this.dequeue();
				if(num>max)
					max=num;
				copy.enqueue(num);
			}
			catch(Exception e)
			{
				b=true;
			}
		}
		restore(copy);
		return max;
	}
   
	public void restore(Queue q)
	{
		boolean b=false;
		while(!b)
		{
			try
			{
				this.enqueue(q.dequeue());
			}
			catch(Exception e)
			{
				b=true;
			}
		}
	}
   
   // Finds minimum element in the queue and returns it
   // Similar to getMax method
	public Integer getMin()
	{
		Queue copy=new Queue();
		boolean b=false;
		int min=Integer.MAX_VALUE;
		while(!b)
		{
			try {
				int num=this.dequeue();
				if(num<min)
					min=num;
				copy.enqueue(num);
			}
			catch(Exception e)
			{
				b=true;
			}
		}
		restore(copy);
		return min;
	}
   
   // Reverses the queue
	public void reverseOrder()
	{
		Stack<Integer> s =new Stack<>();
		boolean b=false;
		while(!b)
		{
			try {
				s.push(this.dequeue());
			}
			catch(Exception e)
			{
				b=true;
			}
		}
		b=false;
		while(!b)
		{
			try
			{
				this.enqueue(s.pop());
			}
			catch(Exception e)
			{
				b=true;
			}
		}
	}
   
   // Finds the average of all the elements in the queue
	public double getAverage()
	{
		int sum=0,cnt=0;
		double average=0.0;
		Queue copy=new Queue();
		boolean b=false;
		while(!b)
		{
			try {
				int temp = this.dequeue();
				copy.enqueue(temp);
				sum+=temp;
				cnt++;
			}
			catch(Exception e)
			{
				b=true;
			}
		}
		restore(copy);
		average=(double)sum/cnt;
		return average;
	}
   
   // Checks if sorted. Returns t/f depending on sort state
	public boolean isSorted()
	{
		Queue q=new Queue();
		boolean b=false;
		boolean sorted=true;
		while(!b)
		{
			try
			{
				Integer n1=this.dequeue();
				Integer n2=this.dequeue();
				q.enqueue(n1);
				q.enqueue(n2);
				if(n1>n2)
					sorted = false;
			}
			catch(Exception e)
			{
				b=true;
			}
		}
		restore(q);
		return sorted;
	}
}

class Driver
{
   public static void main(String[] args)
   {
      Queue  m = new Queue();
      m.enqueue(10);
      m.enqueue(12);
      m.enqueue(15);
      m.enqueue(7);
      m.enqueue(100);
      m.enqueue(22);
      System.out.println("The queue is : " + m);
      m.reverseOrder();
      System.out.println("The queue in the reverse order is: "+ m);
      m.reverseOrder();
      System.out.printf("Average = %.2f\n", m.getAverage());
      System.out.println(m);
      System.out.println("Max = " + m.getMax());
      System.out.println("Max = " + m.getMin());
      System.out.println("The list is sorted: "+ m.isSorted());
      
    
   }
}