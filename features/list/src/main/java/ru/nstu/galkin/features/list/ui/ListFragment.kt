package ru.nstu.galkin.features.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.nstu.galkin.features.list.presentation.ListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.nstu.galkin.list.databinding.FragmentHomeBinding
import ru.nstu.galkin.features.list.presentation.UserAdapter


class ListFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val viewModel: ListViewModel by viewModel()

    private lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        adapter = UserAdapter()
        binding.recycleView.layoutManager = LinearLayoutManager(context)
        binding.recycleView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.users.observe(viewLifecycleOwner) {users ->
            adapter.submitList(users)
        }

        viewModel.getListUsers()
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}