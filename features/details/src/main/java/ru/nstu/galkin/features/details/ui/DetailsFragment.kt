package ru.nstu.galkin.features.details.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
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

    @SuppressLint("SetTextI18n", "IntentReset")
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

                email.setOnClickListener{
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        data = Uri.parse("mailto:" + user.email.trim())
                        type = "text/plain"
                        putExtra(Intent.EXTRA_EMAIL, user.email.trim())
                        putExtra(Intent.EXTRA_SUBJECT, "We have a problem")
                        putExtra(Intent.EXTRA_TEXT,
                            "This email address does not want to be pasted into the appropriate field, please copy it yourself: "
                                    + user.email.trim())
                    }
                    startActivity(intent)
                }
                phone.setOnClickListener{
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:" + user.phone.trim())
                    }
                    startActivity(intent)
                }
                coordinates.setOnClickListener{
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse("geo:" + user.coordinates.trim())
                    }
                    startActivity(intent)
                }
            }
        }
    }
}