package edu.escuelaing.arsw;

import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    public Color color;
    public Cache(){
        color = new Color();
    }
    public static final Cache instance = new Cache();
    public List<Usuario> listausers = new ArrayList<>();
    public List<List<Integer>>listapixel = new ArrayList<>();

    public Color getuserColor (String username){
        for (Usuario user : listausers){
            if (user.getUsername().equals(username)){
                 color = user.getColor();
            }
        }
        return color;
    }
}

