package com.theleapofcode.algosandds.hashtable;

import org.junit.Assert;
import org.junit.Test;

public class TestHashTableLinearProbing {

	@Test
	public void testAdd() {
		HashTableLinearProbing<String, String> ht = new HashTableLinearProbing<>(10);
		ht.add("IronMan", "Tony Stark");
		ht.add("CaptainAmerica", "Steve Rogers");
		ht.add("Hulk", "Bruce Banner");
	}

	@Test
	public void testRemove() {
		HashTableLinearProbing<String, String> ht = new HashTableLinearProbing<>(10);
		ht.add("IronMan", "Tony Stark");
		ht.add("CaptainAmerica", "Steve Rogers");
		ht.add("Hulk", "Bruce Banner");
		ht.remove("Hulk");

		try {
			ht.remove("Thor");
			Assert.fail("testRemove passed");
		} catch (IllegalArgumentException iae) {
			Assert.assertEquals("This key is not present in the hash table. Index: 3", iae.getMessage());
		}
	}

	@Test
	public void testGet() {
		HashTableLinearProbing<String, String> ht = new HashTableLinearProbing<>(10);
		ht.add("IronMan", "Tony Stark");
		ht.add("CaptainAmerica", "Steve Rogers");
		ht.add("Hulk", "Bruce Banner");
		String value = ht.get("CaptainAmerica");
		Assert.assertEquals("Steve Rogers", value);
	}

}
