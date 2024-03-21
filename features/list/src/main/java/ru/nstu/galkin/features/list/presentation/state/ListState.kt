package ru.nstu.galkin.features.list.presentation.state

import ru.nstu.galkin.shared.domain.entity.User

sealed class ListState {
    data object Initial : ListState()

    data object InitialLoading : ListState()

    data object Error : ListState()

    data class Content(
        val currentPage: Int,
        val status: ListStatus,
        val users: List<User>,
    ) : ListState()
}

enum class ListStatus {
    CONTENT,
    LOADING,
    ERROR,
}