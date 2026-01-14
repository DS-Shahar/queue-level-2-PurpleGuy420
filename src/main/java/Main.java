public class Main
{
	public static void main(String[] args)
	{
		
	}
    
    public static <T> void printQueue(Queue<T> q1)
    {
       Queue <T> q2 = copyQueue(q1);      
       while (!q2.isEmpty())
       {
        System.out.println(q2.remove());
       }
    }
    
	public static <T> Queue<T> copyQueue(Queue<T> q1)
    {
        Queue<T> q2 = new Queue<T>();
        Queue<T> q3 = new Queue<T>();
        
        while (!q1.isEmpty())
        {
            T x = q1.remove();
            q2.insert(x);
            q3.insert(x);
        }  
        
        while (!q3.isEmpty())
        {
            q1.insert(q3.remove());
        }
        
        return q2;      
    }
    
    public static Queue<Integer> level2_ex1(Queue<Character> q1)
    {
        Queue<Character> q2 = copyQueue(q1);
        Queue<Integer> q3 = new Queue<>();
        
        char a = q2.remove();
        int x = 1;
        while (!q2.isEmpty())
        {
            char b = q2.remove();
            if (a==b)
               x++;
                
            else
            {
                q3.insert(x);
                x=1;
            }
            a=b;        
        }
        
        q3.insert(x);
        return q3;  
    }
    
    public static boolean level2_ex2(Queue<String> q1)
    {
        Queue<String> q2 = copyQueue(q1);
        Queue<String> q3 = copyQueue(q1);
        int x = 0;
        
        while(!q3.isEmpty())
        {
            x++;
            q3.remove();
        }
        for (int i=0; i<x; i++)
        {
            String b = q2.remove();
            q3 = copyQueue(q1);
            
            for (int j=0; j<x; j++)
            {
                String c=q3.remove();
                
                if (i!=j)
                {
                    if (b.equals(c))
                        return true;
                }
            }
        }
        return false;
    }
    
    public static Queue<Integer> deleteNum(Queue<Integer> q1, int a)
    {
        Queue<Integer> q2 = copyQueue(q1);
        Queue<Integer> q3 = new Queue<>();
        while (!q2.isEmpty())
        {   
            int x = q2.remove();
            if (x != a)
               q3.insert(x);
        }
        return q3;
    }
    
    public static <T> boolean isIn(Queue<T> q1, T a)
    {
        Queue<T> q2 = copyQueue(q1);
        
        while (!q2.isEmpty())
        {
            if (q2.remove().equals(a))
                return true;
        } 
        return false;   
    }
    
    public static Queue<Integer> level2_ex3(Queue<Integer> q1)
    {
        Queue<Integer> q2 = copyQueue(q1);
        Queue<Integer> q3 = new Queue<>();
        
        while (!q2.isEmpty())
        {
            int x = q2.remove();
            if (!isIn(q3, x))
                q3.insert(x);
                
            else
                q2=deleteNum(q2, x);
        }  
        return q3; 
    }
    
    public static Queue<Integer> level2_ex4(Queue<Integer> q1)
    {
        Queue<Integer> q2 = new Queue<>(); 
        Queue<Integer> q3 = new Queue<>(); 

        while (!q1.isEmpty())
        {
            int min = q1.remove();
            q2.insert(min);
            
            while (!q1.isEmpty())
            {
                int x = q1.remove();
                if (x < min) 
                    min = x;
                
                q2.insert(v);
            }

            while (!q2.isEmpty())
            {
                int a = q2.remove();
                if (a == min)
                    q3.insert(a);
                else
                    q1.insert(a);
            }
        }
        return q3;
    }
    
    public static Queue<Integer> Level2_ex5(Queue<Integer> q1, Queue<Integer> q2)
    {
        Queue<Integer> q3 = copyQueue(q1);
        Queue<Integer> q4 = copyQueue(q2);
        Queue<Integer> q5 = new Queue<>();

        while (!q3.isEmpty() && !q4.isEmpty())
        {
            int a = q3.head();
            int b = q4.head();
            
            if (a <= b)
                q5.insert(q3.remove());
                
            else
                q5.insert(q4.remove());
        }
        
        while (!q3.isEmpty())
        { 
            q5.insert(q3.remove());
        }
        
        while (!q4.isEmpty())
        { 
            q5.insert(q4.remove());
        }

        return q5;
    }
    
    public static int Level2_ex6(Queue<Integer> q1)
    {
        int a  =0;
        int b = 0;
        Queue<Integer> q2 = copyQueue(q1);
        
        while (!q2.isEmpty())
        {
            if (q2.remove()%2==0)
                a++;
                
            else 
            {
                if (a>b)
                    b=a;
                
                a=0;
            } 
        }
        if (b==0)    
            return a;
        
        return b;
    }
}
