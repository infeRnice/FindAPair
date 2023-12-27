package game.findapair.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import game.findapair.presentation.navigation.AppNavigation
import game.findapair.ui.theme.FindAPairTheme

class MainActivity : ComponentActivity() {

    private val vmFactory: ViewModelFactory by lazy {
        ViewModelFactory()
    }
    private val vm: FindAPairViewModel by lazy {
        ViewModelProvider(this, vmFactory).get(FindAPairViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FindAPairTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}