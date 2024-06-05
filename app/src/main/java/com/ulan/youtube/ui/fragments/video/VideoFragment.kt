

package com.ulan.youtube.ui.fragments.video

import android.annotation.SuppressLint
import android.content.Intent
import android.webkit.WebChromeClient
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ulan.youtube.base.BaseFragment
import com.ulan.youtube.databinding.FragmentVideoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class VideoFragment : BaseFragment<FragmentVideoBinding>() {
    private val args: VideoFragmentArgs by navArgs()
    private val viewModel : VideoPlayerViewModel by viewModel()
    override fun getViewBinding(): FragmentVideoBinding =
        FragmentVideoBinding.inflate(layoutInflater)


    @SuppressLint("SetJavaScriptEnabled")
    override fun initialize() {
        binding.tvTitleVideo?.text = args.videoTitle
        binding.txtDesc?.text = args.videoDesc
        val videoID = args.videoID
        val videoURL =
            "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/$videoID?autoplay=1\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        binding.webYoutubePlayer.loadData(videoURL, "text/html", "utf-8")
        binding.webYoutubePlayer.settings.javaScriptEnabled = true
        binding.webYoutubePlayer.webChromeClient = WebChromeClient()



    }

    override fun launchObserver() {
        binding.tvTitleVideo?.text = args.videoTitle
        binding.txtDesc?.text = args.videoDesc
    }

    override fun constructorListeners() {
        binding.btnBack?.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnSh?.setOnClickListener {
            share()
        }
    }
    private fun share(){
        val videoID = args.videoID
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,"Я поделился с тобой этим видео " +
                "https://youtu.be/$videoID")
        startActivity(Intent.createChooser(intent,"Поделился с тобой этим видео"))
    }




}
