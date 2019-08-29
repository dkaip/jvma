package com.CIMthetics.jvma.Structures;

public class VmaPoolStats
{
    /** \brief Total amount of `VkDeviceMemory` allocated from Vulkan for this pool, in bytes.
    */
    long size;
    /** \brief Total number of bytes in the pool not used by any #VmaAllocation.
    */
    long unusedSize;
    /** \brief Number of #VmaAllocation objects created from this pool that were not destroyed or lost.
    */
    long allocationCount;
    /** \brief Number of continuous memory ranges in the pool not used by any #VmaAllocation.
    */
    long unusedRangeCount;
    /** \brief Size of the largest continuous free memory region available for new allocation.

    Making a new allocation of that size is not guaranteed to succeed because of
    possible additional margin required to respect alignment and buffer/image
    granularity.
    */
    long unusedRangeSizeMax;
    /** \brief Number of `VkDeviceMemory` blocks allocated for this pool.
    */
    long blockCount;
}
