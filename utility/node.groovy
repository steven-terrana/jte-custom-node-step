void call(Closure body){

    println body

    // println "===methods==="
    // body.metaClass.methods.name.unique().each{ println "- ${it}"}
    // println "============="
    println body.getOwner().getProperty("config")
    println body.getDelegate().getProperty("config")

    def bodyLibConfig = null 

    def nodeLabel = bodyLibConfig?.label ?: config.label ?: "" 
    println "would use node label: ${nodeLabel}"
    steps.node{
        body()
    }
}