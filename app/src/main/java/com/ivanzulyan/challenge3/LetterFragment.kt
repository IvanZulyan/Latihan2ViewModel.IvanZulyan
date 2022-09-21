package com.ivanzulyan.challenge3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanzulyan.challenge3.databinding.FragmentLetterBinding
import com.ivanzulyan.challenge3.vm.LetterViewModel

class LetterFragment : Fragment() {
    lateinit var vmLetter: LetterViewModel
    lateinit var adapterLetter: LetterAdapter


    private var _binding: FragmentLetterBinding? = null
    private val binding get() = _binding!!

    private lateinit var letterList : ArrayList<Letter>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLetterBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterLetter = LetterAdapter(ArrayList())
        vmLetter =ViewModelProvider(this).get(LetterViewModel::class.java)
        vmLetter.letter.observe(viewLifecycleOwner, Observer {
            adapterLetter.setDataLetter(it as ArrayList<Letter>)
        })
        vmLetter.getLetter()
//        letterList = arrayListOf(
//            Letter("A"),
//            Letter("B"),
//            Letter("C"),
//            Letter("D"),
//            Letter("E"),
//            Letter("F"),
//            Letter("G"),
//            Letter("H"),
//            Letter("I"),
//            Letter("J"),
//        )
        binding.rvWords.setHasFixedSize(true)
        var lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvWords.layoutManager = lm
        binding.rvWords.adapter = adapterLetter
    }

}