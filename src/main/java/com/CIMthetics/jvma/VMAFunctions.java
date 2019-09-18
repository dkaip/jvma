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
package com.CIMthetics.jvma;

import java.util.Collection;
import java.util.EnumSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.CIMthetics.jvma.Handles.MappedData;
import com.CIMthetics.jvma.Handles.VmaAllocation;
import com.CIMthetics.jvma.Handles.VmaAllocator;
import com.CIMthetics.jvma.Handles.VmaDefragmentationContext;
import com.CIMthetics.jvma.Handles.VmaPool;
import com.CIMthetics.jvma.Structures.LongReturnValue;
import com.CIMthetics.jvma.Structures.StringReturnValue;
import com.CIMthetics.jvma.Structures.VmaAllocationInfo;
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

public class VMAFunctions
{
    private Logger log = LoggerFactory.getLogger(VMAFunctions.class.getName());

    private static NativeProxies jVmaProxyLibrary;
    private static String pathToNativeLibrary;
    private static String nativeLibraryName;
    
    public VMAFunctions(String pathToNativeLibrary, String nativeLibraryName)
    {
        if (pathToNativeLibrary.endsWith("/") == false)
            VMAFunctions.pathToNativeLibrary = pathToNativeLibrary + "/";
        else
            VMAFunctions.pathToNativeLibrary = pathToNativeLibrary;
        
        VMAFunctions.nativeLibraryName = nativeLibraryName;

        log.trace("Attempting to load native library:{}{}", VMAFunctions.pathToNativeLibrary, VMAFunctions.nativeLibraryName);
        System.load(VMAFunctions.pathToNativeLibrary + VMAFunctions.nativeLibraryName);

        jVmaProxyLibrary = new NativeProxies();
    }
    
    /**
     * Create Allocator Object
     * @param createInfo
     * @param allocator
     * @return
     */
    public static VkResult vmaCreateAllocator(
            VmaAllocatorCreateInfo createInfo,
            VmaAllocator allocator)
    {
        return jVmaProxyLibrary.vmaCreateAllocator(createInfo, allocator);
    }
    
    /**
     * Destroy Allocator Object
     * @param allocator
     */
    public static void vmaDestroyAllocator(
            VmaAllocator allocator)
    {
        jVmaProxyLibrary.vmaDestroyAllocator(allocator);
    }
    
    /**
     * PhysicalDeviceProperties are fetched from physicalDevice by the allocator.
     * You can access it here, without fetching it again on your own.
     * @param allocator
     * @param physicalDeviceProperties
     */
    public static void vmaGetPhysicalDeviceProperties(
            VmaAllocator allocator,
            VkPhysicalDeviceProperties physicalDeviceProperties)
    {
        jVmaProxyLibrary.vmaGetPhysicalDeviceProperties(
                allocator,
                physicalDeviceProperties);
    }
    
    /**
     * PhysicalDeviceMemoryProperties are fetched from physicalDevice by the allocator.
     * You can access it here, without fetching it again on your own.
     * @param allocator
     * @param physicalDeviceMemoryProperties
     */
    public static void vmaGetMemoryProperties(
            VmaAllocator allocator,
            VkPhysicalDeviceMemoryProperties physicalDeviceMemoryProperties)
    {
        jVmaProxyLibrary.vmaGetMemoryProperties(
                allocator,
                physicalDeviceMemoryProperties);
    }

    /**
     * Given Memory Type Index, returns Property Flags of this memory type.
     * <p>
     * This is just a convenience function. Same information can be obtained 
     * using <code>vmaGetMemoryProperties()</code>.
     * @param allocator
     * @param memoryTypeIndex
     * @param flags
     */
    public static void vmaGetMemoryTypeProperties(
            VmaAllocator allocator,
            int memoryTypeIndex,
            EnumSet<VkMemoryPropertyFlagBits> flags)
    {
        jVmaProxyLibrary.vmaGetMemoryTypeProperties(
                allocator,
                memoryTypeIndex,
                flags);
    }

