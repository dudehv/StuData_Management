package com.example.studata;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Utilitie {
    public static void showingToast(Context context) {
        Toast.makeText(context, "Pls Enter The Values", Toast.LENGTH_SHORT).show();
    }

    public static boolean isValid(String username, String userclass, String useraddress, String usermobile) {
        boolean isval = true;
        if (username.isEmpty() && userclass.isEmpty() && useraddress.isEmpty() && usermobile.isEmpty()) {
            return false;
        } else {
            if (username.length() <= 6 || username.length() >= 17) {
                return false;
            }
            if (usermobile.length() != 10) {
                return false;
            }else {
                isval = true;
            }
        }
        return isval;

    }

    public static boolean saveIntosp(Context context, String userregistrationno, String username, String userclass, String useraddress, String usermobile) {
        DBManager sbm = new DBManager(context);
        sbm.open();
        Cursor cursor = sbm.fetch();
        boolean isregisternotavail = true;
        if (((Cursor) cursor).moveToFirst()) {
            do {
                int index = cursor.getColumnIndex("registrationNumber");
                if (index > -1) {
                    String dbregistrationNumber = cursor.getString(index);
                    if (dbregistrationNumber.equals(userregistrationno)) {
                        isregisternotavail = false;
                        break;
                    }
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        if (isregisternotavail) {
            sbm.open().insert(userregistrationno, username, userclass, useraddress, usermobile);
        }
        return isregisternotavail;
    }

    public static int updatestudent(String username, String userclass, String useraddress, String usermobile, String userregistrationno, Context context) {
        DBManager sbm = new DBManager(context);
        sbm.open();
        int i = sbm.update(userregistrationno, username, userclass, useraddress, usermobile);
        Log.d("registrationno", "" + i);
        return i;
    }

    public static boolean isValidStudent(String username, String userclass, String useraddress, String usermobile, String userregistrationno) {
        if (username.length() >= 6 && username.length() <= 10) {
            return true;
        }
        if (usermobile.length() == 10) {
            return true;
        }
        if (useraddress.length() == 10) {
            return true;
        }
        if (userclass.length() == 10) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isValid(String userregistrationno) {
        if (userregistrationno.isEmpty()) {
            return false;
        }
        return true;
    }

    public static StudentDataModel getDataFromDB(UpdateActivity updateActivity, String userregistrationno) {
        DBManager sbm = new DBManager(updateActivity);
        sbm.open();
        Cursor cursor = sbm.fetch();
        StudentDataModel sdm = null;
        int isauthsucc = 000;
        if (((Cursor) cursor).moveToFirst()) {
            do {

                int indexRegNum = cursor.getColumnIndex(ResponceCodefirIntent.REGISTRATIONNO);
                int indexFullName = cursor.getColumnIndex(ResponceCodefirIntent.FULLNAME);
                int indexClass = cursor.getColumnIndex(ResponceCodefirIntent.CLASS);
                int indexAddress = cursor.getColumnIndex(ResponceCodefirIntent.ADDRESS);
                int indexMobile = cursor.getColumnIndex(ResponceCodefirIntent.MOBILE);

                if (indexRegNum > -1) {
                    String dbregNum = cursor.getString(indexRegNum);
                    String dbFullName = cursor.getString(indexFullName);
                    String dbClass = cursor.getString(indexClass);
                    String dbAddress = cursor.getString(indexAddress);
                    String dbMobile = cursor.getString(indexMobile);


                    if (dbregNum.equals(userregistrationno)) {
                        sdm = new StudentDataModel();
                        sdm.setRegistrationNumber(dbregNum);
                        sdm.setFullname(dbFullName);
                        sdm.setClassname(dbClass);
                        sdm.setAddress(dbAddress);
                        sdm.setMobile(dbMobile);
                        isauthsucc = 101;
                    } else {
                        isauthsucc = 103;
                    }
                }
            } while (cursor.moveToNext()) ;
            cursor.close();

        }

        return sdm;
    }


    public static List<StudentDataModel> getAllDataFromDB(SearchActivity searchActivity) {
        List<StudentDataModel> sdmList = new ArrayList<StudentDataModel>();
        DBManager sbm = new DBManager(searchActivity);
        sbm.open();
        Cursor cursor = sbm.fetch();

        if (((Cursor) cursor).moveToFirst()) {

            do {
                int indexRegNum = cursor.getColumnIndex(ResponceCodefirIntent.REGISTRATIONNO);
                int indexFullName = cursor.getColumnIndex(ResponceCodefirIntent.FULLNAME);
                int indeClassx = cursor.getColumnIndex(ResponceCodefirIntent.CLASS);
                int indexAddress = cursor.getColumnIndex(ResponceCodefirIntent.ADDRESS);
                int indexMobile = cursor.getColumnIndex(ResponceCodefirIntent.MOBILE);

                if (indexRegNum > -1) {
                    StudentDataModel sdm = new StudentDataModel();
                    String dbregNum = cursor.getString(indexRegNum);
                    String dbFullName = cursor.getString(indexFullName);
                    String dbClass = cursor.getString(indeClassx);
                    String dbAddress = cursor.getString(indexAddress);
                    String dbMobile = cursor.getString(indexMobile);
                    sdm.setRegistrationNumber(dbregNum);
                    sdm.setFullname(dbFullName);
                    sdm.setClassname(dbClass);
                    sdm.setAddress(dbAddress);
                    sdm.setMobile(dbMobile);
                    sdmList.add(sdm);

                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        return sdmList;
    }
}