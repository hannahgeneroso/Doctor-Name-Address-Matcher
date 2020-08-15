package com.example.separateandsort;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SeparateAndSort {
    public static void main(String[] args) throws Exception{
        Path p = Paths.get("C:/Users/hanna/Desktop/BCDocs.txt");
        List listOfBCDocs = Files.readAllLines(p);

        ArrayList<String> doctorLastNames = new ArrayList();
        ArrayList<String> doctorFirstNames = new ArrayList();

        ArrayList listOfBCDocsArray = listToArrayList(listOfBCDocs);


       ArrayList<Doctor> doctorObjects = Doctor.createDoctorList(listOfBCDocsArray);

        for (Doctor doctor:doctorObjects){
            doctorLastNames.add(doctor.getLastName());
            doctorFirstNames.add(doctor.getFirstName());

        }

        try (PrintWriter writer = new PrintWriter(
                Files.newBufferedWriter(Paths.get("C:/Users/hanna/Desktop/BCDocsLastName.txt")))) {
            for (String row : doctorLastNames) {
                writer.printf(row + "\t");
                writer.println();
            }

        }

        try (PrintWriter writer = new PrintWriter(
                Files.newBufferedWriter(Paths.get("C:/Users/hanna/Desktop/BCDocsFirstName.txt")))) {
            for (String row : doctorFirstNames) {
                writer.printf(row + "\t");
                writer.println();
            }
        }

    }

    public static ArrayList<String> listToArrayList(List<Object> myList) {
        ArrayList<String> arl = new ArrayList<>();
        for (Object object : myList) {
            arl.add((String) object);
        }
        return arl;

    }


    }