    /**
     * Sets index of the current frame.
     * <p>
     * This function must be used if you make allocations with
     * <code>VMA_ALLOCATION_CREATE_CAN_BECOME_LOST_BIT</code> and
     * <code>VMA_ALLOCATION_CREATE_CAN_MAKE_OTHER_LOST_BIT</code> flags to 
     * inform the allocator when a new frame begins. Allocations queried using 
     * </code>vmaGetAllocationInfo()</code> cannot become lost in the current frame.
     * @param allocator
     * @param frameIndex
     */
    public static void vmaSetCurrentFrameIndex(
            VmaAllocator allocator,
            int frameIndex)
    {
        jVmaProxyLibrary.vmaSetCurrentFrameIndex(
                allocator,
                frameIndex);
    }
    
    /**
     * Retrieves statistics from current state of the Allocator.
     * @param allocator
     * @param stats
     */
    public static void vmaCalculateStats(
            VmaAllocator allocator,
            VmaStats stats)
    {
        jVmaProxyLibrary.vmaCalculateStats(
                allocator,
                stats);
    }
    
    /**
     * Builds and returns statistics as string in JSON format.
     * <p>
     * Unlike its C++ counterpart statsString does NOT
     * need to be release with <code>vmaFreeStatsString</code>.
     * @param allocator
     * @param statsString may not be null
     * @param detailedMap
     */
    public static void vmaBuildStatsString(
            VmaAllocator allocator,
            StringReturnValue statsString,
            boolean detailedMap)
    {
        jVmaProxyLibrary.vmaBuildStatsString(
                allocator,
                statsString,
                detailedMap);
    }
    
    /**
     * In the Java environment this method does not do anything since
     * the String returned from the <code>vmaBuildStatsString</code> method is now a
     * Java <code>String</code> and will thus be garbage collected at the appropriate
     * time.
     * <p>
     * This method is here for &quot;compatibility / completeness&quot; reasons.
     * @param allocator
     * @param statsString
     */
    public static void vmaFreeStatsString(
            VmaAllocator allocator,
            String statsString)
    {
        return;
    }
    
    /**
     * Helps to find memoryTypeIndex, given memoryTypeBits and VmaAllocationCreateInfo
     * <p>
     * This algorithm tries to find a memory type that:
     * <ul>
     * <li>
     * Is allowed by memoryTypeBits. See the documentation for <code>memoryTypeBits</code>
     * below.
     * </li>
     * <li>
     * Contains all the flags from pAllocationCreateInfo->requiredFlags.
     * </li>
     * <li>
     * Matches intended usage.
     * </li>
     * <li>
     * Has as many flags from pAllocationCreateInfo->preferredFlags as possible.
     * </li>
     * </ul>
     * <p>
     * @param allocator
     * @param memoryTypeBits Each graphics card will have X number of memory types.
     * Each of these types will have a varying number of properties associated with
     * them.  For example, let's say our card has 4 memory types.  You would represent
     * each type with a bit, i.e. 0x1, 0x2, 0x4, and 0x8.  When calling this method
     * set the memory type bits of the type(s) you would like to be considered in the
     * &quot;search&quot; when this method is called.  If you only want the first and
     * third memory types considered use<code>(0x1 | 0x4)</code> for the value of this 
     * argument.  If you would like to search all memory types pass either a
     * <code>0</code> or a <code>-1</code> for the value of this argument.
     * 
     * @param allocationCreateInfo
     * @param memoryTypeIndex
     * @return Returns <code>VK_ERROR_FEATURE_NOT_PRESENT</code> if not found. Receiving such result
     * from this function or any other allocating function probably means that your
     * device doesn't support any memory type with requested features for the specific
     * type of resource you want to use it for. Please check parameters of your
     * resource, like image layout (OPTIMAL versus LINEAR) or mip level count.
     */
    public static VkResult vmaFindMemoryTypeIndex(
            VmaAllocator allocator,
            int memoryTypeBits,
            VmaAllocationCreateInfo allocationCreateInfo,
            IntReturnValue memoryTypeIndex)
    {
        return jVmaProxyLibrary.vmaFindMemoryTypeIndex(
                allocator,
                memoryTypeBits,
                allocationCreateInfo,
                memoryTypeIndex);
    }

