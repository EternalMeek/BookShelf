/**
 * this is a custom exception
 * throw when there is already a same book in the stack
 * 
 * @author tianjun Chen
 * SBU ID: 111103355
 *
 */

public class BookAlreadyExistException extends IllegalArgumentException{
	public BookAlreadyExistException(String s) {
		super(s);
	}

}