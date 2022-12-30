/* You are given an array prices where prices[i] is the price of a given stock on the ith day... Find the maximum profit you can achieve... You may complete at most two transactions... Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again)...
 * Eg 1: prices = [3, 3, 5, 0, 0, 3, 1, 4]   Output = (3-0) + (4-1) = 3
 * Eg 2: prices = [1, 2, 3, 4, 5]            Output = (5-1) = 4
 * Eg 3: prices = [7, 5, 4, 3, 1]            Output = 0
 */
import java.util.*;
public class MinimumStock 
{
    public int MinimumEvaluate(Vector<Integer> vec)
    {
        int profit1 = 0, profit2 = 0;
        int x1 = vec.get(0);
        for(int i = 0; i < vec.size()-1; i++)
        {
            if(vec.get(i) < x1 || x1 == 0)
            {
                x1 = vec.get(i);
            }
            else if(vec.get(i+1) > x1 && profit1 == 0)
            {
                profit1 = (vec.get(i+1) - x1);
                System.out.println("Profit 1 : "+profit1);
                x1 = 0;
            }
            else if(vec.get(i+1) > x1 && profit1 != 0)
            {
                profit2 = (vec.get(i+1) - x1);
                System.out.println("Profit 2 : "+profit2);
                x1 = 0;
            }
            if(profit1 < profit2)
            {
                profit2 = profit1;
                profit1 = 0;
            }
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, a;
        System.out.print("Enter the size of list : ");
        x = sc.nextInt();
        Vector<Integer> prices = new Vector<Integer>(x);
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter data : ");
            a = sc.nextInt();
            prices.add(i, a);
        }
        System.out.println("The Vector list formed is : "+prices);
        MinimumStock minimum = new MinimumStock();
        System.out.println("The Profit is : "+minimum.MinimumEvaluate(prices));
        sc.close();
    }
}
