# Mi Proyecto Weather App

[![Logo WeatherCam](https://github.com/MathieuClaudio/WeatherCam/blob/main/logo.png)](https://github.com/MathieuClaudio/WeatherCam.git)

[![Print Search](https://github.com/MathieuClaudio/WeatherCam/blob/main/print_search_v1.png)](https://github.com/MathieuClaudio/WeatherCam.git)
[![Print Weather](https://github.com/MathieuClaudio/WeatherCam/blob/main/print_weather.png)](https://github.com/MathieuClaudio/WeatherCam.git)

## Instalación
```bash
## Clonar el repositorio usando `git clone`
git clone https://github.com/MathieuClaudio/WeatherCam.git


## Abrir en Android Studio

```

## Tareas realizadas
- [x] Cree un repositorio público en Github: https://github.com/MathieuClaudio/WeatherCam.git
- [x] Inicie la aplicación android con los elementos básicos.
- [x] Agregué un gif loading al buscar y al mostrar el clima.
- [x] Agregué un objeto Locale de Java para obtener el nombre completo del país en lugar de su código ISO.
- [x] Agregué la humedad y un Log en RepositoryApi para checar valores por el Logcat.
- [] Intenté guardar la configuración del ApiKey en el local.properties pero fallé con rotundo éxito.


Estructura:
- com.weathercam
  - cities
    - CityIntention
    - CityPage.kt
    - CityState
    - CityView.kt
    - CityViewModel.kt
  - weather
    - WeatherIntention.kt
    - WeatherPage.kt
    - WeatherState
    - WeatherView.kt
    - WeatherViewModel.kt
- repository
  - model
    - CityData
    - WeatherData.kt
  - IRepository
  - RepositoryApi
  - RepositoryMock
- router
  - MockRouter
  - NavigationRoutes.kt
  - Router
  - Routes
- ui.theme
- MainActivity
- MainApp.kt

### Requerimientos y funcionalidades solicitadas:
- [x] Tener un buscador de ciudades
- [x] Seleccionar distintas ciudades
- [x] Mostrar el pronóstico clima
- [x] Mostrar temperatura, humedad, estado del clima, etc.
- [] Mostrar el pronóstico de los próximos 7 días
- [] Encontrar la ciudad donde te ubicas usando la geolocalización
- [] Poder compartir el pronóstico seleccionado a otra persona
- [] Guardar la configuración del usuario




