void call(Closure body){

    println body

    // println "===methods==="
    // body.metaClass.methods.name.unique().each{ println "- ${it}"}
    // println "============="
    println body.getOwner()?.config
    println body.getDelegate()?.config

    def bodyLibConfig = null 

    def nodeLabel = bodyLibConfig?.label ?: config.label ?: "" 
    println "would use node label: ${nodeLabel}"
    steps.node{
        body()
    }
}