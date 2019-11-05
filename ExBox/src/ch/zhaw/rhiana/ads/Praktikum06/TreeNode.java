package ch.zhaw.rhiana.ads.Praktikum06;

class TreeNode<T extends Comparable<T>> {
    T element;
    TreeNode<T> left, right;
    int count;
    int height;

    TreeNode(){ }
    TreeNode(T element){
        this.element = element;
    }
    TreeNode(T element, TreeNode<T> left, TreeNode<T> right){
        this(element); this.left = left; this.right = right;
        this.count = getCount();
        this.height = getHeight();
    }

    T getValue(){return element;}
    
    public int getCount() {
    	int cl = this.left != null ? this.left.getCount() : 0;
    	int cr = this.right != null ? this.right.getCount() : 0;
		return 1 + cl + cr;
	}
    
    public int getHeight() {
    	int cl = this.left != null ? this.left.getHeight() : 0;
    	int cr = this.right != null ? this.right.getHeight() : 0;
    	
    	if (cl > cr) {
    		return cl + 1;
    	} else {
    		return cr + 1;
    	}
	}
}