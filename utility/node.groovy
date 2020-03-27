/*
    Sometimes in JTE you want to be able to control node assignment from the pipeline configuration file. 

    This step is an example of how to do that. 

    hierarchical configuration: 
    1. if the node step is passed a label during invocation, for example:
        node("someLabel"){

        }
       then the label argument will always be honored and used 
    2. if no label argument is provided, and the node step is invoked from within 
       another library, we will check if that library has a "label" configuration.
       if it does, we'll use that
    3. if no label argument has been provided, and the calling library has not supplied its own
       "label" configuration - then we will check for the utility library's "label" configuration
       and use this as the default value.  This also applies in the case of invoking the node step
       directly from the pipeline template. 
    4. if none of these options have been provided, we will simply pass an empty label to the original
       node step implementation

*/
void call(String label = null, Closure body){

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

    def nodeLabel = label ?: bodyConfig.label ?: config.label ?: "" 
    steps.node(nodeLabel, body) 
}