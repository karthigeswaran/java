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

    String getKey(){
        return key;
    }

    void setValue(String v){
        value = v;
    }

    String getValue(){
        return value;
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