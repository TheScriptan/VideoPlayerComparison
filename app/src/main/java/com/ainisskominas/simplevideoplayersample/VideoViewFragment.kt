package com.ainisskominas.simplevideoplayersample

import android.graphics.PixelFormat
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ainisskominas.simplevideoplayersample.databinding.FragmentVideoViewBinding

class VideoViewFragment : Fragment() {

    lateinit var videoUri: Uri
    private lateinit var binding: FragmentVideoViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoViewBinding.inflate(inflater, container, false)
        videoUri =
            Uri.parse("android.resource://" + context?.packageName + "/" + R.raw.bunny_trailer)

        binding.videoView.apply {
            setZOrderOnTop(true)
            holder.setFormat(PixelFormat.TRANSLUCENT)
            setVideoURI(videoUri)
            start()

            setOnPreparedListener { mp ->
                mp.isLooping = true
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        binding.videoView.stopPlayback()
        super.onDestroyView()
    }
}
