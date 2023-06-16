package capstone.bangkit.heailyapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import capstone.bangkit.heailyapp.R
//import capstone.bangkit.heailyapp.ui.components.BottomBar
import capstone.bangkit.heailyapp.ui.navigation.NavigationItem
import capstone.bangkit.heailyapp.ui.navigation.Screen
import capstone.bangkit.heailyapp.ui.screens.growth.AddGrowthData
import capstone.bangkit.heailyapp.ui.screens.growth.Growth
import capstone.bangkit.heailyapp.ui.screens.home.Home
import capstone.bangkit.heailyapp.ui.screens.mealplan.LandingMealPlan
import capstone.bangkit.heailyapp.ui.screens.profile.Profile
import capstone.bangkit.heailyapp.ui.theme.HeailyAppTheme

@Composable
fun HeailyApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute !== Screen.SignUp.route
                || currentRoute !== Screen.SignIn.route) {
                BottomBar(navController)
            }
        },
        topBar = {
            if (currentRoute === Screen.GeneratedMeal.route || currentRoute === Screen.LandingMeal.route) {
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
                Home(
                    modifier = Modifier,
                    viewModel = viewModel(
                        factory = ViewModelFactory.getInstance(LocalContext.current)
                    ),
                    navigateToMeal = { navController.navigate(Screen.LandingMeal.route) }
                )
            }
            composable(Screen.LandingMeal.route){
                LandingMealPlan(
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
            composable(Screen.Tumbuh.route){
                Growth(
                    modifier = Modifier,
                    viewModel = viewModel(
                        factory = ViewModelFactory.getInstance(LocalContext.current)
                    ),
                    navigateToAddForm = {}
                )
            }
            composable(Screen.Profile.route){
                Profile()
            }
            composable(
                Screen.AddGrowthData.route,
                arguments = listOf(navArgument("childId") { type = NavType.IntType }),
            ){
                val id = it.arguments?.getInt("childId") ?: -1
                AddGrowthData(
                    childId = id,
                    modifier = Modifier,
                    viewModel = viewModel(
                        factory = ViewModelFactory.getInstance(LocalContext.current)
                    )) {
                }
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                icon = painterResource(id = R.drawable.baseline_home_24),
                screen = Screen.Home,
                contentDescription = ""
            ),
            NavigationItem(
                title = "Meal Plan",
                icon = painterResource(id = R.drawable.baseline_menu_book_24),
                screen = Screen.LandingMeal,
                contentDescription = ""
            ),
            NavigationItem(
                title = "Growth",
                icon = painterResource(id = R.drawable.baseline_table_chart_24),
                screen = Screen.Tumbuh,
                contentDescription = ""
            ),

            NavigationItem(
                title = "Profile",
                icon = painterResource(id = R.drawable.baseline_account_circle_24),
                screen = Screen.Profile,
                contentDescription = ""
            ),
        )
        navigationItems.map { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetHeroesAppPreview() {
    HeailyAppTheme {
        HeailyApp()
    }
}
