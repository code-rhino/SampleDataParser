package com.codedifferently;

import org.apache.commons.io.IOUtils;

public class SampleDataParser {


    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("SampleData.txt"));
        return result;
    }

    public static void main(String[] args){
        try {
            SampleDataParser sampleDataParser = new SampleDataParser();
            String dataString = sampleDataParser.readRawDataToString();

        }catch (Exception ex){
            System.out.println("File not found");
        }
    }

}
