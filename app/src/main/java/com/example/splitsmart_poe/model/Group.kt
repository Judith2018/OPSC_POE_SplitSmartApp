package com.example.splitsmart_poe.model

data class Group(
    val id: String = "",
    val name: String = "",
    val members: List<String> = emptyList()
)
