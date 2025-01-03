package com.hzho.mobileassignments.model

class Model private constructor() {
    val students: MutableList<Student> = ArrayList()

    companion object {
        val shared = Model()
    }

    init {
        for (i in 0..5) {
            val student = Student(
                name = "Name $i",
                id = "Student ID: $i",
                phone = "Phone",
                address = "address",
                isChecked = false
            )

            students.add(student)
        }
    }

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun getStudentAtPosition(position: Int): Student? {
        return if (position in 0 until students.size) {
            students[position]
        } else {
            null
        }
    }

    fun removeStudent(position: Int) {
        students.removeAt(position)
    }

    fun updateStudent(position: Int, updatedStudent: Student) {
        students[position] = updatedStudent
    }
}