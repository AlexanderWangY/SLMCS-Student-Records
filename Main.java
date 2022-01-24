package classreg;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String studentFile = "C:\\Users\\awang1534\\IdeaProjects\\JavaTest\\src\\classreg\\student.csv";
        String classFile = "C:\\Users\\awang1534\\IdeaProjects\\JavaTest\\src\\classreg\\class_registration.csv";
        try {
            BufferedReader classReader = new BufferedReader(new FileReader(classFile));
            BufferedReader studentReader = new BufferedReader(new FileReader(studentFile));

            String line = "";
            ArrayList<String> classArray = new ArrayList<>();
            ArrayList<String> idArray = new ArrayList<>();
            ArrayList<String> englishNameArray = new ArrayList<>();

            while ((line = classReader.readLine()) != null) {
                String[] splited = line.split(",");
                classArray.add(splited[2]);
            }
            while ((line = studentReader.readLine()) != null) {
                String[] splited = line.split(",");
                idArray.add(splited[0]);
                englishNameArray.add(splited[7]);
            }
            classArray.remove(0);
            idArray.remove(0);
            englishNameArray.remove(0);

            System.out.println(classArray);
            System.out.println(idArray);
            System.out.println(englishNameArray);
        }
        catch (Exception e) {
            e.getStackTrace();
        }

    }
}
