# jvma

**jvma** is a Java interface to the 
[Vulkan Memory Allocator Project](https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator) 
(which is written in C++).

This project may be useful to those that are using the [jvulkan](https://github.com/dkaip/jvulkan) project as 
it will allow the use of the [Vulkan Memory Allocator Project](https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator) 
methods / functions for dealing with memory allocation(s).

## Get the code
Use the <code>git clone</code> command to get the code. 

<code>git clone https://github.com/dkaip/jvma jvma</code> 

This will create a <code>jvma</code> directory in your current directory

## Building
Change your current directory (<code>cd</code>) to the project root directory.  If you used the 
command above it would be <code>cd jvma</code>.  

Enter the following <code>gradle</code> command:

<code>gradle assemble</code>

This compiles and creates a jar file with the appropriate files.

The result of a successful build is file <code>jvma.jar</code> found in the <code>build/libs</code> directory.

## Installation

In addition to this library you will need to retrieve and build the 
[jvma-natives-Linux-x86_64](https://github.com/dkaip/jvma-natives-Linux-x86_64) project, 
the [jvulkan](https://github.com/dkaip/jvulkan) project, and 
the [jvulkan-natives-Linux-x86_64](https://github.com/dkaip/jvulkan-natives-Linux-x86_64) project. 

The **jvma-natives-Linux-x86_64** 
library provides the linkage between code written in Java using this library and 
the [Vulkan Memory Allocator](https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator). 

## Documentation

At the current time, refer to the documentation provided by in the 
[Vulkan Memory Allocator Project](https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator).

This documentation is written with C++ in mind.

In the future, I may work on adding javadoc so that working in an IDE might be easier, 
but, that is down the road.

## Usage Notes
The [Vulkan Memory Allocator](https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator) is written in C++ 
and as you might imagine there are some challenges when "wrapping" C++ code with Java. 
As a result there are some systematic differences between using **jvma** and Java 
versus using C++ and the [Vulkan Memory Allocator](https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator) directly.

When a method indicates that an array of <code>SomeObjectType</code> is to be passed as an argument there is always an additional argument indicating the number of elements contained within the array.  (There is an exception to this in the cases where there are &quot;parallel&quot; 
arrays that are directly associated with one another.  In these cases sometimes there is only 
one &quot;number of elements&quot; argument.) When using **jvma**, array arguments of objects will be passed as a <code>Collection&lt;SomeObjectType&gt;</code>.  Additionally, the argument indicating the number of elements contained within the array will not be present since a Java collection knows its size. 

The same applies for sending arrays of primitive types.  Java arrays know their size so the 
&quot;number of elements in the array&quot; argument is not needed and thus not present in 
the Java version of the function(method). 

In Java you cannot pass a pointer to a pointer as an argument to a function (method) as you 
can in C++.  Because of this, in the cases where data (objects) are returned in this manner in the c++ functions the Java objects must be created first in the Java environment.  Here is an example, 
first is the C++ function followed by the Java version provided by **jvma**:  

**c++**

```
    VkResult vmaCreateAllocator(const VmaAllocatorCreateInfo* pCreateInfo, VmaAllocator* pAllocator);
    
    VmaAllocatorCreateInfo createInfo = {};
    /*
     * Fill in createInfo here
     */
    .
    .
    .
    VmaAllocator allocator = nullptr;
    VkResult result = vmaCreateAllocator(&createInfo, &allocator);
```

**Java**  

```
    import static com.CIMthetics.jvma.VMAFunctions.vmaCreateAllocator;
    
    public static VkResult vmaCreateAllocator(
            VmaAllocatorCreateInfo createInfo,
            VmaAllocator allocator)
            
    VmaAllocatorCreateInfo createInfo = new VmaAllocatorCreateInfo();
    /*
     * Fill in createInfo here
     */
    .
    .
    .
    VmaAllocator allocator = new VmaAllocator();
    VkResult result = vmaCreateAllocator(createInfo, allocator);
```

Notice how the <code>VmaAllocator</code> is created 
before the call to <code>vmaCreateAllocator</code>.  This is because Java cannot return 
a created object in the same was as you can in C++, but, it can populate it.  Creating the object first is necessary when anything is returned via the arguments themselves in the C++ environment.

In the case where an object is the return value of the function(method) it does not have to be 
created ahead of time.  The is evident on the example above where the return code 
<code>VkResult result</code> is only declared and not initially created.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

The native method definitions in the file <code>NativeProxies.java</code> are in 
alphabetical order for the Vma functions.  Please keep them in alphabetical order if you 
are adding native methods.  The ones defined in <code>VMAFunctions.java</code> are not 
in alphabetical order and I do not currently feel the need to have them that way.

Please do not reformat the text in existing code.  If you create new classes, etc. please format 
things as you normally would.

In the event you are upgrading or adding to this software the command to recreate the 
JNI header file for the native functions is:

<code>javah -classpath &quot;my-jma-project-path/src/main/java:my-jvulkan-project-path/src/main/java&quot; com.CIMthetics.jvma.NativeProxies</code>

This will create the file <code>com&lowbar;CIMthetics&lowbar;jvma&lowbar;NativeProxies.h</code> that will need to be placed in the <code>headers</code> directory of 
the **jvma-natives-Linux-x86_64** project on your machine.  You will then need to implement 
any new functions you have added here in that project as well.

## License
[Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)