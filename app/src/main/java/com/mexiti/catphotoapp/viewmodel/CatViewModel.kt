package com.mexiti.catphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.catphotoapp.network.CatApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface CatUIState{
    data class Success(val photos:String) : CatUIState

    object Error:CatUIState

    object Loading:CatUIState
}
class CatViewModel: ViewModel() {
    var catUiState:CatUIState by mutableStateOf(CatUIState.Loading)
        private set

    init {
        getCatPhotos()
    }

    fun getCatPhotos(){
        viewModelScope.launch {
            catUiState = try{
                val listResult = CatApi.retrofitService.getPhotos()
                CatUIState.Success("Número de perritos recibidos: ${listResult.size}")
            }
            catch (e: IOException){
                CatUIState.Error
            }
        }
    }
}