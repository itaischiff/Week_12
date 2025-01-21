package com.example.myapplication;

import android.os.Bundle;
import java.text.DateFormat;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // Declare ViewModel
    private SampleViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(SampleViewModel.class);

        // Observe LiveData (foo) for changes
        viewModel.getFoo().observe(this, foo -> {
            // Set the ActionBar title to the updated value of foo
            Objects.requireNonNull(getSupportActionBar()).setTitle(foo);
        });

        // FloatingActionButton click listener
        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {
            // Get current date and time
            String currentDateTime = DateFormat.getDateTimeInstance().format(new Date());
            // Set new value to foo LiveData
            viewModel.getFoo().setValue(currentDateTime);
            // Show a toast to confirm the action
            Toast.makeText(MainActivity.this, "Date and time set!", Toast.LENGTH_SHORT).show();
        });
    }
}
