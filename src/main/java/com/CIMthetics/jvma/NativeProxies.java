package com.CIMthetics.jvma;

import java.util.Collection;
import java.util.EnumSet;

import com.CIMthetics.jvma.Handles.MappedData;
import com.CIMthetics.jvma.Handles.VmaAllocation;
import com.CIMthetics.jvma.Handles.VmaAllocator;
import com.CIMthetics.jvma.Handles.VmaDefragmentationContext;
import com.CIMthetics.jvma.Handles.VmaPool;
import com.CIMthetics.jvma.Structures.LongReturnValue;
import com.CIMthetics.jvma.Structures.StringReturnValue;
import com.CIMthetics.jvma.Structures.VmaAllocationInfo;
import com.CIMthetics.jvma.Structures.VmaDefragmentationInfo;
import com.CIMthetics.jvma.Structures.VmaDefragmentationInfo2;
import com.CIMthetics.jvma.Structures.VmaDefragmentationStats;
import com.CIMthetics.jvma.Structures.VmaPoolStats;
import com.CIMthetics.jvma.Structures.VmaStats;
import com.CIMthetics.jvma.Structures.CreateInfos.VmaAllocationCreateInfo;
import com.CIMthetics.jvma.Structures.CreateInfos.VmaAllocatorCreateInfo;
import com.CIMthetics.jvma.Structures.CreateInfos.VmaPoolCreateInfo;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Enums.VkMemoryPropertyFlagBits;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Enums.VkResult;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Handles.VkBuffer;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Handles.VkImage;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.IntReturnValue;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkMemoryRequirements;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkPhysicalDeviceMemoryProperties;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkPhysicalDeviceProperties;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.CreateInfos.VkBufferCreateInfo;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.CreateInfos.VkImageCreateInfo;

class NativeProxies
{
    native VkResult vmaAllocateMemory(
            VmaAllocator allocator,
            VkMemoryRequirements vkMemoryRequirements,
            VmaAllocationCreateInfo createInfo,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo);
    
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
    
    native VkResult vmaAllocateMemoryPages(
            VmaAllocator allocator,
            Collection<VkMemoryRequirements> vkMemoryRequirements,
            Collection<VmaAllocationCreateInfo> createInfo,
            Collection<VmaAllocation> allocations,
            Collection<VmaAllocationInfo> allocationInfo);
    
    native VkResult vmaBindBufferMemory(
            VmaAllocator allocator,
            VmaAllocation allocation,
            VkBuffer buffer);
    
    native VkResult vmaBindImageMemory(
            VmaAllocator allocator,
            VmaAllocation allocation,
            VkImage image);
    
    native void vmaBuildStatsString(
            VmaAllocator allocator,
            StringReturnValue statsString,
            boolean detailedMap);
    
    native void vmaCalculateStats(
            VmaAllocator allocator,
            VmaStats stats);
    
    native VkResult vmaCheckCorruption(
            VmaAllocator allocator,
            int memoryTypeBits);
    
    native VkResult vmaCheckPoolCorruption(
            VmaAllocator allocator,
            VmaPool pool);
    
    native VkResult vmaCreateAllocator(
            VmaAllocatorCreateInfo createInfo,
            VmaAllocator allocator);
    
    native VkResult vmaCreateBuffer(
            VmaAllocator allocator,
            VkBufferCreateInfo bufferCreateInfo,
            VmaAllocationCreateInfo allocationCreateInfo,
            VkBuffer buffer,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo);
    
    native VkResult vmaCreateImage(
            VmaAllocator allocator,
            VkImageCreateInfo imageCreateInfo,
            VmaAllocationCreateInfo allocationCreateInfo,
            VkImage image,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo);
    
    native void vmaCreateLostAllocation(
            VmaAllocator allocator,
            VmaAllocation allocation);
    
    native VkResult vmaCreatePool(
            VmaAllocator allocator,
            VmaPoolCreateInfo createInfo,
            VmaPool pool);
    
    native VkResult vmaDefragment(
            VmaAllocator allocator,
            VmaAllocation[] allocations,
            long allocationCount,
            boolean[] allocationsChanged,
            VmaDefragmentationInfo defragmentationInfo,
            VmaDefragmentationStats defragmentationStats);
    
    native VkResult vmaDefragmentationBegin(
            VmaAllocator allocator,
            VmaDefragmentationInfo2 info,
            VmaDefragmentationStats stats,
            VmaDefragmentationContext context);
    
    native VkResult vmaDefragmentationEnd(
            VmaAllocator allocator,
            VmaDefragmentationContext context);
    
    native void vmaDestroyAllocator(
            VmaAllocator allocator);
    
    native void vmaDestroyBuffer(
            VmaAllocator allocator,
            VkBuffer buffer,
            VmaAllocation allocation);
    
    native void vmaDestroyImage(
            VmaAllocator allocator,
            VkImage image,
            VmaAllocation allocation);
    
    native void vmaDestroyPool(
            VmaAllocator allocator,
            VmaPool pool);
    
    native VkResult vmaFindMemoryTypeIndex(
            VmaAllocator allocator,
            int memoryTypeBits,
            VmaAllocationCreateInfo allocationCreateInfo,
            IntReturnValue memoryTypeIndex);
    
    native VkResult vmaFindMemoryTypeIndexForBufferInfo(
            VmaAllocator allocator,
            VkBufferCreateInfo bufferCreateInfo,
            VmaAllocationCreateInfo allocationCreateInfo,
            IntReturnValue pMemoryTypeIndex);
    
    native VkResult vmaFindMemoryTypeIndexForImageInfo(
            VmaAllocator allocator,
            VkImageCreateInfo imageCreateInfo,
            VmaAllocationCreateInfo allocationCreateInfo,
            IntReturnValue memoryTypeIndex);
    
    native void vmaFlushAllocation(
            VmaAllocator allocator,
            VmaAllocation allocation,
            long offset,
            long size);
    
    native void vmaFreeMemory(
            VmaAllocator allocator,
            VmaAllocation allocation);
    
    native void vmaFreeMemoryPages(
            VmaAllocator allocator,
            Collection<VmaAllocation> allocations);
    
    native void vmaGetAllocationInfo(
            VmaAllocator allocator,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo);
    
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
    
    native void vmaGetPoolStats(
            VmaAllocator allocator,
            VmaPool pool,
            VmaPoolStats poolStats);
    
    native void vmaInvalidateAllocation(
            VmaAllocator allocator,
            VmaAllocation allocation,
            long offset,
            long size);
    
    native void vmaMakePoolAllocationsLost(
            VmaAllocator allocator,
            VmaPool pool,
            LongReturnValue lostAllocationCount);
    
    native VkResult vmaMapMemory(
            VmaAllocator allocator,
            VmaAllocation allocation,
            MappedData data);
    
    native VkResult vmaResizeAllocation(
            VmaAllocator allocator,
            VmaAllocation allocation,
            long newSize);
    
    native void vmaSetAllocationUserData(
            VmaAllocator allocator,
            VmaAllocation allocation,
            Object userData);
    
    native void vmaSetCurrentFrameIndex(
            VmaAllocator allocator,
            int frameIndex);
    
    native boolean vmaTouchAllocation(
            VmaAllocator allocator,
            VmaAllocation allocation);
    
    native void vmaUnmapMemory(
            VmaAllocator allocator,
            VmaAllocation allocation);
    


}
