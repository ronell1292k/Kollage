package ronell.picsum.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ronell.picsum.R

@Composable
fun HomeScreen(
    kollageUiState: KollageUiState,
    modifier: Modifier = Modifier,
) {
    when(kollageUiState) {
        is KollageUiState.Loading -> LoadingScreen(modifier)
        is KollageUiState.Error -> ErrorScreen(modifier)
        is KollageUiState.Success -> ResultScreen(kollageUiState.photos, modifier)
    }
}

@Composable
fun ResultScreen(kollageUiState: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = kollageUiState)
    }
}


@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(stringResource(R.string.loading))
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(stringResource(R.string.loading_failed))
    }
}
