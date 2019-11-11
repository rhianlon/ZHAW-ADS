package ch.zhaw.rhiana.ads.Praktikum08;


public class LabyrinthNode extends Node<LabyrinthNode> {
	LabyrinthNode prev;
	boolean mark;

	 public void setMark(boolean m) {
	        mark = m;
	    }

	    public boolean getMark() {
	        return mark;
	    }
	    
	    public void setPrev(LabyrinthNode p) {
	        prev = p;
	        
	    }

	    public LabyrinthNode getPrev() {
	        return prev;
	    }
		
	
}
