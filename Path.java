//An instance of this class represents a sequence of Positions
//Each member of the sequence is orthogonally adjacent to its
// predecessor and successor.
//A Position in this Path occurs no more than once in this Path
import java.util.ArrayList;
public class Path
{
   //Instance Variable
	private ArrayList<Position> path;
        private Position lastPos;
	
   //Constructor
	public Path()
	{
            this.path = new ArrayList<Position>();
       	}
	
   //Accessor: 
        public Position getLastPosition()
        {
            return this.lastPos = this.lastPos = path.get(path.size() - 1);
        }
        
   //Returns COPIES of the Positions in this Path in the
   // same order in which they occur in this Path
	public Position[] getPath()
	{
            Position[] pos = new Position[path.size()];
            
            for(Position p : path)          //Makes a copy of the positions in the path
            {
                pos[path.indexOf(p)] = p;
            }
            
            return pos;
	}
	
   //Mutator:
   //Add a new Position after the current last Position in this Path
   //A Runtime Exception is thrown if
   // - the new Position duplicates a Position already in this Path
   // - the new Position is not adjacent to the last Position
	public void extend(Position step)
	{
            if(!(path.isEmpty()))
            {
                if((path.contains(step)))// || !(path.get(path.size()).isAdjacentTo(step))))
                    throw new IllegalArgumentException();
            }
            this.path.add(step);
	}
	
   //Mutator:
   //Remove and return the last Position from this Path
   //A Runtime Exception is thrown if this Path is empty
	public Position backUp()
	{
            if(path.isEmpty())
                throw new IllegalArgumentException();
            
            path.remove(lastPos);
            return lastPos;
	}
	
	public String toString()
	{
            return this.path.toString();
	}
}






















































