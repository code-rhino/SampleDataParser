package com.codedifferently;

import com.codedifferently.exceptions.SodaMarshallerMissingKeyException;
import com.codedifferently.exceptions.SodaMarshallerMissingValueException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class SodaMashallerTest {

    private String sampleItem = "name:Pepsi;price:0.50;exp:0-0-00";

    @Test
    public void findFieldByKeyValueTest1() throws Exception{
        SodaMashaller sodaMashaller = new SodaMashaller();

        String expected = "Pepsi";
        String actual = sodaMashaller.findFieldByKeyValue("name", sampleItem);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findFieldByKeyValueTest2() throws Exception {
        SodaMashaller sodaMashaller = new SodaMashaller();

        Double expected = 0.50;
        Double actual = Double.parseDouble(sodaMashaller.findFieldByKeyValue("price", sampleItem));

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test(expected = SodaMarshallerMissingValueException.class)
    public void findFieldByKeyValueTest3() throws Exception {
        SodaMashaller sodaMashaller = new SodaMashaller();
        String missingValue = "name:;price:0.50";
        sodaMashaller.findFieldByKeyValue("name", missingValue);
    }

    @Test(expected = SodaMarshallerMissingKeyException.class)
    public void findFieldByKeyValueTest4() throws Exception {
        SodaMashaller sodaMashaller = new SodaMashaller();
        String missingValue = "price:0.50";
        sodaMashaller.findFieldByKeyValue("name", missingValue);
    }

    @Test
    public void makeSodaObjectFromStringTest1() throws Exception{
        SodaMashaller sodaMashaller = new SodaMashaller();
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Pepsi");
        data.put("price", "0.50");
        data.put("exp", "0-0-00");
        Soda expected = new Soda(data);
        Soda actual = sodaMashaller.makeSodaObjectFromString(sampleItem);

        Assert.assertEquals(expected.toString(), actual.toString());
    }



}
