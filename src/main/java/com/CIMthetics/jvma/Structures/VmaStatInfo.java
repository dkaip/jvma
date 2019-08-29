package com.CIMthetics.jvma.Structures;

public class VmaStatInfo
{
    /// Number of `VkDeviceMemory` Vulkan memory blocks allocated.
    int blockCount;
    /// Number of #VmaAllocation allocation objects allocated.
    int allocationCount;
    /// Number of free ranges of memory between allocations.
    int unusedRangeCount;
    /// Total number of bytes occupied by all allocations.
    long usedBytes;
    /// Total number of bytes occupied by unused ranges.
    long unusedBytes;
    long allocationSizeMin;
    long allocationSizeAvg;
    long allocationSizeMax;
    long unusedRangeSizeMin;
    long unusedRangeSizeAvg;
    long unusedRangeSizeMax;
}
