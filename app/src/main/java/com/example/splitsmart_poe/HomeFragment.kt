package com.example.splitsmart_poe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.splitsmart_poe.databinding.FragmentHomeBinding
import com.example.splitsmart_poe.model.Expense
import com.example.splitsmart_poe.ui.GroupAdapter
import com.example.splitsmart_poe.ui.RecentActivityAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var groupsAdapter: GroupAdapter
    private lateinit var expensesAdapter: RecentActivityAdapter
    private var groupsList: List<String> = emptyList()
    private var expensesList: List<Expense> = emptyList()

    companion object {
        fun newInstance(groups: List<String>, expenses: List<Expense>): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            // In real app, pass data via ViewModel - this is simplified for POE
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        updateUI()
    }

    private fun setupRecyclerViews() {
        // Groups RecyclerView
        groupsAdapter = GroupAdapter(groupsList)
        binding.rvGroups.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGroups.adapter = groupsAdapter

        // Expenses RecyclerView
        expensesAdapter = RecentActivityAdapter(expensesList)
        binding.rvRecentActivity.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRecentActivity.adapter = expensesAdapter
    }

    private fun updateUI() {
        binding.tvGreeting.text = "Hi, User"
        binding.tvBalance.text = "R150.00"

        groupsAdapter.updateData(groupsList)
        expensesAdapter.updateData(expensesList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
