package com.hzho.mobileassignments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hzho.mobileassignments.model.Model
import com.hzho.mobileassignments.model.Student

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentPosition = intent.getIntExtra("studentPosition", 0)
        val student = Model.shared.getStudentAtPosition(studentPosition)

        val nameEditText: EditText = findViewById(R.id.student_details_name_edit_text)
        val idEditText: EditText = findViewById(R.id.student_details_id_edit_text)
        val phoneEditText: EditText = findViewById(R.id.student_details_phone_edit_text)
        val addressEditText: EditText = findViewById(R.id.student_details_address_edit_text)

        nameEditText.setText(student?.name)
        idEditText.setText(student?.id)
        phoneEditText.setText(student?.phone)
        addressEditText.setText(student?.address)

        val cancelButton: Button = findViewById(R.id.student_details_cancel_button)
        val deleteButton: Button = findViewById(R.id.student_details_delete_button)
        val saveButton: Button = findViewById(R.id.student_details_save_button)

        cancelButton.setOnClickListener {
            finish()
        }

        // Delete button click listener
        deleteButton.setOnClickListener {
            Model.shared.removeStudent(studentPosition)
            Toast.makeText(this, "Student deleted", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        saveButton.setOnClickListener {
            val newStudentName = nameEditText.text.toString().trim()
            val newStudentId = idEditText.text.toString().trim()
            val newStudentPhone = phoneEditText.text.toString().trim()
            val newStudentAddress = addressEditText.text.toString().trim()

            if (newStudentName.isNotEmpty() || newStudentId.isNotEmpty() || newStudentPhone.isNotEmpty() || newStudentAddress.isNotEmpty()) {
                val updatedStudent = Student(newStudentName, newStudentId, newStudentPhone, newStudentAddress, true)

                Model.shared.updateStudent(studentPosition, updatedStudent)
                Toast.makeText(this, "Student updated", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "At lease one of the properties need to be filled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
