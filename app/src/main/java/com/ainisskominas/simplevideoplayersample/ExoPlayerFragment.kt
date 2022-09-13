package com.ainisskominas.simplevideoplayersample

import android.graphics.PixelFormat
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ainisskominas.simplevideoplayersample.databinding.FragmentExoPlayerBinding
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player


class ExoPlayerFragment : Fragment() {

    private var exoPlayer: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentExoPlayerBinding.inflate(inflater, container, false)
        val videoUri =
            Uri.parse("android.resource://" + context?.packageName + "/" + R.raw.bunny_trailer)

        if (exoPlayer == null) {
            val surfaceView = binding.exoplayer.videoSurfaceView as SurfaceView
            surfaceView.setZOrderOnTop(true)
            surfaceView.holder.setFormat(PixelFormat.TRANSLUCENT)

            val rendersFactory =
                DefaultRenderersFactory(requireContext()).setEnableDecoderFallback(true)

            exoPlayer = ExoPlayer.Builder(requireContext(), rendersFactory).build().apply {
                setMediaItem(MediaItem.fromUri(videoUri))
                repeatMode = Player.REPEAT_MODE_ALL
                playWhenReady = true
                prepare()
            }
        }

        binding.exoplayer.player = exoPlayer

        return binding.root
    }

    override fun onDestroyView() {
        exoPlayer?.release()
        exoPlayer = null
        super.onDestroyView()
    }
}
