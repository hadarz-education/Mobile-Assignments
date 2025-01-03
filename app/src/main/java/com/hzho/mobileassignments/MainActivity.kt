package com.hzho.mobileassignments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
        startActivity(intent)

        // Reference to the "Add Student" button
        val addStudentButton: Button = findViewById(R.id.main_acitivity_add_student_button)

        // Set the click listener
        addStudentButton.setOnClickListener {
            // Create an Intent to navigate to StudentsListActivity
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }

}

