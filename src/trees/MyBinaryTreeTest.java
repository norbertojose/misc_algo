package trees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class MyBinaryTreeTest {
	
	private static Node<Integer> binaryTree;
	
	public static void main(String[] args){
		if(args.length>0)
			System.out.print(args[0]);
		
		
		//generateRandomBinaryTreeWithIntegerValues(Integer.parseInt(args[0]));
//		binaryTree.setDepth(0);
		//binaryTree.printDepth();
//		System.out.println("MAX DEPTH:" + binaryTree.getMaxDepth());
		
		binaryTree = new Node<Integer>(0);
		binaryTree.createIntValuesBalancedBinaryTree(binaryTree,Integer.parseInt(args[0]));
		
		HashMap<Integer,ArrayList<Node<Integer>>> map = binaryTree.getNodesByDepth(binaryTree);
		printNodesByDepth(map);
		map.clear();
		map = binaryTree.getNodesByDepthBFS(binaryTree);
		System.out.println("PRINTINT NODES BY DEPTH BFS---------");
		printNodesByDepth(map);
		System.out.println("MAX DEPTH:" + binaryTree.getMaxDepth());
	}

	private static void printNodesByDepth(
			HashMap<Integer, ArrayList<Node<Integer>>> map) {
		for(int key: map.keySet())
		{
			System.out.print("DEPTH " + key+":  ");
			System.out.print("  [");
			for(Node<Integer> node:map.get(key))
			{
				if(map.get(key).indexOf(node) == (map.get(key).size()-1))
					System.out.print(node.getValue()+"]");
				else
					System.out.print(node.getValue()+" , ");
			}
//			System.out.print(" ]  ");
				
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