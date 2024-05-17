package com.sudhirtheindian.postapijava;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sudhirtheindian.postapijava.model.Model;
import com.sudhirtheindian.postapijava.model.TModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity2 extends AppCompatActivity {
    private EditText txtName,txtJob;
    private TextView lblOutput;
    private Button btnPostData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtName = findViewById(R.id.txtName);
        txtJob = findViewById(R.id.txtJob);
        lblOutput = findViewById(R.id.lblOutput);
        btnPostData = findViewById(R.id.btnPostData);


//        java.lang.IllegalArgumentException: Expected URL scheme 'http' or 'https' but was 'stg-tdmsws.transnational-grp.com'

        btnPostData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Data From TextBox
                String systemName,userType;
                systemName = txtName.getText().toString();
                userType = txtJob.getText().toString();

                if(systemName == "")
                {
                    Toast.makeText(MainActivity2.this,"Please Enter Name",Toast.LENGTH_SHORT).show();
                }
                else if(userType == "")
                {
                    Toast.makeText(MainActivity2.this,"Please Enter Job",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
                    Call<TModel> call = methods.getUserTModelData("BC61BA4413924E47B7645EAFA6AD35B8",systemName,userType);

                    call.enqueue(new Callback<TModel>() {
                        @Override
                        public void onResponse(Call<TModel> call, Response<TModel> response) {
                            String strOutput = "";
                            strOutput =  "Id : " + response.body().getRequestId();
                            strOutput = strOutput + "\nName : " + response.body().getSystemName();
                            strOutput = strOutput + "\nJob : " + response.body().getUserType();
                            strOutput = strOutput + "\nCreated At : " + response.body().getUserID();
                            lblOutput.setText(strOutput);
                        }

                        @Override
                        public void onFailure(Call<TModel> call, Throwable t) {
                            Toast.makeText(MainActivity2.this,"Error Occurred",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}