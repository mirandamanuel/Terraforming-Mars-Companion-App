package com.example.tmcompanion

import android.graphics.Color
import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color as RGBColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tmcompanion.ui.theme.TerraformingMarsCompanionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerraformingMarsCompanionAppTheme {
                var creditsProd = 0
                var steelProd = 0
                var titaniumProd = 0
                var plantsProd = 0
                var energyProd = 0
                var heatProd = 0
                Column(modifier = Modifier
                    .background(RGBColor(101, 20, 0))
                    .padding(16.dp)
                    .background(RGBColor.LightGray)
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier) {
                        //Credits
                        Column(modifier = Modifier) {
                            ResourceTile(name = "Credits", icon = Icons.Default.ShoppingCart)
                            ProductionRow(resource = "Credits", currentVal = creditsProd)
                        }
                        //Steel
                        Column(modifier = Modifier) {
                            ResourceTile(name = "Steel", icon = Icons.Default.ShoppingCart)
                            ProductionRow(resource = "Steel", currentVal = steelProd)
                        }
                    }
                    Row(modifier = Modifier) {
                        //Titanium
                        Column(modifier = Modifier) {
                            ResourceTile(name = "Titanium", icon = Icons.Default.ShoppingCart)
                            ProductionRow(resource = "Titanium", currentVal = titaniumProd)
                        }
                        //Plants
                        Column(modifier = Modifier) {
                            ResourceTile(name = "Plants", icon = Icons.Default.ShoppingCart)
                            ProductionRow(resource = "Plants", currentVal = plantsProd)
                        }
                    }
                    Row(modifier = Modifier) {
                        //Energy
                        Column(modifier = Modifier) {
                            ResourceTile(name = "Energy", icon = Icons.Default.ShoppingCart)
                            ProductionRow(resource = "Energy", currentVal = energyProd)
                        }
                        //Heat
                        Column(modifier = Modifier) {
                            ResourceTile(name = "Heat", icon = Icons.Default.ShoppingCart)
                            ProductionRow(resource = "Heat", currentVal = heatProd)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ResourceTile(name: String, icon: ImageVector){
    Icon(imageVector = icon ,
        contentDescription = name ,
        modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp))
}
@Composable
fun ProductionRow(resource: String, currentVal: Int){
    Row{
        Icon(imageVector = Icons.Default.ArrowBack ,
            contentDescription = null)
        Text(text = currentVal.toString())
        Icon(imageVector = Icons.Default.ArrowForward ,
            contentDescription = null)
    }
}
