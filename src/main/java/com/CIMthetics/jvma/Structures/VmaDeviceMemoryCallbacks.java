package com.CIMthetics.jvma.Structures;

import com.CIMthetics.jvma.Handles.VmaAllocator;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Handles.VkDeviceMemory;

public interface VmaDeviceMemoryCallbacks
{
    public abstract void PFN_vmaAllocateDeviceMemoryFunction(
            VmaAllocator    allocator,
            int             memoryType,
            VkDeviceMemory  memory,
            long            size);
    
    public abstract void PFN_vmaFreeDeviceMemoryFunction(
            VmaAllocator    allocator,
            int             memoryType,
            VkDeviceMemory  memory,
            long            size);
    
}