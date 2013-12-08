irisSvm
=======

Java implementation of SVM to process the iris dataset.

This code can be run without any compilation of any sort.  Take a look in the irisSvmApp/bin folder.  You can run irisSvm(non-windows) or irisSvm.bat(windows) directly.  
There are two parameters required, the first is the path to the iris.data dataset.  This dataset has been included in the project for convenience under the data directory.
The second parameter is the path to the folder where you would like the result file to print out.

There is no need to install gradle, just use the gradlew commands in the project root and it will automatically pull the correct version of gradle for you.

If you would like to read through or modify the code, type 'gradlew idea' from the project root to setup the project automatically.  Alternatively, you can type 'gradlew eclipse' to
setup the project for eclipse.

If you want to update the application, then after modifying your code, type 'gradle installApp'
