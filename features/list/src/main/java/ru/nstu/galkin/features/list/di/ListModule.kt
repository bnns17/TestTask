package ru.nstu.galkin.features.list.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.nstu.galkin.features.list.domain.usecases.ClearUsersUseCase
import ru.nstu.galkin.features.list.domain.usecases.GetLocalUsersUseCase
import ru.nstu.galkin.features.list.domain.usecases.GetNetworkUsersUseCase
import ru.nstu.galkin.features.list.domain.usecases.SaveUsersUseCase
import ru.nstu.galkin.features.list.presentation.ListViewModel

val listModule = module {

    factory {
        GetLocalUsersUseCase(repository = get())
    }

    factory {
        GetNetworkUsersUseCase(repository = get())
    }

    factory {
        SaveUsersUseCase(repository = get())
    }

    factory {
        ClearUsersUseCase(repository = get())
    }

    viewModel {
        ListViewModel(
            getNetworkUsersUseCase = get(),
            getLocalUsersUseCase = get(),
            saveUsersUseCase = get(),
            clearUsersUseCase = get()
        )
    }
}