    /**
     *  Helps to find memoryTypeIndex, given VkBufferCreateInfo and VmaAllocationCreateInfo.
     *  <p>
     * It can be useful e.g. to determine value to be used as 
     * <code>VmaPoolCreateInfo.memoryTypeIndex</code>.
     * It internally creates a temporary, dummy buffer that never has memory bound.
     * It is just a convenience function, equivalent to calling:
     * 
     * @param allocator
     * @param bufferCreateInfo
     * @param allocationCreateInfo
     * @param memoryTypeIndex
     * @return
     */
    public static VkResult vmaFindMemoryTypeIndexForBufferInfo(
            VmaAllocator allocator,
            VkBufferCreateInfo bufferCreateInfo,
            VmaAllocationCreateInfo allocationCreateInfo,
            IntReturnValue memoryTypeIndex)
    {
        return jVmaProxyLibrary.vmaFindMemoryTypeIndexForBufferInfo(
                allocator,
                bufferCreateInfo,
                allocationCreateInfo,
                memoryTypeIndex);
    }
    
    /**
     * Helps to find memoryTypeIndex, given VkImageCreateInfo and VmaAllocationCreateInfo.
     * <p>
     * It can be useful e.g. to determine value to be used as 
     * <code>VmaPoolCreateInfo.memoryTypeIndex</code>.
     * It internally creates a temporary, dummy image that never has memory bound.
     * It is just a convenience function, equivalent to calling:
     * 
     * @param allocator
     * @param imageCreateInfo
     * @param allocationCreateInfo
     * @param memoryTypeIndex
     * @return
     */
    public static VkResult vmaFindMemoryTypeIndexForImageInfo(
            VmaAllocator allocator,
            VkImageCreateInfo imageCreateInfo,
            VmaAllocationCreateInfo allocationCreateInfo,
            IntReturnValue memoryTypeIndex)
    {
        return jVmaProxyLibrary.vmaFindMemoryTypeIndexForImageInfo(
                allocator,
                imageCreateInfo,
                allocationCreateInfo,
                memoryTypeIndex);
    }
    
    /**
     * Allocates Vulkan device memory and creates <code>VmaPool</code> object.
     * 
     * @param allocator
     * @param createInfo
     * @param pool
     * @return
     */
    public static VkResult vmaCreatePool(
            VmaAllocator allocator,
            VmaPoolCreateInfo createInfo,
            VmaPool pool)
    {
        return jVmaProxyLibrary.vmaCreatePool(
                allocator,
                createInfo,
                pool);
    }
    
    /**
     * Destroys <code>VmaPool</code> object and frees Vulkan device memory.
     * 
     * @param allocator
     * @param pool
     */
    public static void vmaDestroyPool(
            VmaAllocator allocator,
            VmaPool pool)
    {
        jVmaProxyLibrary.vmaDestroyPool(
                allocator,
                pool);
    }
    
    /**
     * Retrieves statistics of existing #VmaPool object.
     * 
     * @param allocator
     * @param pool
     * @param poolStats
     */
    public static void vmaGetPoolStats(
            VmaAllocator allocator,
            VmaPool pool,
            VmaPoolStats poolStats)
    {
        jVmaProxyLibrary.vmaGetPoolStats(
                allocator,
                pool,
                poolStats);        
    }
    
    /**
     * Marks all allocations in given pool as lost if they are not used in current frame or 
     * <code>VmaPoolCreateInfo.frameInUseCount</code> back from now.
     * 
     * @param allocator Allocator Object
     * @param pool Pool
     * @param lostAllocationCount Number of allocations marked as lost. Optional - pass null if you don't need this information.
     */
    public static void vmaMakePoolAllocationsLost(
            VmaAllocator allocator,
            VmaPool pool,
            LongReturnValue lostAllocationCount)
    {
        jVmaProxyLibrary.vmaMakePoolAllocationsLost(
                allocator,
                pool,
                lostAllocationCount);
    }
    
