package com.example.tmcompanion

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
    var creditsProd = 0
    var steelProd = 0
    var titaniumProd = 0
    var plantsProd = 0
    var energyProd = 0
    var heatProd = 0

    var credits = 0
    var steel = 0
    var titanium = 0
    var plants = 0
    var energy = 0
    var heat = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerraformingMarsCompanionAppTheme {
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
                            ProductionRow(credits, creditsProd)
                        }
                        //Steel
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            ResourceTile(name = "Steel",
                                icon = ImageVector.vectorResource(R.drawable.steel_icon))
                            ProductionRow(steel, steelProd)
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
                            ProductionRow(titanium, titaniumProd)
                        }
                        //Plants
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            ResourceTile(name = "Plants",
                                icon = ImageVector.vectorResource(R.drawable.plants_icon))
                            ProductionRow(plants, plantsProd)
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
                            ProductionRow(energy, energyProd)
                        }
                        //Heat
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            ResourceTile(name = "Heat",
                                icon = ImageVector.vectorResource(R.drawable.heat_icon))
                            ProductionRow(heat, heatProd)
                        }
                    }

                    Row(horizontalArrangement = Arrangement.SpaceEvenly){
                        //Add resources button
                        Button(modifier = Modifier.padding(8.dp), onClick = { /*TODO*/ }) {
                            Text(text = "Add Resources")
                        }

                        //Spend resources button
                        Button(modifier = Modifier.padding(8.dp), onClick = { /*TODO*/ }) {
                            Text(text = "Spend Resources")
                        }
                    }

                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        Button(modifier = Modifier.padding(8.dp), onClick = { /*TODO*/ }) {
                            Text(text = "End Turn")
                        }

                        //End round button: Automates end of round actions
                        Button(modifier = Modifier.padding(8.dp), onClick = { /*TODO*/ }) {
                            Text(text = "End Round")
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
            .size(125.dp) ,
        tint = Color.Unspecified)
}
@Composable
fun ProductionRow(resource: Int, resourceProd: Int){
    Row{
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.ArrowBack ,
                contentDescription = null)
        }

        Text(modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp), text = resource.toString())

        Text(modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
            color = RGBColor(0, 150, 0),
            text = " (+$resourceProd)")


        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.ArrowForward ,
                contentDescription = null)
        }
    }
}

fun getScreenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
}

fun getScreenHeight(): Int {
    return Resources.getSystem().displayMetrics.heightPixels
}
