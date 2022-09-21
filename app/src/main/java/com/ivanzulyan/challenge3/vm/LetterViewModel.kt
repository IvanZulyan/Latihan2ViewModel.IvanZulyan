package com.ivanzulyan.challenge3.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ivanzulyan.challenge3.Letter

class LetterViewModel: ViewModel() {
    val list = arrayListOf(
        Letter("A"),
        Letter("B"),
        Letter("C"),
        Letter("D"),
        Letter("E"),
        Letter("F"),
        Letter("G"),
        Letter("H"),
        Letter("I"),
        Letter("J"),
    )

    val letter: MutableLiveData<List<Letter>> = MutableLiveData()

    fun getLetter() {
        letter.value = list
    }
}