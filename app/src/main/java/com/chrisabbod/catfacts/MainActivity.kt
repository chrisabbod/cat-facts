package com.chrisabbod.catfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chrisabbod.catfacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val catFactList: Set<String> = setOf(
        "Cats are animals",
        "Cats are usually small",
        "Cats are usually furry",
        "Cats are cute!",
        "Cats are troublemakers",
        "Lions are cats",
        "Tigers are cats",
        "Jaguars are cats",
        "Panthers are cats",
        "Cheetahs are cats"
    )

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnRandomFact.setOnClickListener {
                tvRandomFact.text = catFactList.random()
            }
        }
    }
}