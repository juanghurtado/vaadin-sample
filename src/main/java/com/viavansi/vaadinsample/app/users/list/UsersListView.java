package com.viavansi.vaadinsample.app.users.list;

import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.event.Action;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.viavansi.vaadinsample.app.AppUI;
import com.viavansi.vaadinsample.app.users.search.UsersSearchView;
import com.viavansi.vaadinsample.lib.view.GenericView;
import com.viavansi.vaadinsample.models.User;

public class UsersListView extends GenericView {

	private static final long serialVersionUID = 3997350938236800619L;
	private final UsersListPresenter presenter;
	public static final String VIEW_NAME = "users";
	
	public UsersListView() {
		presenter = new UsersListPresenter(this);
		
		this.setSizeFull();
		this.setMargin(true);
		
		HorizontalLayout header = getHeader();
		Table usersList = getUsersListTable();
		VerticalLayout actions = getActions();
		
		this.addComponent(header);
		this.addComponent(usersList);
		this.addComponent(actions);
		this.setExpandRatio(usersList, 1);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
	private VerticalLayout getActions() {
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
		GenericView search = getSearch();
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
	
	private GenericView getSearch() {
		return new UsersSearchView(presenter.getUsers());
	}

	private Table getUsersListTable() {
		BeanContainer<String, User> users = presenter.getUsers();
		Table usersList = new Table();
		
		usersList.setContainerDataSource(users);
		usersList.setVisibleColumns(new Object[] { "name", "lastName", "company" });
		usersList.setColumnHeader("name", "Name");
		usersList.setColumnHeader("lastName", "Last Name");
		usersList.setColumnHeader("company", "Company");
		usersList.setSelectable(true);
		usersList.setSizeFull();
		
		usersList.addActionHandler(new Action.Handler() {
			private static final long serialVersionUID = 9188290972190096595L;
			private final Action remove = new Action("Remove");
			
            @Override
            public Action[] getActions(final Object target, final Object sender) {
            	remove.setIcon(FontAwesome.TIMES);
            	
            	return new Action[] { remove };
            }
 
            @Override
            public void handleAction(final Action action, final Object sender, final Object target) {
                if (remove == action) {
                	ConfirmDialog.show(AppUI.getCurrent(), "Are you sure?",
    			        new ConfirmDialog.Listener() {
							private static final long serialVersionUID = 8888290972190096595L;

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
