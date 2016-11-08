package boardGame;

import java.util.ArrayList;
import java.util.HashSet;

public class Vertex<T> {
	private ArrayList<Vertex<T>> adjacencyList=null;
	private T value;
	
	public Vertex(ArrayList<Vertex<T>> children){
		this.adjacencyList = new ArrayList<Vertex<T>>();
		this.adjacencyList.addAll(children);
	}
	
	public Vertex(T value){
		this.value=value;
	}

	public ArrayList<Vertex<T>> getAdjacencyList() {
		return adjacencyList;
	}

	public void addChild(Vertex<T> child) {
		if(this.adjacencyList==null)
			this.adjacencyList = new ArrayList<Vertex<T>>();
		this.adjacencyList.add(child);
	}
	
	public void printAdjacencyList()
	{
		if(this.adjacencyList!=null)
		{			
			System.out.print("node  "+this.getValue() + " [");
			for(Vertex<T> vertex:this.adjacencyList)
			{
				System.out.print(vertex.getValue()+", ");
			}
			System.out.print("] ");
			System.out.println("");
		}
		else
			System.out.println("node  "+this.getValue() + "has no list");
			

	}

	public T getValue() {
		return value;
	}

}