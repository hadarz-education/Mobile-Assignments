package com.hzho.mobileassignments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hzho.mobileassignments.model.Model

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentPosition = intent.getIntExtra("studentPosition", 0)
        val student = Model.shared.getStudentAtPosition(studentPosition)

        val nameTextView: TextView = findViewById(R.id.student_details_name_text_view)
        val idTextView: TextView = findViewById(R.id.student_details_id_text_view)
        val phoneTextView: TextView = findViewById(R.id.student_details_phone_text_view)
        val addressTextView: TextView = findViewById(R.id.student_details_address_text_view)
        val activeCheckBox: CheckBox = findViewById(R.id.student_details_active_check_box)
        val editButton: Button = findViewById(R.id.student_details_edit_button)
        activeCheckBox.isEnabled = false

        student?.let {
            nameTextView.text = "name: ${it.name}"
            idTextView.text = "id: ${it.id}"
            phoneTextView.text = "phone: ${it.phone}"
            addressTextView.text = "address: ${it.address}"
            activeCheckBox.text = ""
            activeCheckBox.isChecked = it.isChecked
        }


        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("studentPosition", studentPosition)
            startActivity(intent)
        }
    }
}