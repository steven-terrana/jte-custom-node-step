void call(Closure body){
    println body.getOwner() 

    def nodeLabel = config.label ?: "" 
    println "would use node label: ${nodeLabel}"
    steps.node{
        body()
    }
}