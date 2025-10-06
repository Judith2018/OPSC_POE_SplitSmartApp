package com.example.splitsmart_poe.model

data class Expense(
    val id: String = "",
    val title: String = "",
    val subtitle: String = "",
    val amount: Double = 0.0,
    val currency: String = "R"
) {
    fun formattedAmount(): String =
        if (amount == 0.0) "" else String.format("%s%.2f", currency, amount)
}
