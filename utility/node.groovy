void call(Closure body){

    def bodyConfig = [:]
    try{
        bodyConfig = body.config
    }catch(MissingPropertyException ex){
        /*
          config not defined
          this probably means a node block called from the template itself
          as opposed to from within a library step
        */
    }

    def nodeLabel = bodyConfig.label ?: config.label ?: "" 
    println "would use node label: ${nodeLabel}"
    steps.node{
        body()
    }
}