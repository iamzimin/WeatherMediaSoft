package com.evg.welcome.presentation

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.evg.resource.LocalNavHostController
import com.evg.resource.theme.WeatherTheme
import com.evg.welcome.presentation.viewmodel.WelcomeViewModel

@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel = hiltViewModel<WelcomeViewModel>(),
) {
    val context = LocalContext.current
    val navController = LocalNavHostController.current
    var isInitialized by rememberSaveable { mutableStateOf(false) }

    val cities by viewModel.cityList.collectAsState()
    val isCityListLoading by viewModel.isCityListLoading.collectAsState()

    val city by viewModel.city.collectAsState()

    if (!isInitialized) {
        LaunchedEffect(Unit) {
            viewModel.getCityList()
            isInitialized = true
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (isCityListLoading) {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        text = "Загрузка списка городов"
                    )
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        } else {
            //TODO
            if (city != null) {
                Toast.makeText(context, "Navigating to ${city?.name}", Toast.LENGTH_SHORT).show()
                val id = city?.id ?: -1
                navController.navigate("city/${id}")
            }

            WelcomeText(
                listCities = cities,
                checkCity = { name ->
                    viewModel.checkCity(name)
                },
                setCity = { city ->
                    viewModel.setSelectedCity(city)
                },
                onCityApply = {
                    //TODO
                     if (viewModel.city.value != null) {
                        Toast.makeText(context, "Navigating to ${viewModel.city.value}", Toast.LENGTH_SHORT).show()
                         val id = city?.id ?: -1
                         navController.navigate("city/${id}")
                    }
                }
            )
        }
    }
}

/*fun cityNavigate(city: City?) {
    if (city == null) {
        Toast.makeText(context, "nf", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, city.name, Toast.LENGTH_SHORT).show()
    }
}*/

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CharacterFilterDialogPreview() {
    WeatherTheme {
        WelcomeScreen()
    }
}