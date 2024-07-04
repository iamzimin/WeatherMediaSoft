package com.evg.weather

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.evg.resource.LocalNavHostController
import com.evg.resource.theme.WeatherTheme
import com.evg.selection_city.presentation.SelectionCityScreen
import com.evg.shared_prefs.data.repository.SharedPrefsRepositoryImpl
import com.evg.weather_city.presentation.WeatherCityScreen
import com.evg.welcome.presentation.WelcomeScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val sharedPreferencesRepository = SharedPrefsRepositoryImpl(context = LocalContext.current) //TODO
    val latestCity = sharedPreferencesRepository.getLatestCity()

    CompositionLocalProvider(LocalNavHostController provides navController) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "welcome"
                ) {
                    composable("welcome") {
                        if (latestCity != null) {
                            WeatherCityScreen(
                                cityId = latestCity
                            )
                        } else {
                            WelcomeScreen()
                        }
                    }

                    composable(
                        route = "city/{id}",
                        arguments = listOf(
                            navArgument("id") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        ),
                    ) { entry ->
                        val id = entry.arguments?.getInt("id") ?: -1
                        WeatherCityScreen(
                            cityId = id
                        )
                    }

                    composable(
                        route = "cityList",
                    ) {
                        SelectionCityScreen()
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun MainScreenPreview() {
    WeatherTheme {
        MainScreen()
    }
}