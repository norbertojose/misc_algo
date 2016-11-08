import boardGame.DiceBoardGame;
import trees.MyBinaryTreeTest;


public class main {
	
	public static void main(String[] args) {
		DiceBoardGame diceGame = new DiceBoardGame();
		diceGame.createDiceBoardGame(args);
		diceGame.printAdjacencyListByNode();
		//MyBinaryTreeTest.binaryTreeDepthImplementation(args);
	}
}
