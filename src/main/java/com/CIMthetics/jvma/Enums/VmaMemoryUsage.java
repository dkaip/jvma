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

public enum VmaMemoryUsage
{
    /** No intended memory usage specified.
    Use other members of VmaAllocationCreateInfo to specify your requirements.
    */
    VMA_MEMORY_USAGE_UNKNOWN(0),
    /** Memory will be used on device only, so fast access from the device is preferred.
    It usually means device-local GPU (video) memory.
    No need to be mappable on host.
    It is roughly equivalent of `D3D12_HEAP_TYPE_DEFAULT`.

    Usage:
    
    - Resources written and read by device, e.g. images used as attachments.
    - Resources transferred from host once (immutable) or infrequently and read by
      device multiple times, e.g. textures to be sampled, vertex buffers, uniform
      (constant) buffers, and majority of other types of resources used on GPU.

    Allocation may still end up in `HOST_VISIBLE` memory on some implementations.
    In such case, you are free to map it.
    You can use #VMA_ALLOCATION_CREATE_MAPPED_BIT with this usage type.
    */
    VMA_MEMORY_USAGE_GPU_ONLY(1),
    /** Memory will be mappable on host.
    It usually means CPU (system) memory.
    Guarantees to be `HOST_VISIBLE` and `HOST_COHERENT`.
    CPU access is typically uncached. Writes may be write-combined.
    Resources created in this pool may still be accessible to the device, but access to them can be slow.
    It is roughly equivalent of `D3D12_HEAP_TYPE_UPLOAD`.

    Usage: Staging copy of resources used as transfer source.
    */
    VMA_MEMORY_USAGE_CPU_ONLY(2),
    /**
    Memory that is both mappable on host (guarantees to be `HOST_VISIBLE`) and preferably fast to access by GPU.
    CPU access is typically uncached. Writes may be write-combined.

    Usage: Resources written frequently by host (dynamic), read by device. E.g. textures, vertex buffers, uniform buffers updated every frame or every draw call.
    */
    VMA_MEMORY_USAGE_CPU_TO_GPU(3),
    /** Memory mappable on host (guarantees to be `HOST_VISIBLE`) and cached.
    It is roughly equivalent of `D3D12_HEAP_TYPE_READBACK`.

    Usage:

    - Resources written by device, read by host - results of some computations, e.g. screen capture, average scene luminance for HDR tone mapping.
    - Any resources read or accessed randomly on host, e.g. CPU-side copy of vertex buffer used as source of transfer, but also used for collision detection.
    */
    VMA_MEMORY_USAGE_GPU_TO_CPU(4),
    VMA_MEMORY_USAGE_MAX_ENUM(0x7FFFFFFF);
    
    private int value;
    
    private VmaMemoryUsage(int value) { this.value = value; }
    
    public int valueOf() { return value; }
}
