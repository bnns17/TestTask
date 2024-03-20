package ru.nstu.galkin.list.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.nstu.galkin.list.domain.usecases.GetListUsersUseCase
import ru.nstu.galkin.list.presentation.ListViewModel

val listModule = module {

    factory {
        GetListUsersUseCase(repository = get())
    }

    viewModel {
        ListViewModel(getListUsersUseCase = get())
    }
}