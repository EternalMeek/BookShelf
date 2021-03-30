/**
 * This class is a custom exception
 * throw if the stack is empty
 * 
 * @author Tianjun Chen
 *
 *
 */

public class EmptyStackException extends IllegalArgumentException {
	public EmptyStackException(String s) {
		super(s);
	}
}
