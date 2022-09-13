package com.ainisskominas.simplevideoplayersample

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ainisskominas.simplevideoplayersample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnHomeEnterVideoView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToVideoPlayerFragment())
        }

        binding.btnHomeEnterExoPlayer.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToExoPlayerFragment())
        }

        binding.btnHomeChangeTheme.setOnClickListener {
            when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                Configuration.UI_MODE_NIGHT_NO -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }
        }

        return binding.root
    }
}
