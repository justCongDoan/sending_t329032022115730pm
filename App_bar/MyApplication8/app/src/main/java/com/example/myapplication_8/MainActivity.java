package com.example.myapplication_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // region App bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.open:
                Toast.makeText
                        (
                                this,
                                "Open...",
                                Toast.LENGTH_SHORT
                        ).show();
                break;
            case R.id.settings:
                Toast.makeText
                        (
                                this,
                                "Setting...",
                                Toast.LENGTH_SHORT
                        ).show();
                break;
            case R.id.share:
                Toast.makeText
                        (
                                this,
                                "Share...",
                                Toast.LENGTH_SHORT
                        ).show();
                break;
            case R.id.item:
                Toast.makeText
                        (
                                this,
                                "Item...",
                                Toast.LENGTH_SHORT
                        ).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    // endregion

}