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
package com.CIMthetics.jvma.Enums;

/**
 * <code>VmaAllocatorCreateFlagBits.VMA_ALLOCATOR_CREATE_EXTERNALLY_SYNCHRONIZED_BIT</code> Allocator and 
 * all objects created from it will not be synchronized internally, so you must
 * guarantee they are used from only one thread at a time or synchronized externally
 * by you.
 * <p>
 * Using this flag may increase performance because internal mutexes are not used.
 * <p>
 * <code>VmaAllocatorCreateFlagBits.VMA_ALLOCATOR_CREATE_KHR_DEDICATED_ALLOCATION_BIT</code> Enables usage of
 * the <code>VK_KHR_dedicated_allocation</code> extension.
 * <p>
 * Using this extension will automatically allocate dedicated blocks of memory for
 * some buffers and images instead of sub-allocating place for them out of bigger
 * memory blocks (as if you explicitly used the <code>VMA_ALLOCATION_CREATE_DEDICATED_MEMORY_BIT</code>
 * flag) when it is recommended by the driver. It may improve performance on some
 * GPUs.
 * <p>
 * You may set this flag only if you found out that following device extensions are
 * supported, you enabled them while creating Vulkan device passed as
 * VmaAllocatorCreateInfo::device, and you want them to be used internally by this
 * library:
 * <br>
 * <code>VK_KHR_get_memory_requirements2</code>
 * <br>
 * <code>VK_KHR_dedicated_allocation</code>
 * <p>
 * When this flag is set, you may experience following warning reported by Vulkan
 * validation layer. You can ignore it.
 * <br>
 * <code>vkBindBufferMemory(): Binding memory to buffer 0x2d but vkGetBufferMemoryRequirements() 
 * has not been called on that buffer.</code>
 * <p>
 * @author Douglas Kaip
 *
 */
public enum VmaAllocatorCreateFlagBits
{
    VMA_ALLOCATOR_CREATE_EXTERNALLY_SYNCHRONIZED_BIT(0x00000001),
    VMA_ALLOCATOR_CREATE_KHR_DEDICATED_ALLOCATION_BIT(0x00000002),
    VMA_ALLOCATOR_CREATE_FLAG_BITS_MAX_ENUM(0x7FFFFFFF);

    private int value;
    
    private VmaAllocatorCreateFlagBits(int value) { this.value = value; }
    
    public int valueOf() { return value; }
}
