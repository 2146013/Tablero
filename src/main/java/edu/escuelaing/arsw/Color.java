package edu.escuelaing.arsw;

public class Color {
    private int g;
    private int r;
    private int b;
    public Color(){
        this.g = (int) Math.floor(Math.random()*254);
        this.r = (int) Math.floor(Math.random()*254);
        this.b = (int) Math.floor(Math.random()*254);
    }
    public Color(int g,int r,int b){
        this.g = (g);
        this.r = (r);
        this.b = (b);

    }


}
