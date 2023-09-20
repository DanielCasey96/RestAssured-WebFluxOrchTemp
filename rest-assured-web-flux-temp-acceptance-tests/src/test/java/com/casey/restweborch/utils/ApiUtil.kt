package com.casey.restweborch.utils

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class ApiUtil {

    private val wireMockServer = WireMockServer(WireMockConfiguration.options().port(9090))


    @BeforeAll
    fun startWiremock() {
        wireMockServer.start()
    }

    @AfterAll
    fun stopWiremock() {
        if (wireMockServer.isRunning) {
            wireMockServer.stop()
        }
    }
}