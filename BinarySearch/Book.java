

//change this according to application like in case of medical center app it is going to be Patient class
public class Book {
	//book details
	int Book_Id;
	String Book_Name;
	String Author;
	double price;
	int No_Of_Copies;
	
	
	public Book(int book_Id, String book_Name, String author, double price,
			int no_Of_Copies) {
		Book_Id = book_Id;
		Book_Name = book_Name;
		Author = author;
		this.price = price;
		No_Of_Copies = no_Of_Copies;
		
	}
	
	
	
	
	
}
