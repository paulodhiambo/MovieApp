<<<<<<< HEAD
## \[ 🚧 In progress 👷‍♀️⛏🚧 \] Movie App [![CircleCI](https://circleci.com/gh/paulodhiambo/MovieApp.svg?style=shield&circle-token=f5a71b5b89e284cde350f25ccc86d33bb370bd50)](https://circleci.com/gh/paulodhiambo/MovieApp)  [![Codacy Badge](https://api.codacy.com/project/badge/Grade/2baae276a8e24d938edb9ea8f1df0960)](https://app.codacy.com/manual/paulodhiambo/MovieApp?utm_source=github.com&utm_medium=referral&utm_content=paulodhiambo/MovieApp&utm_campaign=Badge_Grade_Dashboard)
=======
## \[ 🚧 Work in progress 👷‍♀️⛏👷🔧️🚧 \] Movie App [![CircleCI](https://circleci.com/gh/paulodhiambo/MovieApp.svg?style=shield&circle-token=f5a71b5b89e284cde350f25ccc86d33bb370bd50)](https://circleci.com/gh/paulodhiambo/MovieApp)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2baae276a8e24d938edb9ea8f1df0960)](https://app.codacy.com/manual/paulodhiambo/MovieApp?utm_source=github.com&utm_medium=referral&utm_content=paulodhiambo/MovieApp&utm_campaign=Badge_Grade_Dashboard)
>>>>>>> ea40b1b2f192a5f8a739e9b136628779d7730afa

A simple android app that shows your favorite movies. In this solution, the following needs to be demonstrated 

 ## Project characteristics

This project brings to table set of best practices, tools, and solutions:

* Kotlin
* Model-View-View Model Architecture
* Android Jetpack
* Testing
* Dependency Injection
* Material design
 

 ## Tech-stack
 
This project takes advantage of many popular libraries and tools of the Android ecosystem. Most of the libraries are in the stable version.
 
 * Tech-stack
     * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform database queries operations.
     * [Rxjava2](https://github.com/ReactiveX/RxJava) - perform network calls.
     * [Glide](https://github.com/bumptech/glide) - Image loading and caching.
     * [Dagger 2](https://dagger.dev/) - dependency injection
     * [Room Database](https://developer.android.com/training/data-storage/room) - an abstraction layer over SQLite to allow fluent database access.
     * [Jetpack](https://developer.android.com/jetpack)
         * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
         * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform action when lifecycle state changes
         * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
     * [Stetho](http://facebook.github.io/stetho/) - application debugging tool - available on debug build only!!!
 
 * Architecture
     * MVVM - application level
     * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) plugin)
 * Tests
     * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/))
 
 ## Getting started
 
 There are a few ways to open this project.
 
 ### Android Studio
 
 1. Android Studio -> File -> New -> From Version control -> Git
 2. Enter `https://github.com/paulodhiambo/MovieApp.git` into URL field
 
 ### Command line + Android Studio
 
 1. Run `git clone https://github.com/paulodhiambo/MovieApp.git`
 2. Android Studio -> File -> Open
 
 ## License
 ```
 MIT License
 
 Copyright (c) 2020 Paul Odhiambo
 
 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
 associated documentation files (the "Software"), to deal in the Software without restriction, including 
 without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to 
 the following conditions:
 
 The above copyright notice and this permission notice shall be included in all copies or substantial 
 portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN 
 NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 WHETHER IN AN ACTION OF  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ```