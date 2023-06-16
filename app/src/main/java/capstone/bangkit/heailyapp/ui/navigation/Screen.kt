package capstone.bangkit.heailyapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object SignIn : Screen("signIn")
    object Profile :Screen("profile")
    object SignUp : Screen("signUp")
    object LandingMeal : Screen("landingMeal")
    object GeneratedMeal : Screen("generatedMeal")
    object DetailMeal : Screen("meal/{mealId}") {
        fun createRoute(mealId: Int) = "home/$mealId"
    }
    object Tumbuh : Screen("tumbuh")
    object Nochild : Screen("noChild")
    object AddGrowthData : Screen("addGrowthData/{childId}"){
        fun createRoute(childId: Int) = "addGrowthData/$childId"
    }
}