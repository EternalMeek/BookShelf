/**
 * this is a custom exception
 * throw when there is already a same book in the stack
 * 
 * @author Tianjun Chen
 *
 *
 */

public class BookAlreadyExistException extends IllegalArgumentException{
	public BookAlreadyExistException(String s) {
		super(s);
	}

}