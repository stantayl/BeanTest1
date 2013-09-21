package beantest1

class MyTestController {
    //
    //  These are all auto-injected from the beans in resource.groovy
    //
    def test1
    def test2
    def test3
    def test4

    def index() { 
        render "<p>Contents of test1: ${test1.author}, ${test1.title}, multi-language? ${test1.supportsMultipleLanguages}</p>"
        render "<p>Contents of test2: ${test2.author}, ${test2.title}, multi-language? ${test2.supportsMultipleLanguages}</p>"
        render "<p>Contents of test3: ${test3.author}, ${test3.title}, multi-language? ${test3.supportsMultipleLanguages}</p>"
        render "<p>" + (test3.supportsMultipleLanguages ? "test3 speaks a lot of languages!" : "test3 speaks only English") + "<p>"
        
        render "<p>Contents of test4: ${test4.author}, ${test4.title}, multi-language? ${test4.supportsMultipleLanguages}</p>"
        
        //  Have to check if method exists, otherwise get a MissingMethodException
        if (test4.hasProperty("somethingSpecificToEfax"))
            render "someThingSpecificToEfax: ${test4.someThingSpecificToEfax()}"
            
        render "myFaxAccountNumber: ${test4.myFaxAccountNumber}"
    }
}
