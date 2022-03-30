package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.popupBtn);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                PopupMenu();
            }
        });
    }

    private void PopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btn);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.addID:
                        Toast.makeText
                                (
                                        MainActivity.this,
                                        "ADD",
                                        Toast.LENGTH_SHORT
                                ).show();
                        break;
                    case R.id.updateID:
                        Toast.makeText
                                (
                                        MainActivity.this,
                                        "UPDATE",
                                        Toast.LENGTH_SHORT
                                ).show();
                        break;
                    case R.id.deleteID:
                        Toast.makeText
                                (
                                        MainActivity.this,
                                        "DELETE",
                                        Toast.LENGTH_SHORT
                                ).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}