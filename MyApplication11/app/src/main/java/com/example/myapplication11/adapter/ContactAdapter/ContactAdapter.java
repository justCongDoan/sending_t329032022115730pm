package com.example.myapplication11.adapter.ContactAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication11.R;
import com.example.myapplication11.model.Contact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private int resource;
    private List<Contact> arrayContact;

    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrayContact = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewModeler viewModeler;
        if (convertView == null) {
            viewModeler = new ViewModeler();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact_listview, parent, false);
            viewModeler.imageAvatarContact = (ImageView) convertView.findViewById(R.id.imageAvatarID);
            viewModeler.tvName = (TextView) convertView.findViewById(R.id.tvNameID);
            viewModeler.tvNumber = (TextView) convertView.findViewById(R.id.tvNumberID);

            convertView.setTag(viewModeler);
        }
        else {
            viewModeler = (ViewModeler) convertView.getTag();
        }

        Contact contact = arrayContact.get(position);

        viewModeler.tvName.setText(contact.getmName());
        viewModeler.tvNumber.setText(contact.getmNumber());

        if(contact.isMale()) {
            viewModeler.imageAvatarContact.setBackgroundResource(R.drawable.male);
        }
        else {
            viewModeler.imageAvatarContact.setBackgroundResource(R.drawable.female);
        }

        return convertView;
    }

    public class ViewModeler {
        ImageView imageAvatarContact;
        TextView tvName, tvNumber;
    }
}
