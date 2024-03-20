package ru.nstu.galkin.features.list.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.nstu.galkin.features.list.domain.usecases.GetUsersUseCase
import ru.nstu.galkin.features.list.presentation.ListViewModel

val listModule = module {

    factory {
        GetUsersUseCase(repository = get())
    }

    viewModel {
        ListViewModel(getUsersUseCase = get())
    }
}