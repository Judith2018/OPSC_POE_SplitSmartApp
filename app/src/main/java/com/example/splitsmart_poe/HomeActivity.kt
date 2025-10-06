package com.example.splitsmart_poe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.splitsmart_poe.databinding.ActivityHomeBinding
import com.example.splitsmart_poe.model.Expense


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val groupsList = mutableListOf<String>()
    private val expensesList = mutableListOf<Expense>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load HomeFragment by default
        loadFragment(HomeFragment.newInstance(groupsList, expensesList))

        setupBottomNavigation()
        setupFAB()

        loadSampleData() // Remove later - for testing
    }

    private fun setupBottomNavigation() {
        binding.btnHome.setOnClickListener {
            loadFragment(HomeFragment.newInstance(groupsList, expensesList))
        }

        binding.btnGroups.setOnClickListener {
            loadFragment(GroupsFragment.newInstance(groupsList))
        }

        binding.btnSettings.setOnClickListener {
            loadFragment(SettingsFragment())
        }
    }

    private fun setupFAB() {
        binding.fabAdd.setOnClickListener {
            loadFragment(AddExpenseFragment.newInstance(expensesList))
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun loadSampleData() {
        groupsList.add("OPSC6312")
        expensesList.add(Expense("Lift Club", "Paid by you", 100.00.toString()))
        expensesList.add(Expense("Dinner", "Paid by Julie", 100.00.toString()))
        expensesList.add(Expense("Groceries", "Paid by Meena", 100.00.toString()))
    }

    companion object {
        const val ADD_EXPENSE_REQUEST = 1
        const val CREATE_GROUP_REQUEST = 2
    }
}