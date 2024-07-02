package com.evg.weather_city.presentation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evg.resource.R
import com.evg.resource.theme.BorderRadius
import com.evg.resource.theme.WeatherTheme
import com.evg.weather_city.presentation.model.CurrentWeatherCloudsUI
import com.evg.weather_city.presentation.model.CurrentWeatherCoordinatesUI
import com.evg.weather_city.presentation.model.CurrentWeatherInfoUI
import com.evg.weather_city.presentation.model.CurrentWeatherMainUI
import com.evg.weather_city.presentation.model.CurrentWeatherRainUI
import com.evg.weather_city.presentation.model.CurrentWeatherSnowUI
import com.evg.weather_city.presentation.model.CurrentWeatherSysUI
import com.evg.weather_city.presentation.model.CurrentWeatherUI
import com.evg.weather_city.presentation.model.CurrentWeatherWindUI

@Composable
fun WeatherContent(
    currentWeather: CurrentWeatherUI,
) {
    val horizontalPadding = 30.dp
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .verticalScroll(scrollState)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Updated: 23:21",
                        modifier = Modifier
                            .padding(horizontal = horizontalPadding),
                        style = MaterialTheme.typography.bodySmall
                    )

                    IconButton(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(35.dp),
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.location),
                            tint = MaterialTheme.colorScheme.inverseSurface,
                            contentDescription = "Filter",
                        )
                    }
                }


                Column(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(
                            top = 20.dp,
                            bottom = 30.dp,
                            start = horizontalPadding,
                            end = horizontalPadding,
                        )
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = currentWeather.name,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Row {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = currentWeather.main.temp.toString(),
                            textAlign = TextAlign.Center,
                            fontSize = 100.sp,
                        )
                    }
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "${currentWeather.main.tempMin} / ${currentWeather.main.tempMax}",
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = currentWeather.weather[0].main,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(BorderRadius))
                .background(color = Color.Gray)
        ) {
            Text(text = "sdfdsf", modifier = Modifier.padding(50.dp))
            /*LazyColumn {

            }*/
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(BorderRadius))
                .background(color = Color.Gray)
        ) {
            Text(text = "sdfdsf", modifier = Modifier.padding(50.dp))
            /*LazyColumn {

            }*/
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "More detailed",
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(3.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(BorderRadius))
                .background(color = Color.Gray)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = MaterialTheme.shapes.medium
                )
        ) {
            Row {
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                    icon = painterResource(id = R.drawable.location),
                    title = "dfsfs",
                    info = "sdfsd",
                )
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                    icon = painterResource(id = R.drawable.location),
                    title = "dfsfs",
                    info = "sdfsd",
                )
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                    icon = painterResource(id = R.drawable.location),
                    title = "dfsfs",
                    info = "sdfsd",
                )
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                    icon = painterResource(id = R.drawable.location),
                    title = "dfsfs",
                    info = "sdfsd",
                )
            }
            Row {
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                    icon = painterResource(id = R.drawable.location),
                    title = "dfsfs",
                    info = "sdfsd",
                )
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                    icon = painterResource(id = R.drawable.location),
                    title = "dfsfs",
                    info = "sdfsd",
                )
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                    icon = painterResource(id = R.drawable.location),
                    title = "dfsfs",
                    info = "sdfsd",
                )
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                    icon = painterResource(id = R.drawable.location),
                    title = "dfsfs",
                    info = "sdfsd",
                )
            }
            Row {
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                    icon = painterResource(id = R.drawable.location),
                    title = "dfsfs",
                    info = "sdfsd",
                )
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                )
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                )
                DetailedInfoTile(
                    modifier = Modifier.weight(1f),
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun MainScreenPreview() {
    WeatherTheme {
        WeatherContent(
            currentWeather = CurrentWeatherUI(
                coordinates = CurrentWeatherCoordinatesUI(lon = 34.56, lat = -78.9),
                weather = listOf(
                    CurrentWeatherInfoUI(id = 800, main = "Clear", description = "clear sky", icon = "01d")
                ),
                main = CurrentWeatherMainUI(
                    temp = 22, feelsLike = 25, tempMin = 20, tempMax = 25,
                    pressure = 1010, humidity = 70, seaLevel = 1015, groundLevel = 1005
                ),
                visibility = 10000,
                wind = CurrentWeatherWindUI(speed = 3.5, deg = 180, gust = 4.2),
                rain = CurrentWeatherRainUI(oneHour = 0.0, threeHour = 0.0),
                snow = CurrentWeatherSnowUI(oneHour = 0.0, threeHour = 0.0),
                clouds = CurrentWeatherCloudsUI(cloudiness = 10),
                timestamp = System.currentTimeMillis() / 1000,
                sys = CurrentWeatherSysUI(country = "US", sunrise = 1625222257, sunset = 1625273893),
                timezone = -14400,
                id = 5128581,
                name = "New York"
            )
        )
    }
}