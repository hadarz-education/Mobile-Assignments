package com.hzho.mobileassignments.model

import kotlin.random.Random

class Model private constructor() {
    val students: MutableList<Student> = ArrayList()
    private val names = listOf("Hadar", "Hila")

    companion object {
        val shared = Model()
    }

    init {
        for (i in 0..5) {
            val randomName = names.random()
            val randomId = Random.nextInt(10000000, 99999999)

            val student = Student(
                name = randomName,
                id = "$randomId",
                phone = "",
                address = "",
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
        val student = students[position]

        student.name = updatedStudent.name
        student.id = updatedStudent.id
        student.phone = updatedStudent.phone
        student.address = updatedStudent.address
        student.isChecked = updatedStudent.isChecked
    }
}