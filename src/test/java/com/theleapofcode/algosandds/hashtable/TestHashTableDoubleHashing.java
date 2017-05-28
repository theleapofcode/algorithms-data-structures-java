package com.theleapofcode.algosandds.hashtable;

import org.junit.Assert;
import org.junit.Test;

public class TestHashTableDoubleHashing {

	@Test
	public void testAdd() {
		HashTableDoubleHashing<String, String> ht = new HashTableDoubleHashing<>(10);
		ht.add("IronMan", "Tony Stark");
		ht.add("CaptainAmerica", "Steve Rogers");
		ht.add("Hulk", "Bruce Banner");
	}

	@Test
	public void testRemove() {
		HashTableDoubleHashing<String, String> ht = new HashTableDoubleHashing<>(10);
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
		HashTableDoubleHashing<String, String> ht = new HashTableDoubleHashing<>(10);
		ht.add("IronMan", "Tony Stark");
		ht.add("CaptainAmerica", "Steve Rogers");
		ht.add("Hulk", "Bruce Banner");
		String value = ht.get("CaptainAmerica");
		Assert.assertEquals("Steve Rogers", value);
	}

}
