# jvma

**jvma** is a Java interface to the Vulkan Memory Allocator project (which is written in C++).

This project
If you are new to this you may want to also fetch the [jvulkan-examples](https://github.com/dkaip/jvulkan-examples) project.  The 
**jvulkan-examples** project provides some working examples of using this project.

The fine folks at JogAmp have created Java bindings that allow you to use the Vulkan API from
Java, however, in my opinion it works fine, but, is not friendly to the Java way of doing things
and is certainly not Java programmer friendly to the normal Java programmer.

This current release is an attempt at providing access to the Vulkan Specification 1.1.106.0 
functionality ultimately via the [Vulkan® SDK](https://www.lunarg.com/vulkan-sdk/) from LUNARG.

It is not, at this moment, complete in implementing all of the 1.1.106.0 functionality, however, it should 
be able to run all of the example programs in the **jvulkan-examples** project.  

Also, do not expect this software to work if you do not have Vulkan drivers available on your 
machine for your graphics card.  

Note: This has only been built and tested in a Linux 64 bit environment, 
at this moment, Fedora 29 and Fedora 30.  It has been running just fine on a Radeon RX460 with 4GB of RAM. 
I expect the examples to run fine on a card that has much less memory.

## Get the code
Use the <code>git clone</code> command to get the code. 

<code>git clone https://github.com/dkaip/jvma jvma</code> 

This will create a <code>jvma</code> directory in your current directory

## Building
Change your current directory (<code>cd</code>) to the project root directory.  If you used the 
command above it would be <code>cd jvma</code>.  

Enter the following <code>gradle</code> command:

<code>gradle assemble</code>

This compiles and creates a jar file with the appropriate files and runs the unit tests.

The result of a successful build is file <code>jvma.jar</code> found in the <code>build/libs</code> directory.

## Installation

In addition to this library you will need to retrieve and build the 
[jvma-natives-Linux-x86_64](https://github.com/dkaip/jvma-natives-Linux-x86_64) project.  The **jvma-natives-Linux-x86_64** 
library provides the linkage between code written in Java using this library and 
the Vulkan Memory Allocator. 

## Documentation

At the current time, refer to the documentation provided by in the 
[Vulkan Memory Allocator Project](https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator).

This documentation is written with c++ in mind.

In the future, I may work on adding javadoc so that working in an IDE might be easier, 
but, that is down the road.

## Usage Notes
The [Vulkan® SDK](https://www.lunarg.com/vulkan-sdk/) from LUNARG is written in c++ 
and as you might imagine there are some challenges when "wrapping" c++ code with Java. 
As a result there are some systematic differences between using **jvulkan** and Java 
versus using c++ and the LUNARG Vulkan® SDK directly.

When the documentation ([Vulkan® Specification](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/)) indicates that an array of <code>SomeObjectType</code> is to be passed as an argument there is always an additional argument indicating the number of elements contained within the array.  (There is an exception to this in the cases where there are &quot;parallel&quot; 
arrays that are directly associated with one another.  In these cases sometimes there is only 
one &quot;number of elements&quot; argument.) When using **jvulkan** array arguments of objects will be passed as a <code>Collection&lt;SomeObjectType&gt;</code>.  Additionally, the argument indicating the number of elements contained within the array will not be present since a Java collection 
knows its size. 

The same applies for sending arrays of primitive types.  Java arrays know their size so the 
&quot;number of elements in the array&quot; argument is not needed and thus not present in 
the Java version of the function(method). 

In Java you cannot pass a pointer to a pointer as an argument to a function (method) as you 
can in c++.  Because of this, in the cases where data (objects) are returned in this manner in the c++ functions the Java objects must be created first in the Java environment.  Here is an example, 
first is the c++ function followed by the Java version provided by **jvulkan**:  

**c++**  
<code>VkResult vkEnumeratePhysicalDevices(
VkInstance                                  instance, 
uint32_t*                                   pPhysicalDeviceCount, 
VkPhysicalDevice*                           pPhysicalDevices);</code> 

<code>uint32_t count = 0;</code> 
<br>
<code>VkPhysicalDevice vkPhysicalDevice = nullptr;</code> 
<br>
<code>VkResult result = vkEnumeratePhysicalDevices(vulkanInstance, &count, &vkPhysicalDevice);</code>

**Java**  
<code>Collection&lt;VkPhysicalDevice&gt; physicalDeviceList = new LinkedList&lt;VkPhysicalDevice&gt;();<br> 
VkResult result = vkEnumeratePhysicalDevices(vulkanInstance, physicalDeviceList);</code>  

Notice how, in the Java environment the argument <code>pPhysicalDeviceCount</code> is not 
present, again because it is not needed since a Java <code>Collection</code> knows its size. 
In addition, notice how the Collection, in this case a <code>LinkedList&lt;VkPhysicalDevice&gt;</code> is created 
before the call to <code>vkEnumeratePhysicalDevices</code>.  This is because Java cannot return 
a created object in this manner, but, it can populate it. The elements that are added to 
the Collection, if any, are in the Java world meaning they are normal Java objects that will 
be garbage collected in the normal manner. In most cases, in this situation, the Collection should be empty 
before the call.  Creating the object first is necessary when anything is returned via the arguments 
themselves in the c++ environment.

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

<code>javah -classpath "my-jma-project-path/src/main/java:my-jvulkan-project-path/src/main/java" com.CIMthetics.jvma.NativeProxies</code>
com_CIMthetics_jvma_NativeProxies.h
This will create the file <code>com&lowbar;CIMthetics&lowbar;jvma&lowbar;VulkanCore&lowbar;NativeProxies.h</code> that will need to be placed in the <code>headers</code> directory of 
the **jvma-natives-Linux-x86_64** project on your machine.  You will then need to implement 
any new functions you have added here in that project as well.

## License
[Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)