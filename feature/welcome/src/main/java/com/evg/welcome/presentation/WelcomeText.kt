package com.evg.welcome.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evg.resource.theme.WeatherTheme
import com.evg.welcome.domain.model.City

@Composable
fun WelcomeText(
    listCities: List<City>?,
    checkCity: (String?) -> Unit,
    setCity: (City?) -> Unit,
    onCityApply: () -> Unit,
) {
    val context = LocalContext.current
    var typedCityText: String? by rememberSaveable { mutableStateOf(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 50.dp),
            text = "Weather",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 40.sp,
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp),
            text = "Choose your city",
            style = MaterialTheme.typography.bodyMedium,
        )

        ExposedCityMenu(
            listCities = listCities,
            onSelect = { city ->
                typedCityText = null
                setCity(city)
            },
            onEdit = { text ->
                typedCityText = text
            }
        )

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = {
                if (typedCityText != null) {
                    checkCity(typedCityText)
                } else {
                    onCityApply()
                }
            }
        ) {
            Text(
                modifier = Modifier
                    .padding(5.dp),
                text = "Submit"
            )
        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun WelcomeTextPreview() {
    WeatherTheme {
        WelcomeText(
            listCities = listOf(
                City(
                    id = 1,
                    coordLat = 123.568,
                    coordLon = 2356.970,
                    name = "Moscow"
                ),
                City(
                    id = 2,
                    coordLat = 45.845,
                    coordLon = 456.00,
                    name = "Samara"
                ),
                City(
                    id = 33,
                    coordLat = 345.898,
                    coordLon = 46756.23,
                    name = "Ulyanovsk"
                ),
            ),
            checkCity = { },
            setCity = { },
            onCityApply = { }
        )
    }
}