package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Top App Bar", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { /* handle navigation click */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { /* handle search click */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
                    }
                    IconButton(onClick = { /* handle more click */ }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "More", tint = Color.White)
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF6200EE)
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF6200EE),
                contentColor = Color.White
            ) {
                IconButton(onClick = { /* handle home click */ }) {
                    Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.White)
                }
                Spacer(modifier = Modifier.weight(1f, true))
                IconButton(onClick = { /* handle profile click */ }) {
                    Icon(Icons.Filled.Person, contentDescription = "Profile", tint = Color.White)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* handle add click */ }) {
                Icon(Icons.Filled.Add, contentDescription = "Add", tint = Color.White)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(50) {
                Text(" item não funcional #$it", fontSize = 20.sp, color = Color.Black)
            }
        }
    }
}


