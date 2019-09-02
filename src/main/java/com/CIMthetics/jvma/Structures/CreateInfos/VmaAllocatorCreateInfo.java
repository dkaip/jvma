package com.CIMthetics.jvma.Structures.CreateInfos;

import java.util.EnumSet;

import com.CIMthetics.jvma.Enums.VmaAllocatorCreateFlagBits;
import com.CIMthetics.jvma.Structures.VmaDeviceMemoryCallbacks;
import com.CIMthetics.jvma.Structures.VmaRecordSettings;
import com.CIMthetics.jvma.Structures.VmaVulkanFunctions;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Handles.VkDevice;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Handles.VkPhysicalDevice;
import com.CIMthetics.jvulkan.VulkanCore.VK11.Structures.VkAllocationCallbacks;

public class VmaAllocatorCreateInfo
{
    /// Flags for created allocator. Use #VmaAllocatorCreateFlagBits enum.
    EnumSet<VmaAllocatorCreateFlagBits> flags = EnumSet.noneOf(VmaAllocatorCreateFlagBits.class);
    /// Vulkan physical device.
    /** It must be valid throughout whole lifetime of created allocator. */
    VkPhysicalDevice physicalDevice;
    /// Vulkan device.
    /** It must be valid throughout whole lifetime of created allocator. */
    VkDevice device;
    /// Preferred size of a single `VkDeviceMemory` block to be allocated from large heaps > 1 GiB. Optional.
    /** Set to 0 to use default, which is currently 256 MiB. */
    long preferredLargeHeapBlockSize;
    /// Custom CPU memory allocation callbacks. Optional.
    /** Optional, can be null. When specified, will also be used for all CPU-side memory allocations. */
    VkAllocationCallbacks allocationCallbacks;
    /// Informative callbacks for `vkAllocateMemory`, `vkFreeMemory`. Optional.
    /** Optional, can be null. */
    VmaDeviceMemoryCallbacks deviceMemoryCallbacks;
    /** \brief Maximum number of additional frames that are in use at the same time as current frame.

    This value is used only when you make allocations with
    VMA_ALLOCATION_CREATE_CAN_BECOME_LOST_BIT flag. Such allocation cannot become
    lost if allocation.lastUseFrameIndex >= allocator.currentFrameIndex - frameInUseCount.

    For example, if you double-buffer your command buffers, so resources used for
    rendering in previous frame may still be in use by the GPU at the moment you
    allocate resources needed for the current frame, set this value to 1.

    If you want to allow any allocations other than used in the current frame to
    become lost, set this value to 0.
    */
    int frameInUseCount;
    /** \brief Either null or a pointer to an array of limits on maximum number of bytes that can be allocated out of particular Vulkan memory heap.

    If not NULL, it must be a pointer to an array of
    `VkPhysicalDeviceMemoryProperties::memoryHeapCount` elements, defining limit on
    maximum number of bytes that can be allocated out of particular Vulkan memory
    heap.

    Any of the elements may be equal to `VK_WHOLE_SIZE`, which means no limit on that
    heap. This is also the default in case of `pHeapSizeLimit` = NULL.

    If there is a limit defined for a heap:

    - If user tries to allocate more memory from that heap using this allocator,
      the allocation fails with `VK_ERROR_OUT_OF_DEVICE_MEMORY`.
    - If the limit is smaller than heap size reported in `VkMemoryHeap::size`, the
      value of this limit will be reported instead when using vmaGetMemoryProperties().

    Warning! Using this feature may not be equivalent to installing a GPU with
    smaller amount of memory, because graphics driver doesn't necessary fail new
    allocations with `VK_ERROR_OUT_OF_DEVICE_MEMORY` result when memory capacity is
    exceeded. It may return success and just silently migrate some device memory
    blocks to system RAM. This driver behavior can also be controlled using
    VK_AMD_memory_overallocation_behavior extension.
    */
    long[] heapSizeLimit;
    /** \brief Pointers to Vulkan functions. Can be null if you leave define `VMA_STATIC_VULKAN_FUNCTIONS 1`.

    If you leave define `VMA_STATIC_VULKAN_FUNCTIONS 1` in configuration section,
    you can pass null as this member, because the library will fetch pointers to
    Vulkan functions internally in a static way, like:

        vulkanFunctions.vkAllocateMemory = &vkAllocateMemory;

    Fill this member if you want to provide your own pointers to Vulkan functions,
    e.g. fetched using `vkGetInstanceProcAddr()` and `vkGetDeviceProcAddr()`.
    */
    VmaVulkanFunctions  vulkanFunctions;
    /** \brief Parameters for recording of VMA calls. Can be null.

    If not null, it enables recording of calls to VMA functions to a file.
    If support for recording is not enabled using `VMA_RECORDING_ENABLED` macro,
    creation of the allocator object fails with `VK_ERROR_FEATURE_NOT_PRESENT`.
    */
    VmaRecordSettings recordSettings;
    
    public EnumSet<VmaAllocatorCreateFlagBits> getFlags()
    {
        return flags;
    }
    
    public void setFlags(EnumSet<VmaAllocatorCreateFlagBits> flags)
    {
        this.flags = flags;
    }
    
    public VkPhysicalDevice getPhysicalDevice()
    {
        return physicalDevice;
    }
    
    public void setPhysicalDevice(VkPhysicalDevice physicalDevice)
    {
        this.physicalDevice = physicalDevice;
    }
    
    public VkDevice getDevice()
    {
        return device;
    }
    
    public void setDevice(VkDevice device)
    {
        this.device = device;
    }
    
    public long getPreferredLargeHeapBlockSize()
    {
        return preferredLargeHeapBlockSize;
    }
    
    public void setPreferredLargeHeapBlockSize(long preferredLargeHeapBlockSize)
    {
        this.preferredLargeHeapBlockSize = preferredLargeHeapBlockSize;
    }
    
    public VkAllocationCallbacks getAllocationCallbacks()
    {
        return allocationCallbacks;
    }
    
    public void setallocationCallbacks(VkAllocationCallbacks allocationCallbacks)
    {
        this.allocationCallbacks = allocationCallbacks;
    }
    
    public VmaDeviceMemoryCallbacks getDeviceMemoryCallbacks()
    {
        return deviceMemoryCallbacks;
    }
    
    public void setDeviceMemoryCallbacks(VmaDeviceMemoryCallbacks deviceMemoryCallbacks)
    {
        this.deviceMemoryCallbacks = deviceMemoryCallbacks;
    }
    
    public int getFrameInUseCount()
    {
        return frameInUseCount;
    }
    
    public void setFrameInUseCount(int frameInUseCount)
    {
        this.frameInUseCount = frameInUseCount;
    }
    
    public long[] getHeapSizeLimit()
    {
        return heapSizeLimit;
    }
    
    void setHeapSizeLimit(long[] heapSizeLimit)
    {
        this.heapSizeLimit = heapSizeLimit;
    }
    
    public VmaVulkanFunctions getVulkanFunctions()
    {
        return vulkanFunctions;
    }
    
    public void setVulkanFunctions(VmaVulkanFunctions vulkanFunctions)
    {
        this.vulkanFunctions = vulkanFunctions;
    }
    
    public VmaRecordSettings getRecordSettings()
    {
        return recordSettings;
    }
    
    public void setRecordSettings(VmaRecordSettings recordSettings)
    {
        this.recordSettings = recordSettings;
    }
}
