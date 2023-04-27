package dao.gui;

import java.util.Arrays;

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
				// TODO: implement

				break;
			case actionEdit:
				// TODO: implement

				break;
			case actionDelete:
				// TODO: implement

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
		final User[] users = (User[]) UserDAO.getInstance().readAll().toArray();

		System.out.println(Arrays.toString(users));
	}
}