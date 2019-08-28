package com.CIMthetics.jVma.Enums;

public enum VmaDefragmentationFlagBits
{
    VMA_DEFRAGMENTATION_FLAG_BITS_MAX_ENUM(0x7FFFFFFF);
    
    private int value;
    
    private VmaDefragmentationFlagBits(int value) { this.value = value; }
    
    public int valueOf() { return value; }
}
