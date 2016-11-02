package trees;

import java.io.IOException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class MyBinaryTreeTest {
	
	private static Node<Integer> binaryTree;
	
	public static void main(String[] args){
		
		//generateRandomBinaryTreeWithIntegerValues(Integer.parseInt(args[0]));
//		binaryTree.setDepth(0);
		//binaryTree.printDepth();
//		System.out.println("MAX DEPTH:" + binaryTree.getMaxDepth());
		long startTime = System.currentTimeMillis();

		System.out.println("STARTING TO GENERATE TREE");		
		binaryTree = new Node<Integer>(0);
		binaryTree.createIntValuesBalancedBinaryTree(binaryTree,Integer.parseInt(args[0]));
	    long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
		System.out.println("BINARY TREE GENERATION IS DONE IN " +elapsedTime + "ms");
	    
//		HashMap<Integer,ArrayList<Node<Integer>>> map = binaryTree.getNodesByDepth(binaryTree);
//		printNodesByDepth(map);
//		map.clear();
		startTime = System.currentTimeMillis();
		HashMap<Integer,ArrayList<Node<Integer>>> map = binaryTree.getNodesByDepthBFS(binaryTree);
	    stopTime = System.currentTimeMillis();
	    elapsedTime = stopTime - startTime;
		System.out.println("GETTING NODES BY DFB---------" +elapsedTime + "ms");
		printNodesByDepth(map);
		//System.out.println("MAX DEPTH:" + binaryTree.getMaxDepth());
	}

	private static void printNodesByDepth(
			HashMap<Integer, ArrayList<Node<Integer>>> map) {
		for(int key: map.keySet())
		{
			System.out.print("DEPTH " + key+":  ");
			System.out.print(map.get(key).size() + " wide ");
			System.out.print("  [");
			for(Node<Integer> node:map.get(key))
			{
				if(map.get(key).indexOf(node) == (map.get(key).size()-1))
					System.out.print(node.getValue()+"]");
				else
					System.out.print(node.getValue()+" , ");
			}
				
			System.out.println("");
		}
	}
	
	public static void generateRandomBinaryTreeWithIntegerValues(int numberOfNodes){
		Random rnd = new Random(0);
		binaryTree = new Node<Integer>(0);
		for (int i = 1; i < numberOfNodes; i++) {
			binaryTree.createRandomBinaryTree(new Node<Integer>(i));
		}
		
		//binaryTree.printInOrderTraversal();
	}
}