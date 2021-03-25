package ClassesAndObjects;

import java.util.ArrayList;

class Library{
	private String name;
	private ArrayList<Books> totalBooks = new ArrayList<Books>();
	private ArrayList<Books> collectionBooks = new ArrayList<Books>();
	private int arr[] = {5,5,5,5,5};
	Library(String name) {
		this.name = name;
		System.out.println("Welcomes To "+name);
	}
	void addBookLibrary(String name, double id) {
		Books b1 = new Books(name, id);
		totalBooks.add(b1);
		collectionBooks.add(b1);
	}
	void showBooks() {
		int i=0;
		for (Books book:totalBooks) {
			System.out.println("Book Name: "+book.name+" and Book Id: "+ book.id+" Quantity: "+arr[i]);
			i++;
		}
		System.out.println();
	}
	class Books{
			private String name;
			private double id;
			Books(String name, double id){
				this.name = name;
				this.id = id;
			}
	}
	class Members{
		private int n = 3;
		private String memberName;
		private double memberId;
		private ArrayList<Books> memberBooks = new ArrayList<Books>(); 
		Members(String name, double id){
			this.memberName = name;
			this.memberId = id;
		}
		void issueBooks(String bName, double bId) {
			int c=0,c1=0,i=0;
			if(n>=1) {
				for (Books book:totalBooks) {
	//				System.out.println(book.name);
	//				System.out.println(bName);
	//				System.out.println(book.id);
	//				System.out.println(bId);
					double id = book.id;
					String name = book.name;
					if(id == bId && bName.equals(name) && arr[i]>0) {
						if(memberBooks.contains(book)) {
							System.out.println("\nYou already issue this book!\n");
							c=1;
							break;
						}else {
							memberBooks.add(book);
	//						totalBooks.remove(book);
							System.out.println("\nSuccessfully Issued!\n");
							c=1;
							n--;
							arr[i] = arr[i]-1;
							break;
						}
					}
					i++;
				}
			}
			else {
				c=1;
				System.out.println("Your Books Issues limit cross!");
				System.out.println("Please Return previously issue book and then issue a new book");
			}
			if(c==0) {
				for(Books book: collectionBooks) {
					if(book.id==bId && book.name.equals(bName)) {
						System.out.println("Book is not available now!");
						c1=1;
						break;
					}
				}
				if(c1==0) {
					System.out.println("There is no such a Book in our Library");
				}
			}
		}
		void returnBooks(String bName, double bId) {
			int c=0,i=0;
			for (Books book: collectionBooks) {
				if(book.id==bId && book.name.equals(bName)) {
					Books b1 = new Books(bName, bId);
//					totalBooks.add(b1);
					memberBooks.remove(b1);
					System.out.println("\nSuccessfully Return!\n");
					c=1;
					n++;
					arr[i] = arr[i]+1;
				}
				i++;
			}
			
			if(c==0) {
				System.out.println("Returning Book is not a book of our library");
			}
		}
	}
}
public class LibraryManangementSystem {

	public static void main(String[] args) {
		Library l1 = new Library("My Library");
		l1.addBookLibrary("C Programming", 1);
		l1.addBookLibrary("C++ Programming", 2);
		l1.addBookLibrary("Python Programming", 3);
		l1.addBookLibrary("Java Programming", 4);
		l1.addBookLibrary("Android", 5);
		l1.showBooks();
		Library.Members m1 = l1.new Members("J", 100);
		Library.Members m2 = l1.new Members("M", 300);
		m1.issueBooks("C Programming", 1.0);
		m2.issueBooks("C++ Programming", 2.0);
		m1.issueBooks("C Programming", 1.0);
		l1.showBooks();
		m1.issueBooks("Java Programming", 4.0);
		m2.issueBooks("Java Programming", 4.0);
		m1.returnBooks("C Programming", 1.0);
		m2.returnBooks("Java Programming", 2.0);
		l1.showBooks();
		m1.issueBooks("Java Programming", 4.0);
		l1.showBooks();
	}

}
