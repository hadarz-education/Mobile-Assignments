package com.hzho.mobileassignments.model

data class Student(
    val name: String,
    val id: String,
    val avatarUrl: String,
    var isChecked: Boolean
)