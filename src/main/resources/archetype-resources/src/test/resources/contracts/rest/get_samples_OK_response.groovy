package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""
Represents a successful scenario of get samples list

```
given:
	/api/v1/samples endpoint
when:
	make GET request
then:
	we'll get list of samples
```

""")
    request {
        method('GET')
        url( "/api/v1/samples" )
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
                [
                        id        : $(c(1), p(regex(number()))),
                        value     : $(c("sampleValue1"), p(regex(ANY_STRING)))
                ], [
                        id        : $(c(2), p(regex(number()))),
                        value     : $(c("sampleValue2"), p(regex(ANY_STRING)))
                ]
        ])
        bodyMatchers {
            jsonPath('$', byType {
                minOccurrence(1)
            })
        }
    }
}
