void call(Closure body){

    println body

    // println "===methods==="
    // body.metaClass.methods.name.unique().each{ println "- ${it}"}
    // println "============="
    try{
        println "owner -> ${body.getOwner().config}"
    }catch(){}


    try{
        println "delegate -> ${body.getDelegate().config}" 
    }catch(){}
    
    def bodyLibConfig = null 

    def nodeLabel = bodyLibConfig?.label ?: config.label ?: "" 
    println "would use node label: ${nodeLabel}"
    steps.node{
        body()
    }
}