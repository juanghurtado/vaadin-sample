package com.viavansi.vaadinsample.app.users.list;

import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.Action;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;
import com.viavansi.vaadinsample.app.AppUI;
import com.viavansi.vaadinsample.app.users.search.UsersSearchViewImpl;

public class UsersListViewImpl extends VerticalLayout implements UsersListView {

	private static final long serialVersionUID = 3997350938236800619L;
	private final UsersListPresenter presenter;
	public String VIEW_NAME = "users";
	
	public UsersListViewImpl() {
		AppUI.getCurrent().getNavigator().addView(VIEW_NAME, this);
		
		presenter = new UsersListPresenter(this);
		
		this.setSizeFull();
		this.setMargin(true);
		
		HorizontalLayout header = getHeader();
		Table usersList = getUsersListTable();
		VerticalLayout addButton = getAddButton();
		
		this.addComponent(header);
		this.addComponent(usersList);
		this.addComponent(addButton);
		this.setExpandRatio(usersList, 1);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
	private VerticalLayout getAddButton() {
		VerticalLayout layout = new VerticalLayout();
		Button button = new Button("Add user");
		
		layout.setMargin(new MarginInfo(0001));
		
		button.setStyleName(ValoTheme.BUTTON_PRIMARY);
		button.setIcon(FontAwesome.PLUS);
		
		button.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = -1152008427884812260L;

			public void buttonClick(ClickEvent event) {
				presenter.openUsersAddView();
		    }
		});
		
		layout.addComponent(button);
		
		return layout;
	}

	private HorizontalLayout getHeader() {
		Label title = getTitleLabel();
		HorizontalLayout search = getSearch();
		HorizontalLayout header = new HorizontalLayout();
		
		header.addComponent(title);
		header.addComponent(search);
		header.setComponentAlignment(search, Alignment.MIDDLE_RIGHT);
		header.setWidth("100%");
		
		return header;
	}

	private Label getTitleLabel() {
		Label title = new Label();
		
		title.setValue("Users");
		title.addStyleName(ValoTheme.LABEL_H1);
		
		return title;
	}
	
	private HorizontalLayout getSearch() {
		return new UsersSearchViewImpl();
	}

	private Table getUsersListTable() {
		IndexedContainer users = presenter.getUsers();
		Table usersList = new Table();
		
		usersList.setContainerDataSource(users);
		usersList.setVisibleColumns(new String[] { "First Name", "Last Name", "Company" });
		usersList.setSelectable(true);
		usersList.setSizeFull();
		
		usersList.addActionHandler(new Action.Handler() {
			private static final long serialVersionUID = 9188290972190096595L;
			private final Action remove = new Action("Remove");
			
            @Override
            public Action[] getActions(final Object target, final Object sender) {
            	return new Action[] { remove };
            }
 
            @Override
            public void handleAction(final Action action, final Object sender, final Object target) {
                if (remove == action) {
                	ConfirmDialog.show(AppUI.getCurrent(), "Are you sure?",
    			        new ConfirmDialog.Listener() {
							private static final long serialVersionUID = 1L;

							public void onClose(ConfirmDialog dialog) {
    			                if (dialog.isConfirmed()) {
    			                	presenter.removeUser((Integer) target);
    			                }
    			            }
    			        });
                }
            }
 
        });
		
		return usersList;
	}
	
}
