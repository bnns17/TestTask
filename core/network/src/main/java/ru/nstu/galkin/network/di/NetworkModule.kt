package ru.nstu.galkin.network.di

import ru.nstu.galkin.network.Retrofit
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val RETROFIT = "RETROFIT"

val networkModule = module {

    single(named(RETROFIT)) {
        Retrofit().newInstance()
    }
}