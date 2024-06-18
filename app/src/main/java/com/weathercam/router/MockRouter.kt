package com.weathercam.router

class MockRouter: Router {
    override fun navigateTo(route: Routes) {
        println("navegar a : ${ route.id }" )
    }
}