package com.example.separateandsort;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String allInfo;
    private String lastName;
    private String firstName;
    private int msp;


    public Doctor(String allInfo, String lastName, String firstName, int msp) {
        this.allInfo = allInfo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.msp = msp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMSP() {
        return msp;
    }

    public String getAllInfo() {
        return allInfo;
    }


    public static ArrayList<Doctor> createDoctorList(List<String> allDocs) {
        ArrayList doctorList = new ArrayList();
        String first = new String();
        String last = new String();
        int mspNum;

        for (String doctorString : allDocs) {

            String justName = new String();
            if (doctorString.lastIndexOf("(") != -1){
                justName = doctorString.substring(doctorString.indexOf(" ") + 1, doctorString.lastIndexOf("(" ) - 1);
            } else if (doctorString.lastIndexOf(",") != -1) {
                justName = doctorString.substring(0, doctorString.lastIndexOf(",") - 1);
            } else if (Character.isLetter(doctorString.charAt(doctorString.length()- 1))){
                justName = doctorString.substring(doctorString.indexOf(" ") + 1);
            } else {
                justName = doctorString.substring(doctorString.indexOf(" ") + 1, doctorString.lastIndexOf(" " ) - 1);
            }

            first = justName.substring(
                    0,
                    justName.lastIndexOf(" "));
            last = StringUtils.substringAfterLast(justName, " ");

            if (doctorString.substring(doctorString.length()).equals(")")) {

                mspNum = Integer.valueOf(
                        StringUtils.substringBetween(doctorString,
                                StringUtils.substringAfterLast(doctorString, "("),
                                StringUtils.substringBeforeLast(doctorString, ")")));
            }

            else {
                mspNum = 0;
            }

                Doctor doctor = new Doctor(
                        doctorString,
                        last,
                        first,
                        mspNum
                );

                doctorList.add(doctor);

        }
        return doctorList;
    }
}


   /** public int getMSP(String all) {
        this.msp = Integer.parseInt(all.replaceAll("^[0-9]", ""));
        return msp;
    }

    public ArrayList<String> listMSP(ArrayList<String> all) {
        for (String docInfo : all) {
            int docMSP = getMSP(docInfo);
            all.add(Integer.toString(docMSP));
        }
        return all;

    }
    **/



