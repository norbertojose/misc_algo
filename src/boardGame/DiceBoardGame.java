package boardGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import trees.Node;

public class DiceBoardGame {
	private Vertex<Integer> rootVertex = new Vertex<Integer>(0);
	
	public void createDiceBoardGame(int positionToMove)
	{
		ArrayList<Vertex<Integer>> lastSixVertexes = new ArrayList<Vertex<Integer>>(6);
		int currentPosition = 0;
		lastSixVertexes.add(this.rootVertex);	
		while(currentPosition<positionToMove){
			//Vertex<Integer> currentVertex = lastSixVertexes.get(lastSixVertexes.size()-1);
			Vertex<Integer> child = new Vertex<Integer>(currentPosition+1);
			//currentVertex.addChild(child);
			for(int i=0; i<lastSixVertexes.size();i++){
				lastSixVertexes.get(i).addChild(child);
			}
			lastSixVertexes.add(child);
			if(lastSixVertexes.size()>6)
				lastSixVertexes.remove(0);
			currentPosition++;
		}
	}
	
	public void printAdjacencyListByNode()
	{
		HashSet<Vertex<Integer>> visitedVertexes = new HashSet<Vertex<Integer>>();
		LinkedList<Vertex<Integer>> nextToVisit = new LinkedList<Vertex<Integer>>();
		nextToVisit.add(this.rootVertex);
		
		while(nextToVisit.size()>0)
		{
			Vertex<Integer> currentVertex = nextToVisit.remove();
			if(visitedVertexes.contains(currentVertex))
				continue;
			currentVertex.printAdjacencyList();
			if(currentVertex.getAdjacencyList()!=null)
				nextToVisit.addAll(currentVertex.getAdjacencyList());
			visitedVertexes.add(currentVertex);
		}
	}

	public void createDiceBoardGame(String[] args) {
		this.createDiceBoardGame(Integer.parseInt(args[0]));
	}
}
