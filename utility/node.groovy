void call(Closure body){

    println body
    println body.getOwner()
    println body.getDelegate() 

    def bodyLibConfig = null 

    def nodeLabel = bodyLibConfig.label ?: config.label ?: "" 
    println "would use node label: ${nodeLabel}"
    steps.node{
        body()
    }
}