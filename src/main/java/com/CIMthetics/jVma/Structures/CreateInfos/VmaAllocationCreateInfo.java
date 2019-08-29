package com.CIMthetics.jVma.Structures.CreateInfos;

import java.util.EnumSet;

import com.CIMthetics.jVma.Enums.VmaAllocationCreateFlagBits;
import com.CIMthetics.jVma.Enums.VmaMemoryUsage;
import com.CIMthetics.jVma.Handles.VmaPool;
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
    /** \brief Bitmask containing one bit set for every memory type acceptable for this allocation.

    Value 0 is equivalent to `UINT32_MAX` - it means any memory type is accepted if
    it meets other requirements specified by this structure, with no further
    restrictions on memory type index. \n
    If `pool` is not null, this member is ignored.
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
}
