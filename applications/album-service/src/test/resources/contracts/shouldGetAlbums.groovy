package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/albums'
        headers {
            header('content-type', 'application/json')
        }
    }
    response {
        status 200
        body("""
  [{"id":1,"artist":"Massive Attack","title":"Mezzanine","year":1998,"rating":9},{"id":2,"artist":"Radiohead","title":"OK Computer","year":1997,"rating":8}]
  """)
        headers {
            header('content-type': 'application/json;charset=UTF-8')
        }
    }
}