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
		
		
		generateRandomBinaryTreeWithIntegerValues(Integer.parseInt(args[0]));
		binaryTree.setDepth(0);
		//binaryTree.printDepth();
		System.out.println("MAX DEPTH:" + binaryTree.getMaxDepth());
		HashMap<Integer,ArrayList<Node<Integer>>> map = binaryTree.getNodesByDepth(binaryTree);
		for(int key: map.keySet())
		{
			System.out.println("DEPTH: " + key);
			System.out.print("nodes: ");
			for(Node<Integer> node:map.get(key))
			{
				System.out.print(node.getValue()+"---");
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