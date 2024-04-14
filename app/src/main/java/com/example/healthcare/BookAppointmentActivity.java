package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookAppointmentActivity extends AppCompatActivity {

    List<String> bookedDates = new ArrayList<>();
    List<String> bookedTime = new ArrayList<>();

    EditText ed1,ed2,ed3,ed4;
    TextView tv;
    Button dateButton,timeButton;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    Button btnBack, btnBook;
    String selectedDate,selectedTime;

    DatabaseReference bookApointmentDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        tv=findViewById(R.id.textViewAppTitle);
        ed1=findViewById(R.id.editTextAppFullName);
        ed2=findViewById(R.id.editTextAppAddress);
        ed3=findViewById(R.id.editTextAppContactNumber);
        ed4=findViewById(R.id.editTextAppConsultantFess);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it=getIntent();
        String title=it.getStringExtra("text1");
        String fullname=it.getStringExtra("text2");
        String address=it.getStringExtra("text3");
        String contact=it.getStringExtra("text4");
        String fees=it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Cons. fess "+fees+"Rs");

        btnBack=findViewById(R.id.buttonAppBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class));
            }
        });

        dateButton=findViewById(R.id.buttonAppDate);
        timeButton=findViewById(R.id.buttonAppTime);
//        date picker

        initDatePicker();
        initTimePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });


        DatabaseReference bookedDatesRef = FirebaseDatabase.getInstance().getReference().child("BookApointment");
        bookedDatesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bookedDates.clear();
                bookedTime.clear();// Clear the existing list
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    BookingDetail_Database bookingDetail = snapshot.getValue(BookingDetail_Database.class);
                    if (bookingDetail != null) {
                        bookedDates.add(bookingDetail.getDate());
                        bookedTime.add(bookingDetail.getTime());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });


//        database acitvity

        bookApointmentDbRef= FirebaseDatabase.getInstance().getReference().child("BookApointment");
        btnBook=findViewById(R.id.buttonCheckout);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookedDates.contains(selectedDate) && bookedTime.contains(selectedTime)){
                      Toast.makeText(getApplicationContext(),"Selected Date is Not available. Select anathor date or time...",Toast.LENGTH_SHORT).show();
                }
                else {
                    insertBookingDetailsData();
                    Toast.makeText(getApplicationContext(), "Appointment Booked", Toast.LENGTH_SHORT).show();
                    Intent it=new Intent(BookAppointmentActivity.this,OppointmentSuccessfullActivity.class);
                    it.putExtra("fullname",ed1.getText().toString());
                    it.putExtra("address",ed2.getText().toString());
                    it.putExtra("contact",ed3.getText().toString());
                    it.putExtra("fees",ed4.getText().toString());
                    it.putExtra("date",selectedDate);
                    it.putExtra("time",selectedTime);
                    startActivity(it);
                }
            }
        });

    }

    private void insertBookingDetailsData(){
        String fullname=ed1.getText().toString();
        String address=ed2.getText().toString();
        String contact= ed3.getText().toString();
        String fees=ed4.getText().toString();
        String date=selectedDate;
        String time=selectedTime;
        BookingDetail_Database bookAppointment=new BookingDetail_Database(fullname,address,contact,fees,date,time);
        bookApointmentDbRef.push().setValue(bookAppointment);
    }

//    insert booking data into firebase database
    private  void  initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i, int i1, int i2) {
                i1=i1*+1;
                selectedDate=i2+"/"+i1+"/"+i;
                dateButton.setText(selectedDate);
            }
        };
        Calendar cal=Calendar.getInstance();
        int Year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_DARK;

        datePickerDialog=new DatePickerDialog(this,style,dateSetListener,Year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }
    private  void  initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int i, int i1) {
                i1=i1*+1;
                selectedTime=i+":"+i1;
                timeButton.setText(selectedTime);
            }
        };
        Calendar cal=Calendar.getInstance();
        int hrs=cal.get(Calendar.HOUR);
        int mins=cal.get(Calendar.MINUTE);

        int style= AlertDialog.THEME_HOLO_DARK;

        timePickerDialog=new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);
    }
}