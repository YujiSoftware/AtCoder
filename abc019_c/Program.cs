using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main(string[] args)
    {
        int N = int.Parse(Console.ReadLine());
        int[] A = 
            Console.ReadLine().Split(' ')
                .Select(s => int.Parse(s))
                .OrderBy(i => i)
                .ToArray();

        HashSet<int> used = new HashSet<int>();
        int count = 0;
        foreach(int val in A){
            if(!used.Contains(val)){
                count++;

                int temp = val * 2;
                while(temp <= 1000000000){
                    used.Add(temp);
                    temp *= 2;
                }
            }
        }

        Console.WriteLine(count);
    }
}
