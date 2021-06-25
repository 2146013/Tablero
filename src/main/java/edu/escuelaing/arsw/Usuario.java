package edu.escuelaing.arsw;

public class Usuario {
    private Color color;
    private String username;

    public Color getColor() {
        return color;
    }

    public String getUsername() {
        return username;
    }

    public Usuario(String username){
         this.color = new Color();
         this.username =username;

    }
}
