package com.betulkircil.cryptoinsight.presentation.view.coinScreen.components

import android.widget.Space
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.betulkircil.cryptoinsight.R
import com.betulkircil.cryptoinsight.presentation.view.coinScreen.AllCoinsViewModel

@Composable
fun AllCoinsScreen(
    navController: NavController,
    allCoinsViewModel: AllCoinsViewModel = hiltViewModel()
) {
    val state = allCoinsViewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.grey_black))){
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Row(modifier = Modifier.padding(20.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Name", style = androidx.compose.material3.MaterialTheme.typography.bodySmall, color = Color.White, fontWeight = FontWeight.Light, fontSize = 10.sp)
                Row(modifier = Modifier) {
                    Text(text = "Price", style = androidx.compose.material3.MaterialTheme.typography.bodySmall, color = Color.White, modifier = Modifier.padding(horizontal = 10.dp), fontWeight = FontWeight.Light, fontSize = 10.sp)
                    Text(text = "24h Change", style = androidx.compose.material3.MaterialTheme.typography.bodySmall, color = Color.White, fontWeight = FontWeight.Light, fontSize = 10.sp)
                }
            }
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(state.coins){coin->
                    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                            .clickable { /*todo*/ }, horizontalArrangement = Arrangement.SpaceAround) {
                            Image(painter = rememberImagePainter(data = coin.image), contentDescription = coin.name,
                                modifier = Modifier
                                    .padding(horizontal = 20.dp)
                                    .size(20.dp, 20.dp)
                                    .clip(RoundedCornerShape(20)))
                            Text(text = coin.symbol.uppercase(), style =  androidx.compose.material3.MaterialTheme.typography.bodyLarge, color = Color.White)
                            Box(modifier = Modifier
                                .width(120.dp)
                                .padding(horizontal = 20.dp)){
                                Text(text = coin.name.trim(), style =  androidx.compose.material3.MaterialTheme.typography.bodySmall, color = Color.White, fontWeight = FontWeight.Light)
                            }
                            Spacer(modifier = Modifier
                                .width(40.dp)
                                .background(color = Color.White))
                            Text(text = "$ " + coin.currentPrice.toString().substring(0, 3), color = Color.White)
                            Text(text = if(coin.marketCapChange24Percentage > 0) "+" + coin.marketCapChange24Percentage.toString().substring(0, 4) + "%" else coin.marketCapChange24Percentage.toString().substring(0, 5) + "%", color = if(coin.marketCapChange24Percentage < 0) Color.Red else Color.Green, modifier = Modifier.padding(horizontal = 20.dp))
                        }
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(0.5.dp)
                            .background(color = colorResource(id = R.color.purple_protest))) {
                            
                        }
                    }
                    
                }
            }
        }
    }
}