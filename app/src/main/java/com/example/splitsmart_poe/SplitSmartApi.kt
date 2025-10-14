package com.example.splitsmart_poe
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST



class SplitSmartApi {
    interface SplitSmartApi {
        @GET("expenses")
        suspend fun getExpenses(): List<Expense>

        @POST("expenses")
        suspend fun addExpense(@Body expense: Expense): Response<Void>
    }
}