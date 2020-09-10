package com.karthi.studentRecordManagementSystem;

import java.util.ArrayList;

public class Student {
    private String name;
    private String clss;
    private ArrayList<String> examId;
    
    public Student(String n, String c,ArrayList<String> eno){
        name = n;
        clss = c;
        examId = eno;
    }

    void setName(String n){
        name = n;
    }

    String getName(){
        return name;
    }

    void setClss(String c){
        clss = c;
    }

    String getClss(){
        return clss;
    }

    boolean addExamID(String exno){
        if(!examId.contains(exno)){
            examId.add(exno);
            return true;
        }
        return false;
    }

    void setExamID(ArrayList<String> exno){
        examId=exno;
    }

    ArrayList<String> getExamID(){
        return examId;
    }

    public String toString(){
        return "Name = "+name+"; Class = "+clss+"; ExamID = "+examId.toString()+";";
    }

    public boolean equals(Student student){
        if(name.equals(student.getName())&&clss.equals(student.getClss())&&examId.equals(student.getExamID())){
            return true;
        }
        return false;
    }
}
