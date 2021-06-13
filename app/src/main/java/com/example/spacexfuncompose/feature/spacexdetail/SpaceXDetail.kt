package com.example.spacexfuncompose.feature.spacexdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.spacexfuncompose.model.AllRocketResponse
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Composable
fun SpaceXDetail(viewModel: SpaceXDetailViewModel){

   Column{
       Text(text = "Test")
   }
}