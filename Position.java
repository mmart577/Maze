//An instance of this class represents a position in a 2-D grid
// and has 2 integer attributes, a row and a column; these may 
// assume any int value, positive, zero, or negative
//An instance of this class is immutable
//
public class Position
{
   //Instance Variables
    public final int row; 
    public final int col;
    
    Position pos[];

    public Position(int row, int column) 
    { 
        if (row < 0 || column < 0) 
        {
            throw new IllegalArgumentException();
        }  
        this.row = row;
        this.col = column;
    }

   //Accessors
   public int getRow()
   {
       return this.row;
   }
   public int getColumn()
   {
       return this.col;
   }
	
   //Return all Positions orthogonally adjacent to this Position
   public Position[] neighbors()
   {
      if(this.row == 0)     //If on top border
      {
          pos = new Position[1];
          pos[0] = new Position(this.row + 1, this.col); //South
          return pos;
      }
      if(this.col == 0)     //If on left border
      {
          pos = new Position[1];
          pos[0] = new Position(this.row, this.col + 1); //East
          return pos;
      }
      if(this.row == 8)     //If on bottom border
      {
          pos = new Position[1];
          pos[0] = new Position(this.row - 1, this.col); //North
          return pos;
      }
      if(this.col == 8)     //If on right border
      {
          pos = new Position[1];
          pos[0] = new Position(this.row, this.col - 1); //West
          return pos;
      }
      //If not on any border
      if(this.row > 0 && this.col > 0 && this.row < 8 && this.col < 8)
      { 
          pos = new Position[4];
          pos[0] = new Position(this.row - 1, this.col); //North
          pos[1] = new Position(this.row, this.col + 1); //East
          pos[2] = new Position(this.row + 1, this.col); //South
          pos[3] = new Position(this.row, this.col - 1); //West
          
          return pos;
      }
      return pos;
   }
   
   //Return true if parameter other is orthogonally adjacent to 
   // this Position, false otherwise
	public boolean isAdjacentTo(Position other)
	{
            if((this.row == other.row && (this.col + 1) == other.col) || this.row == other.row && (this.col - 1) == other.col
              || this.col == other.col && (this.row + 1) == other.row || this.col == other.col && (this.row - 1) == other.row)
            {
                return true;
            }
            else
                return false;
	}
	
   //Override
        @Override
	public String toString()
	{
            return "[" + this.row + "," + this.col + "]";
	}
	
   //Override
        @Override
	public boolean equals(Object other)
	{
            if((other == null) || !(other instanceof Position)) 
                return false;
            
            Position pos = (Position) other;
            return (this.row == pos.row) && (this.col == pos.col);                
	}
}



















































































