package com.viavansi.vaadinsample.lib.filters;

import com.vaadin.data.Item;
import com.vaadin.data.Container.Filter;

public class UsersFilter implements Filter {
	private static final long serialVersionUID = -2957052129604749520L;
	private String needle;

	public UsersFilter(String needle) {
		this.needle = needle.toLowerCase();
	}

	public boolean passesFilter(Object itemId, Item item) {
		String haystack = ("" + item.getItemProperty("name").getValue() + item.getItemProperty("lastName").getValue() + item.getItemProperty("company").getValue());
		return haystack.toLowerCase().contains(needle);
	}

	public boolean appliesToProperty(Object id) {
		return true;
	}
}
