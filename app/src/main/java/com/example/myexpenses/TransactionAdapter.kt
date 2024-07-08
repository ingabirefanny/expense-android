package com.example.myexpenses

import android.view.LayoutInflater
import android.view.SurfaceControl
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter {
    class TransactionAdapter(private val transactions: List<SurfaceControl.Transaction>) :
        RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val icon: ImageView = view.findViewById(R.id.transactionIcon)
            val name: TextView = view.findViewById(R.id.transactionName)
            val amount: TextView = view.findViewById(R.id.transactionAmount)
            val date: TextView = view.findViewById(R.id.transactionDate)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_transaction, parent, false)
            return ViewHolder(view)
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            if (position in transactions.indices) {
                val transaction = transactions[position]
                holder.name.text = transaction.name
                holder.amount.text = transaction.amount
                holder.date.text = transaction.date
                holder.icon.setImageResource(
                    if (transaction.isIncome) R.drawable.ic_income else R.drawable.ic_expense
                )
            } else {
                holder.name.text = ""
                holder.amount.text = ""
                holder.date.text = ""
                holder.icon.setImageResource(0)
            }
        }



        override fun getItemCount() = transactions.size
    }
}
