/**
 * Java Class BooksStack
 * This Class will create a stack of Books
 * And manipulate the stack
 * 
 * @author Tianjun Chen
 *
 *
 */

public class BooksStack {
	
	private int size;
	private Book[] books;
	private Book top;
	
	/**
	 * default constructor
	 * this constructor will create a stack of books with capacity of 10.
	 * initial size=-1 because it's empty
	 */
	public BooksStack(){
		size=-1;
		books=new Book[10];
	}
	
	/**
	 * constructor
	 * @param n the new capacity.
	 * this constructor will create a stack of books with a capacity of n.
	 */
	public BooksStack(int n) {
		size=-1;
		books=new Book[n];
	}
	
	/**
	 * 
	 * @param newBook the book being added
	 * this method will add a newBook to the stack
	 * check if the stack has a book same as the newBook before add.
	 */
	public void push(Book newBook) {
		if(size==books.length-1) {
			enlarge(books.length*2);
		}
		if(size!=-1) {
			for(int i=0; i<size; i++) {
				if(books[i].isSame(newBook))
					throw new BookAlreadyExistException("Already have this book.");
			}
		}
		size++;
		books[size]=newBook;
	}
	
	/**
	 * this method will remove the top book form the stack
	 * @return the book being removed
	 */
	public Book pop() {
		if(size==-1)
			throw new EmptyStackException("The stack is empty");
		int temp=size;
		size--;
		return books[temp];
	}
	
	/**
	 * this method will see which is on the top of the stack.
	 * @return the book on top of stack
	 */
	public Book peek() {
		if(size==-1)
			throw new EmptyStackException("The stack is empty");
		return books[size];
	}
	
	/**
	 * this method check if the stack is empty
	 * @return true if empty, false if not.
	 */
	public boolean isEmpty() {
		if(size==-1)
			return true;
		return false;
	}
	
	/**
	 * this method return the size of the stack
	 * @return how many books are in the stack
	 */
	public int size() {
		int a=size;
		return ++a;
	}
	
	/**
	 * the following methods sort the stack on specific requirement given by user.
	 * @param s the instruction of how to sort the stack
	 * n- sort by name
	 * a- sort by author
	 * g- sort by genre
	 * y- sort by published year
	 * i- sort by ISBN
	 * c- sort by condition
	 */
	public void sort(String s) {
		
		if(s.equalsIgnoreCase("n")) {
			for(int i=0; i<size;i++) {
				for(int j=0; j<size;j++) {
					if(compare(books[j].getName(), books[j+1].getName())<0) {
						Book temp=books[j];
						books[j]=books[j+1];
						books[j+1]=temp;
						
					}
				}
			}
			return;
		}
		
		if(s.equalsIgnoreCase("a")) {
			for(int i=0; i<size;i++) {
				for(int j=0; j<size;j++) {
					if(compare(books[j].getAuthor(), books[j+1].getAuthor())<0) {
						Book temp=books[j];
						books[j]=books[j+1];
						books[j+1]=temp;
						
					}
				}
			}
			return;
		}
		
		if(s.equalsIgnoreCase("g")) {
			for(int i=0; i<size;i++) {
				for(int j=0; j<size;j++) {
					if(compare(books[j].getGenre(), books[j+1].getGenre())<0) {
						Book temp=books[j];
						books[j]=books[j+1];
						books[j+1]=temp;
						
					}
				}
			}
			return;
		}
		
		if(s.equalsIgnoreCase("y")) {
			for(int i=0; i<size;i++) {
				for(int j=0; j<size;j++) {
					if(books[j].getYear()>books[j+1].getYear()) {
						Book temp=books[j];
						books[j]=books[j+1];
						books[j+1]=temp;
					}
				}
			}
			return;
		}
		
		if(s.equalsIgnoreCase("c")) {
			Book[] newBooks=new Book[size];
			Book[] oldBooks=new Book[size];
			int nc=0;
			int oc=0;
			for(int i=0; i<=size;i++) {
				if(books[i].getCondition().name().equalsIgnoreCase("new")) {
					newBooks[nc]=books[i];
					nc++;
				}
				else if(books[i].getCondition().name().equalsIgnoreCase("old")) {
					oldBooks[oc]=books[i];
					oc++;
				}
			}
			
			for(int i=0;i<nc;i++) {
				books[i]=newBooks[i];
			}
			for(int i=nc; i<=size; i++) {
				books[i]=oldBooks[i-nc];
			}
			return;
		}
		
		if(s.equalsIgnoreCase("i")) {
			for(int i=0; i<size;i++) {
				for(int j=0; j<size;j++) {
					if(books[j].getISBN()> books[j+1].getISBN()) {
						Book temp=books[j];
						books[j]=books[j+1];
						books[j+1]=temp;
						
					}
				}
			}
			return;
		}
	}
	
	/**
	 * the following method compare two strings
	 * this method is used for the sorting method to sort by name, author and genre
	 * @param a 1st string
	 * @param b 2nd string
	 * @return this will return 1 if a should appear before b, -1 if b before a.
	 */
	public int compare(String a, String b) {
		for(int i=0; i<b.length(); i++) {
			if(a.charAt(i)<b.charAt(i))
				return 1;
			else if(a.charAt(i)>b.charAt(i))
				return -1;
		}
		return -1;
	}
	
	/**
	 * this method create a larger array of books if it reached the capacity
	 * @param n the new capacity
	 */
	public void enlarge(int n) {
		Book[] newBooks=new Book[n];
		for(int i=0; i<books.length;i++) {
			newBooks[i]=books[i];
		}
		books=newBooks;
	}

	/**
	 * override toString method
	 */
	public String toString(){
		System.out.printf("|%-30s|%-20s|%-16s|%-4s |%-13s|%-3s%n", "Name", "Author", "Genre", "Year", "ISBN Number", "Condition");
		System.out.println("=====================================================================================================");
		String s="";
		for(int i=0; i<=size; i++){
			s+= books[i].toString();
		}
		return s;
	}

}
