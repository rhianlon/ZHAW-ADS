package ch.zhaw.rhiana.ads.Praktikum07;

class DijkstraNode extends Node<DijkstraNode> implements Comparable<DijkstraNode>  {
    boolean mark;
    DijkstraNode prev;
    double dist;

    public double getDist (){
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public void setMark(boolean m) {
        mark = m;
    }

    public boolean getMark() {
        return mark;
    }

    public void setPrev(DijkstraNode p) {
        prev = p;
    }

    public DijkstraNode getPrev() {
        return prev;
    }

    public int compareTo(DijkstraNode n) {
        // TODO: implement
        return 0;
    }
}