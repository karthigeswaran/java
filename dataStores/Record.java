package dataStores;

public class Record{
    private String key;
    private String value;
    
    public Record(String k, String v){
        key = k;
        value = v;
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
        return ""+this.key+": "+this.value;
    }

    public boolean equals(Record rec){
        if(this.key.equals(rec.getKey())&&this.value.equals(rec.getValue())){
            return true;
        }
        return false;
    }

}