package com.example.lamp01;

public class Action {
    private String type="";
    private String direction="";

    public Action(){}
    public Action(String s1,String s2){
        type=s1;
        direction=s2;
    }//consturctors

    public void setType(String s){
        type=s;
    }

    public String generateRecord(){//type indicate whether it is receiving or sending
        if(direction=="receive"){
            return " caught a "+this.type+" sent by ";
        }else{
            return " sent a "+this.type+" to ";
        }
    }


}
