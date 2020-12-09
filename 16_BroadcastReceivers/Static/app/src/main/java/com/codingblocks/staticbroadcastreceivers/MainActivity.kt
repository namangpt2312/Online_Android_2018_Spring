package com.codingblocks.staticbroadcastreceivers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val psr = PowerStateReceiver()
        val iFilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_POWER_CONNECTED)
        }
        
        registerReceiver(psr, iFilter)
    }
    
    inner class PowerStateReceiver: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent == null) return;
            
            if(intent.action == Intent.ACTION_POWER_CONNECTED) {
                Toast.makeText(
                    this@MainActivity,
                    "CHARGER CONNECTED",
                    Toast.LENGTH_SHORT
                ).show()
            }
            
            if(intent.action == Intent.ACTION_POWER_DISCONNECTED) {
                Toast.makeText(
                    this@MainActivity,
                    "CHARGER DISCONNECTED",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
        
}
