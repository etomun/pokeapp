<h1 align="center">PokeApp</h1>

## Tech stack & Open-source libraries
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based
- JetPack
  - Lifecycle - dispose of observing data when lifecycle state changes.
  - Room Persistence - construct a database using the abstract layer.
- Architecture
  - MVP Architecture
  - Repository pattern
- [Dagger](https://github.com/google/dagger) - A robust Dependency Inversion
- [RxAndroid](https://github.com/ReactiveX/RxAndroid) - Rich thread management
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs data
- [Gson](https://github.com/google/gson) - Json Converter
- [Glide](https://github.com/bumptech/glide), loading images.
- [Timber](https://github.com/JakeWharton/timber) - logging.
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components like ripple animation, cardView.

## Open API

<img src="https://user-images.githubusercontent.com/24237865/83422649-d1b1d980-a464-11ea-8c91-a24fdf89cd6b.png" align="right" width="21%"/>

PokeApp using the [PokeAPI](https://pokeapi.co/) for constructing RESTful API.<br>
PokeAPI provides a RESTful API interface to highly detailed objects built from thousands of lines of data related to Pokémon.