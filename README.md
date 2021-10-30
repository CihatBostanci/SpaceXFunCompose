# SpaceXFunCompose
* [General info](#general-info)
* [Technologies](#technologies)
* [Structure](#structure)

## General info
This project is simple Android  SpaceX App to learn  Jetpack Compose  that is Android’s modern toolkit for building native UI and using [MVVM] recommended by Google with (https://developer.android.com/jetpack/guide)
and  Repository Pattern.

## Technology 
Try to use these technology [Coroutines](https://developer.android.com/kotlin/coroutines) and [Flow](https://developer.android.com/kotlin/flow), [Room](https://developer.android.com/training/data-storage/room), [hilt](https://developer.android.com/jetpack/compose/libraries) etc.

## Structure

While doing this app, I want to explain my tech stack in android development process.
* Firstly, This app created with [MVVM (Model-View-ViewModel) ](https://developer.android.com/jetpack/guide) that is recommended by Google and written on Kotlin Language 100%.
* While using MVVM, I chose [Single Activity] Structure with [Jetpack Compose](https://developer.android.com/jetpack/compose)
* Besides that, I used [hilt](https://developer.android.com/jetpack/compose/libraries) Dependency Injection Library works that provides SOLID principles and doing maintainable test easily.
* While doing database operation, I used [Coroutines](https://developer.android.com/kotlin/coroutines) and [Flow](https://developer.android.com/kotlin/flow) to handle. It can easily lifecycle aware and lightweight thread system to deal with Input Output operations with IO Thread and streaming data management with flow. Thus Main thread may not overload.
* For the UI, the Material Library used in this project as possible and use some Compose Animations and Transitions.
* For the local data provider, I used [Room](https://developer.android.com/training/data-storage/room) SQLite DataBase and SharedPreferences.
* Business Operation are in the following; Users can shows rockets and its detail, select/unselect favorite if users like.
* Trying to use Kotlin Lint and Android name conventions.
