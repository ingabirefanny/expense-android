package com.example.myexpenses

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transactionList: RecyclerView = findViewById(R.id.transactionList)
        transactionList.layoutManager = LinearLayoutManager(this)

        val transactions = listOf(
            Transaction("Salary", "KES 40000", "1 July 2024", true),
            Transaction("Rent", "KES 15000", "2 July 2024", false),
            Transaction("Dividends", "KES 2400", "4 July 2024", true),
            Transaction("Electricity", "KES 800", "5 July 2024", false),
            Transaction("Internet", "KES 2500", "5 July 2024", false),
            Transaction("Shopping", "KES 3500", "5 July 2024", false),
            Transaction("Bus fare", "KES 500", "11 July 2024", false)
        )

        transactionList.adapter = TransactionAdapter(transactions)
    }
}