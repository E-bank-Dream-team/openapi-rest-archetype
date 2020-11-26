package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""
		Represents a successful scenario of get one sample
		
		```
		given:
		/api/v1/samples/{sampleID} endpoint
		when:
		make GET request
		then:
		we'll get given sample
		```
		
		""")
    request {
        method('GET')
        url $(p("api/v1/samples/1"), c(regex('api/v1/samples/[0-9]+')))
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        def ANY_STRING = '.+'
        body([
                id         : fromRequest().path(3),
                value      : "sampleValue"
        ])
        bodyMatchers {
            jsonPath('id', byRegex(number()).asInteger())
            jsonPath('value', byRegex(ANY_STRING).asString())
        }
    }
}
