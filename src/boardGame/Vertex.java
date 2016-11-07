package boardGame;

import java.util.ArrayList;

public class Vertex<T> {
	private ArrayList<Vertex<T>> adjacencyList=null;
	private T value;
	
	public Vertex(ArrayList<Vertex<T>> children){
		this.adjacencyList = new ArrayList<Vertex<T>>();
		this.adjacencyList.addAll(children);
	}
	
	public Vertex(T value){
	}

	public ArrayList<Vertex<T>> getAdjacencyList() {
		return adjacencyList;
	}

	public void addChild(Vertex<T> child) {
		this.adjacencyList.add(child);
	}
}