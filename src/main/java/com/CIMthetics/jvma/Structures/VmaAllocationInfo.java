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
}
