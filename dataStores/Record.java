package dataStores;

public class Record{
    private String key;
    private String value;
    public Record(String k, String v){
        key = k;
        value = v;
    }
    public Record(String k){
        key = k;
        value = "";
    }
    String getkey(){
        return key;
    }
    void setkey(String k){
        key = k;
    }
    void setValue(String v){
        value = v;
    }
    public String toString(){
        return (key+": "+value);
    }
    public boolean equals(Record rec){
        if((this.key == rec.key) && (this.value == rec.value)){
            return true;
        }
        return false;
    } 
}