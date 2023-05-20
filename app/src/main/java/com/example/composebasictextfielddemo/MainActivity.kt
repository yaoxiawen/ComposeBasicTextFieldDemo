package com.example.composebasictextfielddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasictextfielddemo.ui.theme.ComposeBasicTextFieldDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTextFieldDemoTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    Spacer(modifier = Modifier.height(50.dp))
                    //普通使用方法
                    var text1 by remember {
                        mutableStateOf("")
                    }
                    BasicTextField(
                        value = text1,
                        onValueChange = {
                            if (it == text1) {
                                return@BasicTextField
                            }
                            text1 = it
                        },
                        modifier = Modifier
                            .padding(top = 30.dp, start = 30.dp)
                            .width(300.dp)
                    )
                    //输入起始默认内容后光标无法定位到最后位
                    Text(text = "点击输入起始默认内容age", modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                        .clickable {
                            val text = "age"
                            text1 = text
                        })

                    //使用TextFieldValue定位光标位置
                    var text2 by remember {
                        mutableStateOf("")
                    }
                    BasicTextField(
                        value = TextFieldValue(
                            text = text2,
                            selection = TextRange(text2.length),
                            composition = TextRange(0, text2.length)
                        ),
                        onValueChange = {
                            if (it.text == text2) {
                                return@BasicTextField
                            }
                            text2 = it.text
                        },
                        modifier = Modifier
                            .padding(top = 30.dp, start = 30.dp)
                            .width(300.dp)
                    )
                    Text(text = "点击输入起始默认内容age", modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                        .clickable {
                            val text = "age"
                            text2 = text
                        })

                    var text3 by remember {
                        mutableStateOf(TextFieldValue())
                    }
                    BasicTextField(
                        value = text3,
                        onValueChange = {
                            if (it.text == text3.text) {
                                return@BasicTextField
                            }
                            text3 = it
                        },
                        modifier = Modifier
                            .padding(top = 30.dp, start = 30.dp)
                            .width(300.dp)
                    )
                    Text(text = "点击输入起始默认内容age", modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                        .clickable {
                            val text = "age"
                            text3 = TextFieldValue(
                                text = text,
                                selection = TextRange(text.length),
                                composition = TextRange(0, text.length)
                            )
                        })
                }
            }
        }
    }
}