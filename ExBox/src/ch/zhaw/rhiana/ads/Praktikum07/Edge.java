package ch.zhaw.rhiana.ads.Praktikum07;

public class Edge<N extends Node> {
    protected N dest;  // Zielknoten der Kante
    protected double weight;  // Kantengewicht

    public Edge() {}

    public Edge(N dest, double weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public void setDest(N node) {this.dest = node;}
    public N getDest() {return dest;}

    public void setWeight(double w) {this.weight = w;}
    double getWeight() {return weight;}
}