    /**
     * Checks magic number in margins around all allocations in given memory pool in search for corruptions.
     * <p>
     * Corruption detection is enabled only when <code>VMA_DEBUG_DETECT_CORRUPTION</code> macro is defined to nonzero,
     * <code>VMA_DEBUG_MARGIN</code> is defined to nonzero and the pool is created in memory type that is
     * <code>HOST_VISIBLE</code> and <code>HOST_COHERENT</code>. For more information, see 
     * [Corruption detection](@ref debugging_memory_usage_corruption_detection).
     * <p>
     * 
     * @param allocator
     * @param pool
     * @return Possible return values:
     * <p>
     * <ul>
     * <li>
     * <code>VK_ERROR_FEATURE_NOT_PRESENT</code> - corruption detection is not enabled for specified pool.
     * </li>
     * <li>
     * <code><code>VK_SUCCESS</code> - corruption detection has been performed and succeeded.
     * </li>
     * <li>
     * <code><code>VK_ERROR_VALIDATION_FAILED_EXT</code> - corruption detection has been performed and found memory 
     * corruption around one of the allocations. <code>VMA_ASSERT</code> is also fired in that case.
     * </li>
     * <li>
     * <code>Other value: Error returned by Vulkan, e.g. memory mapping failure.
     * </li>
     * </ul>
     */
    public static VkResult vmaCheckPoolCorruption(
            VmaAllocator allocator,
            VmaPool pool)
    {
        return jVmaProxyLibrary.vmaCheckPoolCorruption(
                allocator,
                pool);
    }
    
    /**
     * General purpose memory allocation.
     * <p>
     * You should free the memory using <code>vmaFreeMemory()</code> or <code>vmaFreeMemoryPages()</code>.
     * <p>
     * It is recommended to use <code>vmaAllocateMemoryForBuffer()</code>, 
     * <code>vmaAllocateMemoryForImage()</code>, <code>vmaCreateBuffer()</code>,
     * <code>vmaCreateImage()</code> instead whenever possible.
     * <p>
     * @param allocator
     * @param vkMemoryRequirements
     * @param createInfo
     * @param allocation Handle to allocated memory.
     * @param allocationInfo Optional. Information about allocated memory. It 
     * can be later fetched using the method <code>vmaGetAllocationInfo()</code>.
     * @return
     */
    public static VkResult vmaAllocateMemory(
            VmaAllocator allocator,
            VkMemoryRequirements vkMemoryRequirements,
            VmaAllocationCreateInfo createInfo,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo)
    {
        return jVmaProxyLibrary.vmaAllocateMemory(
                allocator,
                vkMemoryRequirements,
                createInfo,
                allocation,
                allocationInfo);
    }
    
    /**
     * 
     * @param allocator
     * @param vkMemoryRequirements
     * @param createInfo
     * @param allocations
     * @param allocationInfo
     * @return
     */
    public static VkResult vmaAllocateMemoryPages(
            VmaAllocator allocator,
            Collection<VkMemoryRequirements> vkMemoryRequirements,
            Collection<VmaAllocationCreateInfo> createInfo,
            Collection<VmaAllocation> allocations,
            Collection<VmaAllocationInfo> allocationInfo)
    {
        return jVmaProxyLibrary.vmaAllocateMemoryPages(
                allocator,
                vkMemoryRequirements,
                createInfo,
                allocations,
                allocationInfo);
    }
    
    /**
     * 
     * @param allocator
     * @param buffer
     * @param createInfo
     * @param allocation Handle to allocated memory.
     * @param allocationInfo Optional. Information about allocated memory. It can be 
     * later fetched using function <code>vmaGetAllocationInfo()</code>.
     * @return
     */
    public static VkResult vmaAllocateMemoryForBuffer(
            VmaAllocator allocator,
            VkBuffer buffer,
            VmaAllocationCreateInfo createInfo,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo)
    {
        return jVmaProxyLibrary.vmaAllocateMemoryForBuffer(
                allocator,
                buffer,
                createInfo,
                allocation,
                allocationInfo);
    }
    
    /**
     * 
     * @param allocator
     * @param image
     * @param createInfo
     * @param allocation Handle to allocated memory.
     * @param allocationInfo Optional. Information about allocated memory. It can be 
     * later fetched using function <code>vmaGetAllocationInfo()</code>.
     * @return
     */
    public static VkResult vmaAllocateMemoryForImage(
            VmaAllocator allocator,
            VkImage image,
            VmaAllocationCreateInfo createInfo,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo)
    {
        return jVmaProxyLibrary.vmaAllocateMemoryForImage(
                allocator,
                image,
                createInfo,
                allocation,
                allocationInfo);
    }
    
