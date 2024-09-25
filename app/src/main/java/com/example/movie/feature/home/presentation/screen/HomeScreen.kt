package com.example.movie.feature.home.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movie.feature.home.presentation.component.GridMovieListView
import com.example.movie.feature.home.presentation.component.HomeSearchBarView
import com.example.movie.feature.home.presentation.component.HorizontalMovieListView
import com.example.movie.feature.home.presentation.viewmodal.HomeViewModal

@Composable
fun HomeScreen(navHostController: NavHostController) {
    val viewModel = HomeViewModal()

    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.Black) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "iMovie",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            HomeSearchBarView(navHostController)
            CategoryListView(viewModel)
            if (viewModel.selectedCategory == "All") {
                HorizontalMovieListView(
                    "Popular",
                    viewModel.popularMovies.observeAsState(initial = emptyList()).value.toMutableStateList(),
                    navHostController
                )
                HorizontalMovieListView(
                    "Now Playing",
                    viewModel.nowPlayingMovies.observeAsState(initial = emptyList()).value.toMutableStateList(),
                    navHostController
                )
                HorizontalMovieListView(
                    "Up Coming",
                    viewModel.upcomingMovies.observeAsState(initial = emptyList()).value.toMutableStateList(),
                    navHostController
                )
            } else {
                GridMovieListView(
                    viewModel.selectedCategory,
                    viewModel.movies.observeAsState(initial = emptyList()).value.toMutableStateList(),
                    navHostController
                )
            }
        }
    }

}

@Composable
fun CategoryListView(viewModel: HomeViewModal) {
    LazyRow(
        Modifier.padding(vertical = 8.dp)
    ) {
        items(viewModel.categories) { category ->
            val color = if (category == viewModel.selectedCategory) {
                Color.White
            } else {
                Color.Gray
            }
            Surface(
                onClick = { viewModel.updateCategory(category) },
                modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 4.dp),
                color = color,
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = category,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }
    }
}

