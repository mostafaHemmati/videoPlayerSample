package com.hemmati.namavatest.view.searchListFragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hemmati.namavatest.R
import com.hemmati.namavatest.databinding.FragmentSearchListBinding
import com.hemmati.namavatest.util.isNetworkAvailable
import com.hemmati.namavatest.util.showIf
import com.hemmati.namavatest.util.showToast
import org.koin.android.viewmodel.ext.android.viewModel


class SearchListFragment : Fragment() {
    private lateinit var fragmentSearchListBinding: FragmentSearchListBinding

    private val videoListViewModel: VideoListViewModel by viewModel()

    private lateinit var mVideosAdapter: VideosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSearchListBinding = FragmentSearchListBinding.inflate(inflater, container, false)
        return fragmentSearchListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialRecyclerView()
        viewModelStartAndObserved()
        onClicksAction()
    }


    private fun initialRecyclerView() {
        fragmentSearchListBinding.videosRecyclerView.apply {
            mVideosAdapter = VideosAdapter()
            adapter = mVideosAdapter
        }
    }

    private fun viewModelStartAndObserved() {
        fragmentSearchListBinding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (isNetworkAvailable()) {
                    videoListViewModel.getPosts(p0.toString())
                } else
                    showToast(getString(R.string.no_internet_connection))

            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })



        with(videoListViewModel) {
            videoListData.observe(viewLifecycleOwner) {
                if (!it.data.isNullOrEmpty()) {
                    mVideosAdapter.videos = it.data
                    showAndVisibleView(
                        recyclerState = true,
                    )
                } else
                    showAndVisibleView(
                        noItemState = true,
                    )


            }
            showProgressbar.observe(viewLifecycleOwner) { state ->
                fragmentSearchListBinding.progressBar.showIf { state }

            }
            messageData.observe(viewLifecycleOwner) {
                showToast(it)
            }
            queryTextNullOrEmpty.observe(viewLifecycleOwner) {
                showAndVisibleView(
                    searchMsgState = true
                )

            }

        }
    }

    private fun showAndVisibleView(
        recyclerState: Boolean = false,
        noItemState: Boolean = false,
        searchMsgState: Boolean = false
    ) {
        fragmentSearchListBinding.videosRecyclerView.showIf {
            recyclerState
        }
        fragmentSearchListBinding.noItemLayout.showIf {
            noItemState
        }
        fragmentSearchListBinding.searchMsgLayout.showIf {
            searchMsgState
        }
    }


    private fun onClicksAction() {
        mVideosAdapter.onItemClick = {
            val id = it.uri.split('/')[2]

            val action =
                SearchListFragmentDirections.actionSearchListFragmentToVideoDetailFragment(id)

            findNavController().navigate(action)
        }
    }
}