package com.example.ams;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TimeTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        Button UpdateTimeTable = findViewById(R.id.UpdateTimeTable);
        String x = "21s";
        EditText s11,f11,r11, s12,f12,r12, s13,f13,r13, s14,f14,r14, s15,f15,r15, s16,f16,r16, s17,f17,r17, s18,f18,r18, s21,f21,r21, s22,f22,r22, s23,f23,r23, s24,f24,r24, s25,f25,r25, s26,f26,r26, s27,f27,r27, s28,f28,r28, s31,f31,r31, s32,f32,r32, s33,f33,r33, s34,f34,r34, s35,f35,r35, s36,f36,r36, s37,f37,r37, s38,f38,r38, s41,f41,r41, s42,f42,r42, s43,f43,r43, s44,f44,r44, s45,f45,r45, s46,f46,r46, s47,f47,r47, s48,f48,r48, s51,f51,r51, s52,f52,r52, s53,f53,r53, s54,f54,r54, s55,f55,r55, s56,f56,r56, s57,f57,r57, s58,f58,r58;
        s11 = findViewById(R.id.s11);
        f11 = findViewById(R.id.f11);
        r11 = findViewById(R.id.r11);

        s12 = findViewById(R.id.s12);
        f12 = findViewById(R.id.f12);
        r12 = findViewById(R.id.r12);

        s13 = findViewById(R.id.s13);
        f13 = findViewById(R.id.f13);
        r13 = findViewById(R.id.r13);

        s14 = findViewById(R.id.s14);
        f14 = findViewById(R.id.f14);
        r14 = findViewById(R.id.r14);

        s15 = findViewById(R.id.s15);
        f15 = findViewById(R.id.f15);
        r15 = findViewById(R.id.r15);

        s16 = findViewById(R.id.s16);
        f16 = findViewById(R.id.f16);
        r16 = findViewById(R.id.r16);

        s17 = findViewById(R.id.s17);
        f17 = findViewById(R.id.f17);
        r17 = findViewById(R.id.r17);

        s18 = findViewById(R.id.s18);
        f18 = findViewById(R.id.f18);
        r18 = findViewById(R.id.r18);

        s21 = findViewById(R.id.s21);
        f21 = findViewById(R.id.f21);
        r21 = findViewById(R.id.r21);

        s22 = findViewById(R.id.s22);
        f22 = findViewById(R.id.f22);
        r22 = findViewById(R.id.r22);

        s23 = findViewById(R.id.s23);
        f23 = findViewById(R.id.f23);
        r23 = findViewById(R.id.r23);

        s24 = findViewById(R.id.s24);
        f24 = findViewById(R.id.f24);
        r24 = findViewById(R.id.r24);

        s25 = findViewById(R.id.s25);
        f25 = findViewById(R.id.f25);
        r25 = findViewById(R.id.r25);

        s26 = findViewById(R.id.s26);
        f26 = findViewById(R.id.f26);
        r26 = findViewById(R.id.r26);

        s27 = findViewById(R.id.s27);
        f27 = findViewById(R.id.f27);
        r27 = findViewById(R.id.r27);

        s28 = findViewById(R.id.s28);
        f28 = findViewById(R.id.f28);
        r28 = findViewById(R.id.r28);

        s31 = findViewById(R.id.s31);
        f31 = findViewById(R.id.f31);
        r31 = findViewById(R.id.r31);

        s32 = findViewById(R.id.s32);
        f32 = findViewById(R.id.f32);
        r32 = findViewById(R.id.r32);

        s33 = findViewById(R.id.s33);
        f33 = findViewById(R.id.f33);
        r33 = findViewById(R.id.r33);

        s34 = findViewById(R.id.s34);
        f34 = findViewById(R.id.f34);
        r34 = findViewById(R.id.r34);

        s35 = findViewById(R.id.s35);
        f35 = findViewById(R.id.f35);
        r35 = findViewById(R.id.r35);

        s36 = findViewById(R.id.s36);
        f36 = findViewById(R.id.f36);
        r36 = findViewById(R.id.r36);

        s37 = findViewById(R.id.s37);
        f37 = findViewById(R.id.f37);
        r37 = findViewById(R.id.r37);

        s38 = findViewById(R.id.s38);
        f38 = findViewById(R.id.f38);
        r38 = findViewById(R.id.r38);

        s41 = findViewById(R.id.s41);
        f41 = findViewById(R.id.f41);
        r41 = findViewById(R.id.r41);

        s42 = findViewById(R.id.s42);
        f42 = findViewById(R.id.f42);
        r42 = findViewById(R.id.r42);

        s43 = findViewById(R.id.s43);
        f43 = findViewById(R.id.f43);
        r43 = findViewById(R.id.r43);

        s44 = findViewById(R.id.s44);
        f44 = findViewById(R.id.f44);
        r44 = findViewById(R.id.r44);

        s45 = findViewById(R.id.s45);
        f45 = findViewById(R.id.f45);
        r45 = findViewById(R.id.r45);

        s46 = findViewById(R.id.s46);
        f46 = findViewById(R.id.f46);
        r46 = findViewById(R.id.r46);

        s47 = findViewById(R.id.s47);
        f47 = findViewById(R.id.f47);
        r47 = findViewById(R.id.r47);

        s48 = findViewById(R.id.s48);
        f48 = findViewById(R.id.f48);
        r48 = findViewById(R.id.r48);

        s51 = findViewById(R.id.s51);
        f51 = findViewById(R.id.f51);
        r51 = findViewById(R.id.r51);

        s52 = findViewById(R.id.s52);
        f52 = findViewById(R.id.f52);
        r52 = findViewById(R.id.r52);

        s53 = findViewById(R.id.s53);
        f53 = findViewById(R.id.f53);
        r53 = findViewById(R.id.r53);

        s54 = findViewById(R.id.s54);
        f54 = findViewById(R.id.f54);
        r54 = findViewById(R.id.r54);

        s55 = findViewById(R.id.s55);
        f55 = findViewById(R.id.f55);
        r55 = findViewById(R.id.r55);

        s56 = findViewById(R.id.s56);
        f56 = findViewById(R.id.f56);
        r56 = findViewById(R.id.r56);

        s57 = findViewById(R.id.s57);
        f57 = findViewById(R.id.f57);
        r57 = findViewById(R.id.r57);

        s58 = findViewById(R.id.s58);
        f58 = findViewById(R.id.f58);
        r58 = findViewById(R.id.r58);

        EditText[][] arr = {{s11, f11, r11}, {s12, f12, r12}, {s13, f13, r13}, {s14, f14, r14}, {s15, f15, r15}, {s16, f16, r16}, {s17, f17, r17}, {s18, f18, r18}, {s21, f21, r21}, {s22, f22, r22}, {s23, f23, r23}, {s24, f24, r24}, {s25, f25, r25}, {s26, f26, r26}, {s27, f27, r27}, {s28, f28, r28}, {s31, f31, r31}, {s32, f32, r32}, {s33, f33, r33}, {s34, f34, r34}, {s35, f35, r35}, {s36, f36, r36}, {s37, f37, r37}, {s38, f38, r38}, {s41, f41, r41}, {s42, f42, r42}, {s43, f43, r43}, {s44, f44, r44}, {s45, f45, r45}, {s46, f46, r46}, {s47, f47, r47}, {s48, f48, r48}, {s51, f51, r51}, {s52, f52, r52}, {s53, f53, r53}, {s54, f54, r54}, {s55, f55, r55}, {s56, f56, r56}, {s57, f57, r57}, {s58, f58, r58}};
        String[] Subjects = {"FREE" , "APTITUDE II" , "DBMS" , "MATH" , "PYTHON" , "IS" , "GP 4" , "GENDER EQ" , "SOFT SKILLS" , "MINI PROJECT" , "OS"};
        int[] count = {0,0,0,0,0,0,0,0,0,0};
        DatabaseReference myRef = database.getReference("22BCS12121");
        String lec[] = new String[40];
        final int[] cnt = {0};
        UpdateTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int a = 0 ; a < 5 ; a++)
                {
                    String key = "day"+Integer.toString(a+2);
                    for(int b = 0 ; b < 8 ; b++)
                    {
                        String subkey = "L"+Integer.toString(b+1);
                        String SubjectValue = arr[(a*8)+b][0].getText().toString();
                        String FacultyValue = arr[(a*8)+b][1].getText().toString();
                        String RoomValue = arr[(a*8)+b][2].getText().toString();

                        if(SubjectValue.isEmpty())
                            SubjectValue= "Free";
                        if(FacultyValue.isEmpty())
                            FacultyValue = "None";
                        if(RoomValue.isEmpty())
                            RoomValue = "000";

                        String FromTime = findFromTime(b , SubjectValue);
                        String ToTime = findToTime(b , SubjectValue);

                        myRef.child("TimeTable").child(key).child(subkey).child("Subject").setValue(SubjectValue);
                        myRef.child("TimeTable").child(key).child(subkey).child("Faculty").setValue(FacultyValue);
                        myRef.child("TimeTable").child(key).child(subkey).child("Room").setValue(RoomValue);
                        myRef.child("TimeTable").child(key).child(subkey).child("From Time").setValue(FromTime);
                        myRef.child("TimeTable").child(key).child(subkey).child("To Time").setValue(ToTime);

                        myRef.child("TeacherSequence").child(FacultyValue).child(Integer.toString(a)+Integer.toString(b)).setValue(Integer.toString(a)+Integer.toString(b));
                        myRef.child("Sequence").child(SubjectValue).child(Integer.toString(a)+Integer.toString(b)).setValue(Integer.toString(a)+Integer.toString(b));
//                        lec[cnt[0]++] = SubjectValue;



//                        int cnt = indexOf(Subjects, SubjectValue);
//                        myRef.child("Sequence").child(SubjectValue).child(Integer.toString(++count[cnt])).child("Room").setValue(RoomValue);
//                        myRef.child("Sequence").child(SubjectValue).child(Integer.toString(++count[cnt])).child("From").setValue(FromTime);
//                        myRef.child("Sequence").child(SubjectValue).child(Integer.toString(++count[cnt])).child("To").setValue(ToTime);
                    }
                }
