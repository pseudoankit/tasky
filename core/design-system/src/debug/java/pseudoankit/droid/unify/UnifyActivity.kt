package pseudoankit.droid.unify

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pseudoankit.droid.unify.componentsdemo.UnifyImageDemo

fun Context.navigateToUnifyDemo() {
    Intent(this, UnifyActivity::class.java).apply {
        startActivity(this)
    }
}

class UnifyActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    UnifyImageDemo()
                    Divider()
                }
            }
        }
    }
}