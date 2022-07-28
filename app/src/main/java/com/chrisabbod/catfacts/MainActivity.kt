package com.chrisabbod.catfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chrisabbod.catfacts.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catFactsAPI = RetrofitHelper.getInstance().create(CatFactsAPI::class.java)

        GlobalScope.launch {
            val result = catFactsAPI.getRandomFact()

            binding.apply {
                btnRandomFact.setOnClickListener {
                    tvRandomFact.text = result.fact
                    Log.e("FACT", result.fact)
                }
            }
        }
    }
}