package com.example.skinwise.ui.Consultation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinwise.adapter.ListChatAdapter
import com.example.skinwise.data.pref.UserPreference
import com.example.skinwise.data.pref.dataStore
import com.example.skinwise.databinding.FragmentListChatBinding
import com.example.skinwise.ui.main.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ListChatFragment : Fragment() {

    private lateinit var binding: FragmentListChatBinding
    private lateinit var chatAdapter: ListChatAdapter
    private lateinit var viewModel: ConsultationViewModel
    private lateinit var userPreference: UserPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = context?.let { ViewModelFactory.getInstance(it) }
        viewModel = viewModelFactory?.let {
            ViewModelProvider(this, it)[ConsultationViewModel::class.java]
        } ?: throw Exception("ViewModelFactory not initialized properly")

        userPreference = context?.let { UserPreference(it.dataStore) } ?: throw Exception("Invalid Activity")

        val recyclerView = binding.recyclerViewChat
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        chatAdapter = ListChatAdapter(mutableListOf())
        recyclerView.adapter = chatAdapter

        chatAdapter.notifyDataSetChanged()

        viewModel.chatList.observe(viewLifecycleOwner) { updatedChatList ->
            chatAdapter.updateChatList(updatedChatList)
        }

        // Get chat list from ViewModel
        CoroutineScope(Dispatchers.Main).launch {
            val session = userPreference.getSession().first()
            val userEmail = session.email
            viewModel.fetchChatList(userEmail)
        }
    }

    override fun onResume() {
        super.onResume()

        CoroutineScope(Dispatchers.Main).launch {
            val session = userPreference.getSession().first()
            val userEmail = session.email
            viewModel.fetchChatList(userEmail)
        }
    }
}
