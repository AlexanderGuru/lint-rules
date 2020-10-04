package com.ag.lint_rules

import android.app.Activity
import android.os.Bundle
import android.util.Log

class TestActivity : Activity() {

    private fun test(){
        Log.d("TEST", "test: 0")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun test1(){
        Log.d("TEST", "test: 1")
    }
}