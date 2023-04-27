package dao.gui;

import java.util.List;

import dao.dao.UserDAO;
import dao.model.User;

public class Menu {
	public static final int
		actionList = 1,
		actionAdd = 2,
		actionEdit = 3,
		actionDelete = 4,
		actionExit = 5;

	public static void print() {
		System.out.println(String.format(Locale.action, actionList, Locale.actionList));
		System.out.println(String.format(Locale.action, actionAdd, Locale.actionAdd));
		System.out.println(String.format(Locale.action, actionEdit, Locale.actionEdit));
		System.out.println(String.format(Locale.action, actionDelete, Locale.actionDelete));
		System.out.println(String.format(Locale.action, actionExit, Locale.actionExit));
		System.out.print(Locale.prompt);
	}

	public static boolean handleAction(final int action) {
		System.out.println();

		switch (action) {
			case actionList:
				list();

				break;
			case actionAdd:
				add();

				break;
			case actionEdit:
				edit();

				break;
			case actionDelete:
				delete();

				break;
			case actionExit:
				System.out.println(Locale.exit);

				return false;
			default:
				System.out.println(String.format(Locale.undefinedAction, action));

				break;
		}

		System.out.println();

		return true;
	}

	private static void list() {
		final List<User> users = UserDAO.getInstance().readAll();

		users.forEach(System.out::println);
		System.out.println(String.format("(%s utilisateur%s)", users.size(), users.size() == 1 ? "" : 's'));
	}

	private static void add() {}

	private static void edit() {}

	private static void delete() {}
}