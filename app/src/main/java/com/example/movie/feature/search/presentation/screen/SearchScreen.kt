package com.example.movie.feature.search.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movie.feature.home.presentation.component.GridMovieListView
import com.example.movie.feature.search.presentation.component.SearchBarView
import com.example.movie.feature.search.presentation.viewmodel.SearchViewModal

@Composable
fun SearchScreen(navHostController: NavHostController) {
    val viewModal = SearchViewModal()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black
    ) { innerPadding ->
        Column (
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(innerPadding)
        ){
            SearchBarView(viewModal)

            Spacer(modifier = Modifier.height(8.dp))

            GridMovieListView(
                sectionTitle ="Result",
                movies = viewModal.movies.observeAsState(initial = emptyList()).value.toMutableStateList(),
                navHostController
            )
        }

    }

}