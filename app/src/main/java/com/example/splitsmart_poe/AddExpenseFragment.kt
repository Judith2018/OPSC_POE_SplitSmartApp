package com.example.splitsmart_poe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.splitsmart_poe.databinding.FragmentAddExpenseBinding

class AddExpenseFragment : Fragment() {

    private var _binding: FragmentAddExpenseBinding? = null
    private val binding get() = _binding!!
    private var expensesList: MutableList<Expense>? = null

    companion object {
        fun newInstance(expenses: MutableList<Expense>): AddExpenseFragment {
            val fragment = AddExpenseFragment()
            fragment.expensesList = expenses
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAddExpenseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveExpense.setOnClickListener {
            saveExpense()
        }

        binding.btnCancel.setOnClickListener {
            // Go back to HomeFragment
            (activity as? HomeActivity)?.loadFragment(
                HomeFragment.newInstance(emptyList(), expensesList ?: emptyList())
            )
        }
    }

    private fun saveExpense() {
        val expenseName = binding.etExpenseName.text.toString().trim()
        val paidBy = binding.etPaidBy.text.toString().trim()
        val amountText = binding.etAmount.text.toString().trim()

        if (expenseName.isEmpty() || paidBy.isEmpty() || amountText.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val amount = amountText.toDoubleOrNull()
        if (amount == null || amount <= 0) {
            Toast.makeText(requireContext(), "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            return
        }

        // Create and add new expense
        val newExpense = Expense(expenseName, "Paid by $paidBy", amount)
        expensesList?.add(0, newExpense) // Add to beginning of list

        Toast.makeText(requireContext(), "Expense added successfully!", Toast.LENGTH_SHORT).show()

        // Go back to HomeFragment to see the new expense
        (activity as? HomeActivity)?.loadFragment(
            HomeFragment.newInstance(emptyList(), expensesList ?: emptyList())
        )

        // TODO: Role 1 - Replace with Firebase save
        // FirebaseAuth.getInstance().currentUser?.uid?.let { userId ->
        //     FirebaseFirestore.getInstance().collection("expenses")
        //         .add(newExpense.toMap())
        //         .addOnSuccessListener { /* Success */ }
        //         .addOnFailureListener { /* Handle error */ }
        // }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}