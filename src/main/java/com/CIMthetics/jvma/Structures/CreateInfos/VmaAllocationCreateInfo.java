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
package com.CIMthetics.jvma.Structures.CreateInfos;

import java.util.EnumSet;

import com.CIMthetics.jvma.Enums.VmaAllocationCreateFlagBits;
import com.CIMthetics.jvma.Enums.VmaMemoryUsage;
import com.CIMthetics.jvma.Handles.VmaPool;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Enums.VkMemoryPropertyFlagBits;

public class VmaAllocationCreateInfo
{
    /// Use #VmaAllocationCreateFlagBits enum.
    EnumSet<VmaAllocationCreateFlagBits> flags = EnumSet.noneOf(VmaAllocationCreateFlagBits.class);
    /** \brief Intended usage of memory.
    
    You can leave #VMA_MEMORY_USAGE_UNKNOWN if you specify memory requirements in another way. \n
    If `pool` is not null, this member is ignored.
    */
    VmaMemoryUsage usage;
    /** \brief Flags that must be set in a Memory Type chosen for an allocation.
    
    Leave 0 if you specify memory requirements in other way. \n
    If `pool` is not null, this member is ignored.*/
    EnumSet<VkMemoryPropertyFlagBits> requiredFlags = EnumSet.noneOf(VkMemoryPropertyFlagBits.class);
    /** \brief Flags that preferably should be set in a memory type chosen for an allocation.
    
    Set to 0 if no additional flags are prefered. \n
    If `pool` is not null, this member is ignored. */
    EnumSet<VkMemoryPropertyFlagBits> preferredFlags = EnumSet.noneOf(VkMemoryPropertyFlagBits.class);
    /**
     * Bitmask containing one bit set for every memory type acceptable for this allocation.
     * <p>
     * A value <code>0</code> is equivalent to all bits set. It means any memory type is accepted if
     * it meets other requirements specified by this structure, with no further
     * restrictions on memory type index.
     * <p>
     * If <code>pool</code> is not <code>null</code>, this member is ignored.
    */
    int memoryTypeBits;
    /** \brief Pool that this allocation should be created in.

    Leave `VK_NULL_HANDLE` to allocate from default pool. If not null, members:
    `usage`, `requiredFlags`, `preferredFlags`, `memoryTypeBits` are ignored.
    */
    VmaPool pool;
    /** \brief Custom general-purpose pointer that will be stored in #VmaAllocation, can be read as VmaAllocationInfo::pUserData and changed using vmaSetAllocationUserData().
    
    If #VMA_ALLOCATION_CREATE_USER_DATA_COPY_STRING_BIT is used, it must be either
    null or pointer to a null-terminated string. The string will be then copied to
    internal buffer, so it doesn't need to be valid after allocation call.
    */
    Object pUserData;
    
    public EnumSet<VmaAllocationCreateFlagBits> getFlags()
    {
        return flags;
    }
    
    public void setFlags(EnumSet<VmaAllocationCreateFlagBits> flags)
    {
        this.flags = flags;
    }
    
    public VmaMemoryUsage getUsage()
    {
        return usage;
    }
    
    public void setUsage(VmaMemoryUsage usage)
    {
        this.usage = usage;
    }
    
    public EnumSet<VkMemoryPropertyFlagBits> getRequiredFlags()
    {
        return requiredFlags;
    }
    
    public void setRequiredFlags(EnumSet<VkMemoryPropertyFlagBits> requiredFlags)
    {
        this.requiredFlags = requiredFlags;
    }
    
    public EnumSet<VkMemoryPropertyFlagBits> getPreferredFlags()
    {
        return preferredFlags;
    }
    
    public void setPreferredFlags(EnumSet<VkMemoryPropertyFlagBits> preferredFlags)
    {
        this.preferredFlags = preferredFlags;
    }
    
    public int getMemoryTypeBits()
    {
        return memoryTypeBits;
    }
    
    public void setMemoryTypeBits(int memoryTypeBits)
    {
        this.memoryTypeBits = memoryTypeBits;
    }
    
    public VmaPool getPool()
    {
        return pool;
    }
    
    public void setPool(VmaPool pool)
    {
        this.pool = pool;
    }
    
    public Object getpUserData()
    {
        return pUserData;
    }
    
    public void setpUserData(Object pUserData)
    {
        this.pUserData = pUserData;
    }
    
}
