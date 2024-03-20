package ru.nstu.galkin.testtask

import android.app.Application
import org.koin.core.context.startKoin
import ru.nstu.galkin.data.network.di.dataModule
import ru.nstu.galkin.features.list.di.listModule
import ru.nstu.galkin.core.network.di.networkModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                networkModule,
                dataModule,
                listModule
            )
        }


    }
}