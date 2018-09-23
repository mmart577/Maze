//An instance of this class represents a 2D grid of Squares
// that are initially either OPEN or BLOCKED to from a Maze
//The status of an OPEN Square may become SELECTED when the
// the Square is selected for an escape path from the Maze
//
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Grid
{
   //Instance Variables
	private final int maxRow;  //Highest index of any row
	private final int maxCol;  //Highest index of any colums
        private final Position start; //Starting position
	
	private SquareState[][] grid; //The 2D grid of Squares
	
   //Constructor
   //Parameter source is initialized to scan the input file
	public Grid(Scanner source)
	{  
            String[] line = source.nextLine().split("\\s+"); //Contains 1st line in the file with no spaces
           
            this.maxRow = Integer.parseInt(line[0]);    //Extracts 1st number in file
            this.maxCol = Integer.parseInt(line[1]);    //Extracts 2nd number in file
            
            grid = new SquareState[maxRow][maxCol];
            
            int[] columnNums = new int[9];  
            for(int x = 0; x <= 8; x++)    
            {
                columnNums[x] = x + 1;
            }
    
            for(int r = 0; r < maxRow; r++)      //Fill in the grid
            {
                String[] next = source.nextLine().split("\\s+");
                int[] intArr = new int[next.length];     //Convert String array to int array
                for (int i = 0; i < next.length; i++) 
                {
                    intArr[i] = Integer.parseInt(next[i]);
                }
                
                List<Integer> intList = new ArrayList<Integer>();
                for(int x = 0; x < intArr.length; x++)
                {
                    intList.add(intArr[x]);
                }
                
                for(int x = 0; x <= 8; x++)   // maxCol; x++)
                {
                    if(!intList.contains(columnNums[x]))
                        grid[r][x] = SquareState.OPEN;
                    else
                        grid[r][x] = SquareState.BLOCKED;
                } 
            }
            
            //Select starting point:
            String[] lastLine = source.nextLine().split("\\s+");
            int startRow = Integer.parseInt(lastLine[0]);
            int startCol = Integer.parseInt(lastLine[1]);
            this.start = new Position(startRow - 1, startCol - 1);
     }
        //Mutator:
        //Changes the status of a square
        public void changeStatus(Position pos, SquareState status)
        {
            grid[pos.row][pos.col] = status;    
        }
        
        public String toString()
	{
            String gridPrint = ""; 
            for(int i = 0 ; i < maxRow ; ++i) 
            { 
                for(int x = 0 ; x < maxCol ; ++x) 
                { 
                    gridPrint = gridPrint + grid[i][x].getSymbol(); 
                } 
                gridPrint = gridPrint + "\n"; 
            } 
            return gridPrint; 
        }
        
        //Accessors:
        public SquareState[][] getGrid()
        {
            return this.grid;
        }
        public int getMaxRow()
        {
            return this.maxRow;
        }
        public int getMaxColumn()
        {
            return this.maxCol;
        }
        public Position getStartPosition()
        {
            return this.start;
        }
        
   //An enum type to represent the state of a square in a Grid
   public enum SquareState
   {
	   OPEN(' '), BLOCKED('#'), SELECTED('+'), REJECTED('X');
	
	   private char symbol;
	
	   private SquareState(char symbol)
	   {
		   this.symbol = symbol;
	   }
	
	   public char getSymbol()
	   {
		   return this.symbol;
	   }
   }
}
























































































