package com.karthi.studentRecordManagementSystem;

import java.util.ArrayList;

public class Exam {
    private ArrayList<Subject> list;
    private int total=0;
    private float avg;
    
    public Exam(ArrayList<Subject> sub){
        list = sub;
        setTotal();
        setAvg();
    }

    private void setTotal(){
        for(Subject subject : list){
            total += subject.getMarks();
        }
    }

    private void setAvg(){
        avg = (float)(total/list.size());
    }

    boolean addSubject(Subject subject){
        if(!list.contains(subject)){
            list.add(subject);
            return true;
        }
        return false;
    }

    boolean removeSubject(Subject subject){
        if(list.contains(subject)){
            list.remove(subject);
            return true;
        }
        return false;
    }

    void setSubjects(ArrayList<Subject> sub){
        list = sub;
    }

    ArrayList<Subject> getSubjects(){
        return list;
    }

    int getTotal(){
        return total;
    }
    
    float getAvg(){
        return avg;
    }

    public String toString(){
        return "Name = "+name+"; Class = "+clss+"; ExamID = "+examid+";";
    }

    public boolean equals(Exam exam){
        if(list.equals(exam.getSubjects())){
            return true;
        }
        return false;
    }

}
