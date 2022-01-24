package com.classreg;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String studentFile = "C:\\Users\\Alexander Wang\\IdeaProjects\\Practice1\\src\\com\\classreg\\student.csv";
        String classFile = "C:\\Users\\Alexander Wang\\IdeaProjects\\Practice1\\src\\com\\classreg\\class_registration.csv";
        ArrayList<String> classArray = new ArrayList<>();
        ArrayList<String> englishNameArray = new ArrayList<>();
        try {
            BufferedReader classReader = new BufferedReader(new FileReader(classFile));
            BufferedReader studentReader = new BufferedReader(new FileReader(studentFile));

            String line = "";

            while ((line = classReader.readLine()) != null) {
                String[] splited = line.split(",");
                classArray.add(splited[2]);
            }
            while ((line = studentReader.readLine()) != null) {
                String[] splited = line.split(",");
                englishNameArray.add(splited[7]);
            }
            classArray.remove(0);
            englishNameArray.remove(0);

            classReader.close();
            studentReader.close();

            System.out.println(classArray);
            System.out.println(englishNameArray);
        } catch (Exception e) {
            e.getStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("C:\\Users\\Alexander Wang\\IdeaProjects\\Practice1\\src\\com\\classreg\\final.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("English_Name, Number_of_Classes");
            pw.flush();

            fw.close();
            bw.close();
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        findStudentClasses(englishNameArray, classArray);

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Alexander Wang\\IdeaProjects\\Practice1\\src\\com\\classreg\\final.txt"));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("MyCSV.csv")));
            out.println();
        }
        catch (Exception e) {
            e.getStackTrace();
        }


    }

    public static void saveRecord(String englishName, int numOfClasses, String saveFilepath) {
        try {
            FileWriter fw = new FileWriter(saveFilepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(englishName + "," + numOfClasses);
            pw.flush();

            fw.close();
            bw.close();
            pw.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void findStudentClasses(ArrayList<String> students, ArrayList<String> classID) {
        for (int i = 0; i < students.size(); i++) {
            String name = students.get(i);
            int counter = 0;
            for (int x = 0; x < classID.size(); x++) {
                if (Integer.valueOf(classID.get(x)) == (i + 15)) {
                    counter++;
                }

            }
            saveRecord(name, counter, "C:\\Users\\Alexander Wang\\IdeaProjects\\Practice1\\src\\com\\classreg\\final.txt");

        }
    }
}
