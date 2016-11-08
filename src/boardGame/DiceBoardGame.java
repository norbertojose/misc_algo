package boardGame;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
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
			Vertex<Integer> child = new Vertex<Integer>(currentPosition+1);
			for(int i=0; i<lastSixVertexes.size();i++){
				lastSixVertexes.get(i).addChild(child);
			}
			lastSixVertexes.add(child);
			if(lastSixVertexes.size()>6)
				lastSixVertexes.remove(0);
			currentPosition++;
		}
	}
	
	public HashSet<LinkedList<Vertex<Integer>>> getFirstSixVertexPossiblePaths()
	{
		HashSet<Vertex<Integer>> visitedVertexes = new HashSet<Vertex<Integer>>();
		LinkedList<Vertex<Integer>> nextToVisit = new LinkedList<Vertex<Integer>>();
		HashSet<LinkedList<Vertex<Integer>>> paths = new HashSet<LinkedList<Vertex<Integer>>>();
		nextToVisit.add(this.rootVertex);
		while(nextToVisit.size()>0)
		{
			Vertex<Integer> currentVertex = nextToVisit.remove();
			if(visitedVertexes.contains(currentVertex))
				continue;
			
			ArrayList<Vertex<Integer>> adjacencyList = currentVertex.getAdjacencyList();
			
			if(adjacencyList!=null)
			{
				addPaths(paths, currentVertex, adjacencyList);
			}			
			if(adjacencyList!=null)
				nextToVisit.addAll(adjacencyList);
			visitedVertexes.add(currentVertex);
		}
		
		return paths;
	}

	private void addPaths(HashSet<LinkedList<Vertex<Integer>>> paths, Vertex<Integer> currentVertex,
			ArrayList<Vertex<Integer>> adjacencyList) {
		HashSet<LinkedList<Vertex<Integer>>> pathsToAdd = new HashSet<LinkedList<Vertex<Integer>>>();
		
		if(paths.size()>0){
			for(LinkedList<Vertex<Integer>> path:paths)
			{
				if(path.getLast().getValue()==currentVertex.getValue())
				{	
					for(int i=0;i<adjacencyList.size();i++)
					{
						Vertex<Integer> itemToAdd = adjacencyList.get(i);

						if(i==(adjacencyList.size()-1)) {
							path.addLast(itemToAdd);
						} else
						{
							LinkedList<Vertex<Integer>> toAdd = new LinkedList<Vertex<Integer>>();
							toAdd.addAll(path);
							toAdd.add(itemToAdd);
							pathsToAdd.add(toAdd);
						}
					}
				}
			}
		}
		else{
			createPathWithAdjacense(currentVertex, adjacencyList, pathsToAdd);
		}
		paths.addAll(pathsToAdd);
	}


	private void createPathWithAdjacense(Vertex<Integer> currentVertex, ArrayList<Vertex<Integer>> adjacencyList,
			HashSet<LinkedList<Vertex<Integer>>> pathsToAdd) {
		
		for(int i=0;i<adjacencyList.size();i++)
		{
			//System.out.println("working with vertex "+adjacencyList.get(i).getValue());
			Vertex<Integer> itemToAdd = adjacencyList.get(i);
			LinkedList<Vertex<Integer>> toAdd = new LinkedList<Vertex<Integer>>();
			toAdd.add(currentVertex);
			toAdd.add(itemToAdd);
			pathsToAdd.add(toAdd);
			
		}
	}

	public void createDiceBoardGame(String[] args) {
		this.createDiceBoardGame(Integer.parseInt(args[0]));
	}
}
