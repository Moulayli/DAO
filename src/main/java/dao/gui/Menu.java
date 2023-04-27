package dao.gui;

import java.util.List;
import java.util.Scanner;

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

	public static boolean handleAction(final Scanner scanner) {
		final int action = scanner.nextInt();

		System.out.println();

		switch (action) {
			case actionList:
				list();

				break;
			case actionAdd:
				add(scanner);

				break;
			case actionEdit:
				edit(scanner);

				break;
			case actionDelete:
				delete(scanner);

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

	private static void add(final Scanner scanner) {
		final User user = new User(null, null, null, null);

		System.out.print(Locale.addUserFirstName);
		user.setFirstName(scanner.next());

		System.out.print(Locale.addUserLastName);
		user.setLastName(scanner.next());

		System.out.print(Locale.addUserLogin);
		user.setLogin(scanner.next());

		UserDAO.getInstance().create(user);

		System.out.println(Locale.addUserSuccess);
	}

	private static void edit(final Scanner scanner) {
		System.out.println(Locale.editUser);
		System.out.print(Locale.prompt);

		final int id = scanner.nextInt();
		final User user = UserDAO.getInstance().read(id);

		if (user == null) {
			System.out.println(String.format(Locale.undefinedUser, id));

			return;
		}

		{
			System.out.print(Locale.editUserFirstName);
			final String firstName = scanner.next();

			if (!firstName.isBlank()) user.setFirstName(firstName);
		}

		{
			System.out.print(Locale.editUserLastName);
			final String lastName = scanner.next();

			if (!lastName.isBlank()) user.setLastName(lastName);
		}

		{
			System.out.print(Locale.editUserLogin);
			final String login = scanner.next();

			if (!login.isBlank()) user.setLogin(login);
		}

		UserDAO.getInstance().update(user);

		System.out.println(Locale.editUserSuccess);
	}

	private static void delete(final Scanner scanner) {
		System.out.println(Locale.deleteUser);
		System.out.print(Locale.prompt);

		final int id = scanner.nextInt();

		UserDAO.getInstance().delete(id);

		System.out.println(String.format(Locale.deleteUserSuccess, id));
	}
}