package com.CIMthetics.jVma;

import java.util.EnumSet;

import com.CIMthetics.jVma.Handles.VmaAllocation;
import com.CIMthetics.jVma.Handles.VmaAllocator;
import com.CIMthetics.jVma.Handles.VmaPool;
import com.CIMthetics.jVma.Structures.VmaAllocationInfo;
import com.CIMthetics.jVma.Structures.VmaPoolStats;
import com.CIMthetics.jVma.Structures.VmaStats;
import com.CIMthetics.jVma.Structures.CreateInfos.VmaAllocationCreateInfo;
import com.CIMthetics.jVma.Structures.CreateInfos.VmaAllocatorCreateInfo;
import com.CIMthetics.jVma.Structures.CreateInfos.VmaPoolCreateInfo;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Enums.VkMemoryPropertyFlagBits;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Enums.VkResult;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Handles.VkBuffer;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Handles.VkImage;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkMemoryRequirements;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkPhysicalDeviceMemoryProperties;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkPhysicalDeviceProperties;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.CreateInfos.VkBufferCreateInfo;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.CreateInfos.VkImageCreateInfo;

class NativeProxies
{
    native VkResult vmaAllocateMemoryForBuffer(
            VmaAllocator allocator,
            VkBuffer buffer,
            VmaAllocationCreateInfo createInfo,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo);
    
    native VkResult vmaAllocateMemoryForImage(
            VmaAllocator allocator,
            VkImage image,
            VmaAllocationCreateInfo createInfo,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo);
    
    native VkResult vmaAllocateMemory(
            VmaAllocator allocator,
            VkMemoryRequirements vkMemoryRequirements,
            VmaAllocationCreateInfo createInfo,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo);
    
    native VkResult vmaAllocateMemoryPages(
            VmaAllocator allocator,
            VkMemoryRequirements vkMemoryRequirements,
            VmaAllocationCreateInfo createInfo,
            long allocationCount,
            VmaAllocation allocations,
            VmaAllocationInfo allocationInfo);
    
    native void vmaBuildStatsString(
            VmaAllocator allocator,
            String statsString,
            boolean detailedMap);
    
    native VkResult vmaCheckPoolCorruption(
            VmaAllocator allocator,
            VmaPool pool);
    
    native VkResult vmaCreateAllocator(
            VmaAllocatorCreateInfo createInfo,
            VmaAllocator allocator);
    
    native VkResult vmaCreatePool(
            VmaAllocator allocator,
            VmaPoolCreateInfo createInfo,
            VmaPool pool);
    
    native void vmaCalculateStats(
            VmaAllocator allocator,
            VmaStats stats);
    
    native void vmaDestroyAllocator(
            VmaAllocator allocator);
    
    native void vmaDestroyPool(
            VmaAllocator allocator,
            VmaPool pool);
    
    native VkResult vmaFindMemoryTypeIndex(
            VmaAllocator allocator,
            EnumSet<VkMemoryPropertyFlagBits> memoryTypeBits,
            VmaAllocationCreateInfo allocationCreateInfo,
            Integer memoryTypeIndex);
    
    native VkResult vmaFindMemoryTypeIndexForBufferInfo(
            VmaAllocator allocator,
            VkBufferCreateInfo bufferCreateInfo,
            VmaAllocationCreateInfo allocationCreateInfo,
            Integer pMemoryTypeIndex);
    
    native VkResult vmaFindMemoryTypeIndexForImageInfo(
            VmaAllocator allocator,
            VkImageCreateInfo imageCreateInfo,
            VmaAllocationCreateInfo allocationCreateInfo,
            Integer memoryTypeIndex);
    
    native void vmaFreeMemory(
            VmaAllocator allocator,
            VmaAllocation allocation);
    
    native void vmaFreeMemoryPages(
            VmaAllocator allocator,
            long allocationCount,
            VmaAllocation allocations);
    
    native void vmaMakePoolAllocationsLost(
            VmaAllocator allocator,
            VmaPool pool,
            Long lostAllocationCount);
    
    native void vmaGetPoolStats(
            VmaAllocator allocator,
            VmaPool pool,
            VmaPoolStats poolStats);
    
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
