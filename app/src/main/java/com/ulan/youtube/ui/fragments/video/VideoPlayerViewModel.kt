package com.ulan.youtube.ui.fragments.video

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ulan.youtube.data.model.BaseMainResponse
import com.ulan.youtube.data.model.ItemPlayList
import com.ulan.youtube.data.repository.YoutubeRepository
import com.ulan.youtube.ui.utils.Resourse

class VideoPlayerViewModel(
    private val repository: YoutubeRepository
) : ViewModel() {

    private var _liveData: LiveData<Resourse<BaseMainResponse<ItemPlayList>?>> = MutableLiveData()
    val liveData get() = _liveData
}
