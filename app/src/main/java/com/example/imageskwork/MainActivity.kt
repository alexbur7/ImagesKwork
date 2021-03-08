package com.example.imageskwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.imageskwork.databinding.ActivityMainBinding
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    val binding:ActivityMainBinding by lazy {DataBindingUtil.setContentView(this,R.layout.activity_main)}
    lateinit var dispContainer:CompositeDisposable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dispContainer= CompositeDisposable()
        initButton(binding.button1,android.R.color.white,"1 кнопка")
        initButton(binding.button2,android.R.color.holo_purple,"2 кнопка")
        initButton(binding.button3,android.R.color.holo_red_dark,"3 кнопка")
        initButton(binding.button4,android.R.color.holo_green_dark,"4 кнопка")
        initButton(binding.button5,android.R.color.holo_blue_dark,"5 кнопка")
        initButton(binding.button6,android.R.color.holo_orange_dark,"6 кнопка")
    }

    private fun initButton(v: View,imgResource: Int,text:String){
       dispContainer.add(RxView.clicks(v).observeOn(Schedulers.io()).subscribe(){
           runOnUiThread {
               binding.textView.setBackgroundResource(imgResource)
           }
           Thread.sleep(4000)
           runOnUiThread {
               binding.textView.text = text
           }
       })
    }
}