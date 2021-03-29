/**
 * This class is a custom exception
 * throw if the stack is empty
 * 
 * @author tianjun Chen
 * SBU ID: 111103355
 *
 */

public class EmptyStackException extends IllegalArgumentException {
	public EmptyStackException(String s) {
		super(s);
	}
}
