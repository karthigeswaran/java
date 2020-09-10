package com.karthi.studentRecordManagementSystem;

public class Subject {
    private String name;
    private int mark;
    
    public Subject(String n, int m){
            name = n;
            mark = m;
    }
    
    void setName(String n){
        name = n;
    }
    
    String getName(){
        return name;
    }
    
    void setMarks(int m){
        mark = m;
    }
    
    int getMarks(){
        return mark;
    }
    
    public String toString(){
        return "SubjectName = "+name+"; Marks = "+mark+";";
    }
     
    public boolean equals(Subject subject){
        if(name.equals(subject.getName())&&mark==subject.getMarks()){
            return true;
        }
        return false;
    }
}
