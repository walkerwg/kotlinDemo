package com.example.myapplication.mvp

data class InfoBean (
    val info: Info,
    val results: List<Result>
)

data class Info (
    val page: Long,
    val results: Long,
    val seed: String,
    val version: String
)

data class Result (
    val cell: String,
    val dob: String,
    val email: String,
    val gender: String,
    val id: ID,
    val location: Location,
    val login: Login,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: String
)

data class ID (
    val name: String,
    val value: String
)

data class Location (
    val city: String,
    val postcode: Long,
    val state: String,
    val street: String
)

data class Login (
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String
)

data class Name (
    val first: String,
    val last: String,
    val title: String
)

data class Picture (
    val large: String,
    val medium: String,
    val thumbnail: String
)
