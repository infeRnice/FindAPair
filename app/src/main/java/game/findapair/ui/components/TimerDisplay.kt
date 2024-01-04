package game.findapair.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import game.findapair.R
import kotlinx.coroutines.delay

@Composable
fun TimerDisplay(timerState: MutableState<Int>) {
    LaunchedEffect(timerState.value) {
        while (timerState.value > 0) {
            delay(1000)
            timerState.value -= 1
        }
    }
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color.LightGray, shape = RoundedCornerShape(9.dp))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.timer),
                        contentDescription = "Timer Icon",
                        modifier = Modifier

                            .size(22.dp),

                        )

                    Text(
                        text = String.format("%02d:%02d", timerState.value / 60, timerState.value % 60),
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
        Text(
            text = "! less time, more reward",
            modifier = Modifier.padding(top = 1.dp),
            style = TextStyle(fontSize = 10.sp)
        )
    }
}