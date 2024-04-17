package com.example.ams;

import android.app.assist.AssistStructure;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class PersonalDetails extends AppCompatActivity {

    HashMap<String, String> data = new HashMap<>();

    String UserID ;
    Spinner spinnerSemester, spinnerGroup , spinnerCourse , spinnerBranch;
    Button B1, B2, B3 ;
//    EditText UID = findViewById(R.id.edt_uid);
//    EditText name = findViewById(R.id.edt_name);


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef ;
    FirebaseAuth auth ;
    FirebaseUser user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        UserID = user.getEmail().toString().substring(0,10).toUpperCase();
        TextView txtName = findViewById(R.id.TxtName);
        TextView txtUid = findViewById(R.id.textUid);
        TextView txtCgpa = findViewById(R.id.textCgpa);
        EditText nameEditText = findViewById(R.id.edt_name);
        EditText uidEditText = findViewById(R.id.edt_uid);
        EditText cgpaEditText = findViewById(R.id.CgpaVal);
        spinnerSemester = findViewById(R.id.spinnerSemester);
        spinnerGroup = findViewById(R.id.spinnerGroup);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        spinnerBranch = findViewById(R.id.spinnerBranch);

        B1 = findViewById(R.id.btn_update_personal);
        B2 = findViewById(R.id.btn_update_teacher);
        B3 = findViewById(R.id.btn_update_subject);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtName.getText().toString();
                String uid = txtUid.getText().toString();
                String Cgpa = txtCgpa.getText().toString();
                String nameVal = nameEditText.getText().toString();
                String uidVal = uidEditText.getText().toString();
                String cgpaval = cgpaEditText.getText().toString();

                data.put(name, nameVal);
                data.put(uid , uidVal);
                data.put(Cgpa, cgpaval);
                myRef = database.getReference(uidVal).child("PersonalDetail");
                myRef.setValue(data);

            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               writeToFirebase(UserID);

            }
        });

        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String selectedSemester = parentView.getItemAtPosition(position).toString();
                addToData("Semester", selectedSemester);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {
                // Do nothing here
            }
        });
        spinnerGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String selectedGroup = parentView.getItemAtPosition(position).toString();
                addToData("Group", selectedGroup);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {
                // Do nothing here
            }
        });
        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String selectedCourse = parentView.getItemAtPosition(position).toString();
                addToData("Course", selectedCourse);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {
                // Do nothing here
            }
        });
        spinnerBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String selectedBranch = parentView.getItemAtPosition(position).toString();
                addToData("Branch", selectedBranch);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {
                // Do nothing here
            }
        });





        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> Secadapter = ArrayAdapter.createFromResource(this, R.array.semester_options,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> Grpadapter = ArrayAdapter.createFromResource(this, R.array.group_options,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> Crsadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.course_options,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> Brnadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.branch_options,android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        Secadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grpadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Crsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Brnadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Apply the adapter to the spinner
        spinnerSemester.setAdapter(Secadapter);
        spinnerGroup.setAdapter(Grpadapter);
        spinnerCourse.setAdapter(Crsadapter);
        spinnerBranch.setAdapter(Brnadapter);


        Spinner spinnerT = findViewById(R.id.spinnerT);
        Spinner spinnerS = findViewById(R.id.spinnerS);
        LinearLayout containerLayoutT = findViewById(R.id.containerLayoutT);
        LinearLayout containerLayoutS = findViewById(R.id.containerLayoutS);

        String[] teacherNumbers = getResources().getStringArray(R.array.teacher_numbers);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, teacherNumbers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerT.setAdapter(adapter);
        spinnerS.setAdapter(adapter);

        spinnerT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int selectedNumber = Integer.parseInt(teacherNumbers[position]);
                updateLayoutT(selectedNumber);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        spinnerS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int selectedNumber = Integer.parseInt(teacherNumbers[position]);
                updateLayoutS(selectedNumber);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });
        spinnerS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int selectedNumber = Integer.parseInt(teacherNumbers[position]);
                updateLayoutS(selectedNumber);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });



    }

    private void addToData(String key, String value) {
        data.put(key, value);
    }


    private void updateLayoutT(int selectedNumber) {
        LinearLayout containerLayout = findViewById(R.id.containerLayoutT);
        containerLayout.removeAllViews();

        for (int i = 1; i <= selectedNumber; i++) {
            // Create a horizontal LinearLayout for each teacher
            LinearLayout teacherLayout = new LinearLayout(this);
            teacherLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            teacherLayout.setOrientation(LinearLayout.HORIZONTAL);

            // Create EditText for teacher's name
            EditText nameEditText = new EditText(this);
            nameEditText.setHint("Teacher's name");
            LinearLayout.LayoutParams nameParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
            nameParams.setMargins(10, 0, 8, 0); // Optional: Add margin between EditText views
            nameEditText.setLayoutParams(nameParams);
            teacherLayout.addView(nameEditText);

            // Create EditText for the subject they teach
            EditText subjectEditText = new EditText(this);
            subjectEditText.setHint("Subject's name");
            LinearLayout.LayoutParams subjectParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
            subjectEditText.setLayoutParams(subjectParams);
            teacherLayout.addView(subjectEditText);

            containerLayout.addView(teacherLayout);

            // Optional: Add margin between teacher details
            if (i < selectedNumber) {
                View marginView = new View(this);
                marginView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 16)); // Adjust the margin as needed
                containerLayout.addView(marginView);
            }
        }
    }

    // Use this method to write data to Firebase
    private void writeToFirebase(String uid) {
        DatabaseReference myRef = database.getReference(uid).child("TeacherDetail");

        LinearLayout containerLayoutT = findViewById(R.id.containerLayoutT);
        for (int i = 0; i < containerLayoutT.getChildCount(); i++) {
            View view = containerLayoutT.getChildAt(i);

            if (view instanceof LinearLayout) {
                LinearLayout teacherLayout = (LinearLayout) view;
                EditText nameEditText = (EditText) teacherLayout.getChildAt(0);
                EditText subjectEditText = (EditText) teacherLayout.getChildAt(1);

                String teacherName = nameEditText.getText().toString();
                String subjectName = subjectEditText.getText().toString();

                // Write data to Firebase
                DatabaseReference teacherRef = myRef.child("Teacher" + i);
                teacherRef.child("Name").setValue(teacherName);
                teacherRef.child("Subject").setValue(subjectName);
            }
        }
        DatabaseReference teacherRef = myRef.child("Teacher" );
        teacherRef.child("Mentor").setValue(((EditText)findViewById(R.id.edt_mentor)).getText().toString());


    }
    private void updateLayoutS(int selectedNumber) {
        LinearLayout containerLayout = findViewById(R.id.containerLayoutS);
        containerLayout.removeAllViews();

        for (int i = 1; i <= selectedNumber; i++) {
            // Create a horizontal LinearLayout for each teacher
            LinearLayout subjectLayout = new LinearLayout(this);
            subjectLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            subjectLayout.setOrientation(LinearLayout.VERTICAL);

            // Create EditText for teacher's name
            EditText nameEditText = new EditText(this);
            nameEditText.setHint("Subject name");
            LinearLayout.LayoutParams nameParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            nameParams.setMargins(0, 0, 0, 8); // Optional: Add margin between EditText views
            nameEditText.setLayoutParams(nameParams);
            subjectLayout.addView(nameEditText);

            // Create EditText for the subject they teach
            EditText subjectEditText = new EditText(this);
            subjectEditText.setHint("Total lectures");
            LinearLayout.LayoutParams subjectParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            subjectEditText.setLayoutParams(subjectParams);
            subjectLayout.addView(subjectEditText);

            // Create EditText for Total lectures
            EditText totalLecturesEditText = new EditText(this);
            totalLecturesEditText.setHint("Attended lectures");
            LinearLayout.LayoutParams totalLecturesParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            totalLecturesEditText.setLayoutParams(totalLecturesParams);
            subjectLayout.addView(totalLecturesEditText);

            // Create EditText for Lectures delivered
            EditText lecturesDeliveredEditText = new EditText(this);
            lecturesDeliveredEditText.setHint("Duty Leaves");
            LinearLayout.LayoutParams lecturesDeliveredParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lecturesDeliveredEditText.setLayoutParams(lecturesDeliveredParams);
            subjectLayout.addView(lecturesDeliveredEditText);
            lecturesDeliveredParams.setMargins(0,0,0,120);


            containerLayout.addView(subjectLayout);

            // Optional: Add margin between teacher details
            if (i < selectedNumber) {
                View marginView = new View(this);
                marginView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 16)); // Adjust the margin as neededcontainerLayout.addView(marginView);
            }
        }
    }

}
