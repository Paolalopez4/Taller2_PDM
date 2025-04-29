package com.pdmtaller2.PaolaLopez_00167523.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        composable(ScreenRoutes.home) { HomeScreen(navController) }
        composable(ScreenRoutes.menu) { MenuScreen(navController) }
        composable(ScreenRoutes.search) { SearchScreen(navController) }
        composable(ScreenRoutes.orders) { OrdersScreen(navController) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val groupedRestaurants = DummyData.restaurants
        .flatMap { restaurant -> restaurant.categories.map { it to restaurant } }
        .groupBy({ it.first }, { it.second })

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Restaurantes") })
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            groupedRestaurants.forEach { (category, restaurants) ->
                item {
                    Text(text = category,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(16.dp)

                    )
                }

                item {
                    LazyRow (horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(restaurants.distinctBy { it.id }.size) { index ->
                            val restaurant = restaurants.distinctBy { it.id }[index]
                            RestaurantCard(restaurant = restaurant) {
                                navController.navigate(ScreenRoutes.menu)
                            }
                        }
                    }
                }
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant, onClick: () -> Unit) {
    Card(
        modifier = Modifier.padding(8.dp).clickable { onClick() },
    ) {
        Column {
            Text(text = restaurant.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun MenuScreen(navController: NavHostController, restaurantId: Int) {
    val context = LocalContext.current
    val restaurant = DummyData.restaurants.find { it.id == restaurantId }

    val searchQuery = remember { mutableStateOf("") }

    if (restaurant == null) {
        Text(text = "Restaurante no encontrado", modifier = Modifier.padding(16.dp))
        return
    }

    val filteredMenu = restaurant.menu.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

}

@Composable
fun SearchScreen(navController: NavHostController) {

}

@Composable
fun OrdersScreen(navController: NavHostController) {

}
