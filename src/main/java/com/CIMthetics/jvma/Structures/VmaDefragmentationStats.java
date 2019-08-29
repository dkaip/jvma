package com.CIMthetics.jvma.Structures;

public class VmaDefragmentationStats
{
    /**
     *  Total number of bytes that have been copied while moving allocations to different places.
     */
    long bytesMoved;
    
    /**
     * Total number of bytes that have been released to the system by freeing empty <code>VkDeviceMemory</code> objects.
     */
    long bytesFreed;
    
    /**
     * Number of allocations that have been moved to different places.
     */
    int allocationsMoved;
    
    /**
     *  Number of empty <code>VkDeviceMemory</code> objects that have been released to the system.
     */
    int deviceMemoryBlocksFreed;
}
