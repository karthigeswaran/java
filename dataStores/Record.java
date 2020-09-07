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

}