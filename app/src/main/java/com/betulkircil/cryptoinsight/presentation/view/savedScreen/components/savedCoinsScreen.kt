package com.betulkircil.cryptoinsight.presentation.view.savedScreen.components


import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.domain.model.Coins
import com.betulkircil.cryptoinsight.presentation.view.savedScreen.viewmodels.SavedCoinsViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun SavedCoins(
    navController : NavController,
    viewModel: SavedCoinsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val savedCoins: List<Coins> by viewModel.savedCoinsFlow.collectAsState(emptyList())
    Column(modifier = Modifier.background(color = colorResource(id = R.color.grey_black))) {
        Scaffold(
            modifier = Modifier.background(colorResource(id = R.color.grey_black)),
            content = {
                it
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.grey_black))
                        .verticalScroll(rememberScrollState())) {
                    savedCoins.forEach { coins ->
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.delete), contentDescription = null, modifier = Modifier
                                .size(50.dp)
                                .clickable {
                                    viewModel.deleteSavedCoins(coins)
                                    Toast
                                        .makeText(
                                            context,
                                            "Coin deleted succesfully!",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                                .padding(horizontal = 10.dp)
                            )
                        }
                        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Image(
                                    painter = rememberImagePainter(data = coins.image),
                                    contentDescription = coins.name,
                                    modifier = Modifier
                                        .padding(horizontal = 20.dp)
                                        .size(20.dp, 20.dp)
                                        .clip(RoundedCornerShape(20))
                                )
                                Text(
                                    text = coins.symbol.uppercase(),
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.White
                                )
                                Box(
                                    modifier = Modifier
                                        .width(120.dp)
                                        .padding(horizontal = 20.dp)
                                ) {
                                    Text(
                                        text = coins.name.trim(),
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Color.White,
                                        fontWeight = FontWeight.Light
                                    )
                                }
                                Spacer(
                                    modifier = Modifier
                                        .width(40.dp)
                                        .background(color = Color.White)
                                )
                                Text(
                                    text = "$ " + coins.currentPrice.toString().substring(0, 3),
                                    color = Color.White
                                )
                                Text(
                                    text = if (coins.marketCapChange24Percentage > 0) "+" + coins.marketCapChange24Percentage.toString()
                                        .substring(
                                            0,
                                            4
                                        ) + "%" else coins.marketCapChange24Percentage.toString()
                                        .substring(0, 5) + "%",
                                    color = if (coins.marketCapChange24Percentage < 0) Color.Red else Color.Green,
                                    modifier = Modifier.padding(horizontal = 20.dp)
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(0.5.dp)
                                    .background(color = colorResource(id = R.color.purple_protest))
                            ) {

                            }
                        }
                        }
                    }
                    Spacer(modifier = Modifier.height(70.dp))
                }
        )
    }
}