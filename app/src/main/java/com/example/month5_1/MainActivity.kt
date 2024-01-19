package com.example.month5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.month5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }
           private fun initClicker(){
            with(binding) {
                incrementBtn.setOnClickListener {
                    presenter.increment()
                }
                decrementBtn.setOnClickListener {
                    presenter.decrement()
                }
        }
    }

    override fun showNewCount(number: Int) {
        binding.resultTV.text = number.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
        binding.resultTV.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
    }

}