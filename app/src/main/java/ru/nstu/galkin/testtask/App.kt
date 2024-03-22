package ru.nstu.galkin.testtask

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.nstu.galkin.data.network.di.dataNetworkModule
import ru.nstu.galkin.features.list.di.listModule
import ru.nstu.galkin.core.network.di.coreNetworkModule
import ru.nstu.galkin.data.database.di.dataDatabaseModule
import ru.nstu.galkin.preferences.di.preferencesModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)

            modules(
                coreNetworkModule,
                dataNetworkModule,
                dataDatabaseModule,
                preferencesModule,
                listModule,
            )
        }
    }
}