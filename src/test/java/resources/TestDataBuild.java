package resources;

import pojo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestDataBuild {

    public static int randomPetID = 0;
    public static String petName = "";
    public static String categoryName = "";
    public CreatePet createPetPayLoad()
    {
        CreatePet p= new CreatePet();
        p.setId(randomPetID=randomNumberId());
        p.setName("testName");
        p.setStatus("Available");

        Category ct = new Category();
        ct.setId(456);
        ct.setName("categoryName");
        p.setCategory(ct);

        ArrayList<String> al = new ArrayList<String>();

        al.add("hhttp:1");
        p.setPhotoUrls(al);


        Tags tg = new Tags();
        tg.setId(789);
        tg.setName("Tagname");
        p.setTags(Collections.singletonList(tg));

        return p;
    }

    public CreatePet createUpdatePetPayLoad(String petID)
    {
        CreatePet p= new CreatePet();
        int petIDIntValue = Integer.parseInt(petID);
        p.setId(petIDIntValue);
        //randomStringGeneration
        p.setName(petName=randomStringGeneration());
        p.setStatus("Available");

        Category ct = new Category();
        ct.setId(456);
        ct.setName(categoryName=randomStringGeneration());
        p.setCategory(ct);

        ArrayList<String> al = new ArrayList<String>();

        al.add("hhttp:1");
        p.setPhotoUrls(al);


        Tags tg = new Tags();
        tg.setId(789);
        tg.setName("Tagname");
        p.setTags(Collections.singletonList(tg));

        return p;
    }

    public CreatePet createPetPayLoadList(List<String> datatablevalues) {

        CreatePet p = new CreatePet();
        String idValue=removeExtraQuotes(datatablevalues.get(0));
        int idIntValue = Integer.parseInt(idValue);
        p.setId(idIntValue);
        String name=removeExtraQuotes(datatablevalues.get(1));
        p.setName(name);
        String status=removeExtraQuotes(datatablevalues.get(2));
        p.setStatus(status);

        ArrayList<String> al = new ArrayList<String>();


        String[] photostringArray = datatablevalues.get(3).split(";");
        int urlCount = photostringArray.length;

        for(String singleUrl:photostringArray)
        {
            String alString= removeExtraQuotes(singleUrl);
            al.add(alString);
            p.setPhotoUrls(al);
        }


        Tags tg = new Tags();
        String tagValue=removeExtraQuotes(datatablevalues.get(4));
        int tagIdValue = Integer.parseInt(tagValue);
        tg.setId(tagIdValue);
        String tagName=removeExtraQuotes(datatablevalues.get(5));
        tg.setName(tagName);
        p.setTags(Collections.singletonList(tg));


        Category ct = new Category();
        String catValue=removeExtraQuotes(datatablevalues.get(6));
        int catIdIntValue = Integer.parseInt(catValue);
        ct.setId(catIdIntValue);
        String catName=removeExtraQuotes(datatablevalues.get(7));
        ct.setName(catName);
        p.setCategory(ct);
        return p;
    }


    public CreatePet createPetUpdatedPayLoadList(List<String> datatablevalues,String petID) {

        CreatePet p = new CreatePet();
        //String idValue=removeExtraQuotes(datatablevalues.get(0));
        int idIntValue = Integer.parseInt(petID);
        p.setId(idIntValue);
        String name=removeExtraQuotes(datatablevalues.get(0));
        p.setName(name);
        String status=removeExtraQuotes(datatablevalues.get(1));
        p.setStatus(status);

        ArrayList<String> al = new ArrayList<String>();


        String[] photostringArray = datatablevalues.get(2).split(";");
        int urlCount = photostringArray.length;

        for(String singleUrl:photostringArray)
        {
            String alString= removeExtraQuotes(singleUrl);
            al.add(alString);
            p.setPhotoUrls(al);
        }


        Tags tg = new Tags();
        String tagValue=removeExtraQuotes(datatablevalues.get(3));
        int tagIdValue = Integer.parseInt(tagValue);
        tg.setId(tagIdValue);
        String tagName=removeExtraQuotes(datatablevalues.get(4));
        tg.setName(tagName);
        p.setTags(Collections.singletonList(tg));


        Category ct = new Category();
        String catValue=removeExtraQuotes(datatablevalues.get(5));
        int catIdIntValue = Integer.parseInt(catValue);
        ct.setId(catIdIntValue);
        String catName=removeExtraQuotes(datatablevalues.get(6));
        ct.setName(catName);
        p.setCategory(ct);
        return p;
    }

    public String removeExtraQuotes(String input)
    {
        input=input.replaceAll("^\"|\"$", "");
        return input;
    }


    public String randomStringGeneration() {
        Random robj = new Random();
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        String newWord = "";
        for (int i = 0; i < 10; i++) {
            char c = alphabets.charAt(robj.nextInt(15));
            newWord = newWord + c;
        }
        return newWord;
    }

    public int randomNumberId()
    {
        Random r = new Random();
        int value =r.nextInt(99);

        return value;
    }

    public String checkInDateGeneration()
    {
        String checkInDate= LocalDate.now().toString();
        return checkInDate;
    }

    public String checkOutDateGeneration()
    {

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        String checkOutDate= tomorrow.toString();
        return checkOutDate;
    }

}
