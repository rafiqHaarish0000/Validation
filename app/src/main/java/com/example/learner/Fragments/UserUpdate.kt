package com.example.learner.Fragments

data class UserUpdate(
    var userName:String?,
    var userPassword:String?
)
data class Signup(
    val fullName:String?,
    val phoneNumber:Int?,
    val emailID:String?,
    val newPassword:String?,
    val confirmPassword:String?
)
