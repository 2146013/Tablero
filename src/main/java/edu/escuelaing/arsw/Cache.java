package edu.escuelaing.arsw;

import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    public Color color;
    public Cache(){

    }
    public static final Cache instance = new Cache();
    public List<Usuario> listausers = new ArrayList<>();
    public List<List<Integer>>listapixel = new ArrayList<>();

    public Color getuserColor (String username){
        for (Usuario user : listausers){
            System.out.println(user.getUsername()+" "+ username+" "+user.getUsername().equals(username));
            if (user.getUsername().equals(username)){
                 return  user.getColor();
            }
        }
        color = new Color(0,0,0);
        return color;
        
    }
    public void adduser (Usuario user){
        listausers.add(user);

    }
    public void addPixel (List<Integer> pixel){
        listapixel.add(pixel);
    }
    public List<List<Integer>> getPixeles(){
        return listapixel;
    }
    public void reiniciar(){
        listapixel.clear();
    }
    public String returnUserString(){
        return listausers.toString();
    }
    public static Cache getcache(){
        return instance;
    }
}

