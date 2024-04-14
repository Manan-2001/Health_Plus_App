package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {


    SearchView searchView;
//    Only uses hardcode value instead of using database
    private String[][] doctor_details1={
            {"Doctor Name: Dr.Manan Jain", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "608"},
            {"Doctor Name: Dr.Shruti Bhandekar", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
            {"Doctor Name: Dr.Rasika Zade", "Hospital Address : Pune", "Exp: 3yrs", "Mobile No:8898989898", "300"},
            {"Doctor Name: Dr.Sushrut Silekar", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
            {"Doctor Name: Dr.Ashok Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Chaitali Bhange", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Surya Kumar", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Sushila Bhargave", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Suresh Lambe", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Sudhanshu Kothe", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"}
    };

    private String[][] doctor_details2={
            {"Doctor Name: Dr.Sambhav Jain", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "608"},
            {"Doctor Name: Dr.Pooja Bhandekar", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
            {"Doctor Name: Dr.Swapnil Kale", "Hospital Address : Pune", "Exp: 3yrs", "Mobile No:8898989898", "300"},
            {"Doctor Name: Dr.Shrikant Deshmukh", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
            {"Doctor Name: Dr.Akhilesh Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Ashok Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Shailesh Lodha", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Sushi Shamkar", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Rakhi Luthra", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"}
    };

    private String[][] doctor_details3={
            {"Doctor Name: Dr.Ajit Saste", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "608"},
            {"Doctor Name : Dr.Prasad Pawar", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
            {"Doctor Name: Dr.Swapnil Kale", "Hospital Address : Pune", "Exp: 3yrs", "Mobile No:8898989898", "300"},
            {"Doctor Name: Dr.Deepak Deshmukh", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
            {"Doctor Name: Dr.Trilok Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Komal Jain", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Priyanka pande", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Pihu Nagpal", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Malvika Shende", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"}
    };

    private String[][] doctor_details4={
            {"Doctor Name: Dr.Rajendra Jain", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "608"},
            {"Doctor Name : Dr.Aniket Bhandekar", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
            {"Doctor Name: Dr.Dhiraj Zade", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
            {"Doctor Name: Dr.Chinteshwar Gail", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
            {"Doctor Name: Dr.Shantanu Patil", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Shikhar Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Mistty Sheik", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Ashneer Grovar", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Namita Thapad", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"}
    };

    private String[][] doctor_details5={
            {"Doctor Name: Dr.Shitij Verulkar", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "608"},
            {"Doctor Name : Dr.Bhuan Katre", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "900"},
            {"Doctor Name: Dr.Lovely Singh", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No:8898989898", "300"},
            {"Doctor Name: Dr.Sudhanshu Patle", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No:9898000000", "500"},
            {"Doctor Name: Dr.Mrunal Deshmukh", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Lionika Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Sushma Bhagat", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Virali Tandav", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name: Dr.Manisha Gurgain", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"}
    };
Button btn;
String [][] doctor_details={};
ArrayList list;
HashMap<String,String> items;
SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        TextView tv=findViewById(R.id.textViewDDTitle);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);



        //        condition for categories vise component data


        if (title != null) {
            if (title.compareTo("Family Physician") == 0)
                doctor_details = doctor_details1;
            else if (title.compareTo("Dietician") == 0)
                doctor_details = doctor_details2;
            else if (title.compareTo("Dentist") == 0)
                doctor_details = doctor_details3;
            else if (title.compareTo("Surgeon") == 0)
                doctor_details = doctor_details4;
            else if (title.compareTo("Cardiologistics") == 0)
                doctor_details = doctor_details5;
        } else {
            // Handle the case where title is null
            // For example, display an error message or set a default value for doctor_details
        }


        btn=findViewById(R.id.buttonLTGotoCart);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list=new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
        items=new HashMap<String,String>();
        items.put("line1",doctor_details[i][0]);
        items.put("line2",doctor_details[i][1]);
        items.put("line3",doctor_details[i][2]);
        items.put("line4",doctor_details[i][3]);
        items.put("line5","Cons Fees:"+doctor_details[i][4]+"Rs.");
        list.add(items);
        }
        sa=new SimpleAdapter(getApplicationContext(),list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView list=findViewById(R.id.listViewCart);
        list.setAdapter(sa);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

        searchView=findViewById(R.id.serachView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                sa.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                sa.getFilter().filter(newText);
                return false;
            }
        });
    }
}