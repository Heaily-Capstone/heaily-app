package capstone.bangkit.heailyapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import capstone.bangkit.heailyapp.ui.components.BottomBar
import capstone.bangkit.heailyapp.ui.navigation.Screen
import capstone.bangkit.heailyapp.ui.screens.home.Home

@Composable
fun HeailyApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute !== Screen.AddChild.route || currentRoute !== Screen.SignUp.route
                || currentRoute !== Screen.SignIn.route) {
                BottomBar(navController)
            }
        },
        topBar = {
            if (currentRoute === Screen.GeneratedMeal.route || currentRoute === Screen.LandingMeal.route
                || currentRoute !== Screen.AddChild.route) {
                TopAppBar(
                    title = { Text("Heaily App") },
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                Home(modifier = Modifier)
            }
        }

        }
}

