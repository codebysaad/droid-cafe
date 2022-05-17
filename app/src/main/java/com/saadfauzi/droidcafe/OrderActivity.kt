package com.saadfauzi.droidcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.saadfauzi.droidcafe.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityOrderBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { radioGroup, pos ->
            when (radioGroup.checkedRadioButtonId) {
                R.id.sameday -> {
                    showToast("${resources.getString(R.string.chosen)} ${resources.getString(R.string.same_day_messenger_service)}")
                }
                R.id.nextday -> {
                    showToast("${resources.getString(R.string.chosen)} ${resources.getString(R.string.next_day_ground_delivery)}")
                }
                R.id.pickup -> {
                    showToast("${resources.getString(R.string.chosen)} ${resources.getString(R.string.pick_up)}")
                }
                else -> Log.d("OrderActivity", resources.getString(R.string.nothing_clicked))
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}