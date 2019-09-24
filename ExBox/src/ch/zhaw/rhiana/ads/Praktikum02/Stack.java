package ch.zhaw.rhiana.ads.Praktikum02;

/**
 * @author Rhiana Weber
 */
public interface Stack {
	
	public void push (Object x) throws StackOverflowError;
	
	public Object pop ();
	
	public boolean isEmpty();
	
	public Object peek ();
	
	public void removeAll();
	
	public boolean isFull();
}
