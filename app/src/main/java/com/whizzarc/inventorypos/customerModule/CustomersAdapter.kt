package com.whizzarc.inventorypos.customerModule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.whizzarc.inventorypos.R
import com.whizzarc.inventorypos.services.data.models.Customer


class CustomersAdapter :
    ListAdapter<Customer, CustomersAdapter.CustomerViewHolder>(UserDiffCallBack) {

    object UserDiffCallBack : DiffUtil.ItemCallback<Customer>() {
        override fun areItemsTheSame(oldItem: Customer, newItem: Customer): Boolean =
            oldItem.phoneNumber == newItem.phoneNumber

        override fun areContentsTheSame(oldItem: Customer, newItem: Customer): Boolean =
            oldItem == newItem
    }
    override fun submitList(list: List<Customer>?) {
        super.submitList(list?.let { ArrayList(it) })
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.customer_list_item, parent, false);
        return CustomerViewHolder(view);
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        currentList[position].let { holder.onBind(it) }
    }
    class CustomerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun onBind(user: Customer) {
            itemView.findViewById<TextView>(R.id.name).text = user.firstName
            itemView.findViewById<TextView>(R.id.lName).text = user.lastName
        }
    }
}