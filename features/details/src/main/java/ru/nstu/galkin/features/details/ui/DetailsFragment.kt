package ru.nstu.galkin.features.details.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.squareup.picasso.Picasso
import ru.nstu.galkin.features.details.databinding.FragmentDetailsBinding
import ru.nstu.galkin.shared.presentation.SharedViewModel

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding!!

    private val activityViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservers()
    }

    @SuppressLint("SetTextI18n")
    private fun setObservers() {
        activityViewModel.selectedUser.observe(viewLifecycleOwner) { user ->
            with(binding) {
                Picasso.get().load(user.picture).into(avatar)
                name.text = user.name
                username.text = "Username: " + user.username
                password.text = "Password: " + user.password
                gender.text = "Gender: " + user.gender
                age.text = "Age: " + user.age.toString()
                location.text = "Location: " + user.location
                coordinates.text = "Coordinates: " + user.coordinates
                phone.text = "Phone: " + user.phone
                email.text = "Email: " + user.email
            }
        }
    }
}