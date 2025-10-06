package com.example.splitsmart_poe.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splitsmart_poe.R
import com.example.splitsmart_poe.model.Expense
import com.example.splitsmart_poe.model.Group
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private lateinit var groupAdapter: GroupAdapter
    private lateinit var recentAdapter: RecentActivityAdapter
    private val groups = mutableListOf<Group>()
    private val expenses = mutableListOf<Expense>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)

        // Groups RecyclerView
        val rvGroups = v.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rv_groups)
        groupAdapter = GroupAdapter(groups)
        rvGroups.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvGroups.adapter = groupAdapter

        // Recent RecyclerView
        val rvRecent = v.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rv_recent)
        recentAdapter = RecentActivityAdapter(expenses)
        rvRecent.layoutManager = LinearLayoutManager(requireContext())
        rvRecent.adapter = recentAdapter

        return v
    }

    /** Called from FAB in HomeActivity */
    fun showAddOptions() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Select Option")
        val options = arrayOf("New Group", "Expense Details")
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> showNewGroupDialog()
                1 -> showExpenseDialog()
            }
        }
        builder.show()
    }

    private fun showNewGroupDialog() {
        val input = EditText(requireContext())
        input.hint = "Group Name"
        AlertDialog.Builder(requireContext())
            .setTitle("New Group")
            .setView(input)
            .setPositiveButton("Save") { _, _ ->
                val name = input.text.toString().trim()
                if (name.isNotEmpty()) {
                    val g = Group(name = name)
                    groups.add(g)
                    groupAdapter.updateData(groups)
                    Snackbar.make(requireView(), "Group added", Snackbar.LENGTH_SHORT).show()
                    // TODO: Role1 → Save group to Firestore under user UID
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showExpenseDialog() {
        val layout = layoutInflater.inflate(R.layout.dialog_expense_details, null)
        val etName = layout.findViewById<EditText>(R.id.et_expense_name)
        val etPaidBy = layout.findViewById<EditText>(R.id.et_paid_by)
        val etAmount = layout.findViewById<EditText>(R.id.et_amount)

        AlertDialog.Builder(requireContext())
            .setTitle("Expense Details")
            .setView(layout)
            .setPositiveButton("Save") { _, _ ->
                val name = etName.text.toString().trim()
                val payer = etPaidBy.text.toString().trim()
                val amount = etAmount.text.toString().toDoubleOrNull() ?: 0.0
                if (name.isNotEmpty() && payer.isNotEmpty() && amount > 0) {
                    val e = Expense(title = name, subtitle = "Paid by $payer", amount = amount)
                    expenses.add(e)
                    recentAdapter.updateData(expenses)
                    Snackbar.make(requireView(), "Expense added", Snackbar.LENGTH_SHORT).show()
                    // TODO: Role1 → Save expense to Firestore
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
