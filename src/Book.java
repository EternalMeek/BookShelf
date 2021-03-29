/**
 * Java Class Book
 * This Class meant to create an object named Book 
 * with title, author, year, genre, condition and year.
 * 
 * @author Tianjun Chen
 * SBU ID: 111103355
 *
 */

public class Book {
	
	enum condition { OLD, NEW	}
	
	private long ISBN;
	private int yearPublished;
	private String name;
	private String author;
	private String genre;
	private condition con;
	
	/**
	 * 
	 * Constructor of class Book
	 * 
	 * @param n name of the Book
	 * @param a author of the Book
	 * @param g genre of the Book
	 * @param y year of the book published
	 * @param i ISBN of the Book
	 * @param c condition of the book, new or old.
	 */
	public Book(String n, String a, String g, int y, long i, String c) {
		name=n;
		author=a;
		genre=g;
		yearPublished=y;
		ISBN=i;
		if(c.equalsIgnoreCase("New")) {
			con=con.NEW;
		}
		if(c.equalsIgnoreCase("Old")) {
			con=con.OLD;
		}
	}
	
	/**
	 * 
	 * @param setters
	 * the following methods assign data to corresponding class variables
	 */
	public void setISBN(long i) {
		ISBN=i;
	}
	public void setYear(int y) {
		yearPublished=y;
	}
	public void setName(String n) {
		name=n;
	}
	public void setAuthor(String a) {
		author=a;
	}
	public void setGenre(String g) {
		genre=g;
	}
	
	public void setCondition(condition c) {
		con=c;
	}
	
	/**
	 * 
	 * @return
	 * getters
	 * the following methods return the date assigned to each class variables.
	 */
	public long getISBN() {
		return ISBN;
	}
	public int getYear() {
		return yearPublished;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public String getGenre() {
		return genre;
	}
	public condition getCondition() {
		return con;
	}
	
	/**
	 * override toString method
	 */
	public String toString() {
		String s="";
		s+="	"+name+"	|	"+author+"	|	"+genre+"	|	"+yearPublished+"	|	"+ISBN+"	|	"+con;
		return s;
	}
	
	/**
	 * 
	 * this method compare if two books are the same book
	 * @param other, the book to be compared with
	 * @return true if two books are the same, false if not the same.
	 * 
	 */
	public boolean isSame(Book other) {
		if(this.name.equalsIgnoreCase(other.name) && 
				this.author.equalsIgnoreCase(other.author)&&
				this.genre.equalsIgnoreCase(other.genre)&&
				this.yearPublished==other.yearPublished&&
				this.ISBN==other.ISBN&&
				this.con.equals(other.con))
			return true;
		else
			return false;
	}

}
