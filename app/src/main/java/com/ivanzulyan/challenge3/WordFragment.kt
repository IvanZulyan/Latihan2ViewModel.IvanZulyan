package com.ivanzulyan.challenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanzulyan.challenge3.databinding.FragmentWordBinding

class WordFragment : Fragment() {

    private var _binding: FragmentWordBinding? = null
    private val binding get() = _binding!!

    private lateinit var wordList: ArrayList<Word>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getLetter = arguments?.getSerializable("letter") as Letter
        val word = getLetter.letter
        wordList = when (word) {
            "A" -> {
                arrayListOf(
                    Word("Akar"),
                    Word("Akward"),
                    Word("Asah"),
                )
            }
            "B" -> {
                arrayListOf(
                    Word("Banjir"),
                    Word("Bekasi"),
                    Word("Bakwan"),
                )
            }
            "C" -> {
                arrayListOf(
                    Word("Curug"),
                    Word("Clara"),
                    Word("Contoh"),
                )
            }
            "D" -> {
                arrayListOf(
                    Word("Dada"),
                    Word("Dasi"),
                    Word("Dadu"),
                )
            }
            "E" -> {
                arrayListOf(
                    Word("Ekor"),
                    Word("Elang"),
                    Word("Evaluasi"),
                )
            }
            "F" -> {
                arrayListOf(
                    Word("Farhan"),
                    Word("Fardu"),
                    Word("Forza"),
                )
            }
            "G" -> {
                arrayListOf(
                    Word("Gitar"),
                    Word("Golang"),
                    Word("Gosip"),
                )
            }
            "H" -> {
                arrayListOf(
                    Word("Hantu"),
                    Word("Haji"),
                    Word("Hobi"),
                )
            }
            "I" -> {
                arrayListOf(
                    Word("Indonesia"),
                    Word("Inggris"),
                    Word("Ilfeel"),
                )
            }
            "J" -> {
                arrayListOf(
                    Word("Jepang"),
                    Word("Jawa"),
                    Word("Jawab"),
                )
            }
            else -> arrayListOf()
        }

        binding.rvWords.setHasFixedSize(true)
        var lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvWords.layoutManager = lm
        binding.rvWords.adapter = WordAdapter(wordList)
    }
}