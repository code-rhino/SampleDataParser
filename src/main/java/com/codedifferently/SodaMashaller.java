package com.codedifferently;

import com.codedifferently.exceptions.SodaMarshallerMissingKeyException;
import com.codedifferently.exceptions.SodaMarshallerMissingValueException;
import com.codedifferently.exceptions.SodaMarshallerSodaCreationException;

import java.util.ArrayList;
import java.util.HashMap;

public class SodaMashaller {

    private ArrayList<String> listOfKeys;

    public SodaMashaller(){
        listOfKeys = new ArrayList<>();
        listOfKeys.add("name");
        listOfKeys.add("price");
        listOfKeys.add("exp");
    }

    public Soda makeSodaObjectFromString(String data) throws SodaMarshallerSodaCreationException{
        HashMap<String, String> sodaData = new HashMap<>();
        try{
            for (String key:listOfKeys){
                String value = findFieldByKeyValue(key, data);
                sodaData.put(key, value);
            }
            return new Soda(sodaData);
        }catch(SodaMarshallerMissingKeyException exception){
            throw new SodaMarshallerSodaCreationException();
        }catch (SodaMarshallerMissingValueException exception){
            throw new SodaMarshallerSodaCreationException();
        }
    }

    public String findFieldByKeyValue(String key, String data) throws SodaMarshallerMissingValueException, SodaMarshallerMissingKeyException {
        String[] dataArray = data.split(";");
        String value = null;
        for (String item: dataArray) {
            if(item.contains(key)){
                String[] itemArray = item.split(":");
                if(itemArray.length < 2) throw new SodaMarshallerMissingValueException();
                value = itemArray[1];
            }
        }
        if(value == null) throw new SodaMarshallerMissingKeyException();
        return value;
    }
}
