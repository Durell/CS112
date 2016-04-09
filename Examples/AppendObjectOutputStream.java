/*
 *	Author: Nicholas Warner
 *	Date: 3/23/2015
 *	Filename: AppendObjectOutputStream.java
 *	Professor: June Porto
 *	Assignment: Midterm, "Gas Pump Simulation"
 *
 *	Problem: Extend the ObjectOutputStream to allow appending
 *
 *	Algorithm: Ensure we have the "reset()"
 */

import java.io.*;

public class AppendObjectOutputStream extends ObjectOutputStream {

	public AppendObjectOutputStream(OutputStream output) throws IOException {
		
		super(output);
	} 
	
	@Override
	protected void writeStreamHeader() throws IOException {
		
		reset();
	}
}