package boardGame;

import java.util.ArrayList;

public class DiceBoardGame {
	private Vertex<Integer> rootVertex = new Vertex<Integer>(0);
	
	public void createDiceBoardGame(int positionToMove)
	{
		ArrayList<Vertex<Integer>> lastSixVertexes = new ArrayList<Vertex<Integer>>(6);
		int currentPosition = 0;
		lastSixVertexes.add(this.rootVertex);		
		while(currentPosition<positionToMove){
			Vertex<Integer> currentVertex = lastSixVertexes.get(lastSixVertexes.size()-1);
			currentVertex.addChild(new Vertex<Integer>(currentPosition+1));
			
			for(int i=0; i<lastSixVertexes.size();i++){
				
			}
			
		}
	}
}
