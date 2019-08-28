package com.CIMthetics.jVma;

import java.util.EnumSet;

import com.CIMthetics.jVma.Handles.VmaAllocator;
import com.CIMthetics.jVma.Structures.CreateInfos.VmaAllocatorCreateInfo;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Enums.VkMemoryPropertyFlagBits;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Enums.VkResult;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkPhysicalDeviceMemoryProperties;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkPhysicalDeviceProperties;

class NativeProxies
{
    native VkResult vmaCreateAllocator(
            VmaAllocatorCreateInfo createInfo,
            VmaAllocator allocator);
    
    native void vmaDestroyAllocator(
            VmaAllocator allocator);
    
    native void vmaGetMemoryProperties(
            VmaAllocator allocator,
            VkPhysicalDeviceMemoryProperties physicalDeviceMemoryProperties);
    
    native void vmaGetMemoryTypeProperties(
            VmaAllocator allocator,
            int memoryTypeIndex,
            EnumSet<VkMemoryPropertyFlagBits> flags);
    
    native void vmaGetPhysicalDeviceProperties(
            VmaAllocator allocator,
            VkPhysicalDeviceProperties physicalDeviceProperties);
    
    native void vmaSetCurrentFrameIndex(
            VmaAllocator allocator,
            int frameIndex);

}
