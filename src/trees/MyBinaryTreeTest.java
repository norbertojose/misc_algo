package trees;

import java.util.Random;


public class MyBinaryTreeTest {
	
	private static Node<Integer> binaryTree;
	
	public static void main(String[] args){
		generateRandomBinaryTreeWithIntegerValues(10);
	}
	
	public static void generateRandomBinaryTreeWithIntegerValues(int numberOfNodes){
		Random rnd = new Random(0);
		binaryTree = new Node<Integer>(0);
		for (int i = 1; i < numberOfNodes; i++) {
			binaryTree.appendInOrderNode(new Node<Integer>(i));
		}
		
		binaryTree.printInOrderTraversal();
	}
}