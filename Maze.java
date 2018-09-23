//An instance of this class represents a Maze constructed from
// a 2D grid of OPEN and BLOCKED Squares.
//A solution of a Maze is a Path of orthogonally adjacent OPEN
// Squares beginning at a specially designated OPEN Square and
// ending at any OPEN Square on the boundary of the grid
//
import java.util.*;
public class Maze
{
   //Instance Variables
	private Grid grid;
	private Path path;
	private boolean traceOn;
   
   //Constructor
	public Maze(Scanner source)
	{
            this.grid = new Grid(source);
            this.path = new Path();
	}
	
   public void setTraceOn()
   {
      this.traceOn = true;
   }
   
   public Position getStart()
   {
       return this.grid.getStartPosition();
   }
   //Construct a solution of this Maze.
   //Return true if the construction succeeds, otherwise false
   public boolean solve(int x, int y)
   {   
       //Base Cases:
       if(x < 0 || x >= grid.getMaxRow() || y < 0 || y >= grid.getMaxColumn()) 
           return false;    //If position is outside of maze bounds
       
       if((x == 0 || x == grid.getMaxRow() || y == 0 || y == grid.getMaxColumn()) && 
                                    (grid.getGrid()[x][y] == Grid.SquareState.OPEN))
       {
           return true;     //If at the border and finds an open space, maze is complete
       }
       
       if(grid.getGrid()[x][y] != Grid.SquareState.OPEN)   //If the next position is not open
           return false;
           
       path.extend(new Position(x,y));
       grid.changeStatus(new Position(x,y),Grid.SquareState.SELECTED);
      
       Position pos1 = new Position(0,0);
       Position pos2 = new Position(0,0); 
       Position pos3 = new Position(0,0);
       Position pos4 = new Position(0,0); 
       
       if(x == 0 || y == 0 || x == grid.getMaxRow() - 1 || y == grid.getMaxColumn() - 1)  //If current position is on border
       {
           //only 1 possible move
           pos1 = path.getLastPosition().neighbors()[0];
           if(solve(pos1.row,pos1.col) == true)
               return true;
       }
       else
       {
           pos1 = path.getLastPosition().neighbors()[0];
           pos2 = path.getLastPosition().neighbors()[1];
           pos3 = path.getLastPosition().neighbors()[2];
           pos4 = path.getLastPosition().neighbors()[3];
           
           if(solve(pos1.row,pos1.col) == true)
               return true;
           if(solve(pos2.row,pos2.col) == true)
               return true;
           if(solve(pos3.row,pos3.col) == true)
               return true;
           if(solve(pos4.row,pos4.col) == true)
               return true;
       }
       
       path.backUp();       //Unmark from position path
       grid.changeStatus(new Position(x,y),Grid.SquareState.REJECTED);
       
       return false;
   }
       public String toString()
       {
           return this.grid + "\n" + this.path;
       }
}




































































