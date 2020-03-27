void call(Closure body){
    def bodyLibConfig.getOwner().getConfig() 

    def nodeLabel = bodyLibConfig.label ?: config.label ?: "" 
    println "would use node label: ${nodeLabel}"
    steps.node{
        body()
    }
}