void call(Closure body){
    println body.getOwner() 
    steps.node(config.label ?: ""){
        body()
    }
}