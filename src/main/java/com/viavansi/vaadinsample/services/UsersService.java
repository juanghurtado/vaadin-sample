package com.viavansi.vaadinsample.services;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;

public class UsersService {

	private static UsersService INSTANCE;
	private IndexedContainer container = new IndexedContainer();
	
	private static final String FNAME = "First Name";
	private static final String LNAME = "Last Name";
	private static final String COMPANY = "Company";
	private static final String[] fieldNames = new String[] { FNAME, LNAME, COMPANY };
	
	private UsersService(){ 
		for (String p : fieldNames) {
			container.addContainerProperty(p, String.class, "");
		}

		String[] fnames = { "Peter", "Alice", "Joshua", "Mike", "Olivia",
				"Nina", "Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene",
				"Lisa", "Marge" };
		String[] lnames = { "Smith", "Gordon", "Simpson", "Brown", "Clavel",
				"Simons", "Verne", "Scott", "Allison", "Gates", "Rowling",
				"Barks", "Ross", "Schneider", "Tate" };
		String[] companies = { "Apple", "Viavansi", "Carrefour", "Barclays", "Junta de Andalucía",
				"Endesa", "GitHub" };
		
		for (int i = 0; i < 5; i++) {
			Object id = container.addItem();
			container.getContainerProperty(id, FNAME).setValue(fnames[(int) (fnames.length * Math.random())]);
			container.getContainerProperty(id, LNAME).setValue(lnames[(int) (lnames.length * Math.random())]);
			container.getContainerProperty(id, COMPANY).setValue(companies[(int) (companies.length * Math.random())]);
		}
	}
	
	public static UsersService getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new UsersService();
		}
		
		return INSTANCE; 
	}
	
	public IndexedContainer getUsers() {
		return container;
	}
	
	public void removeUser(Integer id) {
		container.removeItem(id);
	}
	
	public void addUser(String name, String last_name, String company) {
		Object id = container.addItem();
		
		container.getContainerProperty(id, FNAME).setValue(name);
		container.getContainerProperty(id, LNAME).setValue(last_name);
		container.getContainerProperty(id, COMPANY).setValue(company);
	}
	
	public void filter(String text) {
		container.removeAllContainerFilters();
		container.addContainerFilter(new UsersFilter(text));
	}
	
	public void clearFilter() {
		container.removeAllContainerFilters();
	}
	
	private class UsersFilter implements Filter {
		private static final long serialVersionUID = -2957052129604749520L;
		private String needle;

		public UsersFilter(String needle) {
			this.needle = needle.toLowerCase();
		}

		public boolean passesFilter(Object itemId, Item item) {
			String haystack = ("" + item.getItemProperty(FNAME).getValue()
					+ item.getItemProperty(LNAME).getValue() + item
					.getItemProperty(COMPANY).getValue()).toLowerCase();
			return haystack.contains(needle);
		}

		public boolean appliesToProperty(Object id) {
			return true;
		}
	}
	
}
