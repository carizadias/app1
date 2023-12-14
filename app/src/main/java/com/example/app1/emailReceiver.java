package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class emailReceiver extends AppCompatActivity {

    private TextView email, password;
    private RecyclerView recyclerView;
    private EmailAdapter adapter;
    private List<EmailData> emailDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_email);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        emailDataList = new ArrayList<>();

        //email = findViewById(R.id.Text_email);
        //password = findViewById(R.id.Text_password);

        String useremail = getIntent().getStringExtra("keyemail");
        String userpass = getIntent().getStringExtra("keypass");

        EmailData emailData = new EmailData(useremail, userpass);
        emailDataList.add(emailData);

        adapter = new EmailAdapter(emailDataList);
        recyclerView.setAdapter(adapter);


    }
}