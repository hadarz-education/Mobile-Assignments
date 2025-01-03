package com.hzho.mobileassignments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.RadioGroup
import android.widget.Toast
import com.hzho.mobileassignments.model.Model
import com.hzho.mobileassignments.model.Student

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saveButton: Button = findViewById(R.id.add_student_activity_save_button)
        val cancelButton: Button = findViewById(R.id.add_student_activity_cancel_button)

        val studentNameEditText: EditText = findViewById(R.id.add_student_activity_name_edit_text)
        val studentIdEditText: EditText = findViewById(R.id.add_student_activity_id_edit_text)
        val studentPhoneEditText: EditText = findViewById(R.id.add_student_activity_phone_edit_text)
        val studentAddressEditText: EditText = findViewById(R.id.add_student_activity_address_edit_text)
        val checkStatusGroup: RadioGroup = findViewById(R.id.check_status_group)

        cancelButton.setOnClickListener {
            finish()
        }

        saveButton.setOnClickListener {
            // Get the entered name and ID
            val studentName = studentNameEditText.text.toString().trim()
            val studentId = studentIdEditText.text.toString().trim()
            val studentPhone = studentPhoneEditText.text.toString().trim()
            val studentAddress = studentAddressEditText.text.toString().trim()


            // Check if the input fields are not empty
            if (studentName.isNotEmpty() && studentId.isNotEmpty() && studentPhone.isNotEmpty() && studentAddress.isNotEmpty()) {

                // Get the selected radio button (Checked or Unchecked)
                val selectedRadioButtonId = checkStatusGroup.checkedRadioButtonId
                val isChecked = when (selectedRadioButtonId) {
                    R.id.radio_checked -> true
                    R.id.radio_unchecked -> false
                    else -> false
                }

                // Create a new student object
                val newStudent =
                    Student(studentName,studentId, studentPhone,studentAddress,isChecked)
                Model.shared.addStudent(newStudent)

                // Show a success message
                Toast.makeText(this, "Student added successfully!", Toast.LENGTH_SHORT).show()

                // Optionally, you can clear the input fields for the next entry
                studentNameEditText.text.clear()
                studentIdEditText.text.clear()
                checkStatusGroup.clearCheck() // Clear selected radio button

                val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
                startActivity(intent)
            } else {
                // Show error message if fields are empty
                Toast.makeText(this, "Please Make sure you filled all the details", Toast.LENGTH_SHORT).show()
            }

        }
    }
}