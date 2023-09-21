package com.casey.restweborch.test

import com.casey.restweborch.utils.ApiUtil
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import com.casey.restweborch.stubs.singleDateEndpointStubs.Companion.returnSingleDataStub

class GetSingleEndpointTest : ApiUtil() {

    @Test
    fun single_data_endpoint_returns_200() {
        returnSingleDataStub()
        given()
            .header("Correlation-Id", "6c688931-b2c9-4227-952e-af91ff6eb423")
            .get("http://localhost:8080/web-flux-orch-template/data/single/1")
            .then().statusCode(200)
    }

}