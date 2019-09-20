
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.File;
import java.io.FileReader;

import java.util.*;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world");

        JSONParser parser = new JSONParser();



        Integer max_group = 0;
        Integer index = 0;


        try {

            File folder = new File("src/main/resources/json2/");
            File[] files = folder.listFiles();

            for (int i =0; i < files.length; i++){



                if (files[i].isFile()){

                    Object obj = parser.parse(new FileReader(files[i]));
                    JSONObject jsonObject = (JSONObject) obj;

                   String gid = valueOf(jsonObject.get("gid")) ;


                  //  System.out.println("gid:" + gid);

                    JSONArray uidsList = (JSONArray)jsonObject.get("uids");
                    Integer group = uidsList.size();





                    if (group >= max_group) {
                        index = Integer.valueOf(gid);
                        max_group = group;
                    } else {
                        max_group = max_group;
                        index = index;
                    };





                    //System.out.println("group:" + uidsList.size());










//                    Iterator<String> iterator = uidsList.iterator();
//
//
//                    while (iterator.hasNext( )){
//
//
//                        //System.out.println(valueOf(iterator.next()));
//                    }







                } else if (files[i].isDirectory()){
                    System.out.println("Directory" + files[i].getName());
                }
            }



           // Object obj = parser.parse(new FileReader("/home/antvi/IdeaProjects/max_group/src/main/resources/json2/g131595"));
//            Object obj = parser.parse(new FileReader("src/main/resources/json2/g131595.json"));
//            JSONObject jsonObject = (JSONObject) obj;
//
//            String gid = valueOf(jsonObject.get("gid")) ;
//
//            JSONArray uidsList = (JSONArray)jsonObject.get("uids");
//
//
//            System.out.println("gid:" + gid);
//            System.out.println("\nuids List:");
//
//            Iterator<String> iterator = uidsList.iterator();
//            while (iterator.hasNext()){
//                System.out.println(valueOf(iterator.next()));
//            }

        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("max_group:" + max_group);
        System.out.println("json:" +"g" + index);

    }
}
