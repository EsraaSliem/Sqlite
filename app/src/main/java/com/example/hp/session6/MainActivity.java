package com.example.hp.session6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText name ,phone ,id;
    Button add ,get;
    TextView nameTxt,phoneTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        id=(EditText)findViewById(R.id.contactId);
        add=(Button) findViewById(R.id.add);
        get=(Button) findViewById(R.id.get);
        nameTxt=(TextView)findViewById(R.id.nameTxt);
        phoneTxt=(TextView)findViewById(R.id.phoneTxt);
        final DatabaseHandler db=new DatabaseHandler(MainActivity.this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact contacts=new contact(name.getText().toString(),phone.getText().toString());
                db.insert(contacts);

            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact contacts=  db.get(Integer.parseInt(id.getText().toString()));
                nameTxt.setText(contacts.getName());
                phoneTxt.setText(contacts.getPhone());
            }
        });


    }
}
