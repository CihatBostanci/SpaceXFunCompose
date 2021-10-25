package com.example.spacexfuncompose.feature.detailspacex

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spacexfuncompose.base.BaseViewModel
import com.example.spacexfuncompose.feature.spacex.domain.SpaceXUseCase
import com.example.spacexfuncompose.model.FavoriteIdEntity
import com.example.spacexfuncompose.usecases.AddRocketToFavoriteUseCase
import com.example.spacexfuncompose.usecases.DeleteRocketToFavoriteUseCase
import com.example.spacexfuncompose.usecases.GetFavoriteRocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class SpaceXDetailViewModel @Inject constructor(
    private val spaceXUseCase: SpaceXUseCase
) : BaseViewModel() {

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

    private fun getFavoriteRocketList() = launchDataLoad {
        spaceXUseCase.getFavoriteRocketUseCase.execute(GetFavoriteRocketUseCase.Request())
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
                    _isFavorite.postValue(false)
                }
                _favoriteRocketList.postValue(it)
            }
    }

    fun addRocketToFavorite(rocketId: String) = launchDataLoad {
        spaceXUseCase.addRocketToFavoriteUseCase.execute(AddRocketToFavoriteUseCase.Request(rocketId))
            .onStart {
                Log.d(TAG, "On start favorite create")
            }
            .onCompletion {
                Log.d(TAG, "On Completion favorite create")
            }
            .catch {
                Log.d(TAG, "On Error favorite create")
            }
            .collect {
                Log.d("Cihat Log:", " favorite create:$rocketId")
            }
    }

    fun deleteRocketToFavorite(rocketId: String) = launchDataLoad {
        spaceXUseCase.deleteRocketToFavoriteUseCase.execute(
            DeleteRocketToFavoriteUseCase.Request(
                rocketId
            )
        )
            .onStart {
                Log.d(TAG, "On start favorite create")
            }
            .onCompletion {
                Log.d(TAG, "On Completion favorite create")
            }
            .catch {
                Log.d(TAG, "On Error favorite create")
            }
            .collect {
                Log.d("Cihat Log:", " favorite deleted:$rocketId")
            }
    }

}
