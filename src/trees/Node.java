package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Node<T extends Object> {
	private Node<T> nextRigth=null;
	private Node<T> nextLeft=null;
	private T value;
	private int depth=0;

	
	public Node(T value, Node<T> nextRigth,Node<T> nextLeft){
		this.nextRigth = nextRigth;
		this.nextLeft  = nextLeft;
	}
	
	public Node(T value){
		this.value	   = value;
	}
	
	public void setDepth(int depth){
		this.depth = depth;
		//System.out.println("Node " + this.value +"  Has depth: " + this.depth);
		if(this.nextLeft!=null)
			this.nextLeft.setDepth(depth+1);
		if(this.nextRigth!=null)
			this.nextRigth.setDepth(depth + 1);
	}
	
	public void printDepth()
	{
		System.out.println("Getting in");
		System.out.println("Node " + this.value +"  Has depth: " + this.depth);
		if(this.nextLeft!=null)
			this.nextLeft.printDepth();
		if(this.nextRigth!=null)
			this.nextRigth.printDepth();
			
	}
	
	public  HashMap<Integer,ArrayList<Node<T>>> getNodesByDepth(Node<T> rootNode){
		HashMap<Integer,ArrayList<Node<T>>> toRet = new HashMap<Integer,ArrayList<Node<T>>>();		
		rootNode.setDepth(0);
		addNodeToDepth(toRet,rootNode);
		return toRet;
	}
	
	private void addNodeToDepth(HashMap<Integer, ArrayList<Node<T>>> depthHash, Node<T> node) {
		System.out.println("adding node to depth: " +node.getDepth()+"with value: " + node.getValue());
		int currentDepth = node.getDepth();
		if(depthHash.containsKey(currentDepth))
		{
			depthHash.get(currentDepth).add(node);
		}else
		{
			ArrayList<Node<T>> listAtDepth = new ArrayList<Node<T>>();
			listAtDepth.add(node);
			depthHash.put(currentDepth,listAtDepth);
		}
		if(node.nextLeft!=null)
			addNodeToDepth(depthHash,node.nextLeft);
		if(node.nextRigth!=null)
			addNodeToDepth(depthHash,node.nextRigth);
	}

	public int getDepth() {
		return this.depth;
	}

	public int getMaxDepth(){

		int maxDepth = this.depth;
		System.out.println("calculating max depth:" + this.value);
		if(this.nextLeft!=null)
			maxDepth = Math.max(this.depth,this.nextLeft.getMaxDepth());
		
		if(this.nextRigth!=null)
			maxDepth = Math.max(maxDepth,this.nextRigth.getMaxDepth());
		return maxDepth;
	}
	
	public void printInOrderTraversal(){
		System.out.println("Node"+value.toString());
		if(this.nextLeft != null)
		{
			System.out.print("LEFT");
			this.nextLeft.printInOrderTraversal();
		}
		if(this.nextRigth!=null)
		{
			System.out.print("RIGTH");
			this.nextRigth.printInOrderTraversal();
		}
	}
	
	public Node<?> getNextRigth() {
		return nextRigth;
	}
	
	public void setNextRigth(Node<T> nextRigth) {
		this.nextRigth = nextRigth;
	}
	
	public Node<?> getNextLeft() {
		return nextLeft;
	}
	
	public void setNextLeft(Node<T> nextLeft) {
		this.nextLeft = nextLeft;
	}
	
	public void createRandomBinaryTree(Node<T> node){
		if(this.nextLeft==null){
			//System.out.println("appending to the left of     " + this.getValue() + "   node:   " + node.getValue());
			this.nextLeft= node;
		}
		else if(this.nextRigth==null){
			//System.out.println("appending to the right of    " + this.getValue() + "    node: " + node.getValue());
			this.nextRigth = node;
		}
		else if(this.nextLeft.getNextLeft() == null)
			this.nextLeft.createRandomBinaryTree(node);
		else if(this.nextRigth.getNextLeft() == null)
			this.nextRigth.createRandomBinaryTree(node);
		else if(this.nextLeft.getNextRigth() == null)
			this.nextLeft.createRandomBinaryTree(node);
		else if(this.nextRigth.getNextRigth() == null)
			this.nextRigth.createRandomBinaryTree(node);
		else
			this.nextLeft.createRandomBinaryTree(node);
	}
	
	public T getValue() {
		return value;
	}	
}
