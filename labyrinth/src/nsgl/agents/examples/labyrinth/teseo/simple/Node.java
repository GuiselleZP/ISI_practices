package nsgl.agents.examples.labyrinth.teseo.simple;

public class Node {
	private Node left;
	private Node up;
	private Node right;
	private Node down;
	
	private int[] position;
	
	public Node() {
		left = null;
		up = null;
		right = null;
		down = null;
		position = new int[4];
	}
	
	public Node(int position[]){		
		left = null;
		up = null;
		right = null;
		down = null;
		this.position = position;
	}
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}	
}
