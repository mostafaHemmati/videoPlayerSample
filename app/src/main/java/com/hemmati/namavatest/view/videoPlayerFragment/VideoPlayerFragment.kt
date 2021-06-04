package com.hemmati.namavatest.view.videoPlayerFragment

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.util.Util
import com.hemmati.namavatest.R
import com.hemmati.namavatest.databinding.FragmentVideoPlayerBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class VideoPlayerFragment : Fragment(R.layout.fragment_video_player) {
    val args: VideoPlayerFragmentArgs by navArgs()
    private lateinit var fragmentVideoPlayerBinding: FragmentVideoPlayerBinding
    private val videosUrlViewModel: VideosUrlViewModel by viewModel() {
        parametersOf(args.videoId)
    }
    private var player: SimpleExoPlayer? = null
    private var fileUrl: String = ""
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition: Long = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentVideoPlayerBinding =
            FragmentVideoPlayerBinding.inflate(inflater, container, false)
        return fragmentVideoPlayerBinding.root
    }

    override fun onStart() {
        super.onStart()
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        videosUrlViewModel.videoUrlData.observe(viewLifecycleOwner) {
            fileUrl = it.request.files.progressive[it.request.files.progressive.size - 1].url
            initPlayer()
        }
    }


    private fun initPlayer() {
        player = SimpleExoPlayer.Builder(requireContext()).build()
        fragmentVideoPlayerBinding.videoPlayer.player = player
        val mediaItem = MediaItem.fromUri(fileUrl)
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.play()
    }

    private fun releasePlayer() {
        if (player != null) {
            playWhenReady = player?.playWhenReady ?: false
            playbackPosition = player?.currentPosition ?: 0
            currentWindow = player?.currentWindowIndex ?: 0
            player?.release()
            player = null
        }
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT <= 23)
            if ((player == null)) {
                initPlayer()
            }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23)
            releasePlayer()
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23)
            releasePlayer()
    }

    override fun onDestroy() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onDestroy()
    }

}