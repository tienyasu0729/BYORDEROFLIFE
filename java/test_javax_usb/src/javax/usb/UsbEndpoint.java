package javax.usb;

/**
 * Copyright (c) 1999 - 2001, International Business Machines Corporation.
 * All Rights Reserved.
 *
 * This software is provided and licensed under the terms and conditions
 * of the Common Public License:
 * http://oss.software.ibm.com/developerworks/opensource/license-cpl.html
 */

/**
 * Interface for a USB endpoint.
 * @author Dan Streetman
 */
public interface UsbEndpoint
{
	/**
	 * Get the parent UsbInterface that this UsbEndpoint belongs to.
	 * @return The parent interface.
	 */
	public UsbInterface getUsbInterface();

	/**
	 * Get the descriptor for this UsbEndpoint.
	 * <p>
	 * The descriptor may be cached.
	 * @return The descriptor for this UsbEndpoint.
	 */
	public UsbEndpointDescriptor getUsbEndpointDescriptor();

	/**
	 * Get this endpoint's direction.
	 * <p>
	 * This is the logical AND of the
	 * {@link UsbConst#ENDPOINT_DIRECTION_MASK direction mask} and the
	 * {@link #getUsbEndpointDescriptor() endpoint descriptor}'s
	 * {@link UsbEndpointDescriptor#bEndpointAddress() address}.
	 * @return This endpoint's direction.
	 * @see UsbConst#ENDPOINT_DIRECTION_IN
	 * @see UsbConst#ENDPOINT_DIRECTION_OUT
	 */
	public byte getDirection();

	/**
	 * Get this endpoint's type.
	 * <p>
	 * This is the logical AND of the
	 * {@link UsbConst#ENDPOINT_TYPE_MASK type mask} and the
	 * {@link #getUsbEndpointDescriptor() endpoint descriptor}'s
	 * {@link UsbEndpointDescriptor#bmAttributes() attributes}.
	 * @return This endpoint's type.
	 * @see UsbConst#ENDPOINT_TYPE_CONTROL
	 * @see UsbConst#ENDPOINT_TYPE_BULK
	 * @see UsbConst#ENDPOINT_TYPE_INTERRUPT
	 * @see UsbConst#ENDPOINT_TYPE_ISOCHRONOUS
	 */
	public byte getType();

	/**
	 * Get the UsbPipe for this UsbEndpoint.
	 * <p>
	 * This is the only method of communication to this endpoint.
	 * @return This UsbEndpoint's UsbPipe.
	 */
	public UsbPipe getUsbPipe();
}
