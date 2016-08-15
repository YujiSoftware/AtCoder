using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main(string[] args)
    {
        int N = int.Parse(Console.ReadLine());
        string[] S = new string[N];
        for (int i = 0; i < N; i++)
        {
            S[i] = Console.ReadLine();
        }

        Console.WriteLine(S.GroupBy(s => s).OrderBy(g => g.Count()).Last().Key);
    }
}
