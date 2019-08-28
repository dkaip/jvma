package com.CIMthetics.jVma.Enums;

/**
 * <code>VmaRecordFlagBits.VMA_RECORD_FLUSH_AFTER_CALL_BIT</code> Enables flush 
 * after recording every function call.
 * <p>
 * Enable it if you expect your application to crash, which may leave recording 
 * file truncated.
 * <p>
 * It may degrade performance though.
 * 
 * @author Douglas Kaip
 *
 */
public enum VmaRecordFlagBits
{
    VMA_RECORD_FLUSH_AFTER_CALL_BIT(0x00000001),
    VMA_RECORD_FLAG_BITS_MAX_ENUM(0x7FFFFFFF);
    
    private int value;
    
    private VmaRecordFlagBits(int value) { this.value = value; }
    
    public int valueOf() { return value; }

}
