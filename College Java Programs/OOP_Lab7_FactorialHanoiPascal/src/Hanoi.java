import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
/*
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated 10/24/2018
 * Submitted: N/A
 * Comments: N/A
 * @author Peter Costantino
 * @version 2018.10.24
 */

public class Hanoi
{
	private static int recursivecount;
	public static int diskmoves;
	private static BufferedReader br;
	/**
	 * The main operating system of the program
	 * @param args
	 * @throws IOException
	 */
	public static void main (String args[]) throws IOException
	{
		recursivecount = 0;
		diskmoves = 0;
		boolean running = true;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press 1 to begin.");
		int input;
		while(running)
		{
			input = Integer.parseInt(br.readLine()); 
			switch(input)
			{
				case 0:
					running = false;
					break;
				case 1:
					hanoiShell();
					break;
			}
		}
	}
	
	/**
	 * Facilitates working with the Towers of Hanoi method
	 * @throws IOException
	 */
	public static void hanoiShell() throws IOException
	{
		recursivecount = 0; //resets the count and disk moves from any previous run
		diskmoves = 0;
		System.out.println("Please enter the size of the Tower of Hanoi.");
		solve(Integer.parseInt(br.readLine().trim()), "First Tower", "Second Tower", "Third Tower");
		System.out.println("Recursive calls = " + recursivecount + " Disk Moves = " + diskmoves);
	}
	
	/**
	 * Recursive method for moving the disks around
	 * @param n
	 * @param init
	 * @param dest
	 * @param temp
	 */
	public static void solve(int n, String init, String dest, String temp)
	{
		recursivecount++;
		if(n > 0)
		{
			solve(n-1, init, temp, dest);
			System.out.println("Move disk " + n + " from " + init + " to " + dest);
			solve(n-1, temp, dest, init);
			diskmoves++;
		}
	}

}
