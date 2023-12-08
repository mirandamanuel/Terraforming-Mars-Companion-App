package com.example.tmcompanion

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.tmcompanion.ui.theme.TerraformingMarsCompanionAppTheme
import androidx.compose.ui.graphics.Color as RGBColor

val credits = Resource(0 ,0)
val steel = Resource(0 ,0)
val titanium = Resource(0 ,0)
val plants = Resource(0 ,0)
val energy = Resource(0 ,0)
val heat = Resource(0 ,0)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerraformingMarsCompanionAppTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController){
    val state = remember { mutableStateOf(false) }
    key(state.value){
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

                    ProductionRow(credits)
                }
                //Steel
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    ResourceTile(name = "Steel",
                        icon = ImageVector.vectorResource(R.drawable.steel_icon))
                    ProductionRow(steel)
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
                    ProductionRow(titanium)
                }
                //Plants
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    ResourceTile(name = "Plants",
                        icon = ImageVector.vectorResource(R.drawable.plants_icon))
                    ProductionRow(plants)
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
                    ProductionRow(energy)
                }
                //Heat
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    ResourceTile(name = "Heat",
                        icon = ImageVector.vectorResource(R.drawable.heat_icon))
                    ProductionRow(heat)
                }
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly){
                //Add resources button
                Button(modifier = Modifier.padding(8.dp), onClick = {
                    navController.navigate(Screen.AddResourcesScreen.route)}) {
                    Text(text = "Add Resources")
                }

                //Spend resources button
                Button(modifier = Modifier.padding(8.dp), onClick = { /*TODO*/ }) {
                    Text(text = "Spend Resources")
                }
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(modifier = Modifier.padding(8.dp), onClick = {/*TODO*/}) {
                    Text(text = "End Turn")
                }

                //End round button: Automates end of round actions
                Button(modifier = Modifier.padding(8.dp), onClick = {
                    roundEndResourcePayout()
                    state.value = !state.value
                }){
                    Text(text = "End Round")
                }
            }
        }
    }

}

@Composable
fun AddResourcesScreen() {
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

                ProductionRow(credits)
            }
            //Steel
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                ResourceTile(name = "Steel",
                    icon = ImageVector.vectorResource(R.drawable.steel_icon))
                ProductionRow(steel)
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
                ProductionRow(titanium)
            }
            //Plants
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                ResourceTile(name = "Plants",
                    icon = ImageVector.vectorResource(R.drawable.plants_icon))
                ProductionRow(plants)
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
                ProductionRow(energy)
            }
            //Heat
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                ResourceTile(name = "Heat",
                    icon = ImageVector.vectorResource(R.drawable.heat_icon))
                ProductionRow(heat)
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
fun ResourceQuantity(modifier: Modifier = Modifier, resource: Resource){
    Box(modifier = modifier){
        Text(text = resource.getValue().toString())
    }
}

@Composable
fun ResourceProduction(modifier: Modifier = Modifier, resource: Resource){
    Box(modifier = modifier){
        var text = "(+${resource.getProduction()})"
        var textColor = RGBColor(0, 150, 0)
        if(resource.getProduction() < 0){
            textColor = RGBColor(200, 0, 0)
            text = "(${resource.getProduction()})"
        }
        Text(text = text,
            color = textColor)
    }
}

@Composable
fun ProductionRow(resource: Resource){
    val i = remember { mutableStateOf(0) }
    key(i.value){
        Row{
            IconButton(onClick = {
                resource.setProduction(resource.getProduction() - 1)
                println(resource.getProduction())
                i.value = resource.getProduction()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack ,
                    contentDescription = null)
            }
            ResourceQuantity(resource = resource,
                modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp))

            ResourceProduction(resource = resource,
                modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp))

            IconButton(onClick = {
                resource.setProduction(resource.getProduction() + 1)
                println(resource.getProduction())
                i.value = resource.getProduction()
            }) {
                Icon(imageVector = Icons.Default.ArrowForward ,
                    contentDescription = null)
            }
        }
    }
}

fun roundEndResourcePayout(){
    credits.setValue(credits.getValue() + credits.getProduction())
    steel.setValue(steel.getValue() + steel.getProduction())
    titanium.setValue(titanium.getValue() + titanium.getProduction())
    plants.setValue(plants.getValue() + plants.getProduction())
    energy.setValue(energy.getValue() + energy.getProduction())
    heat.setValue(heat.getValue() + heat.getProduction())
}
