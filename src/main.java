import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import boardGame.DiceBoardGame;
import boardGame.Vertex;
import trees.MyBinaryTreeTest;


public class main {
	
	public static void main(String[] args) {
		
		ArrayList<Long> allPossibleWays = new ArrayList<Long>();
		
		for(int i=0;i<611;i++)
		{
			if(i<7)
			{
				DiceBoardGame diceGame = new DiceBoardGame();
				diceGame.createDiceBoardGame(i);
				HashSet<LinkedList<Vertex<Integer>>> paths = diceGame.getFirstSixVertexPossiblePaths();
				allPossibleWays.add((long) paths.size());
				System.out.println("For N = "+i+" --- "+paths.size());
			}
			else
			{
				long newPosibilities = 0;
				for(i=allPossibleWays.size()-6;i<allPossibleWays.size();i++)
				{
					newPosibilities+=allPossibleWays.get(i);
				}
				System.out.println("For N = "+i+" --- "+newPosibilities);
				allPossibleWays.add((long) (newPosibilities & 0x00000000ffffffffL));
			}
		}
	}

	private static void printWays(HashSet<LinkedList<Vertex<Integer>>> paths) {
		for(LinkedList<Vertex<Integer>> path:paths)
		{
			System.out.print("Path:[");
			for(Vertex<Integer> vertex: path)
			{
				System.out.print(vertex.getValue()+", ");
			}
			System.out.print("]");
			System.out.println("");
		}
	}
}
