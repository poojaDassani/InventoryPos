package com.whizzarc.inventorypos.customerModule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.whizzarc.inventorypos.R
import com.whizzarc.inventorypos.databinding.FragmentCustomerBinding
import com.whizzarc.inventorypos.databinding.FragmentLoginBinding
import com.whizzarc.inventorypos.services.data.dao.CustomerDao
import com.whizzarc.inventorypos.services.data.models.Customer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import java.util.Date
import javax.inject.Inject

@AndroidEntryPoint
class CustomerFragment : Fragment() {

    private var _binding: FragmentCustomerBinding? = null
    private var adapter: CustomersAdapter? = null
    private val customerVM: CustomerViewModel by viewModels()

    private val binding get() = _binding!!
    private var listCustomers = ArrayList<Customer>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = CustomersAdapter()
        binding.recyclerView.adapter = adapter
        getData()
        binding.createBtn.setOnClickListener {
            val cus = Customer(
                Date().time,
                "Lokesh",
                "Yadav",
                "test",
                null,
                "Male",
                Date(),
                null,
                123106,
                true,
                false,
                Date(),
                Date()
            )
            runBlocking {
                customerVM.insertCustomer(cus)
            }
        }
        customerVM.getCustomer.observe(viewLifecycleOwner, Observer {
            listCustomers.clear()
            listCustomers.addAll(it)
            adapter?.submitList(listCustomers)

        })
        customerVM.insertCustomer.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                listCustomers.add(it)
                adapter?.submitList(listCustomers)
            }

        })

    }

    private fun getData() {
        runBlocking {
//            customerVM.deleteData()
            customerVM.getCustomers()
        }
    }



}