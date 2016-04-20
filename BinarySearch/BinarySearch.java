import java.util.Scanner;


public class BinarySearch {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args){
		//change this according to application like in case of medical center app it is going to be Patient objects
		Book b1 = new Book(1,"ABC","XYZ",300,4);
		Book b2 = new Book(2,"jhk","XYZ",300,4);
		Book b3 = new Book(3,"frt","XYZ",300,4);
		Book b4 = new Book(4,"wed","XYZ",300,4);
		Book b5 = new Book(5,"vrt","XYZ",300,4);
		
		Book[] b = {b2,b5,b1,b4,b3};
		BinaryTree tree = new BinaryTree(b2);
		for (int i = 1; i < b.length; i++) {
			tree.addNode(b[i]);
		}
		
		
		//change the search parameter according to application
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		BinaryTree searched_book = searchById(tree,id);
		
		if(searched_book != null){
			System.out.println(searched_book.data.Book_Id +" "+ searched_book.data.Book_Name+"  "+ searched_book.data.No_Of_Copies);
		}else{
			System.out.println("Book not found");
		}
	}

	private static BinaryTree searchById(BinaryTree root, int id) {
		// TODO Auto-generated method stub
		
		if(root == null){
			return null;
		}
		else{
			if(root.data.Book_Id == id){
				return root;
			}else if(root.data.Book_Id > id){
				root = searchById(root.left, id);
			}else{
				root = searchById(root.right, id);
			}
		}
		return root;
	}
	
	
}
