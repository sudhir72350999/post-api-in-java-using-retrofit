package com.sudhirtheindian.postapijava;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sudhirtheindian.postapijava.model.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText txtName,txtJob;
    private TextView lblOutput;
    private Button btnPostData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtJob = findViewById(R.id.txtJob);
        lblOutput = findViewById(R.id.lblOutput);
        btnPostData = findViewById(R.id.btnPostData);



        btnPostData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Data From TextBox
                String strName,strJob;
                strName = txtName.getText().toString();
                strJob = txtJob.getText().toString();

                if(strName == "")
                {
                    Toast.makeText(MainActivity.this,"Please Enter Name",Toast.LENGTH_SHORT).show();
                }
                else if(strJob == "")
                {
                    Toast.makeText(MainActivity.this,"Please Enter Job",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
                    Call<Model> call = methods.getUserData(strName,strJob);

                    call.enqueue(new Callback<Model>() {
                        @Override
                        public void onResponse(Call<Model> call, Response<Model> response) {
                            String strOutput = "";
                            strOutput =  "Id : " + response.body().getId();
                            strOutput = strOutput + "\nName : " + response.body().getName();
                            strOutput = strOutput + "\nJob : " + response.body().getJob();
                            strOutput = strOutput + "\nCreated At : " + response.body().getCreatedAt();
                            lblOutput.setText(strOutput);
                        }

                        @Override
                        public void onFailure(Call<Model> call, Throwable t) {
                            Toast.makeText(MainActivity.this,"Error Occurred",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}