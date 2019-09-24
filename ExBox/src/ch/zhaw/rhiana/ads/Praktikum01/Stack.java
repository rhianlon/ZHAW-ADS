package ch.zhaw.rhiana.ads.Praktikum01;

/**
 * @author Rhiana Weber
 */
public interface Stack {
	
	/**
	 * Fügt das übergebene Objekt dem Stack hinzu.
	 * 
	 * @param x Objekt.
	 * 
	 * @throws StackOverflowError Falls die grösse des Stacks überschritten wurde.
	 */
	public void push(Object x) throws StackOverflowError;

	/**
	 * Entfernt das oberste Objekt aus dem Stack.
	 * 
	 * @return Oberstes Objekt.
	 */
	public Object pop();

	/**
	 * Liefert <code>true</code> wenn der Stack leer ist. Andernfalls <code>false</code>.
	 * 
	 * @return <code>true</code> wenn der Stack leer ist.
	 */
	public boolean isEmpty();

	/**
	 * Liefert das oberste Objekt des Stacks.
	 * 
	 * @return Oberstes Objekt.
	 */
	public Object peek();

	/**
	 * Entfernt alle Objekte des Stacks.
	 */
	public void removeAll();

	/**
	 * Liefert <code>true</code> wenn der Stack gefüllt ist. Andernfalls <code>false</code>.
	 * 
	 * @return <code>true</code> wenn der Stack gefüllt ist.
	 */
	public boolean isFull();
}
