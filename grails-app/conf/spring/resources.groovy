// Place your Spring DSL code here
beans = {
    test1(MyBeanTest)
    
    test2(MyBeanTest)
    {
        author = "Barbara"
        title = "eFax (domestic) MyAccount"
        product = "EFAX"
    }
    
    println "*** grailsApplication.config.myproduct=${grailsApplication.config.myproduct}"    
    
    //
    //  test3 is a bean of type "MyBeanTest", but can be one of several objects --
    //  test1, test2, or an entirely new object, depending on the value of the 
    //  myproduct config
    //
    if (grailsApplication.config.myproduct == "EFAX")
        test3 = test2
    else if (grailsApplication.config.myproduct == "MYFAX")
        test3(MyBeanTest)
        {
            author = "John"
            title = "MyFax MyAccount"
            product = "MYFAX"
        }
    else
        test3 = test1
        
    //
    //  test4 can be one of several CLASSES, depending on the value of the 
    //  myproduct config
    //
    if (grailsApplication.config.myproduct == "EFAX")
        test4(MyBeanEfax)
    else if (grailsApplication.config.myproduct == "MYFAX")
        test4(MyBeanMyFax)
    else
        test4(MyBeanTest) // the original "EFAXI" class
    
}
