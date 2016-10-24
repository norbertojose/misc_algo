package trees;

public class Node<T extends Object> {
	private Node<T> nextRigth=null;
	private Node<T> nextLeft=null;
	private T value;

	
	public Node(T value, Node<T> nextRigth,Node<T> nextLeft){
		this.nextRigth = nextRigth;
		this.nextLeft  = nextLeft;
	}
	
	public Node(T value){
		this.value	   = value;
	}
	
	public void printInOrderTraversal(){
		System.out.println("Node Value is: "+value.toString());
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
	
	public void appendInOrderNode(Node<T> node){
		if(this.nextLeft==null){
			System.out.println("appending to the left of     " + this.getValue() + "   node:   " + node.getValue());
			this.nextLeft= node;
		}
		else if(this.nextRigth==null){
			System.out.println("appending to the right of    " + this.getValue() + "    node: " + node.getValue());
			this.nextRigth = node;
		}
		else if(this.nextLeft.getNextLeft() == null)
			this.nextLeft.appendInOrderNode(node);
		else if(this.nextRigth.getNextLeft() == null)
			this.nextRigth.appendInOrderNode(node);
		else if(this.nextLeft.getNextRigth() == null)
			this.nextLeft.appendInOrderNode(node);
		else if(this.nextRigth.getNextRigth() == null)
			this.nextRigth.appendInOrderNode(node);
	}
	
	public T getValue() {
		return value;
	}	
}
