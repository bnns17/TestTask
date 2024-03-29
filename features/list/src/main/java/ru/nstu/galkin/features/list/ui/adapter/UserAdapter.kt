package ru.nstu.galkin.features.list.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.nstu.galkin.list.databinding.ListUserBinding
import ru.nstu.galkin.list.R
import ru.nstu.galkin.shared.domain.entity.User

class UserAdapter(
    private val onItemClick: (User) -> Unit,
    private val onLoadMore: () -> Unit,
) : ListAdapter<User, UserAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ListUserBinding.bind(view)

        fun bind(user: User, onClick: (User) -> Unit) =
            with(binding) {
                nameTextView.text = user.name
                phoneTextView.text = user.phone
                locationTextView.text = user.location
                Picasso.get().load(user.picture).into(userImageView)
                root.setOnClickListener { onClick(user) }
            }
    }

    class Comparator : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position), onItemClick)

        if (position > itemCount - 10) onLoadMore()
    }
}