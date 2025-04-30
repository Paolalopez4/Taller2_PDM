package com.pdmtaller2.PaolaLopez_00167523.ui.navigation

import android.widget.Toast
import com.pdmtaller2.PaolaLopez_00167523.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pdmtaller2.PaolaLopez_00167523.data.DummyData
import com.pdmtaller2.PaolaLopez_00167523.data.Restaurant

object ScreenRoutes {
    val home = "home"
    val menu = "menu"
    val search = "search"
    val orders = "orders"
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = ScreenRoutes.home) {
        composable(ScreenRoutes.home) { ScreenPrincipal(navController) }
        composable("${ScreenRoutes.menu}/{restaurantId}",
            arguments = listOf(navArgument("restaurantId") { type = NavType.IntType })
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: -1
            PantallaConMenus(navController, restaurantId)
        }
        composable(ScreenRoutes.search) { Busqueda(navController) }
        composable(ScreenRoutes.orders) { Pedidos(navController) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPrincipal (navController: NavHostController) {
    val groupedRestaurants = DummyData.restaurants
        .flatMap { restaurant -> restaurant.categories.map { it to restaurant } }
        .groupBy({ it.first }, { it.second })

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Restaurantes") })
        },
        bottomBar = { BottomNav(navController) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            groupedRestaurants.forEach { (category, restaurants) ->
                item {
                    Column {
                        Text(
                            text = category,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(16.dp)

                        )
                        LazyRow(
                            modifier = Modifier.padding(start = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            items(restaurants.distinctBy { it.id }) { restaurant ->
                                CardRestaurants(restaurant = restaurant,
                                    onClick = { navController.navigate("${ScreenRoutes.menu}/${restaurant.id}") } )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CardRestaurants (restaurant: Restaurant, onClick: () -> Unit) {
    Card(
        modifier = Modifier.padding(8.dp).clickable { onClick() }, colors = CardDefaults.cardColors(containerColor = Color(0xFFC57A30))
    ) {
        Column {
            Image(
                painter = painterResource(id = restaurant.imageResId),
                contentDescription = restaurant.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = restaurant.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaConMenus (navController: NavHostController, restaurantId: Int) {
    val context = LocalContext.current
    val restaurant = DummyData.restaurants.find { it.id == restaurantId }

    var searchQuery = remember { mutableStateOf("") }

    if (restaurant == null) {
        Text(text = "Restaurante no encontrado", modifier = Modifier.padding(16.dp))
        return
    }

    val filteredMenu = restaurant.menu.filter {
        it.name.contains(searchQuery.value, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(restaurant.name) })
        },
        bottomBar = { BottomNav(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            OutlinedTextField(
                value = searchQuery.value,
                onValueChange = { searchQuery.value = it },
                label = { Text("Buscar en el menú") },
                modifier = Modifier.padding(16.dp).fillMaxWidth()

            )
            Spacer(modifier = Modifier.padding(8.dp))

            if (filteredMenu.isEmpty()) {
                Text(
                    text = "No se encontraron platillos",
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(filteredMenu) { dish ->
                        Card(
                            modifier = Modifier.fillMaxWidth().padding(16.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFFC57A30))
                        )
                        {
                            Row(
                                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            )
                            {
                                Image(
                                    painter = painterResource(id = dish.imageResId),
                                    contentDescription = dish.name,
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(text = dish.name, style = MaterialTheme.typography.titleMedium)
                                    Text(text = dish.description, style = MaterialTheme.typography.bodyMedium)
                                    Button(onClick = {
                                        Toast.makeText(
                                            context,
                                            "${dish.name} agregado al carrito",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA05B18
                                    ))) {
                                        Text(text = "Agregar al carrito")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Busqueda(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Busquedas") })
        },
        bottomBar = { BottomNav(navController) }
    ) {
            innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            Text(text = "Pantalla de busquedas")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pedidos(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Ordenes") }, )
        },
        bottomBar = { BottomNav(navController) }
    ) {
        innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            Text(text = "Pantalla de ordenes")
        }
    }
}

@Composable
fun BottomNav(navController: NavController) {
    val items = listOf(
        ScreenRoutes.home to "Restaurantes",
        ScreenRoutes.search to "Busqueda",
        ScreenRoutes.orders to "Ordenes",
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        items.forEach { (route, label) ->
            NavigationBarItem(
                selected = currentRoute == route,
                onClick = {
                    if (currentRoute != route) {
                        navController.navigate(route) {
                            popUpTo(ScreenRoutes.home) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                },
                label = { Text(label) },
                icon = {  }
            )
        }
    }
}