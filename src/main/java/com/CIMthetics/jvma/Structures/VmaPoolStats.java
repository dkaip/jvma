/*
 * Copyright 2019 Douglas Kaip
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    
    public VmaPoolStats()
    {
        
    }

    public long getSize()
    {
        return size;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

    public long getUnusedSize()
    {
        return unusedSize;
    }

    public void setUnusedSize(long unusedSize)
    {
        this.unusedSize = unusedSize;
    }

    public long getAllocationCount()
    {
        return allocationCount;
    }

    public void setAllocationCount(long allocationCount)
    {
        this.allocationCount = allocationCount;
    }

    public long getUnusedRangeCount()
    {
        return unusedRangeCount;
    }

    public void setUnusedRangeCount(long unusedRangeCount)
    {
        this.unusedRangeCount = unusedRangeCount;
    }

    public long getUnusedRangeSizeMax()
    {
        return unusedRangeSizeMax;
    }

    public void setUnusedRangeSizeMax(long unusedRangeSizeMax)
    {
        this.unusedRangeSizeMax = unusedRangeSizeMax;
    }

    public long getBlockCount()
    {
        return blockCount;
    }

    public void setBlockCount(long blockCount)
    {
        this.blockCount = blockCount;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nVmaPoolStats\n"));
        sb.append(String.format("    size:%d\n", size));
        sb.append(String.format("    unusedSize:%d\n", unusedSize));
        sb.append(String.format("    allocationCount:%d\n", allocationCount));
        sb.append(String.format("    unusedRangeCount:%d\n", unusedRangeCount));
        sb.append(String.format("    unusedRangeSizeMax:%d\n", unusedRangeSizeMax));
        sb.append(String.format("    blockCount:%d\n", blockCount));
        
        return sb.toString();
    }
}
