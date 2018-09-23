import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class MazeClient
{
	public static void main(String[] args) throws IOException
	{
		boolean quitting = false;
		do
		{
			String fileName = JOptionPane.showInputDialog(null,
			                  "Enter the name of a Maze data file or CANCEL to quit");
			
			if (fileName == null)
				quitting = true;
			else
			{
				Maze maze = new Maze( new Scanner( new FileReader(fileName) ) );
				System.out.println();
				System.out.println(maze);
				System.out.println("\n" + (maze.solve(maze.getStart().row,maze.getStart().col) ? maze + " SUCCESS" :
                                                      maze + " FAILURE"));
			}
		} while (!quitting);
	}
}























