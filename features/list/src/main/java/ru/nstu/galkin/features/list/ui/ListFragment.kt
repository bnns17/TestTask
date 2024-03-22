package ru.nstu.galkin.features.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.nstu.galkin.features.list.presentation.ListViewModel
import ru.nstu.galkin.features.list.presentation.state.ListState
import ru.nstu.galkin.features.list.presentation.state.ListStatus
import ru.nstu.galkin.features.list.ui.adapter.UserAdapter
import ru.nstu.galkin.list.databinding.FragmentHomeBinding
import ru.nstu.galkin.shared.domain.entity.User
import ru.nstu.galkin.shared.presentation.SharedViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val viewModel: ListViewModel by viewModel()
    private val activityViewModel: SharedViewModel by activityViewModels()

    private lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setListeners()
        setObservers()
    }

    private fun setAdapter() {
        adapter = UserAdapter(
            onItemClick = ::onUserClick,
            onLoadMore = viewModel::getUsers,
        )
        binding.recycleView.layoutManager = LinearLayoutManager(context)
        binding.recycleView.adapter = adapter
    }

    private fun onUserClick(user: User) {
        activityViewModel.setUser(user)
        viewModel.navigateToDetails(findNavController())
    }

    private fun setObservers() {
        viewModel.state.observe(viewLifecycleOwner, ::handleState)
    }

    private fun setListeners() {
        binding.refreshButton.setOnClickListener {
            viewModel.updateUsers()
        }
    }

    private fun handleState(state: ListState) {
        when (state) {
            is ListState.Initial,
            is ListState.InitialLoading -> showLoading()

            is ListState.Content -> showContent(state)

            is ListState.Error -> {
                showError()
                viewModel.getUsers()
            }
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = VISIBLE
        binding.content.visibility = GONE
    }

    private fun showContent(state: ListState.Content) {
        when (state.status) {
            ListStatus.LOADING,
            ListStatus.CONTENT -> {
                binding.content.visibility = VISIBLE
                adapter.submitList(state.users)
            }

            ListStatus.ERROR -> {
                showError()
            }
        }
    }

    private fun showError() {
        Toast.makeText(requireContext(), "Ошибка загрузки", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}