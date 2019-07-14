package com.stuffshuf.okhttp_with_gson

import java.util.ArrayList

data class Example (
    val items: ArrayList<Users>
)


data class Users (
    val login:String,
    val id:Int,
    val avatar_url:String

)
/*
data class Users (
    val id:Int,
    val name:String,
    val username:String,
    val email:String,
    val address: Address,
    val geo: Geo
)

data class Address(
    val street:String,
    val suite:String,
    val city:String,
    val zipcode:Int
)

data class Geo(
    val lat:Float,
    val lng:Float
)
        */