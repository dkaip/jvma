package com.CIMthetics.jVma;

import java.util.EnumSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.CIMthetics.jVma.Handles.VmaAllocator;
import com.CIMthetics.jVma.Structures.CreateInfos.VmaAllocatorCreateInfo;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Enums.VkMemoryPropertyFlagBits;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Enums.VkResult;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkPhysicalDeviceMemoryProperties;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkPhysicalDeviceProperties;

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
     * Create Alocator Object
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
}
