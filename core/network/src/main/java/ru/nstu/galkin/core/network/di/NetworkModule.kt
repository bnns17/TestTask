package ru.nstu.galkin.core.network.di

import ru.nstu.galkin.core.network.Retrofit
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val RETROFIT = "RETROFIT"

val coreNetworkModule = module {

    single(named(RETROFIT)) {
        Retrofit().newInstance()
    }
}