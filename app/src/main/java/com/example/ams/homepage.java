package com.example.ams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class homepage extends AppCompatActivity {

    static class period
    {
        String subject , Faculty , Room , From , To , Day ;

        public period(String subject, String faculty, String room, String from, String to, String day) {
            this.subject = subject;
            Faculty = faculty;
            Room = room;
            From = from;
            To = to;
            Day = day;
        }
    }

    static FirebaseAuth auth;
    static FirebaseUser user;
    FirebaseDatabase databse = FirebaseDatabase.getInstance();

    static String AttendSub="";
    FloatingActionButton noti;
    TextView uid, name, section;
    Dialog popDialog ;
    ListView SubLV;

    TextView b5t1name , b5t2name , b5t3name , b5t4name , b5t5name, b5t6name , b5t7name ,b5t8name, b5t1room , b5t2room , b5t3room , b5t4room , b5t5room,  b5t6room , b5t7room ,b5t8room, b5t1from , b5t2from , b5t3from , b5t4from , b5t5from , b5t6from , b5t7from ,b5t8from, b5t1to , b5t2to , b5t3to , b5t4to , b5t5to,  b5t6to , b5t7to ,b5t8to ;
    TextView b2t1next , b2t2next , b2t3next , b2t4next , b2t5next , b2t6next , b2t7next , b2t8next , b2t9next , b2t10next ;
    TextView b1t2nxtlec,b1t1nxtlec,b1t3nxtlec,b1t4nxtlec,b1t5nxtlec,b1t6nxtlec,b1t7nxtlec;
    TextView b1t2name,b1t1name,b1t3name,b1t4name,b1t5name,b1t6name,b1t7name;
    CardView A1, A2, A3, A4, A5, A6, A7, A8, A9, A10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        auth = FirebaseAuth.getInstance();
        Intent logIn = new Intent(getApplicationContext(), Login.class);
        user = auth.getCurrentUser();
        if (user == null || auth == null) {
            startActivity(logIn);
            finish();
        }
        else
        {
            popDialog = new Dialog(this);

            SubLV = findViewById(R.id.SubLV);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            uid = findViewById(R.id.uid);
            name = findViewById(R.id.name_heading);
            section = findViewById(R.id.sec_top);
            ImageButton setting = findViewById(R.id.settings);
            noti = findViewById(R.id.notifications);

            ArrayList<String> ArrSub = new ArrayList<>();

            period[][] TT = new period[7][8];
            setHeaderData();
            updateAttendance(getCurrentDay() , getCurrentTimeFormatted());
            setAttendanceData("APTITUDE II");
            {
                A1 = findViewById(R.id.A1);
                A2 = findViewById(R.id.A2);
                A3 = findViewById(R.id.A3);
                A4 = findViewById(R.id.A4);
                A5 = findViewById(R.id.A5);
                A6 = findViewById(R.id.A6);
                A7 = findViewById(R.id.A7);
                A8 = findViewById(R.id.A8);
                A9 = findViewById(R.id.A9);
                A10 = findViewById(R.id.A10);

                b1t2nxtlec = findViewById(R.id.b1t2nxtlec);
                b1t1nxtlec = findViewById(R.id.b1t1nxtlec);
                b1t3nxtlec = findViewById(R.id.b1t3nxtlec);
                b1t4nxtlec = findViewById(R.id.b1t4nxtlec);
                b1t5nxtlec = findViewById(R.id.b1t5nxtlec);
                b1t6nxtlec = findViewById(R.id.b1t6nxtlec);
                b1t7nxtlec = findViewById(R.id.b1t7nxtlec);

                b1t1name = findViewById(R.id.b1t1name);
                b1t2name = findViewById(R.id.b1t2name);
                b1t3name = findViewById(R.id.b1t3name);
                b1t4name = findViewById(R.id.b1t4name);
                b1t5name = findViewById(R.id.b1t5name);
                b1t6name = findViewById(R.id.b1t6name);
                b1t7name = findViewById(R.id.b1t7name);

                b2t1next = findViewById(R.id.b2t1next);
                b2t2next = findViewById(R.id.b2t2next);
                b2t3next = findViewById(R.id.b2t3next);
                b2t4next = findViewById(R.id.b2t4next);
                b2t5next = findViewById(R.id.b2t5next);
                b2t6next = findViewById(R.id.b2t6next);
                b2t7next = findViewById(R.id.b2t7next);
                b2t8next = findViewById(R.id.b2t8next);
                b2t9next = findViewById(R.id.b2t9next);
                b2t10next = findViewById(R.id.b2t10next);

                b5t1name = findViewById(R.id.b5t1name);
                b5t2name = findViewById(R.id.b5t2name);
                b5t3name = findViewById(R.id.b5t3name);
                b5t4name = findViewById(R.id.b5t4name);
                b5t5name = findViewById(R.id.b5t5name);
                b5t6name = findViewById(R.id.b5t6name);
                b5t7name = findViewById(R.id.b5t7name);
                b5t8name = findViewById(R.id.b5t8name);

                b5t1room = findViewById(R.id.b5t1room);
                b5t2room = findViewById(R.id.b5t2room);
                b5t3room = findViewById(R.id.b5t3room);
                b5t4room = findViewById(R.id.b5t4room);
                b5t5room = findViewById(R.id.b5t5room);
                b5t6room = findViewById(R.id.b5t6room);
                b5t7room = findViewById(R.id.b5t7room);
                b5t8room = findViewById(R.id.b5t8room);

                b5t1from = findViewById(R.id.b5t1from);
                b5t2from = findViewById(R.id.b5t2from);
                b5t3from = findViewById(R.id.b5t3from);
                b5t4from = findViewById(R.id.b5t4from);
                b5t5from = findViewById(R.id.b5t5from);
                b5t6from = findViewById(R.id.b5t6from);
                b5t7from = findViewById(R.id.b5t7from);
                b5t8from = findViewById(R.id.b5t8from);

                b5t1to = findViewById(R.id.b5t1to);
                b5t2to = findViewById(R.id.b5t2to);
                b5t3to = findViewById(R.id.b5t3to);
                b5t4to = findViewById(R.id.b5t4to);
                b5t5to = findViewById(R.id.b5t5to);
                b5t6to = findViewById(R.id.b5t6to);
                b5t7to = findViewById(R.id.b5t7to);
                b5t8to = findViewById(R.id.b5t8to);
            }
                TextView[][] arr = {
                        {b5t1name, b5t1room, b5t1from, b5t1to},
                        {b5t2name, b5t2room, b5t2from, b5t2to},
                        {b5t3name, b5t3room, b5t3from, b5t3to},
                        {b5t4name, b5t4room, b5t4from, b5t4to},
                        {b5t5name, b5t5room, b5t5from, b5t5to},
                        {b5t6name, b5t6room, b5t6from, b5t6to},
                        {b5t7name, b5t7room, b5t7from, b5t7to},
                        {b5t8name, b5t8room, b5t8from, b5t8to}
                };

                TextView[] TNext = {b1t2nxtlec, b1t1nxtlec, b1t3nxtlec, b1t4nxtlec, b1t5nxtlec, b1t6nxtlec, b1t7nxtlec};
                TextView[] TName = {b1t2name, b1t1name, b1t3name, b1t4name, b1t5name, b1t6name, b1t7name};
                String[] Subjects = {"APTITUDE II", "DBMS", "MATH", "PYTHON", "IS", "GP 4", "GENDER EQ", "SOFT SKILLS", "MINI PROJECT", "OS"};
                TextView[] arr2 = {b2t1next, b2t2next, b2t3next, b2t4next, b2t5next, b2t6next, b2t7next, b2t8next, b2t9next, b2t10next};
                CardView[] Attend = {A1, A2, A3, A4, A5, A6, A7, A8, A9, A10};

            setTimeTable(arr, arr2, Subjects, TName, TNext);

            for(int a = 0 ;a < 10 ; a++)
            {
                int finalA = a;
                Attend[a].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        AttendSub = (Subjects[finalA]);
                        setAttendanceData(AttendSub);
                        ((TextView)findViewById(R.id.DetailSub)).setText(AttendSub);
                        ArrSub.clear();
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
                        myRef.child("22BCS12121").child("AttendanceDetail").child(AttendSub).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                // Handle the data change
                                if (dataSnapshot.exists()) {

                                    long count = (long)dataSnapshot.child("count").getValue();
                                    Toast.makeText(getApplicationContext() , "clicked" , Toast.LENGTH_SHORT).show();
                                    for(long i = 1 ; i <= count ; i++ )
                                        ArrSub.add(dataSnapshot.child(Long.toString(i)).getValue(String.class));
                                    ArrayAdapter<String> SubAdapter = new ArrayAdapter<>(getApplicationContext() , R.layout.activity_lv , ArrSub);
                                    SubLV.setAdapter(SubAdapter);

                                }else {
                                    ArrayAdapter<String> SubAdapter = new ArrayAdapter<>(getApplicationContext() , R.layout.activity_lv , ArrSub);
                                    SubLV.setAdapter(SubAdapter);
                                    // Data does not exist for the specified key
                                    // Handle this case if needed
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                // Handle errors, if any
                            }
                        });
                    }
                });
            }

            setting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent gotoSetting = new Intent(getApplicationContext(), Settings.class);
                    startActivity(gotoSetting);
                }
            });
        }
    }

    private void updateAttendance(String currentDay, String currentTimeFormatted) {
        int Day = Integer.parseInt(currentDay.substring(3,4));
        int Period = getPeriodCount(currentTimeFormatted);

        DatabaseReference MyDbase = databse.getReference("22BCS12121").child("LastUpdated");
        MyDbase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String PrevDate = (String) dataSnapshot.child("Date").getValue();
                    int PrevPeriod = (int) dataSnapshot.child("Period").getValue();

                    Date today = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String todayFormatted = dateFormat.format(today);
                    String dayDiff[] = calculateDaysBetween( todayFormatted , PrevDate);
                    for(String DayIndividual : dayDiff)
                    {
                        dayOfWeekNumber(DayIndividual);
                    }
                    Toast.makeText(getApplicationContext() , todayFormatted , Toast.LENGTH_SHORT).show();

                }
                else {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors if any
            }
        });

    }

    public static String dayOfWeekNumber(String dateStr) {
        // Parse the input date string into a LocalDate object
        LocalDate localDate = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            localDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        // Get the day of the week as a number (1 for Monday, 2 for Tuesday, ..., 7 for Sunday)
        int dayOfWeekNumber = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dayOfWeekNumber = localDate.getDayOfWeek().getValue();
        }

        return "Day"+dayOfWeekNumber;
    }

    public static String[] calculateDaysBetween(String startDateStr, String endDateStr) {
        // Parse the input date strings into LocalDate objects
        LocalDate startDate = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startDate = LocalDate.parse(startDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        LocalDate endDate = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            endDate = LocalDate.parse(endDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        // Calculate the number of days between the two dates
        int daysBetween = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            daysBetween = (int) startDate.until(endDate).getDays();
        }

        // Create a list to store the dates
        List<String> datesList = new ArrayList<>();

        // Populate the list with dates
        for (int i = 0; i <= daysBetween; i++) {
            LocalDate currentDate = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                currentDate = startDate.plusDays(i);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                datesList.add(currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }
        }

        // Convert the list to an array
        String[] datesArray = datesList.toArray(new String[0]);

        return datesArray;
    }

    private void setAttendanceData(String sub) {
        DatabaseReference MyDbase = databse.getReference("22BCS12121").child("AttendanceDetail").child(sub);

        MyDbase.child("count").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    long currentCount = (long) dataSnapshot.getValue();
                    MyDbase.child("count").setValue(currentCount + 1);
                    MyDbase.child(Long.toString(currentCount+1)).setValue("Present");
                } else {
                    MyDbase.child(Integer.toString(1)).setValue("Present");
                    MyDbase.child("count").setValue(1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors if any
            }
        });

        // Set the value of "Present"
