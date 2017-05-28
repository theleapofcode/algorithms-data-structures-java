package com.theleapofcode.algosandds.hashtable;

import org.junit.Assert;
import org.junit.Test;

public class TestHashTableChaining {

	@Test
	public void testAdd() {
		HashTableChaining<String, String> ht = new HashTableChaining<>(10);
		ht.add("IronMan", "Tony Stark");
		ht.add("CaptainAmerica", "Steve Rogers");
		ht.add("Hulk", "Bruce Banner");
		System.out.println(ht.toString());
	}

	@Test
	public void testRemove() {
		HashTableChaining<String, String> ht = new HashTableChaining<>(10);
		ht.add("IronMan", "Tony Stark");
		ht.add("CaptainAmerica", "Steve Rogers");
		ht.add("Hulk", "Bruce Banner");
		ht.remove("Hulk");
		System.out.println(ht.toString());

		try {
			ht.remove("Thor");
			Assert.fail("testRemove passed");
		} catch (IllegalArgumentException iae) {
			Assert.assertEquals("This key is not present in the hash table. Bucket: 3", iae.getMessage());
		}
	}

	@Test
	public void testGet() {
		HashTableChaining<String, String> ht = new HashTableChaining<>(10);
		ht.add("IronMan", "Tony Stark");
		ht.add("CaptainAmerica", "Steve Rogers");
		ht.add("Hulk", "Bruce Banner");
		String value = ht.get("CaptainAmerica");
		Assert.assertEquals("Steve Rogers", value);
	}

}
