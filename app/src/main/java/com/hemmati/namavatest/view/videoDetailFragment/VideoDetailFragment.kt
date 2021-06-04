package com.hemmati.namavatest.view.videoDetailFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hemmati.namavatest.databinding.FragmentVideoDetailBinding
import com.hemmati.namavatest.util.showToast
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.DefinitionParameters

class VideoDetailFragment : Fragment() {
    private lateinit var fragmentVideoDetailBinding: FragmentVideoDetailBinding

    private val args: VideoDetailFragmentArgs by navArgs()
    private val videosDetailViewModel: VideosDetailViewModel by viewModel() {
        DefinitionParameters(listOf(args.id))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentVideoDetailBinding = FragmentVideoDetailBinding.inflate(inflater, container, false)
        return fragmentVideoDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelStartAndObserved()
        onClicksAction()
    }


    private fun viewModelStartAndObserved() {
        with(videosDetailViewModel) {

            videoDetailData.observe(viewLifecycleOwner) {
                fragmentVideoDetailBinding.videoDetailData = it
            }

            showProgressbar.observe(viewLifecycleOwner) { state ->
                fragmentVideoDetailBinding.progressBar.isVisible = state
                fragmentVideoDetailBinding.allViews.isVisible = !state
            }

            messageData.observe(viewLifecycleOwner) {
                showToast(it)
            }

        }
    }

    private fun onClicksAction() {
        fragmentVideoDetailBinding.videoPlayer.setOnClickListener {
            val action =
                VideoDetailFragmentDirections.actionVideoDetailFragmentToVideoPlayerFragment(args.id)
            findNavController().navigate(action)
        }
    }

}