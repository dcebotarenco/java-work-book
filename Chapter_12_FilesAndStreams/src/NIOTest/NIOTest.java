package NIOTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

/**
 * Programul calculeaza Suma CRC-32 pentru file.
 * Folosire : java NIOTEST nume_fisier.
 */
public class NIOTest 
{
	public static long checksumInputStream(String filename)
	throws IOException
	{
		InputStream in  = new FileInputStream(filename);
		CRC32 crc = new CRC32();
		
		int c;
		while((c = in.read()) != -1)
		{
			crc.update(c);
		}
		return crc.getValue();
	}
	
	public static long checksumBufferedInputStream(String filename)
	throws IOException
	{
		InputStream in = new BufferedInputStream(new FileInputStream(filename));
		CRC32 crc = new CRC32();
		
		int c;
		while((c = in.read()) != -1)
		{
			crc.update(c);
		}
		return crc.getValue();
	}
	
	public static long checksumRandomAccessFile(String filename)
	throws IOException
	{
		RandomAccessFile file = new RandomAccessFile(filename, "r");
		long lenght = file.length();
		CRC32 crc = new CRC32();
		
		for(long p = 0; p<lenght; p++)
		{
			file.seek(p);
			int c = file.readByte();
			crc.update(c);
		}
		return crc.getValue();
	}
	
	public static long checksumMappedFile(String filename)
	throws IOException
	{
		FileInputStream in = new FileInputStream(filename);
		FileChannel channel = in.getChannel();
		
		CRC32 crc = new CRC32();
		int lenght = (int) channel.size();
		MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, lenght);
		
		for(int p = 0; p< lenght; p++)
		{
			int c = buffer.get(p);
			crc.update(c);
		}
		return crc.getValue();
	}
	
	public static void main(String[] args)
	throws IOException
	{
		System.out.println("InputStream:");
		long start = System.currentTimeMillis();
		long crcValue = checksumInputStream(args[0]);
		long end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end-start) + " milliseconds");
		
		System.out.println("Buffered Input Stream:");
		start = System.currentTimeMillis();
		crcValue = checksumBufferedInputStream(args[0]);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + " milleseconds");
		
		System.out.println("Random Access File :");
		start  = System.currentTimeMillis();
		crcValue = checksumRandomAccessFile(args[0]);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + " milliseconds");
	}
}
