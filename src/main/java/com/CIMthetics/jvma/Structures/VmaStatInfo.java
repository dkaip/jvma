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
    
    public int getBlockCount()
    {
        return blockCount;
    }
    
    public int getAllocationCount()
    {
        return allocationCount;
    }
    
    public int getUnusedRangeCount()
    {
        return unusedRangeCount;
    }
    
    public long getUsedBytes()
    {
        return usedBytes;
    }
    
    public long getUnusedBytes()
    {
        return unusedBytes;
    }
    
    public long getAllocationSizeMin()
    {
        return allocationSizeMin;
    }
    
    public long getAllocationSizeAvg()
    {
        return allocationSizeAvg;
    }
    
    public long getAllocationSizeMax()
    {
        return allocationSizeMax;
    }
    
    public long getUnusedRangeSizeMin()
    {
        return unusedRangeSizeMin;
    }
    
    public long getUnusedRangeSizeAvg()
    {
        return unusedRangeSizeAvg;
    }
    
    public long getUnusedRangeSizeMax()
    {
        return unusedRangeSizeMax;
    }
    
    void setBlockCount(int blockCount)
    {
        this.blockCount = blockCount;
    }
    
    void setAllocationCount(int allocationCount)
    {
        this.allocationCount = allocationCount;
    }
    
    void setUnusedRangeCount(int unusedRangeCount)
    {
        this.unusedRangeCount = unusedRangeCount;
    }
    
    void setUsedBytes(long usedBytes)
    {
        this.usedBytes = usedBytes;
    }
    
    void setUnusedBytes(long unusedBytes)
    {
        this.unusedBytes = unusedBytes;
    }
    
    void setAllocationSizeMin(long allocationSizeMin)
    {
        this.allocationSizeMin = allocationSizeMin;
    }
    
    void setAllocationSizeAvg(long allocationSizeAvg)
    {
        this.allocationSizeAvg = allocationSizeAvg;
    }
    
    void setAllocationSizeMax(long allocationSizeMax)
    {
        this.allocationSizeMax = allocationSizeMax;
    }
    
    void setUnusedRangeSizeMin(long unusedRangeSizeMin)
    {
        this.unusedRangeSizeMin = unusedRangeSizeMin;
    }
    
    void setUnusedRangeSizeAvg(long unusedRangeSizeAvg)
    {
        this.unusedRangeSizeAvg = unusedRangeSizeAvg;
    }
    
    void setUnusedRangeSizeMax(long unusedRangeSizeMax)
    {
        this.unusedRangeSizeMax = unusedRangeSizeMax;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nVmaStatInfo\n"));
        sb.append(String.format("    blockCount:%d\n", blockCount));
        sb.append(String.format("    allocationCount:%d\n", allocationCount));
        sb.append(String.format("    unusedRangeCount:%d\n", unusedRangeCount));
        sb.append(String.format("    usedBytes:%d\n", usedBytes));
        sb.append(String.format("    unusedBytes:%d\n", unusedBytes));
        sb.append(String.format("    allocationSizeMin:%d\n", allocationSizeMin));
        sb.append(String.format("    allocationSizeAvg:%d\n", allocationSizeAvg));
        sb.append(String.format("    allocationSizeMax:%d\n", allocationSizeMax));
        sb.append(String.format("    unusedRangeSizeMin:%d\n", unusedRangeSizeMin));
        sb.append(String.format("    unusedRangeSizeAvg:%d\n", unusedRangeSizeAvg));
        sb.append(String.format("    unusedRangeSizeMax:%d\n", unusedRangeSizeMax));
        
        return sb.toString();
    }
}
