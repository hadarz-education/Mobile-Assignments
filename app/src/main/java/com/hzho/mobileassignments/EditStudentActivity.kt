package com.hzho.mobileassignments

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

//        val nameEditText: EditText = findViewById(R.id.student_details_name_edit_text)
//        val idEditText: EditText = findViewById(R.id.student_details_id_edit_text)
//        val phoneEditText: EditText = findViewById(R.id.student_details_phone_edit_text)
//        val addressEditText: EditText = findViewById(R.id.student_details_address_edit_text)

        val cancelButton: Button = findViewById(R.id.student_details_cancel_button)
        val deleteButton: Button = findViewById(R.id.student_details_delete_button)
        val saveButton: Button = findViewById(R.id.student_details_save_button)

        cancelButton.setOnClickListener {
            finish()
        }
    }
}