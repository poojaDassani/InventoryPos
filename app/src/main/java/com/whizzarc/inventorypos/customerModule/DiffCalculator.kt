package com.whizzarc.inventorypos.customerModule

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil

class DiffCalculator(oldEmployeeList: List<Comparable>, newEmployeeList: List<Comparable>) :
    DiffUtil.Callback() {
    private val mOldEmployeeList: List<Comparable>
    private val mNewEmployeeList: List<Comparable>

    init {
        mOldEmployeeList = oldEmployeeList
        mNewEmployeeList = newEmployeeList
    }

    override fun getOldListSize(): Int {
        return mOldEmployeeList.size
    }

    override fun getNewListSize(): Int {
        return mNewEmployeeList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldEmployeeList[oldItemPosition].getId() == mNewEmployeeList[newItemPosition].getId()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldEmployeeList[oldItemPosition]
        val newEmployee = mNewEmployeeList[newItemPosition]
        return oldEmployee.getId() == newEmployee.getId()
    }

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}
abstract class Comparable{
    abstract fun getId():Int
}