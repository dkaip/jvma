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

import com.CIMthetics.jvma.Handles.MappedData;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Handles.VkDeviceMemory;

public class VmaAllocationInfo
{
    /** \brief Memory type index that this allocation was allocated from.
    
    It never changes.
    */
    int memoryType;
    /** \brief Handle to Vulkan memory object.

    Same memory object can be shared by multiple allocations.
    
    It can change after call to vmaDefragment() if this allocation is passed to the function, or if allocation is lost.

    If the allocation is lost, it is equal to `VK_NULL_HANDLE`.
    */
    VkDeviceMemory deviceMemory;
    /** \brief Offset into deviceMemory object to the beginning of this allocation, in bytes. (deviceMemory, offset) pair is unique to this allocation.

    It can change after call to vmaDefragment() if this allocation is passed to the function, or if allocation is lost.
    */
    long offset;
    /** \brief Size of this allocation, in bytes.

    It never changes, unless allocation is lost.
    */
    long size;
    /** \brief Pointer to the beginning of this allocation as mapped data.

    If the allocation hasn't been mapped using vmaMapMemory() and hasn't been
    created with #VMA_ALLOCATION_CREATE_MAPPED_BIT flag, this value null.

    It can change after call to vmaMapMemory(), vmaUnmapMemory().
    It can also change after call to vmaDefragment() if this allocation is passed to the function.
    */
    MappedData mappedData;
    /** \brief Custom general-purpose pointer that was passed as VmaAllocationCreateInfo::pUserData or set using vmaSetAllocationUserData().

    It can change after call to vmaSetAllocationUserData() for this allocation.
    */
    Object userData;
    
    public VmaAllocationInfo()
    {
    }

    public int getMemoryType()
    {
        return memoryType;
    }

    public void setMemoryType(int memoryType)
    {
        this.memoryType = memoryType;
    }

    public VkDeviceMemory getDeviceMemory()
    {
        return deviceMemory;
    }

    public void setDeviceMemory(VkDeviceMemory deviceMemory)
    {
        this.deviceMemory = deviceMemory;
    }

    public long getOffset()
    {
        return offset;
    }

    public void setOffset(long offset)
    {
        this.offset = offset;
    }

    public long getSize()
    {
        return size;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

    public MappedData getMappedData()
    {
        return mappedData;
    }

    public void setMappedData(MappedData mappedData)
    {
        this.mappedData = mappedData;
    }

    public Object getUserData()
    {
        return userData;
    }

    public void setUserData(Object userData)
    {
        this.userData = userData;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nVmaAllocationInfo\n"));
        
        sb.append(String.format("    memoryType:%d\n", memoryType));
        sb.append(String.format("    deviceMemory:%s\n", deviceMemory.toString()));
        sb.append(String.format("    offset:%d\n", offset));
        sb.append(String.format("    size:%d\n", size));
        sb.append(String.format("    mappedData:%s\n", mappedData.toString()));
        sb.append(String.format("    userData:%s\n", userData == null ? "null" : userData.toString()));
        
        return sb.toString();
    }
}
