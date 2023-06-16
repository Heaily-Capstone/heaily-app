package capstone.bangkit.heailyapp.ui.components
//
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.BottomNavigationItem
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.List
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.navigation.NavGraph.Companion.findStartDestination
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.currentBackStackEntryAsState
//import capstone.bangkit.heailyapp.R
//import capstone.bangkit.heailyapp.ui.navigation.NavigationItem
//import capstone.bangkit.heailyapp.ui.navigation.Screen
//
//@Composable
//fun BottomBar(
//    navController: NavHostController,
//    modifier: Modifier = Modifier
//) {
//    BottomNavigation(
//        modifier = modifier
//    ) {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//        val navigationItems = listOf(
//            NavigationItem(
//                title = "Home",
//                icon = Icons.Default.Home,
//                screen = Screen.Home,
//                contentDescription = "Home"
//            ),
//            NavigationItem(
//                title = "Meal Plan",
//                icon = Icons.Default.Menu,
//                screen = Screen.LandingMeal,
//                contentDescription = "Meal Plan"
//            ),
//            NavigationItem(
//                title = "Growth",
//                icon = Icons.Default.List,
//                screen = Screen.Tumbuh,
//                contentDescription = "Growth"
//            ),
//            NavigationItem(
//                title = "Profile",
//                icon = Icons.Default.Person,
//                screen = Screen.Profile,
//                contentDescription = "Profile"
//            ),
//        )
//        BottomNavigation {
//            navigationItems.map { item ->
//                BottomNavigationItem(
//                    icon = {
//                        Icon(
//                            imageVector = item.icon,
//                            contentDescription = item.contentDescription
//                        )
//                    },
//                    label = { Text(item.title) },
//                    selected = currentRoute == item.screen.route,
//                    onClick = {
//                        navController.navigate(item.screen.route) {
//                            popUpTo(navController.graph.findStartDestination().id) {
//                                saveState = true
//                            }
//                            restoreState = true
//                            launchSingleTop = true
//                        }
//                    }
//                )
//            }
//        }
//    }
//}