//        MyDbase.child("status").setValue("Present");
    }


    private void setTimeTable(TextView[][] arr, TextView[] arr2, String[] Subject , TextView[] TName , TextView[] TNext) {
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
        myRef.child("22BCS12121").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Handle the data change
                if (dataSnapshot.exists()) {
                    TextView name_heading = findViewById(R.id.name_heading);
                    TextView uid = findViewById(R.id.uid);
                    TextView sec = findViewById(R.id.sec_top);
                    TextView cgpa = findViewById(R.id.cgpa_top);

                    for(int a = 0 ; a < 8  ; a++)
                    {
                        arr[a][0].setText(dataSnapshot.child("TimeTable").child(getCurrentDay()).child("L"+Integer.toString(a+1)).child("Subject").getValue(String.class));
                        arr[a][1].setText(dataSnapshot.child("TimeTable").child(getCurrentDay()).child("L"+Integer.toString(a+1)).child("Room").getValue(String.class));
                        arr[a][2].setText(arr[a][2].getText()+dataSnapshot.child("TimeTable").child(getCurrentDay()).child("L"+Integer.toString(a+1)).child("From Time").getValue(String.class));
                        arr[a][3].setText(arr[a][3].getText()+dataSnapshot.child("TimeTable").child(getCurrentDay()).child("L"+Integer.toString(a+1)).child("To Time").getValue(String.class));
                    }

                    //some amendments here
                    for(int a = 0 ;  a < 10 ; a ++)
                    {
                        String next = "unknown";
                        int x = getPeriodCount(getCurrentTimeFormatted());
                        int x2 = x ;
                        int y = Integer.parseInt(getCurrentDay().substring(3,4)) - 2;
                        int y2 = y ;
                        int z = y*8 + x ;
                        boolean broke = false ;
                        outer:
                        for(int i = y2 ; i <= 4 ; i++)
                        {
                            for(int j = x2 ; j <= 7 ; j++)
                            {
                                next = Integer.toString(i)+Integer.toString(j);
                                if(dataSnapshot.child("Sequence").child(Subject[a]).hasChild(next))
                                {
                                    next = getDateTime(next , arr2[a].getText().toString());
                                    arr2[a].setText(arr2[a].getText() + next);
                                    broke = true ;
                                    break outer;
                                }
                            }
                            x2 = 0 ;
                        }
                        if(!broke)
                        {
                            outer:
                            for(int i = 0 ; i <= y2 ; i++)
                            {
                                x2 = 7 ;
                                for(int j = 0 ; j <= x2 ; j++)
                                {
                                    next = Integer.toString(i)+Integer.toString(j);
                                    if(dataSnapshot.child("Sequence").child(Subject[a]).hasChild(next))
                                    {
                                        next = getDateTime(next , arr2[a].getText().toString());
                                        arr2[a].setText(arr2[a].getText() + next);
                                        break outer;
                                    }
                                }
                                if(i==y2)
                                    x2 = x ;

                            }
                        }

                    }

                    for(int a = 0 ;a < 7 ; a ++)
                    {
                        String next = "unknown";
                        int x = getPeriodCount(getCurrentTimeFormatted());
                        int x2 = x ;
                        int y = Integer.parseInt(getCurrentDay().substring(3,4)) - 2;
                        int y2 = y ;
                        int z = y*8 + x ;
                        boolean broke = false ;
                        outer:
                        for(int i = y2 ; i <= 4 ; i++)
                        {
                            for(int j = x2 ; j <= 7 ; j++)
                            {
                                next = Integer.toString(i)+Integer.toString(j);
                                if(dataSnapshot.child("TeacherSequence").child(TName[a].getText().toString()).hasChild(next))
                                {
                                    next = getDateTime(next  , TNext[a].getText().toString());
                                    TNext[a].setText(TNext[a].getText() + next);
                                    broke = true ;
                                    break outer;
                                }
                            }
                            x2 = 0 ;
                        }
                        if(!broke)
                        {
                            outer:
                            for(int i = 0 ; i <= y2 ; i++)
                            {
                                x2 = 7 ;
                                for(int j = 0 ; j <= x2 ; j++)
                                {
                                    next = Integer.toString(i)+Integer.toString(j);
                                    if(dataSnapshot.child("TeacherSequence").child(TName[a].getText().toString()).hasChild(next))
                                    {
                                        next = getDateTime(next , TNext[a].getText().toString());
                                        TNext[a].setText(TNext[a].getText() +next);
                                        break outer;
                                    }
                                }
                                if(i==y2)
                                    x2 = x ;

                            }
                        }

                    }

                } else {
                    // Data does not exist for the specified key
                    // Handle this case if needed
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors, if any
            }
        });
    }

    private String getDateTime(String next, String predata) {
        int x = Integer.parseInt(next.substring(0,1));
        int y = Integer.parseInt(next.substring(1,2));
        String data = "", space = "";
        for(int a = 0 ; a < predata.length() ; a++)
            space = space + "";

        switch(x)
        {
            case 0:
            {
                data = "Monday";
                break;
            }
            case 1:
            {
                data = "Tuesday";
                break;
            }
            case 2:
            {
                data = "Wednesday";
                break;
            }
            case 3:
            {
                data = "Thursday";
                break;
            }
            case 4:
            {
                data = "Friday";
                break;
            }
            default:
            {
                data = "holiday";
            }
        }
        switch (y)
        {
            case 0:
            {
                data = data+" 9:30-10:20";
                break;
            }
            case 1:
            {
                data = data+ " 10:20-11:10";
                break;
            }
            case 2:
            {
                data = data+" 11:10-12:00";
                break;
            }
            case 3:
            {
                data = data+" 12:00-12:50";
                break;
            }
            case 4:
            {
                data = data+ " 01:00-01:50";
                break;
            }
            case 5:
            {
                data = data+" 01:50-02:40";
                break;
            }
            case 6:
            {
                data = data+ " 02:40-03:30";
                break;
            }
            case 7:
            {
                data = data+" 03:30-04:20";
                break;
            }
            default:
            {
                data = data +" ? ";
            }
        }
        return data;

    }

    private int getPeriodCount(String currentTimeFormatted) {
        String num1 =  currentTimeFormatted.substring(0, currentTimeFormatted.indexOf(':')) ;
        String num2 = currentTimeFormatted.substring( currentTimeFormatted.indexOf(':')+1 , currentTimeFormatted.length()) ;
        int min =Integer.parseInt(num1)*60+ Integer.parseInt(num2);
        if(min < 570)
            return 0;
        else if(min < 620)
            return 1;
        else if(min < 670)
            return 2;
        else if(min < 730)
            return 3;
        else if(min < 790)
            return 4 ;
        else if(min < 840)
            return 5;
        else if(min < 890)
            return 6 ;
        else if(min < 940)
            return 7 ;
        else
            return 8 ;
    }

    private String getCurrentTimeFormatted() {
        LocalTime currentTime = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            currentTime = LocalTime.now();
        }
        DateTimeFormatter formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("HH:mm");
        }
        String formattedTime = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formattedTime = currentTime.format(formatter);
        }
        return formattedTime;
    }

    private String getCurrentDay() {
        // Get the current day of the week
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return "day" + dayOfWeek;
    }

    private void setHeaderData() {
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
        myRef.child("22BCS12121").child("PersonalDetail").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Handle the data change
                if (dataSnapshot.exists()) {
                    // Data exists, retrieve the value
                    String name = dataSnapshot.child("Name").getValue(String.class);
                    String UID = dataSnapshot.child("UID").getValue(String.class);
                    String Sec = dataSnapshot.child("Semester").getValue(String.class);
                    String group = dataSnapshot.child("Group").getValue(String.class);
                    String CGPA = dataSnapshot.child("Current CGPA").getValue(String.class);

                    // Use the retrieved data as needed (e.g., display it in a TextView)
                    TextView name_heading = findViewById(R.id.name_heading);
                    TextView uid = findViewById(R.id.uid);
                    TextView sec = findViewById(R.id.sec_top);
                    TextView cgpa = findViewById(R.id.cgpa_top);

                    name_heading.setText(name);
                    uid.setText(UID);
                    sec.setText(sec.getText().toString()+Sec+" "+group);
                    cgpa.setText(cgpa.getText().toString()+ CGPA);
                } else {
                    // Data does not exist for the specified key
                    // Handle this case if needed
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors, if any
            }
        });
    }
}

