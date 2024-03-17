package com.mexiti.catphotoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mexiti.catphotoapp.R
import com.mexiti.catphotoapp.viewmodel.CatUIState


@Composable

fun HomeScreen(
    catUiState:CatUIState,
    modifier: Modifier= Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
               ){
    when(catUiState){
        is CatUIState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is CatUIState.Success -> ResultScreen(photos = catUiState.photos,
            modifier=modifier.fillMaxWidth())
        is CatUIState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.error_en_la_nube), contentDescription = "Error")
    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.bar), contentDescription = "Loading")
    }
}


@Composable
fun ResultScreen(photos:String, modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
        ){
        Text(text = photos )
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        //HomeScreen(stringResource(R.string.placeholder_result))
    }

}
