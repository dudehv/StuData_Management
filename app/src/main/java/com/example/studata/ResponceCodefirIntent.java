package com.example.studata;

import android.os.Bundle;
import android.text.StaticLayout;

interface ResponceCodefirIntent {
    static int Add=101;
    static int Delete=102;
    static int Update=103;
    static int Search=104;
     String TABLE_NAME ="StudentList";
     String REGISTRATIONNO="registrationNumber";
     String FULLNAME = "fullname";
     String CLASS = "classname";
     String ADDRESS="address";
     String MOBILE="mobile";

    String REGISTRATION_NUM_INTANT_KEY="registrationNumber";
    String REGISTRATION_NAME_INTANT_KEY="registration";

}
