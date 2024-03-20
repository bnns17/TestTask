package ru.nstu.galkin.testtask

import android.app.Application
import org.koin.core.context.startKoin
import ru.nstu.galkin.data.di.dataModule
import ru.nstu.galkin.list.di.listModule
import ru.nstu.galkin.network.di.networkModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(
                networkModule,
                dataModule,
                listModule
            )
        }


    }
}