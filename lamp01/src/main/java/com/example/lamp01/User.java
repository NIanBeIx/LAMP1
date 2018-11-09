package com.example.lamp01;

import java.util.ArrayList;

public class User implements connected{
    public ArrayList<String> records=new ArrayList<>();
    private String username="";
    private User patner;
    public Action a;
    private boolean tap=false;

    public User(String s){
        username=s;
    }//constructor, input usernames
    public String getUsername(){
        return this.username;
    }
    public void setPatner(User u){
        patner=u;
    }

    public void connectwith(User u){
        patner=u;
        u.setPatner(this);
    }//get connected with the other lamp, set paterner


    @Override
    public void record(String s) {
        records.add(s);
    }//record every actions sent or received

    public void haveActon(String s1,String s2){//s1 indicate the message type, s2 indicate the type of receiving or sending,  only implemented into ender function, the receiver will be updated automatically, return a string that describe the action
        if(this.patner==null){
            record( "Please get connected with one user first. Thank yout.");
        }

        a=new Action(s1,s2);

        String r=this.username+a.generateRecord()+this.patner.getUsername();//can indicate the time of the action also
        //System.out.println(r);
        this.record(r);
    }

    public void receivetap(){
        tap=true;
        String r=patner.getUsername()+" said GoodNight to you, Have a nice dream.";
        record(r);
    }

    public void updatePatner(String s1,String s2){//log the smae event but change the activity type in the other user's side, need to be inplemented with haveAction
        this.patner.haveActon(s1,s2);
    }

    public String checkHistory(){
        return this.records.toString();
    }

    public void activity(String s1){
        haveActon(s1,"sent");
        updatePatner(s1,"received");
    }

}
