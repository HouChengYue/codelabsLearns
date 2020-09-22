/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding

/**
 * 7.总结
安全Args：

当您将数据从一个Fragment传递到另一个Fragment时，为了帮助捕获因缺少键或类型不匹配而导致的错误，请使用名为Safe Args的Gradle插件。
对于您应用中的每个Fragment，Safe Args插件都会生成一个相应的NavDirection类。您将该NavDirection类添加到Fragment代码中，然后使用该类在Fragment和其他片段之间传递参数。
这些NavDirection类表示所有应用程序操作的导航。
隐式意图：

一个隐含的意图声明，您的应用程序要一些其他的应用程序（如相机应用或电子邮件应用）代表其执行的操作。
如果多个Android应用程序可以处理隐式意图，则Android向用户显示一个选择器。例如，当用户点击AndroidTrivia应用程序中的共享图标时，用户可以选择他们要使用哪个应用程序共享游戏结果。
要构建意图，您可以声明要执行的动作，例如ACTION_SEND。
有几个Intent()构造函数可用来帮助您建立意图。
共享功能：

与朋友分享您的成功时，应Intent采取的行动是Intent.ACTION_SEND.
要将选项菜单添加到片段，请在片段代码中将setHasOptionsMenu()方法设置为true。
在“片段”代码中，重写onCreateOptionsMenu()方法以使菜单膨胀。
重写onOptionsItemSelected()使用startActivity()发送Intent到可以处理其他应用程序。
当用户点击菜单项时，将触发该意图，并且用户会看到该SEND操作的选择器。
 * https://codelabs.developers.google.com/codelabs/kotlin-android-training-start-external-activity/index.html#6
 * navigation 学习项目 需翻墙
 */
class MainActivity : AppCompatActivity() {
    /**
     * 抽屉布局
     */
    private lateinit var draerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        draerLayout = binding.drawerLayout
        NavigationUI.setupActionBarWithNavController(this, navController, draerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, draerLayout)
    }
    // TODO (01) Create the new TitleFragment
    // Select File->New->Fragment->Fragment (Blank)

    // TODO (02) Clean up the new TitleFragment
    // In our new TitleFragment

    // TODO (03) Use DataBindingUtil.inflate to inflate and return the titleFragment in onCreateView
    // In our new TitleFragment
    // R.layout.fragment_title
}
