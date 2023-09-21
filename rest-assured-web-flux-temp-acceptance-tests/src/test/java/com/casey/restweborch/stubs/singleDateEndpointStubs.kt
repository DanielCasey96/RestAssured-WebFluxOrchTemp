package com.casey.restweborch.stubs

import com.casey.restweborch.utils.ApiUtil.Companion.wireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*

open class singleDateEndpointStubs {

companion object {
    fun returnSingleDataStub() {
        wireMockServer.stubFor(
            get(urlEqualTo("/rest-assured-template/service/data/single/1"))
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Accept", "application/json")
                    .withBody("Value Test"))
        )
    }
}
}