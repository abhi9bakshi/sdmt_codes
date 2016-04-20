
public class BinaryTree {
	
	BinaryTree left;
	BinaryTree right;
	Book data;
	
	public BinaryTree(Book b){
		data = b;
	}
	
	public void addNode(Book b) {
		if (b.Book_Id < this.data.Book_Id) {
		if (this.left != null) {
		this.left.addNode(b);
		} else {
		this.left = new BinaryTree(b);
		}

		} else {
		if (this.right != null) {
		this.right.addNode(b);
		} else {
		this.right = new BinaryTree(b);
		}

		}
	}

}