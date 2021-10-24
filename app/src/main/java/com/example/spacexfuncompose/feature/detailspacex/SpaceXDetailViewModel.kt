package com.example.spacexfuncompose.feature.detailspacex

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import com.example.spacexfuncompose.model.FavoriteIdEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class SpaceXDetailViewModel @Inject constructor(
    private val spaceXUseCase: SpaceXUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "SpaceXDetailViewModel"
    }

    private var _favoriteRocketList: MutableLiveData<MutableList<FavoriteIdEntity>> =
        MutableLiveData()
    val favoriteRocketListLiveData: LiveData<MutableList<FavoriteIdEntity>> get() = _favoriteRocketList

    private var _isFavorite: MutableLiveData<Boolean> =
        MutableLiveData()
    val isFavoriteLiveData: LiveData<Boolean> get() = _isFavorite

    init {
        getFavoriteRocketList()
    }

    fun getFavoriteRocketList() = viewModelScope.launch(Dispatchers.IO) {
        spaceXUseCase.getFavoriteRockets()
            .onStart {
                Log.d(TAG, "On start favorite")
            }
            .onCompletion {
                Log.d(TAG, "On Completion favorite")
            }
            .catch {
                Log.d(TAG, "On Error favorite")
            }
            .collect {
                Log.d(TAG, "On Collect favorite")
                if (it.size >= 1) {
                    _isFavorite.postValue(true)
                } else {
                    false
                }
                _favoriteRocketList.postValue(it)
            }
    }

    fun addRocketToFavorite(rocketId: String) = viewModelScope.launch(Dispatchers.IO) {
        Log.d("Cihat Log:", " favorite create:$rocketId")
        spaceXUseCase.addRocketToFavorite(rocketId)
    }

    fun deleteRocketToFavorite(rocketId: String) = viewModelScope.launch(Dispatchers.IO) {
        Log.d("Cihat Log:", " favorite deleted:$rocketId")
        spaceXUseCase.deleteRocketToFavorite(rocketId)
    }
}
