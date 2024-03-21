package ru.nstu.galkin.testtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.nstu.galkin.shared.presentation.SharedViewModel
import ru.nstu.galkin.testtask.R

class MainActivity : AppCompatActivity() {

    private val viewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}