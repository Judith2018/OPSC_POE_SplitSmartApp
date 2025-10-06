package com.example.splitsmart_poe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.splitsmart_poe.databinding.FragmentGroupsBinding

class GroupsFragment : Fragment() {

    private var _binding: FragmentGroupsBinding? = null
    private val binding get() = _binding!!
    private var groupsList: MutableList<String>? = null

    companion object {
        fun newInstance(groups: MutableList<String>): GroupsFragment {
            val fragment = GroupsFragment()
            fragment.groupsList = groups
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentGroupsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCreateGroup.setOnClickListener {
            createNewGroup()
        }

        binding.btnBack.setOnClickListener {
            // Go back to HomeFragment
            (activity as? HomeActivity)?.loadFragment(
                HomeFragment.newInstance(groupsList ?: emptyList(), emptyList())
            )
        }
    }

    private fun createNewGroup() {
        val groupName = binding.etGroupName.text.toString().trim()

        if (groupName.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter a group name", Toast.LENGTH_SHORT).show()
            return
        }

        // Add new group
        groupsList?.add(groupName)
        Toast.makeText(requireContext(), "Group '$groupName' created!", Toast.LENGTH_SHORT).show()

        // Clear input
        binding.etGroupName.text.clear()

        // Go back to HomeFragment to see the new group
        (activity as? HomeActivity)?.loadFragment(
            HomeFragment.newInstance(groupsList ?: emptyList(), emptyList())
        )

        // TODO: Role 1 - Replace with Firebase save
        // FirebaseAuth.getInstance().currentUser?.uid?.let { userId ->
        //     FirebaseFirestore.getInstance().collection("groups")
        //         .add(hashMapOf("name" to groupName, "members" to listOf(userId)))
        //         .addOnSuccessListener { /* Success */ }
        //         .addOnFailureListener { /* Handle error */ }
        // }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}