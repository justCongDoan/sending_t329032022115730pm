package com.example.myapplication11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication11.adapter.ContactAdapter.ContactAdapter;
import com.example.myapplication11.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contact> contactList;
    private ContactAdapter adapter;
    private EditText editName, editNumber;
    private RadioButton rBtnMale, rBtnFemale;
    private Button btnAddContact;
    private ListView lvContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidget();
        contactList = new ArrayList<>();
        adapter = new ContactAdapter(this, R.layout.item_contact_listview, contactList);
        lvContact.setAdapter(adapter);
    }

    public void setWidget() {
        editName = (EditText) findViewById(R.id.editNameID);
        editNumber = (EditText) findViewById(R.id.editNumberID);
        rBtnMale = (RadioButton) findViewById(R.id.rBtbMaleID);
        rBtnFemale = (RadioButton) findViewById(R.id.rBtnFemaleID);
        btnAddContact = (Button) findViewById(R.id.addContactBtnID);
        lvContact = (ListView) findViewById(R.id.lvContactID);
    }

    public void onAddContactButtonClick (View view) {
        if(view.getId() == R.id.addContactBtnID) {
            String name = editName.getText().toString().trim(),
                    number = editNumber.getText().toString().trim();
            boolean isMale = true;
            if(rBtnMale.isChecked()) {
                isMale = true;
            }
            else {
                isMale = false;
            }
            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(number)) {
                Toast.makeText(this, "Please enter name or number!", Toast.LENGTH_SHORT).show();
            }
            else {
                Contact contact = new Contact(isMale, name, number);
                contactList.add(contact);
            }
            adapter.notifyDataSetChanged();

        }
    }
}