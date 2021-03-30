/**
 * Java Class LibraryManager
 * this class will intact with user to manipulate stack
 * 
 * @author Tianjun Chen
 *
 *
 */

import java.util.Scanner;

public class LibraryManager {
	
	/**
	 * The following will crate an interface for user to interact with the stack
	 * @param args
	 */

	public static void main(String[] args) {
		
		BooksStack stackingBooks=new BooksStack();
		
		boolean stillInput=true;
		
		while(stillInput) {
			System.out.println();
			System.out.println("Starting...");
			System.out.println("Menu: ");
			System.out.printf(
					'\u2022'+" (A)-Add Book%n"+
					'\u2022'+" (R)-Remove Book%n"+
					'\u2022'+" (G)-Get Book%n"+
					'\u2022'+" (P)-Print Books%n"+
					'\u2022'+" (S)-Sort Books%n"+
					'\u2022'+" (Q)-Quit%n"+
					"______________________________________________________________________%n");
			
			Scanner in=new Scanner(System.in);
			String choice=in.next();

			String name, author, genre,con;
			int year;
			long isbn;
			
			if(choice.equalsIgnoreCase("A")) {
				System.out.print("Please enter the name: ");
				name=info();
				System.out.printf("%nPlease enter the author: ");
				author=info();
				System.out.printf("%nPlease enter the genre: ");
				genre=info();
				System.out.printf("%nPlease enter the year it was published: ");
				year=Integer.parseInt(info());
				System.out.printf("%nPlease enter the ISBN Number: ");
				isbn=Long.parseLong(info());
				System.out.printf("%nPlease enter the condition: ");
				con=info();
				
				Book newBook=new Book(name, author, genre, year, isbn, con);
				stackingBooks.push(newBook);
			}
			
			if(choice.equalsIgnoreCase("R")) {
				String title="";
				System.out.print("Please enter the name of the book: ");
				title=info();
				BooksStack tempStack=new BooksStack(stackingBooks.size());
				while(!stackingBooks.isEmpty()&& !stackingBooks.peek().getName().equalsIgnoreCase(title)) {
					tempStack.push(stackingBooks.pop());
				}
				if(stackingBooks.peek().getName().equalsIgnoreCase(title)) {
					stackingBooks.pop();
					while(!tempStack.isEmpty()) {
						stackingBooks.push(tempStack.pop());
					}
				}
				if(stackingBooks.isEmpty())
					System.out.println("Book not found.");
			}
			
			if(choice.equalsIgnoreCase("G")) {
				System.out.print("Please enter the name of the book:");
				String s=info();
				BooksStack temp=new BooksStack(stackingBooks.size());
				while(!stackingBooks.peek().getName().equalsIgnoreCase(s)&&!stackingBooks.isEmpty()) {
					temp.push(stackingBooks.pop());
				}
				if(stackingBooks.isEmpty()) {
					System.out.println("Title not found.");
				}
				Book copy=stackingBooks.peek();
				System.out.println(copy.getName()+" was written by "+copy.getAuthor()+" in the year "+
				copy.getYear()+". It is of the "+copy.getGenre()+" genre. The ISBN Number is "+copy.getISBN()+
				" and it is "+copy.getCondition());
				while(!temp.isEmpty()) {
					stackingBooks.push(temp.pop());
				}
				
			}
			
			if(choice.equalsIgnoreCase("P")) {
				System.out.print(stackingBooks.toString());
				/*
				int size=stackingBooks.size();
				BooksStack temp=new BooksStack(size);
				int i=0;
				while(!stackingBooks.isEmpty() && i<=size) {
					System.out.print(stackingBooks.peek().toString());
					temp.push(stackingBooks.pop());
					i++;
				}
				while(!temp.isEmpty()) {
					stackingBooks.push(temp.pop());
				}

				 */
			}
			
			if(choice.equalsIgnoreCase("S")) {
				System.out.printf("Please select by what: %n"+
						'\u2022'+"(N)-Name%n"+'\u2022'+"(A)-Author%n"+
						'\u2022'+"(G)-Genre%n"+'\u2022'+"(Y)-Year%n"+
						'\u2022'+"(C)-Condition%n"+'\u2022'+"(I)-ISBN Number%n");
				System.out.print("Choose an option: ");
				String s=info();
				if(stackingBooks.size()-1>0) {
					stackingBooks.sort(s);}
			}
			
			if(choice.equalsIgnoreCase("Q")) {
				stillInput=false;
			}
		}
	}

	/**
	 * this method will take user's input
	 * it's being used in the main.
	 * @return user's input
	 */
	private static String info() {
		Scanner in=new Scanner(System.in);
		return in.next();
	}

}