    /**
     * Frees memory previously allocated using <code>vmaAllocateMemory()</code>,
     * <code>vmaAllocateMemoryForBuffer()</code>, or <code>vmaAllocateMemoryForImage()</code>.
     * @param allocator
     * @param allocation
     */
    public static void vmaFreeMemory(
            VmaAllocator allocator,
            VmaAllocation allocation)
    {
        jVmaProxyLibrary.vmaFreeMemory(
                allocator,
                allocation);
    }
    
    /**
     * Frees memory and destroys multiple allocations.
     * <p>
     * Word "pages" is just a suggestion to use this function to free pieces of memory used for sparse binding.
     * It is just a general purpose function to free memory and destroy allocations made using 
     * e.g. <code>vmaAllocateMemory()</code>, vmaAllocateMemoryPages() and other functions.
     * It may be internally optimized to be more efficient than calling 
     * <code>vmaFreeMemory()</code> <code>allocationCount</code> times.
     * <p>
     * Allocations in <code>allocations</code> array can come from any memory pools and types.
     * Passing <code>VK_NULL_HANDLE</code> as elements of <code>allocations</code> 
     * array is valid. Such entries are just skipped.
     * <p>
     * @param allocator
     * @param allocations
     */
    public static void vmaFreeMemoryPages(
            VmaAllocator allocator,
            Collection<VmaAllocation> allocations)
    {
        jVmaProxyLibrary.vmaFreeMemoryPages(
                allocator,
                allocations);
    }
    
    /**
     * Tries to resize an allocation in place, if there is enough free memory after it.
     * <p>
     * Tries to change allocation's size without moving or reallocating it.
     * You can both shrink and grow allocation size. When growing, it succeeds 
     * only when the allocation belongs to a memory block with enough free space
     * after it.
     * <p>
     * After successful call to this method, <code>VmaAllocationInfo.size</code> 
     * of this allocation changes. All other parameters stay the same: memory 
     * pool and type, alignment, offset, mapped pointer.
     * <p>
     * <ul>
     * <li>
     * Calling this function on allocation that is in lost state fails with 
     * result <code>VK_ERROR_VALIDATION_FAILED_EXT</code>.
     * </li>
     * <li>
     * Calling this function with <code>newSize</code> same as current allocation
     * size does nothing and returns <code>VK_SUCCESS</code>.
     * </li>
     * <li>
     * Resizing dedicated allocations, as well as allocations created in pools 
     * that use linear or buddy algorithm, is not supported.
     * The function returns <code>VK_ERROR_FEATURE_NOT_PRESENT</code> in such cases.
     * Support may be added in the future.
     * </li>
     * </ul>
     * 
     * @param allocator
     * @param allocation
     * @param newSize
     * @return
     * <ul>
     * <li>
     * <code>VK_SUCCESS</code> if allocation's size has been successfully changed.
     * </li>
     * <li>
     * <code>VK_ERROR_OUT_OF_POOL_MEMORY</code> if allocation's size could not be changed.
     * </li>
     * <li>
     * <code>VK_ERROR_FEATURE_NOT_PRESENT</code> - see above
     * </li>
     * </ul>
     */
    public static VkResult vmaResizeAllocation(
            VmaAllocator allocator,
            VmaAllocation allocation,
            long newSize)
    {
        return jVmaProxyLibrary.vmaResizeAllocation(
                allocator,
                allocation,
                newSize);
    }
    
    public static void vmaGetAllocationInfo(
            VmaAllocator allocator,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo)
    {
        jVmaProxyLibrary.vmaGetAllocationInfo(
                allocator,
                allocation,
                allocationInfo);
    }
    
    public static boolean vmaTouchAllocation(
            VmaAllocator allocator,
            VmaAllocation allocation)
    {
        return jVmaProxyLibrary.vmaTouchAllocation(
                allocator,
                allocation);
    }
    
    public static void vmaSetAllocationUserData(
            VmaAllocator allocator,
            VmaAllocation allocation,
            Object userData)
    {
        jVmaProxyLibrary.vmaSetAllocationUserData(
                allocator,
                allocation,
                userData);
    }
    
    public static void vmaCreateLostAllocation(
            VmaAllocator allocator,
            VmaAllocation allocation)
    {
        jVmaProxyLibrary.vmaCreateLostAllocation(
                allocator,
                allocation);
    }
    
