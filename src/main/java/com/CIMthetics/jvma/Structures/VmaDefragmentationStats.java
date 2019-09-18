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

    public long getBytesMoved()
    {
        return bytesMoved;
    }

    public void setBytesMoved(long bytesMoved)
    {
        this.bytesMoved = bytesMoved;
    }

    public long getBytesFreed()
    {
        return bytesFreed;
    }

    public void setBytesFreed(long bytesFreed)
    {
        this.bytesFreed = bytesFreed;
    }

    public int getAllocationsMoved()
    {
        return allocationsMoved;
    }

    public void setAllocationsMoved(int allocationsMoved)
    {
        this.allocationsMoved = allocationsMoved;
    }

    public int getDeviceMemoryBlocksFreed()
    {
        return deviceMemoryBlocksFreed;
    }

    public void setDeviceMemoryBlocksFreed(int deviceMemoryBlocksFreed)
    {
        this.deviceMemoryBlocksFreed = deviceMemoryBlocksFreed;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nVmaDefragmentationStats\n"));
        
        sb.append(String.format("    bytesMoved:%d\n", bytesMoved));
        sb.append(String.format("    bytesFreed:%d\n", bytesFreed));
        sb.append(String.format("    allocationsMoved:%d\n", allocationsMoved));
        sb.append(String.format("    deviceMemoryBlocksFreed:%d\n", deviceMemoryBlocksFreed));
        
        return sb.toString();
    }
}
