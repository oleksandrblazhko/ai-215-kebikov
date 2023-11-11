package com.example.watercleaningapp.model

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.watercleaningapp.databinding.ActivityMainBinding
import com.example.watercleaningapp.model.UserTemperatureParam

import com.example.watercleaningapp.repository.TemperatureParamRepository
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var doneBtn: Button
    private lateinit var fanButton: RadioButton
    private lateinit var coldButton: RadioButton
    private lateinit var heatButton: RadioButton
    private lateinit var temperatureText: EditText

    private val repo = TemperatureParamRepository()

    companion object {
        const val SUCCESS = 1
        const val DATA_ERROR = -1
        const val Unknown_mode_ERROR = -2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        doneBtn = binding.doneBtn
        fanButton = binding.fanRadioButton2
        coldButton = binding.coldRadioButton
        heatButton = binding.heatRadioButton3
        temperatureText = binding.temperature

        doneBtn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            when (setModeTemperature()) {
                SUCCESS -> {
                    builder.setTitle("Параметри успішно встановлені")
                    builder.setPositiveButton("OK") { _, _ -> }
                    builder.create().show()
                }

                DATA_ERROR -> {
                    builder.setTitle("Неправильні дані")
                    builder.setPositiveButton("OK") { _, _ -> }
                    builder.create().show()
                }

                Unknown_mode_ERROR -> {
                    builder.setTitle("Неправильний режим")
                    builder.setPositiveButton("OK") { _, _ -> }
                    builder.create().show()
                }
            }
        }
    }


    private fun setModeTemperature(): Int {
        val isHeatMode = heatButton.isActivated
        val isColdMode = coldButton.isActivated
        val isFanMode = fanButton.isActivated
        val temperatureParam = temperatureText.text.toString()


        if (temperatureParam.toIntOrNull() == null) {
            return DATA_ERROR
        }

        if (!(isHeatMode && isColdMode && isFanMode) && !(!isHeatMode && !isColdMode && !isFanMode)) {
            val mode = if (isHeatMode) {
                "Heat Mode"
            } else if (isColdMode) {
                "Cold mode"
            } else {
                "Fan mode"
            }

            repo.save(
                FirebaseAuth.getInstance().currentUser!!.uid,
                UserTemperatureParam(temperatureParam.toInt(), mode)
            )
            return SUCCESS
        }
        return Unknown_mode_ERROR
    }

    fun setModeTemperature(isHeatMode: Boolean,
                           isColdMode: Boolean,
                           isFanMode: Boolean,
                           temperatureParam: String): Int {
        if (temperatureParam.toIntOrNull() == null) {
            return DATA_ERROR
        }

        if (!(isHeatMode && isColdMode && isFanMode) && !(!isHeatMode && !isColdMode && !isFanMode)) {
            val mode = if (isHeatMode) {
                "Heat Mode"
            } else if (isColdMode) {
                "Cold mode"
            } else {
                "Fan mode"
            }

            repo.save(
                FirebaseAuth.getInstance().currentUser!!.uid,
                UserTemperatureParam(temperatureParam.toInt(), mode)
            )
            return SUCCESS
        }
        return Unknown_mode_ERROR
    }
}