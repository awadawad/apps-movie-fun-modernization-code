package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/albums'
        body("""
    {
      "artist":"Massive Attack",
      "title":"Mezzanine",
      "year":1998,
      "rating":9
    }
    """)
        headers {
            header('Content-Type', 'application/json')
        }
    }
    response {
        status 201
    }
}