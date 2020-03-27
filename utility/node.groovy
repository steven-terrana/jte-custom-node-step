void call(Closure body){
    def bodyLibConfig = body.getOwner().config

    def nodeLabel = bodyLibConfig.label ?: config.label ?: "" 
    println "would use node label: ${nodeLabel}"
    steps.node{
        body()
    }
}