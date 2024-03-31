package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[] [] packages =
            {
                    {"Package 1 : Full Body Checkup","","","","Total Cost: 999"},
                    {"Package 2 : Blood Glucose Fasting","","","","Total Cost: 299"},
                    {"Package 3 : COVID-19 Antibody - IgG","","","","Total Cost: 899"},
                    {"Package 4 : Thyroid Check","","","","Total Cost: 499"},
                    {"Package 5 : Immunity Check","","","","Total Cost: 699"},
                    {"Package 6 : Sugar check","","","","Total Cost: 399"},
                    {"Package 7 : Urine Check","","","","Total Cost: 499"}
            };

    private String[] package_details = {
            "Blood Glucose Fasting\n" +
                    "Complete Hemogram\n" +
                    "HbA1c\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "LDH Lactate Dehydrogenase, Serum\n" +
                    "Lipid Profile\n" +
                    "Liver Function Test",
            "Blood Glucose Fasting",
            "COVID-19 Antibody IgG",
            "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitive)",
            "Complete Hemogram\n" +
            "CRP (C Reactive Protein) Quantitative, Serum\n" +
            "Iron Studies\n" +
            "Kidney Function Test\n" +
            "Vitamin D Total-25 Hydroxy\n" +
            "Liver Function Test\n" +
                    "Lipid Profile",
           "Random Blood Sugar (RBS) Test."+
    "Fasting Blood Sugar (FBS) Test.\n"+
    "HbA1c\n"+ "Glycated Hemoglobin Test.\n"+
    "Post Prandial Blood Sugar Test.\n"+
    "Vitamin B12 Test.\n"+
    "Glucose Challenge Test (GCT) 75g\n"+"Fluoride Plasma.\n"+
    "Insulin Level (Fasting) Test.",
            "Albumin test.\n"+
                    "Amorphous Deposits test.\n," +
                    "Bacteria test.\n" +
                    "Bilirubin test.\n" +
                    "Blood test\n" +
                    "Cast test.\n" +
                    "Colour test\n" +
                    "Crystals test.\n" +
                    "Deposit test.\n" +
                    "Epithelial cells test\n" +
                    "Leukocyte Esterase test,\n" +
                    "Nitrate test.\n" +
                    "pH Urine test.\n" +
                    "Protozoa, Pus cells (Leukocytes), Red blood cells test."
    };
    HashMap<String , String> item;
    ArrayList list;
    SimpleAdapter sa;

    Button btnGotoCart;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        listView=findViewById(R.id.listViewLT);
        list=new ArrayList();
        for (int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5",packages[i][4]+"Rs");
            list.add(item);
        }

        sa=new SimpleAdapter(getApplicationContext(),list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
            Intent it=new Intent(LabTestActivity.this, LabTestDetailActivity.class);
            it.putExtra("text1",packages[i][0]);
            it.putExtra("text2",package_details[i]);
            it.putExtra("text3",packages[i][4]);
            startActivity(it);
            }
        });

//        for back
        Button btnBack=findViewById(R.id.buttonLTBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });



    }
}