//                cnt[0] = 0 ;
//                for(int a = 0 ;  a < 40 ; a ++)
//                {
//                    myRef.child("Sequence").child(Integer.toString(a+1)).setValue(lec[a]);
//                }
//                myRef.child("Sequence").setValue(lec);
            }
        });

    }

    private int indexOf(String[] subjects, String subjectValue) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjectValue.equals(subjects[i])) {
                return i;
            }
        }
        return -1; // Return -1 if the value is not found
    }


    private String findToTime(int b, String subjectValue) {
        int min = 30 ;
        if(b < 3)
        {
            min = min + (50*(b+1));

        }
        else if(b > 3)
        {
            min = min + (50*(b+1)+10);
        }
        else
        {
            if(subjectValue.equals("Free"))
            {
                min = 240;
            }
            else
            {
                min = 230 ;
            }
        }
        int h = 9 ;
        h = (h+(min/60))%12;
        if(h == 0)
            h = 12 ;
        min = min%60;
        String time = Integer.toString(h) +":"+ (Integer.toString(min).length()==0 ? "0"+Integer.toString(min) : Integer.toString(min));
        return time ;
    }

    private String findFromTime(int b, String subjectValue) {
        int min = 30 ;
        if(b>=4)
            min+= (50*b) + 10 ;
        else
            min+= (50*b) ;
        int h = 9 ;
        h = (h+(min/60))%12;
        if(h == 0)
            h = 12;
        min = min%60;
        String time = Integer.toString(h) +":"+ (Integer.toString(min).length()==0 ? "0"+Integer.toString(min) : Integer.toString(min));
        return time ;
    }
}