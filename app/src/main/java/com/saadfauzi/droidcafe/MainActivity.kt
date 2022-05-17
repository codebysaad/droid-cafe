package com.saadfauzi.droidcafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.saadfauzi.droidcafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            donut.setOnClickListener {
                showFoodOrder(resources.getString(R.string.donut_order_message))
            }
            iceCream.setOnClickListener {
                showFoodOrder(resources.getString(R.string.ice_cream_order_message))
            }
            froyo.setOnClickListener {
                showFoodOrder(resources.getString(R.string.froyo_order_message))
            }
            fab.setOnClickListener {
                Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null)
                    .show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_order -> displayToast(resources.getString(R.string.action_order_message))
            R.id.action_status -> displayToast(resources.getString(R.string.action_status_message))
            R.id.action_favorites -> displayToast(resources.getString(R.string.action_favorites_message))
            R.id.action_contact -> displayToast(resources.getString(R.string.action_contact_message))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun displayToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showFoodOrder(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, OrderActivity::class.java))
    }
}