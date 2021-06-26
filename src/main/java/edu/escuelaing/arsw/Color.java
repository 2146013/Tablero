package edu.escuelaing.arsw;

public class Color {
    private int g;
    private int r;
    private int b;

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Color(){
        this.g = (int) Math.floor(Math.random()*253+1);
        this.r = (int) Math.floor(Math.random()*253+1);
        this.b = (int) Math.floor(Math.random()*253+1);
    }
    public Color(int r,int g,int b){
        this.g = (g);
        this.r = (r);
        this.b = (b);

    }


}
