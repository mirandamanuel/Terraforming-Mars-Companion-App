package com.example.tmcompanion

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.tmcompanion.ui.theme.TerraformingMarsCompanionAppTheme
import androidx.compose.ui.graphics.Color as RGBColor


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
                    .fillMaxSize() ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    //Row 1
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        //Credits
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            ResourceTile(name = "Credits",
                                icon = ImageVector.vectorResource(R.drawable.credit_icon))
                            ProductionRow(resource = "Credits", currentVal = creditsProd)
                        }
                        //Steel
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            ResourceTile(name = "Steel",
                                icon = ImageVector.vectorResource(R.drawable.steel_icon))
                            ProductionRow(resource = "Steel", currentVal = steelProd)
                        }
                    }
                    //Row 2
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        //Titanium
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            ResourceTile(name = "Titanium",
                                icon = ImageVector.vectorResource(R.drawable.titanium_icon))
                            ProductionRow(resource = "Titanium", currentVal = titaniumProd)
                        }
                        //Plants
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            ResourceTile(name = "Plants",
                                icon = ImageVector.vectorResource(R.drawable.plants_icon))
                            ProductionRow(resource = "Plants", currentVal = plantsProd)
                        }
                    }
                    //Row 3
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        //Energy
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            ResourceTile(name = "Energy",
                                icon = ImageVector.vectorResource(R.drawable.energy_icon))
                            ProductionRow(resource = "Energy", currentVal = energyProd)
                        }
                        //Heat
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            ResourceTile(name = "Heat",
                                icon = ImageVector.vectorResource(R.drawable.heat_icon))
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
        modifier = Modifier
            .padding(16.dp, 16.dp, 16.dp, 0.dp)
            .size(150.dp) ,
        tint = Color.Unspecified)
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

fun getScreenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
}

fun getScreenHeight(): Int {
    return Resources.getSystem().displayMetrics.heightPixels
}