    public static VkResult vmaMapMemory(
            VmaAllocator allocator,
            VmaAllocation allocation,
            MappedData data)
    {
        return jVmaProxyLibrary.vmaMapMemory(
                allocator,
                allocation,
                data);
    }
    
    public static void vmaUnmapMemory(
            VmaAllocator allocator,
            VmaAllocation allocation)
    {
        jVmaProxyLibrary.vmaUnmapMemory(
                allocator,
                allocation);
    }
    
    public static void vmaFlushAllocation(
            VmaAllocator allocator,
            VmaAllocation allocation,
            long offset,
            long size)
    {
        jVmaProxyLibrary.vmaFlushAllocation(
                allocator,
                allocation,
                offset,
                size);
    }
    
    public static void vmaInvalidateAllocation(
            VmaAllocator allocator,
            VmaAllocation allocation,
            long offset,
            long size)
    {
        jVmaProxyLibrary.vmaInvalidateAllocation(
                allocator,
                allocation,
                offset,
                size);
    }
    
    public static VkResult vmaCheckCorruption(
            VmaAllocator allocator,
            int memoryTypeBits)
    {
        return jVmaProxyLibrary.vmaCheckCorruption(
                allocator,
                memoryTypeBits);
    }
    
    public static VkResult vmaDefragmentationBegin(
            VmaAllocator allocator,
            VmaDefragmentationInfo2 info,
            VmaDefragmentationStats stats,
            VmaDefragmentationContext context)
    {
        return jVmaProxyLibrary.vmaDefragmentationBegin(
                allocator,
                info,
                stats,
                context);
    }
    
    public static VkResult vmaDefragmentationEnd(
            VmaAllocator allocator,
            VmaDefragmentationContext context)
    {
        return jVmaProxyLibrary.vmaDefragmentationEnd(
                allocator,
                context);
    }
    
//    public static VkResult vmaDefragment(
//            VmaAllocator allocator,
//            VmaAllocation[] allocations,
//            long allocationCount,
//            boolean[] allocationsChanged,
//            VmaDefragmentationInfo defragmentationInfo,
//            VmaDefragmentationStats defragmentationStats)
//    {
//        return jVmaProxyLibrary.vmaDefragment(
//                allocator,
//                allocations,
//                allocationCount,
//                allocationsChanged,
//                defragmentationInfo,
//                defragmentationStats);
//    }
//    
    public static VkResult vmaBindBufferMemory(
            VmaAllocator allocator,
            VmaAllocation allocation,
            VkBuffer buffer)
    {
        return jVmaProxyLibrary.vmaBindBufferMemory(
                allocator,
                allocation,
                buffer);
    }
    
    public static VkResult vmaBindImageMemory(
            VmaAllocator allocator,
            VmaAllocation allocation,
            VkImage image)
    {
        return jVmaProxyLibrary.vmaBindImageMemory(
                allocator,
                allocation,
                image);
    }
    
    public static VkResult vmaCreateBuffer(
            VmaAllocator allocator,
            VkBufferCreateInfo bufferCreateInfo,
            VmaAllocationCreateInfo allocationCreateInfo,
            VkBuffer buffer,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo)
    {
        return jVmaProxyLibrary.vmaCreateBuffer(
                allocator,
                bufferCreateInfo,
                allocationCreateInfo,
                buffer,
                allocation,
                allocationInfo);
    }
    
    public static void vmaDestroyBuffer(
            VmaAllocator allocator,
            VkBuffer buffer,
            VmaAllocation allocation)
    {
        jVmaProxyLibrary.vmaDestroyBuffer(
                allocator,
                buffer,
                allocation);
    }
    
    public static VkResult vmaCreateImage(
            VmaAllocator allocator,
            VkImageCreateInfo imageCreateInfo,
            VmaAllocationCreateInfo allocationCreateInfo,
            VkImage image,
            VmaAllocation allocation,
            VmaAllocationInfo allocationInfo)
    {
        return jVmaProxyLibrary.vmaCreateImage(
                allocator,
                imageCreateInfo,
                allocationCreateInfo,
                image,
                allocation,
                allocationInfo);
    }
    
    public static void vmaDestroyImage(
            VmaAllocator allocator,
            VkImage image,
            VmaAllocation allocation)
    {
        jVmaProxyLibrary.vmaDestroyImage(
                allocator,
                image,
                allocation);
    }
    
}
