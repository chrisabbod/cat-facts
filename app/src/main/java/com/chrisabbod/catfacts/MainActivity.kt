package com.chrisabbod.catfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chrisabbod.catfacts.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val catFactsAPI: CatFactsAPI = RetrofitHelper.getInstance().create(CatFactsAPI::class.java)

    private val parentJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + parentJob)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coroutineScope.launch(Dispatchers.Main) {
            val catFactList = catFactsAPI.retrieveListOfFacts(300, 100)

            binding.btnRandomFact.setOnClickListener { getCatFact(catFactList) }
        }
    }

    private fun getCatFact(listOfFacts: CatFactResponse) {
        binding.tvRandomFact.text = listOfFacts.data.random().fact
    }
}